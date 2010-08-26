package com.logica.hummingbird.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BytesUtility {
	
	private static final Logger LOG = LoggerFactory.getLogger(BytesUtility.class);

	public static int combine(byte[] b, int sizeIntBits) {
		// Defensive!
		if (b.length > 4) {
			throw new IllegalArgumentException("An int is only 4 bytes");
		}
	
		int value = 0;
		for (int i = 0; i < b.length; ++i) {	
			int index;
			index = b.length - 1 - i;
			System.out.println("index = " + index);
			
			value |= (b[index] & 0xff) << (i << 3);
		}
	
		// Calculate how much we have to chop off to make the sizeInBits integer
		int numCompleteBytesUsed = sizeIntBits / 8;
		int extraBitsRequired = sizeIntBits % 8;
	
		int totalBytesRequired;
		if (extraBitsRequired != 0) {
			// We need to keep completeBytesRequired + 1
			totalBytesRequired = numCompleteBytesUsed + 1;
		}
		else {
			totalBytesRequired = numCompleteBytesUsed;
		}
	
		// We need to chop off (right shift) the size of an int (2 Bytes) minus the required bytes.
		// We also need to chop off any surplus bits in the last Byte; so..
		// number of Bytes in an int - total required Bytes * number of Bits in a Byte gives us the base chop value
		int chopBits = (b.length - totalBytesRequired) * 8;
		if (extraBitsRequired != 0) {
			chopBits += 8 - extraBitsRequired;
		}
	
		LOG.debug("Number of complete Bytes used = " + numCompleteBytesUsed);
		LOG.debug("Number of extra bits required = " + extraBitsRequired);
		LOG.debug("Total Bytes required to store value = " + totalBytesRequired);
		LOG.debug("Need to chop " + chopBits + " bits off");
	
		value = value >>> chopBits;
	
		return value;
	}

	/**
	 * Dumps the byte array into a string as a series of 8bit decimal numbers
	 * @param bytes
	 * @return
	 */
	public static String decimalDump(byte[] bytes) {
		StringBuffer buffer = new StringBuffer();
		for(byte b : bytes) {
			buffer.append(Byte.toString(b));
			buffer.append(" ");
		}
		
		return buffer.toString();
	}
}
