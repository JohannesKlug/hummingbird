package org.hbird.transport.payloadcodec;

import java.util.BitSet;

import org.hbird.core.commons.data.GenericPayload;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.core.commons.tmtc.TmTcGroup;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;

public interface PayloadCodec {

	ParameterGroup decode(byte[] payload, String payloadLayoutId, long timeStamp) throws UnknownParameterGroupException;

	ParameterGroup decode(BitSet payload, String payloadLayoutId, long timeStamp) throws UnknownParameterGroupException;

	ParameterGroup decode(GenericPayload payload) throws UnknownParameterGroupException;

	byte[] encodeToByteArray(ParameterGroup parameterGroup);

	GenericPayload encodeToGenericPayload(TmTcGroup parameterGroup);
}
