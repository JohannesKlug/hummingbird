package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

/**
 * Abstract class providing the get size in bits functionality which is common across all
 * NumberParameterTypeBehaviours.
 * 
 * @author Mark Doyle 
 *
 */
public abstract class AbstractNumberBehaviour implements NumberParameterTypeBehaviour {
	
	private final long SIZE_IN_BITS;
	
	public AbstractNumberBehaviour(long sizeInBits) {
		this.SIZE_IN_BITS = sizeInBits;
	}

	@Override
	public long getSizeIntBits() {
		return SIZE_IN_BITS;
	}

	@Override
	public BitSet getRawParameterBinary(BitSet packet) {
		int offset = 0;
		return packet.get(offset, offset + (int) getSizeIntBits());
	}
}
