package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;

/**
 * How do we handle unsigned longs in Java?  Long is always signed.  Perhaps some math package?
 * @author Mark Doyle
 * @author Johannes Klug
 *
 */
public class LongSignedBehaviour extends AbstractIntegerBehaviour {
	
	public LongSignedBehaviour(int sizeInBits) throws InvalidParameterTypeException {
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
	public BitSet insertIntoBitSet(Number number, BitSet bitSetTarget, int offset) {
		return bitSetTarget;
		// TODO Auto-generated method stub
	}

	@Override
	public String getTypeName() {
		return "Unsigned long";
	}

}
