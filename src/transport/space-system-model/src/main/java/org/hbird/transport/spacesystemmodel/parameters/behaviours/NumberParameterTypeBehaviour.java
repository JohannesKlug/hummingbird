package org.hbird.transport.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

public interface NumberParameterTypeBehaviour extends ParameterBehaviour {
	
	public Number valueFromBitSet(BitSet packet);
	
	public String getTypeName();

}
