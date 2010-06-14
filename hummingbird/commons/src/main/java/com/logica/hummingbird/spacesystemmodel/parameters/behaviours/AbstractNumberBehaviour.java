package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

/**
 * Abstract class providing the get size in bits functionality which is common across all
 * NumberParameterTypeBehaviours.
 * 
 * @author Mark Doyle 
 *
 */
public abstract class AbstractNumberBehaviour implements NumberParameterTypeBehaviour {
	
	private final int SIZE_IN_BITS;
	
	public AbstractNumberBehaviour(int sizeInBits) {
		this.SIZE_IN_BITS = sizeInBits;
	}

	@Override
	public int getSizeIntBits() {
		return SIZE_IN_BITS;
	}
}
