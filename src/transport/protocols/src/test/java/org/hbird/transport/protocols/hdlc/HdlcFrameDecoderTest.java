package org.hbird.transport.protocols.hdlc;

import static org.junit.Assert.assertArrayEquals;

import org.hbird.transport.protocols.hdlc.exceptions.CrcFailureException;
import org.junit.Before;
import org.junit.Test;

public class HdlcFrameDecoderTest {

	private HdlcFrameDecoder decoder = null;

	@Before
	public void setupDecoder() {
		decoder = new HdlcFrameDecoder();
		decoder.setUseChecksum(false);
	}

	@Test
	public void testDecode() throws CrcFailureException {
		byte[] input = new byte[] { (byte) 0xC0, (byte) 0x80, (byte) 0x80, (byte) 0x85, 0x09, 0x02, 0x66, (byte) 0x9A, 0x05, 0x00, 0x00, 0x59, 0x00, 0x57 };
		byte[] expected = new byte[] { (byte) 0x80, (byte) 0x85, 0x09, 0x02, 0x66, (byte) 0x9A, 0x05, 0x00, 0x00, 0x59, 0x00, 0x57 };

		byte[] actual = decoder.decode(input);

		assertArrayEquals(expected, actual);
	}

}
