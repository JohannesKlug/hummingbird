package org.hbird.core.commons.util;

import org.hbird.core.commons.util.exceptions.InvalidBinaryStringException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Various byte utility methods used across the Hummingbird transport layer.
 * 
 * @author Johannes Klug (John Clever, lol)
 * @author Mark Doyle
 * 
 */
public abstract class BytesUtility {

	private static final Logger LOG = LoggerFactory.getLogger(BytesUtility.class);

	private BytesUtility() {
		// Utility class
	}

	/**
	 * Here be magical byte work. Please don't mess it up :(
	 * 
	 * <p>
	 * 
	 * Combines a byte array representing a signed or unsigned number of size sizeInBits into a long value. This is
	 * returned as a {@link Number} from which users can grab any primitive type value via the {@link Number} methods.
	 * 
	 * @param b
	 *            byte array that represents a number
	 * @param sizeIntBits
	 *            the size in bits of the number the byte array represents
	 * @param signed
	 *            whether the number the byte array represetns is signed or not.
	 * @return Number value of the byte array combined into a long primitive.
	 */
	public static Number combine(final byte[] b, final int sizeIntBits, final boolean signed) {
		// Defensive! We are combining into a primitive long so we are limited to 64 bits (8 bytes)
		if (b.length > 8) {
			throw new IllegalArgumentException("Cannot fit this Byte array into a long.  Max size is 8 elements.");
		}

		// this is the primitive the byte array will be combined into
		long value = 0;

		// This loop iterates over the byte array in reverse order. It does the work of pushing the byte array into the
		// long primitive
		for (int i = 0; i < b.length; ++i) {
			// First calculate the index which is the byte array element we are accessing on this iteration
			int index;
			index = b.length - 1 - i;

			// If we are dealing with a signed number...
			if (signed) {
				// ...and if we are on the first element in the byte array, i.e., the part that contains the sign
				if (i == b.length - 1 && b[index] < 0) {
					// push it into the long primitive with the sign bit
					// the (i << 3) logic calculates how far along the long primitive to push this byte element
					value |= (long) (b[index]) << (i << 3);
				}
				// ...else push the byte element into the long with the first bit masked off, i.e., not regarding it as
				// a sign bit
				else {
					// "anding" with 0xff removes the sign
					value |= (long) (b[index] & 0xff) << (i << 3);
				}
			}
			// ...else if we are dealing with an unsigned number
			else {
				value |= (long) (b[index] & 0xff) << (i << 3);
			}

		}

		// Calculate how much we have to chop off to make the sizeInBits integer
		int numCompleteBytesRequired = sizeIntBits / 8;
		int extraBitsRequired = sizeIntBits % 8;
		int totalBytesRequired;

		// If we required extra bits then we will need an extra byte to store the number...
		if (extraBitsRequired != 0) {
			// We need to keep completeBytesRequired + 1
			totalBytesRequired = numCompleteBytesRequired + 1;
		}
		// ..else we just need the number of bytes already calculated
		else {
			totalBytesRequired = numCompleteBytesRequired;
		}

		// Because we are using a byte array we are bound by multiples of 8 bits to represent the number
		// This means we will (if bit size is off the bound) have extra bits at the end of the long primitive we need to
		// chop off (right shift)
		int chopBits = (b.length - totalBytesRequired) * 8;
		if (extraBitsRequired != 0) {
			chopBits += 8 - extraBitsRequired;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Number of complete Bytes used = " + numCompleteBytesRequired);
			LOG.debug("Number of extra bits required = " + extraBitsRequired);
			LOG.debug("Total Bytes required to store value = " + totalBytesRequired);
			LOG.debug("Need to chop (unsigned right shift) " + chopBits + " bits off");
		}

		// if not signed chop the bits and pad the start of the long primitive with 0's
		if (!signed) {
			value = value >>> chopBits;
		}
		// ...else chop the bits whilst retaining the sign bit
		else {
			value = value >> chopBits;
		}

		return value;
	}

	/**
	 * Dumps the byte array into a string as a series of 8bit decimal numbers
	 * 
	 * @param bytes
	 * @return
	 */
	public static String decimalDump(final byte[] bytes) {
		StringBuffer buffer = new StringBuffer();
		for (byte b : bytes) {
			buffer.append(Byte.toString(b));
			buffer.append(" ");
		}

		return buffer.toString();
	}

	public static byte[] binaryStringToByteArray(final String binaryString) throws InvalidBinaryStringException {
		if ((binaryString.length() % 8) != 0) {
			throw new InvalidBinaryStringException(binaryString.length());
		}

		int numberOfBytes = binaryString.length() / 8;
		byte[] result = new byte[numberOfBytes];

		for (int i = 0; i < numberOfBytes; i++) {
			String currentByteAsString = binaryString.substring(i * Byte.SIZE, (i + 1) * Byte.SIZE);
			int currentByteAsInt = Integer.parseInt(currentByteAsString, 2);
			result[i] = (byte) (currentByteAsInt & 0xFF);
		}

		return result;
	}

	public static String hexDump(byte[] payload) {
		String hexdump = "";
		for (byte b : payload) {
			hexdump += Integer.toHexString(b & 0xff) + " ";
		}
		return hexdump;
	}
}
