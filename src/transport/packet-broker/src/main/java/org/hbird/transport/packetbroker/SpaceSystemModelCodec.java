package org.hbird.transport.packetbroker;

import java.util.BitSet;

import org.hbird.transport.spacesystemmodel.ParameterGroup;

public interface SpaceSystemModelCodec {

	public ParameterGroup decode(Byte[] inStream);
	
	public ParameterGroup decode(BitSet inStream);
	
	public Byte[] encodeToByteArray(ParameterGroup parameterGroup);
	
	public BitSet encodeToBitSet(ParameterGroup parameterGroup);
}
