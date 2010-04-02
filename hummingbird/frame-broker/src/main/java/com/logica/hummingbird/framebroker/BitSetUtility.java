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
package com.logica.hummingbird.framebroker;

import java.util.BitSet;

import com.logica.hummingbird.framebroker.exceptions.BitSetOperationException;

/**
 * The bitset utilities class helps the encoding / decoding of simple java types
 * such as integer and float to a bitset.
 * 
 * TODO Make the class set the final bit + 1 in the set automatically.
 */
public class BitSetUtility
{
	/**
	 * Extracts an integer value from the given <tt>BitSet</tt> from offset of the given amount of
	 * bits (given by <tt>lenght</tt>).
	 * 
	 * @param bitSet the bit set to operate on
	 * @param offset the offset in the bit set
	 * @param length the length of the bit string that represents the encoded int
	 * @return the extracted integer value
	 * @throws RuntimeException if <tt>length</tt> is greater than the bit-count of int
	 */
	public static int extractInteger(BitSet bitSet, int offset, int length)
	{
		// checking the bit length
		if (length > Integer.SIZE)
			throw new RuntimeException("You can not set a higher length than " + Integer.SIZE
					+ " bits.");

		int newValue = 0;
		int mask = 1;
		for (int i = 0; i < length - 1; ++i, mask <<= 1)
			if (bitSet.get(offset + i))
				newValue |= mask;

		if (bitSet.get(offset + length - 1))
			newValue *= -1;

		return newValue;
	}

	/**
	 * Encodes the given integer value in the <tt>BitSet</tt> from the position offset by the
	 * given amount of bits.
	 * 
	 * @param bitSet the <tt>BitSet</tt> to operate on
	 * @param offset the offset in the bit set
	 * @param length the length of the bit string that should represent the given value
	 * @param value the value to encode in the bit set
	 * @return the modified bit set
	 * @throws RuntimeException if <tt>length</tt> is greater than the amount of bits in an
	 *         integer value
	 * @throws RuntimeException if <tt>value</tt> is greater than the value encodeable by the
	 *         given amount of bits or if value == Integer.MIN_VALUE (no absolute value available as
	 *         int)
	 */
	public static BitSet insertInteger(BitSet bitSet, int offset, int length, int value)
	{
		// checking the bit length
		if (length > Integer.SIZE)
			throw new RuntimeException("You can not set a higher length than " + Integer.SIZE
					+ " bits.");

		// checking whether the value fits into the bit string of length - 1
		int absValue = Math.abs(value);
		if (absValue > Math.pow(2.0, length) - 1 || value == Integer.MIN_VALUE)
			throw new RuntimeException("The value of " + value
					+ " does not fit into a bit string of " + (length - 1) + " bits.");

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
	 * Extracts a double value from <tt>bitSet</tt> from the offset position to the given
	 * offset+length-1. It does the reverse scaling done by
	 * <tt>public static BitSet doubleToBitSet(BitSet bitSet, int offset, int length, double minValue,
	 double maxValue, double value)</tt>.
	 * 
	 * @param bitSet the bit set to operate on
	 * @param offset the offset position in the bit set
	 * @param length the number of bit that represent the value
	 * @param minValue the same value set in <tt>doubleToBitSet(...)</tt>
	 * @param maxValue the same value set in <tt>doubleToBitSet(...)</tt>
	 * @return the back scaled value from the bit set
	 * @see public static BitSet doubleToBitSet(BitSet bitSet, int offset, int length, double
	 *      minValue, double maxValue, double value)
	 * @throws RuntimeException if the number of bits given by <tt>length</tt> is greater than
	 *         Long.SIZE
	 */
	public static double extractDouble(BitSet bitSet, int offset, int length, double minValue,
			double maxValue)
	{
		// checking the bit length
		if (length > Long.SIZE)
			throw new RuntimeException("You can not set a higher length than " + Long.SIZE
					+ " bits.");

		// getting the value as natural number from the bitSet
		long longValue = 0;
		long mask = 1;
		for (int i = 0; i < length; ++i, mask <<= 1)
			if (bitSet.get(offset + i))
				longValue |= mask;

		// hint: without sign!
		long max = (int) (Math.pow(2.0, length - 1) * 2 - 1);

		// returning the scaled back double value
		return (longValue / (max / (maxValue - minValue)) + minValue);
	}

	/**
	 * Encodes a double value in a <tt>BitSet</tt> by scaling the interval (given by minValue and
	 * maxValue) to the codomain of the natural number representable by n bits (n=length).
	 * <tt>minValue</tt> and <tt>maxValue</tt> are necessary to calculate a scaling function
	 * between the two codomains.
	 * 
	 * @param bitSet the <tt>BitSet</tt> to operate on
	 * @param offset the offset in the given bit set
	 * @param length the number of bits used to encode <tt>value</tt>
	 * @param minValue minimal value of <tt>value</tt>
	 * @param maxValue maximal value of <tt>value</tt>
	 * @param value the value to encode
	 * @return the manipulated bit set
	 * @throws BitSetOperationException 
	 * @throws RuntimeException if the value of <tt>value</tt> does not fit in ]minValue,
	 *         maxValue[
	 * @throws RuntimeException if the number of bits (<tt>length</tt>) is bigger than
	 *         <tt>Long.SIZE</tt>
	 */
	public static BitSet insertDouble(BitSet bitSet, int offset, int length, double minValue, double maxValue, double value) throws BitSetOperationException
	{
		if (value < minValue || value > maxValue) {
			throw new BitSetOperationException("Value " + value + " is out of bounds.  Bounds are from " + minValue + " to " + maxValue);
		}

		if (length > Long.SIZE) {
			throw new BitSetOperationException("You can not set a value greater than " + Long.SIZE + " bits in length.");
		}

		// scaling function:
		// x element of ]minValue, maxValue[
		// ==> f(x) element of ]0, (2^(length-1)*2 -1)[
		//
		// so:
		// f(x) = (x-minValue) * m
		// m = max / (maxValue - minValue)

		double intervalLength = maxValue - minValue;
		// hint: without sign!
		int max = (int) (Math.pow(2.0, length - 1) * 2 - 1);

		// scaling the input interval to the output interval of 0...2^(length-1)*2 -1
		long scaledValue = Math.round((value - minValue) * max / intervalLength);

		// putting the scaled value to the bitset (without any sign!)
		long mask = 1;
		for (int i = 0; i < length; ++i, mask <<= 1) {
			if ((mask & scaledValue) > 0) {
				bitSet.set(offset + i);
			}
		}
		
		return bitSet;
	}
	
	/**
	 * Encodes a bitset in binary format, i.e. a string in the format '01100101...'.
	 * 
	 * The encoding always follows sequentially from the least significant bit to the
	 * most significant bit, i.e. the value 1 encoded in a 8 bit field is '1000000' not
	 * '0000001' as people are used too.
	 *  
	 * To simplify the reading, a space is inserted for each byte and only 8 bytes are
	 * displayed per line. The string is thus formatted as;
	 *   '00000000 00000000 10000000 10010111 11111111 00011101 11000100 11100000' 
	 *   '01100100 10111100 10000000 10010111 11000001 10001101 00101100 10000011'
	 *   
	 * Notice that the complete bitset is displayed. A bit set is always an equal 
	 * number of words, i.e. encoding on bit at the start of a bitset will create a
	 * 64 bit long BitSet with 1 bit set. This function will print 
	 *   '10000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000'
	 *   
	 * @param BitSet The bitset to be converted to a string. 
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
	 * Creates a {@link BitSet} from a String.  The String must represent bit states using 
	 * a '0' or a '1' (ASCII values 48 or 49).  Invalid characters in the String will cause a 
	 * BitSetOperationException to be thrown.  
	 * @param str  {@link String} encoding the required BitSet using 1's and 0's
	 * @return a {@link BitSet} equal to the BitSet encoded by the input String
	 * @throws BitSetOperationException if the input string contains invald characters, that is, not equal to 1 or 0
	 */
	public static BitSet fromString(String str) throws BitSetOperationException {
		str = str.trim();
		BitSet result = new BitSet(str.length());
		int count = 0;
		for(byte c : str.getBytes()) {
			// If character '1' flip the bit to "on"
			if (c == 49) {
				result.flip(count);
			}
			// else the bit must be equal to 48 ('0'); if not we have a problem...
			else if (c != 48) {
				throw new BitSetOperationException("invalid bit string, cannot infer 0 or 1 frmo character " + c);
			}
			count++;
		}
		
		return result;
	}
	
	public static String toString(BitSet data) {
		String result = "";
			
		return result;
	}
}
