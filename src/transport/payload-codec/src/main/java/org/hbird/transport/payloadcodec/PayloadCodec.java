package org.hbird.transport.payloadcodec;

import java.util.BitSet;

import org.hbird.transport.spacesystemmodel.ParameterGroup;

public interface PayloadCodec {

	ParameterGroup decode(byte[] payload, Object payloadLayoutId);
	ParameterGroup decode(BitSet payload, Object payloadLayoutId);

	Byte[] encodeToByteArray(ParameterGroup parameterGroup);
}
