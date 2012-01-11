package org.hbird.core.commons.util;

/** TODO Put in the transport.common */
import java.util.BitSet;

import org.apache.commons.lang.StringUtils;
import org.hbird.core.commons.util.exceptions.BitSetOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The bitset utilities class helps the encoding / decoding of simple java types such as integer and float to a bitset.
 *
 * @author Mark Doyle
 * @author Johannes Klug
 */
public final class BitSetUtility {
	private static final int BYTE_TO_INT_MASK = 0xFF;
	private static final int WORD_LENGTH = 64;
	private static final int BIN_DUMP_LINE_SIZE = 64;
	private static final int OCTET_SIZE = 8;
	private static final Logger LOG = LoggerFactory.getLogger(BitSetUtility.class);

	public static enum FloatSizeInBits {
		THIRTY_TWO(32), SIXTY_FOUR(64);

		private final int size;

		FloatSizeInBits(final int size) {
			this.size = size;
		}

		public int getSize() {
			return size;
		}
	}

	/**
	 * This is a Utility class containing only static methods. It cannot and should not be instantiated.
	 */
	private BitSetUtility() {
		// Utility class
	}

	/**
	 * Encodes a bitset in binary format, i.e. a string in the format '01100101...'.
	 *
	 * The encoding always follows sequentially from the least significant bit to the most significant bit, i.e. the
	 * value 1 encoded in a 8 bit field is '1000000' not '0000001' as people are used too.
	 *
	 * To simplify the reading, a space is inserted for each byte and only 8 bytes are displayed per line. The string is
	 * thus formatted as; '00000000 00000000 10000000 10010111 11111111 00011101 11000100 11100000' '01100100 10111100
	 * 10000000 10010111 11000001 10001101 00101100 10000011'
	 *
	 * Notice that the complete bitset is displayed. A bit set is always an equal number of words, i.e. encoding on bit
	 * at the start of a bitset will create a 64 bit long BitSet with 1 bit set. This function will print '10000000
	 * 00000000 00000000 00000000 00000000 00000000 00000000 00000000'
	 *
	 * @param BitSet
	 *            The bitset to be converted to a string.
	 * @return A string representing the bitset in binary format.
	 *
	 */
	public static String binDump(final BitSet data) {
		String dump = "";
		final String[] bits = data.toString().replaceAll("\\{", "").replaceAll("\\}", "").split(", ");

		int totalIndex = 0;
		int lineIndex = 0;
		int octetIndex = 0;
		int bitIndex = 0;

		while (totalIndex < data.size()) {
			if (bitIndex < bits.length && bits[bitIndex].equals("") == false && totalIndex == Integer.parseInt(bits[bitIndex])) {
				dump += "1";
				++bitIndex;
			}
			else {
				dump += "0";
			}

			++totalIndex;
			++lineIndex;
			++octetIndex;

			if (octetIndex == OCTET_SIZE) {
				dump += " ";
				octetIndex = 0;
			}

			if (lineIndex == BIN_DUMP_LINE_SIZE) {
				dump += System.getProperty("line.separator");
				lineIndex = 0;
			}
		}

		// trim the trailing line.separator from the dump
		dump = StringUtils.trim(dump);

		return dump;
	}

	/**
	 * Creates a {@link BitSet} from a String. The String must represent bit states using a '0' or a '1' (ASCII values
	 * 48 or 49). Invalid characters in the String will cause a BitSetOperationException to be thrown.
	 *
	 * @param str
	 *            {@link String} encoding the required BitSet using 1's and 0's
	 * @param isBigEndian
	 *            Parameter determines whether to write the value from the left or right of the returned BitSet. In
	 *            other words, if you wish to interpret the BitSet later you must chose the endianess that will be used.
	 * @return a {@link BitSet} equal to the BitSet encoded by the input String
	 * @throws BitSetOperationException
	 *             if the input string contains invalid characters, that is, not equal to 1 or 0
	 */
	public static BitSet stringToBitSet(final String binaryString, final boolean isBigEndian, final boolean bigEndianOut) throws BitSetOperationException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("I was passed: " + binaryString);
		}

		String str = binaryString;
		str = binaryString.trim();

		// If little endian
		if (!isBigEndian) {
			// ...and we want big endian output
			if (bigEndianOut) {
				str = StringUtils.reverse(str);
			}
		}
		// else if the input is big endian
		else {
			// ...and we want little endian
			if (!bigEndianOut) {
				str = padStringFromTheFront(str, WORD_LENGTH);
			}
			else {
				str = StringUtils.reverse(str);
				str = padStringFromTheFront(str, WORD_LENGTH);
			}
		}

		final BitSet result = new BitSet(str.length());

		int count = 0;
		int crement = 1; // Haha, the CREMENT!

		if (isBigEndian) {
			// count = result.size() - 1;
			count = str.length() - 1;
			crement = -1;
		}

		for (final byte c : str.getBytes()) {
			// If character '1' flip the bit to "on"
			if (c == '1') {
				result.flip(count);
			}
			// else the bit must be equal to 48 ('0'); if not we have a problem...
			else if (c != '0') {
				throw new BitSetOperationException("Invalid bit string, cannot infer 0 or 1 from character " + c);
			}
			count += crement;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Returning: " + binDump(result));
		}

		return result;
	}

	/**
	 * Converts the passed BitSet into a binary string.
	 *
	 * A flag is used to determine whether you wish to convert the logical bitSet or the entire BitSet. If
	 * useLogicalSize is set to false it will use the complete BitSet i.e. the size and <b><i>not</i></b> the length.
	 * Note: BitSets always finish on 64 bit a boundary.
	 *
	 * If useLogicalSize is set to true it will use the logical BitSet, that is, only the relevant set bits
	 *
	 * Whichever one you choose the returned value will equate to the same, however, if you set useLogicalSize to false
	 * you will get the complete 0 padded BitSet.
	 *
	 * @param data
	 * @param useLogicalSize
	 * @return
	 */
	public static String bitSetToBinaryString(final BitSet data, final boolean useLogicalSize) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("I was passed: " + BitSetUtility.binDump(data));
		}
		int bitSetSize;
		if (useLogicalSize) {
			bitSetSize = data.length();
		}
		else {
			bitSetSize = data.size();
		}

		final StringBuilder binaryString = new StringBuilder(bitSetSize);
		for (int i = 0; i < bitSetSize; i++) {
			if (data.get(i)) {
				binaryString.append('1');
			}
			else {
				binaryString.append('0');
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Returning: " + binaryString.toString());
		}

		return binaryString.toString();
	}

	/**
	 * FIXME Javadoc
	 *
	 * @param data
	 * @param length
	 * @return
	 */
	public static String bitSetToBinaryString(final BitSet data, final int length) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("I was passed: " + BitSetUtility.binDump(data));
		}
		final int bitSetSize = length;

		final StringBuilder binaryString = new StringBuilder(bitSetSize);
		for (int i = 0; i < bitSetSize; i++) {
			if (data.get(i)) {
				binaryString.append('1');
			}
			else {
				binaryString.append('0');
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Returning: " + binaryString.toString());
		}

		return binaryString.toString();
	}

	public static String padStringFromTheFront(final String binaryString, final int finalLength) {
		final int zeroesToAdd = finalLength - binaryString.length();
		if (LOG.isDebugEnabled()) {
			LOG.debug("Padding " + zeroesToAdd + " zero(s) to the front of the binary string " + binaryString);
		}

		String newString = "";
		for (int i = 0; i < zeroesToAdd; i++) {
			newString += '0';
		}

		newString += binaryString;

		if (LOG.isDebugEnabled()) {
			LOG.debug("Padded string is now " + newString);
		}
		return newString;
	}

	public static String padStringFromTheBack(final String string, final int finalLength) {
		final int zeroesToAdd = finalLength - string.length();
		if (LOG.isDebugEnabled()) {
			LOG.debug("Padding " + zeroesToAdd + " zero(s) to the back of the binary string " + string);
		}

		int capacity = string.length() + zeroesToAdd;
		final StringBuilder newBinaryString = new StringBuilder(capacity);
		newBinaryString.append(string);

		for (int i = 0; i < zeroesToAdd; i++) {
			newBinaryString.append('0');
		}

		return newBinaryString.toString();
	}

	/**
	 * TODO Can we remove the magic numbers?
	 *
	 * @param bits
	 * @return
	 */
	public static float toFloat(final BitSet bits) {
		final byte[] bytes = toByteArray(bits, 32);

		int intFromBitset = 0;
		int requiredByteShifts = 3;
		int bytePosition = requiredByteShifts;
		for(int i = 0; i < Integer.SIZE / 8; i++) {
			intFromBitset += (bytes[i] & BYTE_TO_INT_MASK) << bytePosition * Byte.SIZE;
			bytePosition--;
		}

		return Float.intBitsToFloat(intFromBitset);
	}

	/**
	 * TODO Can we remove the magic numbers?
	 *
	 * @param bits
	 * @return
	 */
	public static double toDouble(final BitSet bits) {
		final byte[] bytes = toByteArray(bits, 64);

		long longFromBitset = 0;

		longFromBitset += (long) (bytes[0] & BYTE_TO_INT_MASK) << 56;
		longFromBitset += (long) (bytes[1] & BYTE_TO_INT_MASK) << 48;
		longFromBitset += (long) (bytes[2] & BYTE_TO_INT_MASK) << 40;
		longFromBitset += (long) (bytes[3] & BYTE_TO_INT_MASK) << 32;
		longFromBitset += (long) (bytes[4] & BYTE_TO_INT_MASK) << 24;
		longFromBitset += (long) (bytes[5] & BYTE_TO_INT_MASK) << 16;
		longFromBitset += (long) (bytes[6] & BYTE_TO_INT_MASK) << 8;
		longFromBitset += (bytes[7] & BYTE_TO_INT_MASK);

		return Double.longBitsToDouble(longFromBitset);
	}

	/**
	 * FIXME javadoc
	 *
	 * @param bitset
	 * @param sizeInBits
	 * @return
	 */
	public static final byte[] toByteArray(final BitSet bitset, final int sizeInBits) {
		// Split into Bytes.
		int numberOfBytes = sizeInBits / Byte.SIZE;
		// Any remaining bits require an extra Byte
		if (sizeInBits % Byte.SIZE != 0) {
			numberOfBytes++;
		}
		final byte[] bytes = new byte[numberOfBytes];

		int bitSetPosition = 0;
		for (int byteNo = 0; byteNo < numberOfBytes; byteNo++) {
			bytes[byteNo] = 0;
			for (int i = Byte.SIZE; i >= 1; i--) {
				if (bitset.get(bitSetPosition)) {
					bytes[byteNo] += Math.pow(2, i - 1);
				}
				bitSetPosition++;
			}
		}
		return bytes;
	}

	/**
	 * Takes a byte array and returns a BitSet of the same value.
	 *
	 * @param bytes
	 * @return
	 */
	public static final BitSet fromByteArray(final byte[] bytes) {
		final int bitsToSet = bytes.length * Byte.SIZE;
		final BitSet result = new BitSet(bitsToSet);

		// Loop over the number of bits we must set in the BitSet to convert this byte array.
		for (int i = 0; i < bitsToSet; i++) {
			// calculate which byte in the array covers this bit index
			final int byteIndex = i / Byte.SIZE;
			// Mask the byte with a mask which contains a 1 set in the current bit index we are working on.
			// We mask the byte moving a 1 from left to right
			final int maskShift = i % 8;

			if ((bytes[byteIndex] & (128 >>> maskShift)) > 0) {
				// if the results is > 0 i.e. the bit at position i is set to 1 in the byte
				// then set the same position in the BitSet
				result.set(i);
			}
		}
		return result;
	}

	public static BitSet reverse(final BitSet bitset, final int sizeInBits) {
		final BitSet reversed = new BitSet();

		int reversedIndex = 0;
		for (int i = sizeInBits - 1; i >= 0; i--) {
			if (bitset.get(i)) {
				reversed.set(reversedIndex);
			}
			reversedIndex++;

		}
		return reversed;
	}

}
