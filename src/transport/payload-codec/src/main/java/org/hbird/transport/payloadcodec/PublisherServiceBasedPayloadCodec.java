package org.hbird.transport.payloadcodec;

import java.util.BitSet;
import java.util.List;

import org.hbird.core.commons.data.GenericPayload;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.hbird.core.spacesystemmodel.tmtc.TmTcGroup;
import org.hbird.core.spacesystempublisher.exceptions.UnavailableSpaceSystemModelException;
import org.hbird.core.spacesystempublisher.interfaces.PublisherClient;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.hbird.transport.payloadcodec.exceptions.CodecConfigurationException;
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

	public void configureCodec() {
		if (publisher != null) {
			try {
				codec = new InMemoryPayloadCodec(publisher.getParameterGroups(), publisher.getCommands(), publisher.getEncodings(), publisher.getRestrictions());
			}
			catch (UnavailableSpaceSystemModelException e) {
				LOG.error("Could not configure the payload codec. Codec requests will return null.");
				codec = null;
			}
		}
		else {
			LOG.warn("Attempt to cache space system model information when there is no publisher service available");
		}
	}

	private final void checkCodec() throws CodecConfigurationException {
		if (codec == null) {
			throw new CodecConfigurationException("The payload codec is not configured, cannot decode payload.");
		}
	}

	@Override
	public ParameterGroup decode(final byte[] payload, final List<String> payloadLayoutIds, final long timeStamp) throws CodecConfigurationException {
		checkCodec();
		return this.codec.decode(payload, payloadLayoutIds, timeStamp);
	}

	@Override
	public ParameterGroup decode(final BitSet payload, final List<String> payloadLayoutIds, final long timeStamp) throws CodecConfigurationException {
		checkCodec();
		return this.codec.decode(payload, payloadLayoutIds, timeStamp);
	}

	@Override
	public ParameterGroup decode(final GenericPayload payload) throws CodecConfigurationException {
		checkCodec();
		return this.codec.decode(payload);
	}

	@Override
	public byte[] encodeToByteArray(final ParameterGroup parameterGroup) throws CodecConfigurationException {
		checkCodec();
		return this.codec.encodeToByteArray(parameterGroup);
	}

	@Override
	public GenericPayload encodeToGenericPayload(final TmTcGroup parameterGroup) throws CodecConfigurationException {
		checkCodec();
		return this.codec.encodeToGenericPayload(parameterGroup);
	}

	@Override
	public void entireModelUpdated() {
		configureCodec();
	}

	public void setPublisher(final SpaceSystemPublisher publisher) {
		this.publisher = publisher;
	}
}
