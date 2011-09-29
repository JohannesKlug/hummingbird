package org.hbird.transport.payloadcodec;

import org.hbird.transport.spacesystemmodel.ParameterGroup;

public interface PayloadCodec {

	ParameterGroup decode(Byte[] payload, Object payloadLayoutId);

	Byte[] encodeToByteArray(ParameterGroup parameterGroup);

}
