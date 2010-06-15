package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;

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
	 * @throws BitSetOperationException 
	 */
	public BitSet insertIntoBitSet(Number number, BitSet bitSetTarget, int offset) throws BitSetOperationException; 

}
