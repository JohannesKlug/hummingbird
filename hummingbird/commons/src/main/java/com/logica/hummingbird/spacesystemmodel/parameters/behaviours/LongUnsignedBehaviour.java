package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;

public class LongUnsignedBehaviour extends AbstractIntegerBehaviour {
	
	public LongUnsignedBehaviour(long sizeInBits) throws InvalidParameterTypeException {
		super(sizeInBits);
		if(sizeInBits > 64) {
			throw new InvalidParameterTypeException("LongUnsigned cannot be greater than 64-bits in size.");
		}
	}

	@Override
	public Long valueFromBitSet(BitSet packet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BitSet getRawParameterBinary(BitSet packet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BitSet insertIntoBitSet(BitSet bitSetTarget, int offset) {
		return bitSetTarget;
		// TODO Auto-generated method stub
	}

}
