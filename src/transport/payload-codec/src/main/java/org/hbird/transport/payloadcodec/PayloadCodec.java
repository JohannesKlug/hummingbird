package org.hbird.transport.payloadcodec;

import java.util.BitSet;
import java.util.List;

import org.hbird.core.commons.data.GenericPayload;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.hbird.core.spacesystemmodel.tmtc.TmTcGroup;
import org.hbird.transport.payloadcodec.exceptions.CodecConfigurationException;

public interface PayloadCodec {

	ParameterGroup decode(byte[] payload, List<String> layoutIdentifier, long timeStamp) throws CodecConfigurationException;

	ParameterGroup decode(BitSet payload, List<String> layoutIdentifier, long timeStamp) throws CodecConfigurationException;

	ParameterGroup decode(GenericPayload payload) throws CodecConfigurationException;

	byte[] encodeToByteArray(ParameterGroup parameterGroup) throws CodecConfigurationException;

	GenericPayload encodeToGenericPayload(TmTcGroup parameterGroup) throws CodecConfigurationException;

}
