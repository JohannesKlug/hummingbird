package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.util.BitSetUtility;

//TODO javadoc
public class IntegerUnsignedBehaviour extends AbstractIntegerBehaviour {
	private static final Logger LOG = LoggerFactory.getLogger(IntegerUnsignedBehaviour.class);
	
	public IntegerUnsignedBehaviour(int sizeInBits, boolean isBigEndian) throws InvalidParameterTypeException {
		super(sizeInBits, isBigEndian);
		if(sizeInBits > 32) {
			throw new InvalidParameterTypeException("Integer unsigned cannot be greater than 32-bits in size.");
		}
	}

	// FIXME Using an int to contain the result, this means it will be treated as a signed int.  Boundary tests will have picked this up.
	@Override
	public Integer valueFromBitSet(BitSet packet) {
		if(LOG.isDebugEnabled()) {
			LOG.debug("Extracting value from " + BitSetUtility.binDump(packet));
		}
		
		int parameterValue = 0;
		int offset = 0;
		int mask = 1;

		for (int i = 0; i < getSizeIntBits(); i++, mask <<= 1) {
			if (packet.get(offset + i)) {
				parameterValue |= mask;
			}
		}
		
		if(LOG.isDebugEnabled()) {
			LOG.debug("Calculated value from bitset was: " + parameterValue);
		}
		return parameterValue;
	}

	@Override
	public BitSet insertIntoBitSet(Number number, BitSet bitSetTarget, int offset) {
		int length = getSizeIntBits();
		
		long unsignedInt = number.longValue();

		// checking whether the value fits into the bit string of length - 1
		long absValue = Math.abs(unsignedInt);
		if (absValue > Math.pow(2.0, length) - 1 || unsignedInt == Long.MIN_VALUE) {
			throw new RuntimeException("The value of " + unsignedInt + " does not fit into a bit string of " + (length - 1) + " bits.");
		}

		// setting all bits to zero
		bitSetTarget.clear(offset, offset + length - 1);

		// setting up the number in reverse order
		int mask = 1;
		for (int i = 0; i < length; ++i, mask <<= 1) {
			if ((mask & absValue) > 0) {
				bitSetTarget.set(offset + i);
			}
		}
		
		if(LOG.isDebugEnabled()) {
			LOG.debug("Calculated Bitset from value " + number.intValue() + " was: " + BitSetUtility.binDump(bitSetTarget));
		}

		return bitSetTarget;	
	}

	@Override
	public String getTypeName() {
		return getSizeIntBits() + "bit Unsigned integer";
	}


}
