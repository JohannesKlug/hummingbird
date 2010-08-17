package com.logica.hummingbird.util;

import java.util.BitSet;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.util.exceptions.BitSetOperationException;

/**
 * The bitset utilities class helps the encoding / decoding of simple java types such as integer and float to a bitset.
 * 
 * TODO Make the class set the final bit + 1 in the set automatically.
 * 
 * @author Gert Villemos
 * @author Mark Doyle
 * @author Johannes Klug
 */
public class BitSetUtility {
	private static final Logger LOG = LoggerFactory.getLogger(BitSetUtility.class);

	public enum FloatSizeInBits {
		THIRTY_TWO(32), SIXTY_FOUR(64);

		private final int size;

		FloatSizeInBits(int size) {
			this.size = size;
		}

		public int getSize() {
			return size;
		}
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
	public static String binDump(BitSet data) {
		String dump = "";
		String[] bits = data.toString().replaceAll("\\{", "").replaceAll("\\}", "").split(", ");

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

			if (octetIndex == 8) {
				dump += " ";
				octetIndex = 0;
			}

			if (lineIndex == 64) {
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
	 * 			  Parameter determines whether to write the value from the left or right of the returned BitSet.
	 * 			  In other words, if you wish to interpret the BitSet later you must chose the endianess that
	 * 			  will be used.
	 * @return a {@link BitSet} equal to the BitSet encoded by the input String
	 * @throws BitSetOperationException
	 *             if the input string contains invalid characters, that is, not equal to 1 or 0
	 */
	public static BitSet stringToBitSet(String str, boolean isBigEndian, boolean bigEndianOut) throws BitSetOperationException {
		if(LOG.isDebugEnabled()) {
			LOG.debug("I was passed: " + str);
		}
		
		str = str.trim();
	
		// If little endian
		if (!isBigEndian) {
			// ...and we want big endian output
			if(bigEndianOut) {
				str = StringUtils.reverse(str);
			}
		}
		// else if the input is big endian
		else {
			// ...and we want little endian
			if(!bigEndianOut) {
				str = StringUtils.reverse(str);
			}
		}
		
		BitSet result = new BitSet(str.length());
		
		int count = 0;
		int crement = 1;
		
		if (isBigEndian) {
			count = result.size() - 1;
			crement = -1;
		}
		
		for (byte c : str.getBytes()) {
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
		
		if(LOG.isDebugEnabled()) {
			LOG.debug("Returning: " + binDump(result));
		}

		return result;
	}

	/**
	 * Converts the passed BitSet into a binary string.
	 * 
	 * A flag is used to determine whether you wish to convert the logical bitSet or
	 * the entire BitSet.
	 * If useLogicalSize is set to false it will use the complete BitSet i.e. the size 
	 * and <b><i>not</i></b> the length.  Note: BitSets always finish on 64 bit a boundary.
	 * 
	 * If useLogicalSize is set to true it will use the logical BitSet, that is, only the 
	 * relevant set bits
	 * 
	 * Whichever one you choose the returned value will equate to the same, however, if you
	 * set useLogicalSize to false you will get the complete 0 padded BitSet.
	 * 
	 * @param data
	 * @param useLogicalSize
	 * @return
	 */
	public static String bitSetToBinaryString(BitSet data, boolean useLogicalSize) {
		if(LOG.isDebugEnabled()) {
			LOG.debug("I was passed: " + BitSetUtility.binDump(data));
		}
		int bitSetSize;
		if (useLogicalSize) {
			bitSetSize = data.length();
		}
		else {
			bitSetSize = data.size();
		}

		StringBuilder binaryString = new StringBuilder(bitSetSize);
		for (int i = 0; i < bitSetSize; i++) {
			if (data.get(i)) {
				binaryString.append('1');
			}
			else {
				binaryString.append('0');
			}
		}
		
		if(LOG.isDebugEnabled()) {
			LOG.debug("Returning: " + binaryString.toString());
		}
		
		return binaryString.toString();
	}
	
	public static String bitSetToBinaryString(BitSet data, int length) {
		if(LOG.isDebugEnabled()) {
			LOG.debug("I was passed: " + BitSetUtility.binDump(data));
		}
		int bitSetSize = length;

		StringBuilder binaryString = new StringBuilder(bitSetSize);
		for (int i = 0; i < bitSetSize; i++) {
			if (data.get(i)) {
				binaryString.append('1');
			}
			else {
				binaryString.append('0');
			}
		}
		
		if(LOG.isDebugEnabled()) {
			LOG.debug("Returning: " + binaryString.toString());
		}
		
		return binaryString.toString();
	}

	public static String padStringFromTheFront(String string, int finalLength) {
		int zeroesToAdd = finalLength - string.length();
		if (LOG.isDebugEnabled()) {
			LOG.debug("Padding " + zeroesToAdd + " zero(s) to the front of the binary string " + string);
		}

		String newString = "";
		for (int i = 0; i < zeroesToAdd; i++) {
			newString += '0';
		}

		newString += string;

		return newString;
	}
	
	public static String padStringFromTheBack(String string, int finalLength) {
		int zeroesToAdd = finalLength - string.length();
		if (LOG.isDebugEnabled()) {
			LOG.debug("Padding " + zeroesToAdd + " zero(s) to the back of the binary string " + string);
		}

		String newString = "";
		for (int i = 0; i < zeroesToAdd; i++) {
			newString += '0';
		}

		string += newString;

		return string;
	}
	
	public static int toInt(BitSet bits) {
		byte[] bytes = toByteArray(bits, 32);
		
		int intFromBitset = 0;
		
		intFromBitset += (bytes[0] & 0xFF) << 24;
		intFromBitset += (bytes[1] & 0xFF) << 16;
		intFromBitset += (bytes[2] & 0xFF) << 8;
		intFromBitset += (bytes[3] & 0xFF);
		
		return intFromBitset;
	}
	
	public static long toLong(BitSet bits) {
		byte[] bytes = toByteArray(bits, 64);
		
		long longFromBitset = 0;
		
		longFromBitset += (long) (bytes[0] & 0xFF) << 56;
		longFromBitset += (long) (bytes[1] & 0xFF) << 48;
		longFromBitset += (long) (bytes[2] & 0xFF) << 40;
		longFromBitset += (long) (bytes[3] & 0xFF) << 32;
		longFromBitset += (long) (bytes[4] & 0xFF) << 24;
		longFromBitset += (long) (bytes[5] & 0xFF) << 16;
		longFromBitset += (long) (bytes[6] & 0xFF) << 8;
		longFromBitset += (long) (bytes[7] & 0xFF);
		
		return longFromBitset;
	}
	
	public static byte[] toByteArray(BitSet bits, int sizeInBits) {
		// Split into Bytes.
		int numberOfBytes = sizeInBits/8;
		// Any remaining bits require an extra Byte
		if (sizeInBits%8 != 0) {
			numberOfBytes++;
		}
		byte[] bytes = new byte[numberOfBytes];
		
		int bitSetPosition = 0;
		for (int byteNo=0; byteNo<numberOfBytes; byteNo++) {
			bytes[byteNo] = 0;
			for (int i=8; i>=1; i--) {
				if (bits.get(bitSetPosition)) {
					bytes[byteNo] += Math.pow(2, i-1);
				}
				bitSetPosition++;
			}
		}
		
		return bytes;
	}
	
}
