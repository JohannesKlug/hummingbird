package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;

public class IntegerUnsignedBehaviour extends AbstractIntegerBehaviour {
	
	public IntegerUnsignedBehaviour(long sizeInBits) throws InvalidParameterTypeException {
		super(sizeInBits);
		if(sizeInBits > 32) {
			throw new InvalidParameterTypeException("Integer unsigned cannot be greater than 32-bits in size.");
		}
	}

	@Override
	public Integer valueFromBitSet(BitSet packet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BitSet getRawParameterBinary(BitSet packet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertIntoBitSet(BitSet bitSetTarget) {
		// TODO Auto-generated method stub

	}

}
