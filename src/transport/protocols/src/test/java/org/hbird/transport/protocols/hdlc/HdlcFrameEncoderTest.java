package org.hbird.transport.protocols.hdlc;

import static org.junit.Assert.assertArrayEquals;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Johannes Klug
 * 
 */
public class HdlcFrameEncoderTest {

	private static HdlcFrameEncoder encoder = new HdlcFrameEncoder();

	@BeforeClass
	public static final void setup() {
		encoder.setUseChecksum(false);
	}

	@Test
	public void testEncodeByteArrayByteByte() {
		byte address = 0x01;
		byte control = 0x02;
		byte[] information = new byte[] { 0x03, 0x04 };

		byte[] result = encoder.encode(information, address, control);

		assertArrayEquals(new byte[] { 0x01, 0x02, 0x03, 0x04 }, result);
	}

	@Test
	public void testEncodeByteArray() {
		byte[] information = new byte[] { 0x01, 0x02 };

		byte[] result = encoder.encode(information);

		assertArrayEquals(new byte[] { 0x00, 0x00, 0x01, 0x02 }, result);
	}

}
