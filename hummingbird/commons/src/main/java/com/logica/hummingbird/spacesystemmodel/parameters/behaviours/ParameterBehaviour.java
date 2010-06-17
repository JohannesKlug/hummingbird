package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;

public interface ParameterBehaviour {
	
	public long getSizeIntBits();
	
	/**
	 * Returns the raw binary data of the parameter as a BitSet
	 * 
	 * @param packet the BitSet packet containing the parameter beginning 
	 * 		  at offset 0 i.e. the start of the BitSet 
	 * @return a BitSet of the raw binary data
	 */
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
