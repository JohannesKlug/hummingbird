package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

public interface ParameterBehaviour {
	
	public long getSizeIntBits();
	
	public BitSet getRawParameterBinary(BitSet packet);

	/**
	 * Inserts the Number into the bitSetTarget at position offset.
	 * 
	 * @param number
	 * @param bitSetTarget
	 * @param offset
	 * @return
	 */
	public BitSet insertIntoBitSet(Number number, BitSet bitSetTarget, int offset); 

}
