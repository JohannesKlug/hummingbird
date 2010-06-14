package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

public interface ParameterBehaviour {
	
	public long getSizeIntBits();
	
	public void insertIntoBitSet(BitSet bitSetTarget);
	
	public BitSet getRawParameterBinary(BitSet packet); 

}
