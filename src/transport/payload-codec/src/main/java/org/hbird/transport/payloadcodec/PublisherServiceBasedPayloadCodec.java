package org.hbird.transport.payloadcodec;

import java.util.BitSet;
import java.util.List;

import org.hbird.core.commons.data.GenericPayload;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.hbird.core.spacesystemmodel.tmtc.TmTcGroup;
import org.hbird.core.spacesystempublisher.interfaces.PublisherClient;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO publisher update mechanism, the publisher needs to be able to update the payload codec.
 * 
 * @author Mark Doyle
 * 
 */
public class PublisherServiceBasedPayloadCodec implements PayloadCodec, PublisherClient {
	private static final Logger LOG = LoggerFactory.getLogger(PublisherServiceBasedPayloadCodec.class);

	private InMemoryPayloadCodec codec;

	private SpaceSystemPublisher publisher;

	public void cacheModelInformation() {
		if (publisher != null) {
			codec = new InMemoryPayloadCodec(publisher.getParameterGroups(), publisher.getCommands(), publisher.getEncodings(), publisher.getRestrictions());
		}
		else {
			LOG.warn("Attempt to cache space system model information when there is no publisher service available");
		}
	}

	public void setPublisher(final SpaceSystemPublisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public ParameterGroup decode(final byte[] payload, final List<String> payloadLayoutIds, final long timeStamp) {
		return this.codec.decode(payload, payloadLayoutIds, timeStamp);
	}

	@Override
	public ParameterGroup decode(final BitSet payload, final List<String> payloadLayoutIds, final long timeStamp) {
		return this.codec.decode(payload, payloadLayoutIds, timeStamp);
	}

	@Override
	public ParameterGroup decode(final GenericPayload payload) {
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

	@Override
	public void entireModelUpdated() {
		// Reconfigure model
		this.codec.parameterGroups = publisher.getParameterGroups();
		this.codec.commandGroups = publisher.getCommands();
		this.codec.encodings = publisher.getEncodings();
		this.codec.restrictions = publisher.getRestrictions();
	}
}
