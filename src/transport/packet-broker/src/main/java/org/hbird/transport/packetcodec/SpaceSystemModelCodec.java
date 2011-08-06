package org.hbird.transport.packetcodec;

import java.util.BitSet;

import org.hbird.transport.spacesystemmodel.ParameterGroup;

public interface SpaceSystemModelCodec {

	ParameterGroup decode(ParameterGroup parameterGroup, Byte[] inStream);

	ParameterGroup decode(ParameterGroup parameterGroup, BitSet inStream);

	Byte[] encodeToByteArray(ParameterGroup parameterGroup);

	BitSet encodeToBitSet(ParameterGroup parameterGroup);
}
