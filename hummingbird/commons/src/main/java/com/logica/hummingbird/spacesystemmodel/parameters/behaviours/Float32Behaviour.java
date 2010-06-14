package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

/**
 * Parameter behaviour for an IEEE 754 32-bit precision FLoat.
 * @author Mark Doyle
 *
 */
public class Float32Behaviour extends AbstractFloatBehaviour {

	public Float32Behaviour() {
		super(32l);
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
	public void insertIntoBitSet(BitSet bitSetTarget, int offset) {
		// TODO Auto-generated method stub
		
	}


}
