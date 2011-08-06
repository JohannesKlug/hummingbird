package org.hbird.transport.packetcodec.codecparameters.number;
//package org.hbird.transport.packetcodec.codecparameters.number;
//
//import java.util.BitSet;
//
//import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
//
//public abstract class AbstractFloatBehaviour {
//
//	public AbstractFloatBehaviour(final int sizeInBits) {
//		super(sizeInBits, true);
//	}
//
//	/**
//	 * Converts a binary string into a bitset of length SIZE_IN_BITS defined in superclass {@link AbstractNumberCodec}
//	 * 
//	 * @param binaryString
//	 *            the binary string to convert
//	 * @return a new BitSet matching the supplied string
//	 * @throws BitSetOperationException
//	 *             if an invalid character is encountered. Strings must be made up of 1's or 0's or if the binary string
//	 *             is too long for this float type behaviour
//	 */
//	protected BitSet bitSetFromString(final String binaryString) throws BitSetOperationException {
//		if (binaryString.length() > getSizeInBits()) {
//			throw new BitSetOperationException("The provided binary string is longer than this floats behaviour. "
//					+ "String length = " + binaryString.length() + " and float length = " + getSizeInBits()
//					+ ".  Note: This is a " + getTypeName() + " behaviour");
//		}
//
//		BitSet valueBitSet = new BitSet((int) getSizeInBits());
//
//		for (int bitIndex = 0; bitIndex < getSizeInBits(); bitIndex++) {
//			if (bitIndex < binaryString.length()) {
//				if (binaryString.charAt(bitIndex) == '0') {
//					valueBitSet.clear(bitIndex);
//				}
//				else if (binaryString.charAt(bitIndex) == '1') {
//					valueBitSet.set(bitIndex);
//				}
//				else {
//					throw new BitSetOperationException(
//							"Error converting floating point String to a BitSet: invalid character '"
//									+ binaryString.charAt(bitIndex) + "' encountered at position " + bitIndex + ".");
//				}
//			}
//			else {
//				// When we run out of characters in our binaryString, set the rest to zero.
//				valueBitSet.clear(bitIndex);
//			}
//		}
//
//		return valueBitSet;
//	}
//
//
// }
