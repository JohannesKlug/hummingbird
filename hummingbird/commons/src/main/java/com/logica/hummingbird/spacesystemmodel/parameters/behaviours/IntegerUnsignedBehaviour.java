package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.util.BitSetUtility;

//TODO javadoc
public class IntegerUnsignedBehaviour extends AbstractIntegerBehaviour {
	private static final Logger LOG = LoggerFactory.getLogger(IntegerUnsignedBehaviour.class);
	
	public IntegerUnsignedBehaviour(int sizeInBits) throws InvalidParameterTypeException {
		super(sizeInBits);
		if(sizeInBits > 32) {
			throw new InvalidParameterTypeException("Integer unsigned cannot be greater than 32-bits in size.");
		}
	}

	@Override
	public Integer valueFromBitSet(BitSet packet) {
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
		int length = (int) getSizeIntBits();
		
		long unsignedInt = number.longValue();
		
		// checking the bit length against unsigned int
		if (length > Integer.SIZE + 1) {
			throw new RuntimeException("You can not set a higher length than " + (Integer.SIZE + 1) + " bits.");
		}

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
		return "Unsigned integer";
	}


}
