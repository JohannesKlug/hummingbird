package org.hbird.core.commons.util.crc;

import java.util.zip.Checksum;

public class CRC16CCITT implements Checksum {

	int crc = 0xFFFF; // initial value
	int normalPolynomial = 0x1021; // 0001 0000 0010 0001 (0, 5, 12)

	@Override
	public void update(int b) {
		for (int i = 0; i < 8; i++) {
			boolean bit = ((b >> (7 - i) & 1) == 1);
			boolean c15 = ((crc >> 15 & 1) == 1);
			crc <<= 1;
			if (c15 ^ bit) {
				crc ^= normalPolynomial;
			}
		}
		crc &= 0xFFFF;
	}

	@Override
	public void update(byte[] b, int off, int len) {
		throw new UnsupportedOperationException("Offset update not implemented.");
	}

	@Override
	public long getValue() {
		return crc & 0xFFFF;
	}

	@Override
	public void reset() {
		crc = 0xFFFF;
	}

}
