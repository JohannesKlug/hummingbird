package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

/**
 * Parameter behaviour for an IEEE 754 64-bit precision Float.
 * @author Mark Doyle
 *
 */
public class Float64Behaviour extends AbstractFloatBehaviour {

	public Float64Behaviour() {
		super(64l);
	}

	@Override
	public Double valueFromBitSet(BitSet packet) {
		// TODO Auto-generated method stub
		return null;
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
