/* ----------------------------------------------------------------------------
 * (c) Copyright Logica 2010
 *
 * All rights reserved. This document is protected by international copyright 
 * law and may not be reprinted, reproduced, copied or utilised in whole or in 
 * part by any means including electronic, mechanical, or other means without 
 * the prior written consent of Logica. 
 * Whilst reasonable care has been taken by Logica to ensure the information 
 * contained herein is reasonably accurate, Logica shall not, under any 
 * circumstances be liable for any loss or damage (direct or consequential) 
 * suffered by any party as a result of the contents of this publication or the 
 * reliance of any party thereon or any inaccuracy or omission therein. The 
 * information in this document is therefore provided on an "as is" basis 
 * without warranty and is subject to change without further notice and cannot 
 * be construed as a commitment by Logica. 
 * The products mentioned in this document are identified by the names, 
 * trademarks, service marks and logos of their respective companies or 
 * organisations and may not be used in any advertising or publicity or in any 
 * other way whatsoever without the prior written consent of those companies 
 * or organisations and Logica.
 * ----------------------------------------------------------------------------
 * System       : Hummingbird
 * Author       : VillemosG
 * Created on   : 08.01.2010
 * ----------------------------------------------------------------------------
 */
package com.logica.hummingbird.util;

import java.util.BitSet;

import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;

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
	 * Extracts an integer value from the given <tt>BitSet</tt> from offset of the given amount of bits (given by
	 * <tt>lenght</tt>).
	 * 
	 * @param bitSet
	 *            the bit set to operate on
	 * @param offset
	 *            the offset in the bit set
	 * @param length
	 *            the length of the bit string that represents the encoded int
	 * @param isSigned
	 * @return the extracted integer value
	 * @throws RuntimeException
	 *             if <tt>length</tt> is greater than the bit-count of int
	 */
	public static long extractInteger(BitSet bitSet, int offset, int length, boolean isSigned) {
		long newValue = 0;
		int mask = 1;

		int end = length;
		if (isSigned) {
			end = length - 1;
		}

		for (int i = 0; i < end; i++, mask <<= 1) {
			if (bitSet.get(offset + i)) {
				newValue |= mask;
			}
		}

		if (isSigned && bitSet.get(offset + length - 1)) {
			newValue *= -1;
		}

		return newValue;
	}

	/**
	 * Encodes the given integer value in the <tt>BitSet</tt> from the position offset by the given amount of bits.
	 * 
	 * @param bitSet
	 *            the <tt>BitSet</tt> to operate on
	 * @param offset
	 *            the offset in the bit set
	 * @param length
	 *            the length of the bit string that should represent the given value
	 * @param value
	 *            the value to encode in the bit set
	 * @return the modified bit set
	 * @throws RuntimeException
	 *             if <tt>length</tt> is greater than the amount of bits in an integer value
	 * @throws RuntimeException
	 *             if <tt>value</tt> is greater than the value encodeable by the given amount of bits or if value ==
	 *             Integer.MIN_VALUE (no absolute value available as int)
	 */
	public static BitSet insertInteger(BitSet bitSet, int offset, int length, long value) {
		// checking the bit length
		if (length > Integer.SIZE)
			throw new RuntimeException("You can not set a higher length than " + Integer.SIZE + " bits.");

		// checking whether the value fits into the bit string of length - 1
		int absValue = Math.abs((int) value);
		if (absValue > Math.pow(2.0, length) - 1 || value == Integer.MIN_VALUE)
			throw new RuntimeException("The value of " + value + " does not fit into a bit string of " + (length - 1) + " bits.");

		// setting all bits to zero
		bitSet.clear(offset, offset + length - 1);

		// setting up the number in reverse order
		int mask = 1;
		for (int i = 0; i < length; ++i, mask <<= 1)
			if ((mask & absValue) > 0)
				bitSet.set(offset + i);

		// setting up the sign
		if (value < 0)
			bitSet.set(offset + length - 1);

		return bitSet;
	}

	/**
	 * Extracts a floating point number from <tt>bitSet</tt> from the offset position to the given offset+length-1. It
	 * does the reverse scaling done by
	 * <tt>public static BitSet doubleToBitSet(BitSet bitSet, int offset, int length, double minValue,
	 double maxValue, double value)</tt>.
	 * 
	 * @param bitSet
	 *            the bit set to operate on
	 * @param offset
	 *            the offset position in the bit set
	 * @param length
	 *            the number of bit that represent the value
	 * @param minValue
	 *            the same value set in <tt>doubleToBitSet(...)</tt>
	 * @param maxValue
	 *            the same value set in <tt>doubleToBitSet(...)</tt>
	 * @return the back scaled value from the bit set
	 * @see public static BitSet doubleToBitSet(BitSet bitSet, int offset, int length, double minValue, double maxValue,
	 *      double value)
	 * @throws RuntimeException
	 *             if the number of bits given by <tt>length</tt> is greater than Long.SIZE
	 */
	public static double extractFloat(BitSet bitSet, int offset, FloatSizeInBits floatSize) {
		// Float.intBitsToFloat(b1010101);
		//		
		// int length = floatSize.getSize();
		//
		// // getting the value as natural number from the bitSet
		// long longValue = 0;
		// long mask = 1;
		// for (int i = 0; i < length; ++i, mask <<= 1) {
		// if (bitSet.get(offset + i)) {
		// longValue |= mask;
		// }
		// }
		//
		// // hint: without sign!
		// long max = (int) (Math.pow(2.0, length - 1) * 2 - 1);
		//
		// // returning the scaled back double value
		// return (longValue / (max / (maxValue - minValue)) + minValue);
		BitSet actualBitSet = bitSet.get(offset, offset + floatSize.size);
		
		return Double.longBitsToDouble(BitSetUtility.toLong(actualBitSet));
	}

	public static BitSet insertFloat(BitSet bitSet, int offset, FloatSizeInBits floatSize, double value) throws BitSetOperationException {
		BitSet floatBitSet = floatToBitSet(floatSize, value);

		for (int i = 0; i < floatSize.getSize(); i++) {
			if (floatBitSet.get(i)) {
				bitSet.set(i + offset);
			}
			else {
				bitSet.set(i + offset);
			}
		}
		return bitSet;
	}

	public static BitSet floatToBitSet(FloatSizeInBits floatSize, double value) throws BitSetOperationException {
		BitSet bitSet = new BitSet(floatSize.getSize());

		String binaryString = new String();
		if (floatSize == FloatSizeInBits.THIRTY_TWO) {
			// Parse as IEEE-754 Single Precision (32-bit) (Java Float)
			int intBits = Float.floatToIntBits((float) value);
			binaryString = Integer.toBinaryString(intBits);

		}
		else if (floatSize == FloatSizeInBits.SIXTY_FOUR) {
			// Parse as IEEE-754 Double Precision (64-bit) (Java Double)
			Long longBits = Double.doubleToLongBits(value);
			binaryString = Long.toBinaryString(longBits);
		}

		if (value >= 0) {
			// We have to add the Sign bit manually for positive Numbers
			binaryString = '0' + binaryString;
		}

		for (int bitIndex = 0; bitIndex < floatSize.getSize(); bitIndex++) {
			if (bitIndex < binaryString.length()) {
				if (binaryString.charAt(bitIndex) == '0') {
					bitSet.clear(bitIndex);
				}
				else if (binaryString.charAt(bitIndex) == '1') {
					bitSet.set(bitIndex);
				}
				else {
					throw new BitSetOperationException("Error converting floating point number '" + value + "' to a BitSet: invalid character '" + binaryString
							.charAt(bitIndex) + "' encountered at position " + bitIndex + ".");
				}
			}
			else {
				// When we run out of characters in our binaryString, set the rest to zero.
				bitSet.clear(bitIndex);
			}
		}

		return bitSet;
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

		return dump;
	}

	/**
	 * Creates a {@link BitSet} from a String. The String must represent bit states using a '0' or a '1' (ASCII values
	 * 48 or 49). Invalid characters in the String will cause a BitSetOperationException to be thrown.
	 * 
	 * @param str
	 *            {@link String} encoding the required BitSet using 1's and 0's
	 * @return a {@link BitSet} equal to the BitSet encoded by the input String
	 * @throws BitSetOperationException
	 *             if the input string contains invalid characters, that is, not equal to 1 or 0
	 */
	public static BitSet stringToBitSet(String str) throws BitSetOperationException {
		str = str.trim();
		BitSet result = new BitSet(str.length());
		int count = 0;
		for (byte c : str.getBytes()) {
			// If character '1' flip the bit to "on"
			if (c == '1') {
				result.flip(count);
			}
			// else the bit must be equal to 48 ('0'); if not we have a problem...
			else if (c != '0') {
				throw new BitSetOperationException("Invalid bit string, cannot infer 0 or 1 from character " + c);
			}
			count++;
		}

		return result;
	}

	public static long toLong(BitSet bitset) {
		return Long.parseLong(BitSetUtility.toBinaryBigEndianString(bitset, false), 2);
	}

	public static String toBinaryBigEndianString(BitSet data, boolean pad) {
		String binaryString = "";

		int iterateCount;
		if(pad) {
			iterateCount = data.size() - 1;
		}
		else {
			iterateCount = data.length() - 1 ;
		}
		
		for (int i = iterateCount; i >= 0; i--) {
			if (data.get(i)) {
				binaryString += '1';
			}
			else {
				binaryString += '0';
			}
		}
		return binaryString;
	}
}
