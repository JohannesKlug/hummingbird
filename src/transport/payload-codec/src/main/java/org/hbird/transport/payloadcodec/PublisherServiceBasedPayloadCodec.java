package org.hbird.transport.payloadcodec;

import java.util.BitSet;

import org.hbird.core.commons.data.GenericPayload;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.core.commons.tmtc.TmTcGroup;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;

/**
 * TODO publisher update mechanism, the publisher needs to be able to update the payload codec.
 * 
 * @author Mark Doyle
 * 
 */
public class PublisherServiceBasedPayloadCodec implements PayloadCodec {

	private InMemoryPayloadCodec codec;
	private SpaceSystemPublisher publisher;

	public void cacheModelInformation() {
		codec = new InMemoryPayloadCodec(publisher.getParameterGroups(), publisher.getCommands(), publisher.getEncodings(), publisher.getRestrictions());
	}

	public void setPublisher(final SpaceSystemPublisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public ParameterGroup decode(final byte[] payload, final String payloadLayoutId, final long timeStamp) throws UnknownParameterGroupException {
		return this.codec.decode(payload, payloadLayoutId, timeStamp);
	}

	@Override
	public ParameterGroup decode(final BitSet payload, final String payloadLayoutId, final long timeStamp) throws UnknownParameterGroupException {
		return this.codec.decode(payload, payloadLayoutId, timeStamp);
	}

	@Override
	public ParameterGroup decode(final GenericPayload payload) throws UnknownParameterGroupException {
		return this.codec.decode(payload);
	}

	@Override
	public byte[] encodeToByteArray(final ParameterGroup parameterGroup) {
		return this.codec.encodeToByteArray(parameterGroup);
	}

	@Override
	public GenericPayload encodeToGenericPayload(final TmTcGroup parameterGroup) {
		return this.codec.encodeToGenericPayload(parameterGroup);
	}

}
