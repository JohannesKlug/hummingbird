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
	
	private final int SIZE_IN_BITS;
	
	protected final boolean isBigEndian;
	
	public AbstractNumberBehaviour(int sizeInBits, boolean isBigEndian) {
		this.SIZE_IN_BITS = sizeInBits;
		this.isBigEndian = isBigEndian;
	}

	@Override
	public int getSizeIntBits() {
		return SIZE_IN_BITS;
	}

	@Override
	public BitSet getRawParameterBinary(BitSet packet) {
		int offset = 0;
		return packet.get(offset, offset + getSizeIntBits());
	}
}
