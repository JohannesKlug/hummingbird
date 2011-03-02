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
		actual = encoder.encodeFrame(0, 0, new byte[1]);
		assertEquals(100, actual.length);
	}
	
	@Test
	public void virtualChannelId() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		int virtualChannelId = 7;
		actual = encoder.encodeFrame(0, virtualChannelId, new byte[1]);
		assertEquals(virtualChannelId, (actual[1] >> 1) & 0x7);
		
		virtualChannelId = 3;
		actual = encoder.encodeFrame(0, virtualChannelId, new byte[1]);
		assertEquals(virtualChannelId, (actual[1] >> 1) & 0x7);
		
		virtualChannelId = 0;
		actual = encoder.encodeFrame(0, virtualChannelId, new byte[1]);
		assertEquals(virtualChannelId, (actual[1] >> 1) & 0x7);
	}
	
	@Test (expected=InvalidVirtualChannelIdException.class)
	public void virtualChannelIdTooHigh() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		actual = encoder.encodeFrame(0, 8, new byte[1]);
		assertEquals(0, actual[1]);
	}
	
	@Test (expected=InvalidVirtualChannelIdException.class)
	public void virtualChannelIdTooLow() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		actual = encoder.encodeFrame(0, -1, new byte[1]);
		assertEquals(0, actual[1]);
	}
	
	@Test
	public void spacecraftId() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		int spacecraftId = 1023; // 10 bits all set
		actual = encoder.encodeFrame(spacecraftId, 0, null);
		assertEquals(0x3f, actual[0] & 0xff);
		assertEquals(0xf0, actual[1] & 0xff);
		
		spacecraftId = 0; // all bits unset
		actual = encoder.encodeFrame(spacecraftId, 0, null);
		assertEquals(0, actual[0]);
		assertEquals(0, actual[1]);
	}
	
	@Test (expected=InvalidSpacecraftIdException.class)
	public void spacecraftIdTooLow() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		actual = encoder.encodeFrame(-1, 0, new byte[1]);
		assertEquals(0, actual[1]);
	}
	
	@Test (expected=InvalidSpacecraftIdException.class)
	public void spacecraftIdTooHigh() throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		actual = encoder.encodeFrame(1024, 0, new byte[1]);
		assertEquals(0, actual[1]);
	}

}
