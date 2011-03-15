package org.hbird.transport.protocols.ccsds.transferframe.encoder;


import static org.junit.Assert.*;

import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidSpacecraftIdException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidVirtualChannelIdException;
import org.junit.Before;
import org.junit.Test;

public class CcsdsFrameEncoderTest {
	
	private CcsdsFrameEncoder encoder;
	byte[] actual;

	@Before
	public void setUp() throws Exception {
		encoder = new CcsdsFrameEncoder(100);
	}
	
	@Test
	public void length() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		actual = encoder.encodeFrame(0, 0, false, new byte[1]);
		assertEquals(100, actual.length);
	}
	
	@Test
	public void virtualChannelId() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		int virtualChannelId = 7;
		actual = encoder.encodeFrame(0, virtualChannelId, false, new byte[1]);
		assertEquals(virtualChannelId, (actual[1] >> 1) & 0x7);
		
		virtualChannelId = 3;
		actual = encoder.encodeFrame(0, virtualChannelId, false, new byte[1]);
		assertEquals(virtualChannelId, (actual[1] >> 1) & 0x7);
		
		virtualChannelId = 0;
		actual = encoder.encodeFrame(0, virtualChannelId, false, new byte[1]);
		assertEquals(virtualChannelId, (actual[1] >> 1) & 0x7);
	}
	
	@Test (expected=InvalidVirtualChannelIdException.class)
	public void virtualChannelIdTooHigh() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		actual = encoder.encodeFrame(0, 8, false, new byte[1]);
		assertEquals(0, actual[1]);
	}
	
	@Test (expected=InvalidVirtualChannelIdException.class)
	public void virtualChannelIdTooLow() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		actual = encoder.encodeFrame(0, -1, false, new byte[1]);
		assertEquals(0, actual[1]);
	}
	
	@Test
	public void spacecraftId() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		int spacecraftId = 1023; // 10 bits all set
		actual = encoder.encodeFrame(spacecraftId, 0, false, null);
		assertEquals(0x3f, actual[0] & 0xff);
		assertEquals(0xf0, actual[1] & 0xff);
		
		spacecraftId = 0; // all bits unset
		actual = encoder.encodeFrame(spacecraftId, 0, false, null);
		assertEquals(0, actual[0]);
		assertEquals(0, actual[1]);
	}
	
	@Test (expected=InvalidSpacecraftIdException.class)
	public void spacecraftIdTooLow() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		actual = encoder.encodeFrame(-1, 0, false, new byte[1]);
		assertEquals(0, actual[1]);
	}
	
	@Test (expected=InvalidSpacecraftIdException.class)
	public void spacecraftIdTooHigh() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		actual = encoder.encodeFrame(1024, 0, false, new byte[1]);
		assertEquals(0, actual[1]);
	}
	
	@Test
	public void ocf() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		int spacecraftId = 1023; // 10 bits all set
		actual = encoder.encodeFrame(spacecraftId, 0, false, null);
		
		// last bit is unset (ocf == false)
		assertEquals(0x0, actual[1] & 0x1);
		
		spacecraftId = 0; // all bits unset
		actual = encoder.encodeFrame(spacecraftId, 0, true, null);
		
		// last bit is set (ocf == true)
		assertEquals(0x1, actual[1] & 0x1);
	}
	
	@Test
	public void frameCounters() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		encoder = new CcsdsFrameEncoder(100);
		actual = encoder.encodeFrame(0, 0, false, null);
		
		// master channel frame count == 0
		assertEquals(0, actual[2]);
		
		// virtual channel frame count == 0
		assertEquals(0, actual[3]);
		
		actual = encoder.encodeFrame(0, 1, false, null);
		
		// master channel frame count == 1
		assertEquals(1, actual[2]);
		
		// virtual channel frame count == 0
		assertEquals(0, actual[3]);
		
		actual = encoder.encodeFrame(0, 0, false, null);
		
		// master channel frame count == 2
		assertEquals(2, actual[2]);
		
		// virtual channel frame count == 1
		assertEquals(1, actual[3]);
	}
	
	@Test 
	public void frameCountersRollOver() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		encoder = new CcsdsFrameEncoder(100);
		
		// encode 256 frames
		for (int i=0; i<256; i++) {
			actual = encoder.encodeFrame(0, 0, false, null);
			assertEquals(i, actual[2] & 0xFF);
			assertEquals(i, actual[3] & 0xFF);
		}

		// both master and virtual channel frame count should be 255 now.
		assertEquals(255, actual[2] & 0xFF);
		assertEquals(255, actual[3] & 0xFF);
		
		// encode another frame
		actual = encoder.encodeFrame(0, 0, false, null);
		
		// both master and virtual channel frame count should be 0 now.
		assertEquals(0, actual[2] & 0xFF);
		assertEquals(0, actual[3] & 0xFF);
	}

}
