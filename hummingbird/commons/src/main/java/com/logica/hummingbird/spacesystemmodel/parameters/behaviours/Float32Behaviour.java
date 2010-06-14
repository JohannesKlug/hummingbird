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
	public BitSet insertIntoBitSet(Number number, BitSet bitSetTarget, int offset) {
		return bitSetTarget;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTypeName() {
		return "Float (IEEE754 Single precision 32-bit)"; 
	}


}
