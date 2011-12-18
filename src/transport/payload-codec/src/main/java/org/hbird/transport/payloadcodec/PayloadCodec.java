package org.hbird.transport.payloadcodec;

import java.util.BitSet;

import org.hbird.core.commons.data.GenericPayload;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;


public interface PayloadCodec {

	ParameterGroup decode(byte[] payload, String payloadLayoutId, long timeStamp) throws UnknownParameterGroupException;
	ParameterGroup decode(BitSet payload, String payloadLayoutId, long timeStamp) throws UnknownParameterGroupException;
	
	ParameterGroup decode(GenericPayload payload) throws UnknownParameterGroupException;

	byte[] encodeToByteArray(ParameterGroup parameterGroup);
	GenericPayload encodeToGenericPayload(ParameterGroup parameterGroup);
}
