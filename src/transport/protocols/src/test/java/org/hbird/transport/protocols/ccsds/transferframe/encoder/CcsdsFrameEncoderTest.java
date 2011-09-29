package org.hbird.transport.protocols.ccsds.transferframe.encoder;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidOperationalControlFieldException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidSpacecraftIdException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidVirtualChannelIdException;
import org.junit.Before;
import org.junit.Test;

public class CcsdsFrameEncoderTest {

	private CcsdsFrameEncoder encoder;
	List<byte[]> actual;

	@Before
	public void setUp() throws Exception {
		encoder = new CcsdsFrameEncoder(100);
	}

	@Test
	public void length() throws Exception {
		actual = encoder.encodeFrames(0, 0, new byte[1]);
		assertEquals(100, actual.get(0).length);
	}

	@Test
	public void virtualChannelId() throws Exception {
		int virtualChannelId = 7;
		actual = encoder.encodeFrames(0, virtualChannelId, new byte[1]);
		assertEquals(virtualChannelId, (actual.get(0)[1] >> 1) & 0x7);

		virtualChannelId = 3;
		actual = encoder.encodeFrames(0, virtualChannelId, new byte[1]);
		assertEquals(virtualChannelId, (actual.get(0)[1] >> 1) & 0x7);

		virtualChannelId = 0;
		actual = encoder.encodeFrames(0, virtualChannelId, new byte[1]);
		assertEquals(virtualChannelId, (actual.get(0)[1] >> 1) & 0x7);
	}

	@Test(expected = InvalidVirtualChannelIdException.class)
	public void virtualChannelIdTooHigh() throws Exception {
		actual = encoder.encodeFrames(0, 8, new byte[1]);
		assertEquals(0, actual.get(0)[0]);
	}

	@Test(expected = InvalidVirtualChannelIdException.class)
	public void virtualChannelIdTooLow() throws Exception {
		actual = encoder.encodeFrames(0, -1, new byte[1]);
		assertEquals(0, actual.get(0)[1]);
	}

	@Test
	public void spacecraftId() throws Exception {
		int spacecraftId = 1023; // 10 bits all set
		actual = encoder.encodeFrames(spacecraftId, 0, null);
		assertEquals(0x3f, actual.get(0)[0] & 0xff);
		assertEquals(0xf0, actual.get(0)[1] & 0xff);

		spacecraftId = 0; // all bits unset
		actual = encoder.encodeFrames(spacecraftId, 0, null);
		assertEquals(0, actual.get(0)[0]);
		assertEquals(0, actual.get(0)[1]);
	}

	@Test(expected = InvalidSpacecraftIdException.class)
	public void spacecraftIdTooLow() throws Exception {
		actual = encoder.encodeFrames(-1, 0, new byte[1]);
		assertEquals(0, actual.get(0)[1]);
	}

	@Test(expected = InvalidSpacecraftIdException.class)
	public void spacecraftIdTooHigh() throws Exception {
		actual = encoder.encodeFrames(1024, 0, new byte[1]);
		assertEquals(0, actual.get(0)[1]);
	}

	@Test
	public void ocf() throws Exception {
		int spacecraftId = 1023; // 10 bits all set
		actual = encoder.encodeFrames(spacecraftId, 0, new byte[0], null);

		// last bit is unset (ocf == false)
		assertEquals(0x0, actual.get(0)[1] & 0x1);

		actual = encoder.encodeFrames(spacecraftId, 0, null, null);

		// last bit is unset (ocf == false)
		assertEquals(0x0, actual.get(0)[1] & 0x1);

		spacecraftId = 0; // all bits unset
		actual = encoder.encodeFrames(spacecraftId, 0, new byte[4], null);

		// last bit is set (ocf == true)
		assertEquals(0x1, actual.get(0)[1] & 0x1);
	}

	@Test(expected = InvalidOperationalControlFieldException.class)
	public void ocfTooSmall() throws Exception {
		actual = encoder.encodeFrames(0, 0, new byte[1], new byte[1]);
	}

	@Test(expected = InvalidOperationalControlFieldException.class)
	public void ocfTooLarge() throws Exception {
		actual = encoder.encodeFrames(0, 0, new byte[5], new byte[1]);
	}

	@Test
	public void frameCounters() throws Exception {
		encoder = new CcsdsFrameEncoder(100);
		actual = encoder.encodeFrames(0, 0, null);

		// master channel frame count == 0
		assertEquals(0, actual.get(0)[2]);

		// virtual channel frame count == 0
		assertEquals(0, actual.get(0)[3]);

		actual = encoder.encodeFrames(0, 1, null);

		// master channel frame count == 1
		assertEquals(1, actual.get(0)[2]);

		// virtual channel frame count == 0
		assertEquals(0, actual.get(0)[3]);

		actual = encoder.encodeFrames(0, 0, null);

		// master channel frame count == 2
		assertEquals(2, actual.get(0)[2]);

		// virtual channel frame count == 1
		assertEquals(1, actual.get(0)[3]);
	}

	@Test
	public void frameCountersRollOver() throws Exception {
		encoder = new CcsdsFrameEncoder(100);

		// encode 256 frames
		for (int i = 0; i < 256; i++) {
			actual = encoder.encodeFrames(0, 0, null);
			assertEquals(i, actual.get(0)[2] & 0xFF);
			assertEquals(i, actual.get(0)[3] & 0xFF);
		}

		// both master and virtual channel frame count should be 255 now.
		assertEquals(255, actual.get(0)[2] & 0xFF);
		assertEquals(255, actual.get(0)[3] & 0xFF);

		// encode another frame
		actual = encoder.encodeFrames(0, 0, null);

		// both master and virtual channel frame count should be 0 now.
		assertEquals(0, actual.get(0)[2] & 0xFF);
		assertEquals(0, actual.get(0)[3] & 0xFF);
	}

	@Test
	public void segmentLengthIdentifier() throws Exception {
		actual = encoder.encodeFrames(0, 0, null);
		assertEquals(0x18, actual.get(0)[4] & 0x18 & 0xFF);
	}
	
	@Test
	public void payloadNull() throws Exception {
		actual = encoder.encodeFrames(null);
		assertEquals(1, actual.size());
	}
	
	@Test
	public void payloadEmpty() throws Exception {
		actual = encoder.encodeFrames(new byte[0]);
		assertEquals(1, actual.size());
	}
	
	@Test
	public void payloadContentsSingleByte() throws Exception {
		byte[] payload = new byte[1];
		payload[0] = (byte) 0xFF;
		
		actual = encoder.encodeFrames(payload);
		assertEquals(0xFF, actual.get(0)[6] & 0xFF);
		assertEquals(0x00, actual.get(0)[7] & 0xFF);
	}
	
	@Test
	public void payloadContentsTwoBytes() throws Exception {
		byte[] payload = new byte[2];
		payload[0] = (byte) 0xFF;
		payload[1] = (byte) 0xFF;
		
		actual = encoder.encodeFrames(payload);
		assertEquals(0xFF, actual.get(0)[6] & 0xFF);
		assertEquals(0xFF, actual.get(0)[7] & 0xFF);
		assertEquals(0x00, actual.get(0)[8] & 0xFF);
	}
	
	@Test
	public void payloadContentsTwoBytesInTwoFrames() throws Exception {
		byte[] payload = new byte[95];
		payload[0] = (byte) 0xFF;
		payload[94] = (byte) 0xFF;
		
		actual = encoder.encodeFrames(payload);
		assertEquals(0xFF, actual.get(0)[6] & 0xFF);
		assertEquals(0x00, actual.get(0)[7] & 0xFF);
		
		assertEquals(0xFF, actual.get(1)[6] & 0xFF);
		assertEquals(0x00, actual.get(1)[7] & 0xFF);
	}
	
	@Test
	public void largePayload() throws Exception {
		// This encodes 940000 bytes as the payload. 
		// At a frame length of 100, there are 94 bytes payload capacity.
		// Hence, there must be 10000 frames resulting from this input.
		actual = encoder.encodeFrames(new byte[940000]);
		assertEquals(10000, actual.size());
	}
}
