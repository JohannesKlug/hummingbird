package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;

public abstract class AbstractFloatBehaviour extends AbstractNumberBehaviour {

	public AbstractFloatBehaviour(long sizeInBits) {
		super(sizeInBits);
	}

	/**
	 * Converts a binary string into a bitset of length SIZE_IN_BITS defined in superclass {@link AbstractNumberBehaviour}
	 * @param binaryString the binary string to convert
	 * @return a new BitSet matching the supplied string
	 * @throws BitSetOperationException if an invalid character is encountered.  Strings must be made up of 1's or 0's
	 */
	protected BitSet bitSetFromString(String binaryString) throws BitSetOperationException {
		BitSet valueBitSet = new BitSet((int) getSizeIntBits());

		for (int bitIndex = 0; bitIndex < getSizeIntBits(); bitIndex++) {
			if (bitIndex < binaryString.length()) {
				if (binaryString.charAt(bitIndex) == '0') {
					valueBitSet.clear(bitIndex);
				}
				else if (binaryString.charAt(bitIndex) == '1') {
					valueBitSet.set(bitIndex);
				}
				else {
					throw new BitSetOperationException("Error converting floating point String to a BitSet: invalid character '" + binaryString
							.charAt(bitIndex) + "' encountered at position " + bitIndex + ".");
				}
			}
			else {
				// When we run out of characters in our binaryString, set the rest to zero.
				valueBitSet.clear(bitIndex);
			}
		}
		
		return valueBitSet;
	}
	
	
}
