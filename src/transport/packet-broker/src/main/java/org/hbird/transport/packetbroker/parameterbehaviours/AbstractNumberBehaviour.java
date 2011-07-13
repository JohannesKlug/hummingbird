package org.hbird.transport.packetbroker.parameterbehaviours;

import java.util.BitSet;

/**
 * Abstract class providing the get size in bits functionality which is common across all NumberParameterTypeBehaviours.
 * 
 * @author Mark Doyle
 * 
 */
public abstract class AbstractNumberBehaviour implements ParameterBehaviour {

	protected final int SIZE_IN_BITS;

	protected final boolean isBigEndian;

	public AbstractNumberBehaviour(final int sizeInBits, final boolean isBigEndian) {
		this.SIZE_IN_BITS = sizeInBits;
		this.isBigEndian = isBigEndian;
	}

	@Override
	public int getSizeInBits() {
		return SIZE_IN_BITS;
	}

	@Override
	public BitSet getRawParameterBitSet(final BitSet packet) {
		int offset = 0;
		return packet.get(offset, offset + getSizeInBits());
	}
}
