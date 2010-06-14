package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;

public class IntegerUnsignedBehaviour extends AbstractIntegerBehaviour {
	private static final Logger LOG = LoggerFactory.getLogger(IntegerUnsignedBehaviour.class);
	
	public IntegerUnsignedBehaviour(long sizeInBits) throws InvalidParameterTypeException {
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
		
		LOG.debug("Calculated value from bitset was: " + parameterValue);
		return parameterValue;
	}

	@Override
	public BitSet getRawParameterBinary(BitSet packet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertIntoBitSet(BitSet bitSetTarget, int offset) {
		// TODO Auto-generated method stub
		
	}


}
