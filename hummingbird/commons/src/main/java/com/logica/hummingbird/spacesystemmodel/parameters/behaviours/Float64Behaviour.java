package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

/**
 * Parameter behaviour for an IEEE 754 64-bit precision Float.
 * @author Mark Doyle
 *
 */
public class Float64Behaviour extends AbstractNumberBehaviour implements NumberParameterTypeBehaviour {

	public Float64Behaviour() {
		super(64);
	}

	@Override
	public Float valueFromBitSet(BitSet packet) {
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
