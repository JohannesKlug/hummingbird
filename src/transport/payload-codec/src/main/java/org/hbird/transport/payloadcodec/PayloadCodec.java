package org.hbird.transport.payloadcodec;

import java.util.BitSet;

import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;


public interface PayloadCodec {

	ParameterGroup decode(byte[] payload, Object payloadLayoutId);
	ParameterGroup decode(BitSet payload, Object payloadLayoutId) throws UnknownParameterGroupException;

	byte[] encodeToByteArray(ParameterGroup parameterGroup);
	BitSet encodeToBitSet(ParameterGroup parameterGroup);
}
