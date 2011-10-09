package org.hbird.transport.payloadcodec;

import java.util.BitSet;

import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;


public interface PayloadCodec {

	ParameterGroup decode(byte[] payload, Object payloadLayoutId);
	ParameterGroup decode(BitSet payload, Object payloadLayoutId);

	byte[] encodeToByteArray(ParameterGroup parameterGroup);
	BitSet encodeToBitSet(ParameterGroup parameterGroup);
}
