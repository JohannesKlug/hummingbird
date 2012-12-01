package org.hbird.core.commons.util.crc;

import static org.junit.Assert.assertEquals;

import org.hbird.core.commons.util.crc.CRC16CCITT;
import org.junit.Before;
import org.junit.Test;

public class CRC16CCITTtest {

	private final static String TEST_INPUT = "123456789";
	private final static int EXPECTED_CRC = 0x29B1;
	private final static int EXPECTED_RESET_CRC = 0xFFFF;

	private CRC16CCITT crc;

	@Before
	public void setUp() throws Exception {
		crc = new CRC16CCITT();
	}

	private void testUpdateInt() {
		for (byte b : TEST_INPUT.getBytes()) {
			crc.update(b);
		}
		assertEquals(EXPECTED_CRC, crc.getValue());
	}

	@Test
	public void testUpdateAndReset() {
		testUpdateInt();
		crc.reset();
		assertEquals(EXPECTED_RESET_CRC, crc.getValue());
	}

}
