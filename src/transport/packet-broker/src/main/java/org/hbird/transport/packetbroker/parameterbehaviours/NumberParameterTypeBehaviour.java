package org.hbird.transport.packetbroker.parameterbehaviours;

import java.util.BitSet;

public interface NumberParameterTypeBehaviour extends ParameterBehaviour {
	
	public Number valueFromBitSet(BitSet packet);
	
	public String getTypeName();

}
