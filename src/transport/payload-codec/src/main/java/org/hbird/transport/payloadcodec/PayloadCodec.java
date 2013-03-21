package org.hbird.transport.payloadcodec;

import java.util.BitSet;
import java.util.List;

import org.hbird.core.commons.data.GenericPayload;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.hbird.core.spacesystemmodel.tmtc.TmTcGroup;

public interface PayloadCodec {

	ParameterGroup decode(byte[] payload, List<String> layoutIdentifier, long timeStamp) throws UnknownParameterGroupException;

	ParameterGroup decode(BitSet payload, List<String> layoutIdentifier, long timeStamp) throws UnknownParameterGroupException;

	ParameterGroup decode(GenericPayload payload) throws UnknownParameterGroupException;

	byte[] encodeToByteArray(ParameterGroup parameterGroup);

	GenericPayload encodeToGenericPayload(TmTcGroup parameterGroup);

}
