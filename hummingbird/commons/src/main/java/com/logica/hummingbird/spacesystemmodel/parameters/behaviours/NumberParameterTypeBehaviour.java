package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

public interface NumberParameterTypeBehaviour {
	
	public Number valueFromBitSet(BitSet binary);
	
	public void insertIntoBitSet(BitSet bitSetTarget);
	
	public int getSizeIntBits();

}
