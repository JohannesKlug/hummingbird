package org.hbird.transport.protocols;

import static org.junit.Assert.*;

import org.hbird.transport.protocols.hdlc.HdlcFrameEncoder;
import org.junit.Test;

public class HdlcFrameEncoderTest {
	
	private HdlcFrameEncoder encoder = new HdlcFrameEncoder();

	@Test
	public void testEncodeByteArrayByteByte() {
		byte address = 0x01;
		byte control = 0x02;
		byte[] information = new byte[] {0x03, 0x04 };
		
		byte[] result = encoder.encode(information, address, control);
		
		assertArrayEquals(new byte[] { 0x01, 0x02, 0x03, 0x04 }, result);
	}

	@Test
	public void testEncodeByteArray() {
		byte[] information = new byte[] {0x01, 0x02 };
		
		byte[] result = encoder.encode(information);
		
		assertArrayEquals(new byte[] { 0x00, 0x00, 0x01, 0x02 }, result);
	}

}
