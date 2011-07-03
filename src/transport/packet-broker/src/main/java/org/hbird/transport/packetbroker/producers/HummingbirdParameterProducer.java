/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.packetbroker.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hbird.transport.spacesystemmodel.SpaceSystemModelFactory;
import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.ParameterObserver;
import org.hbird.transport.telemetry.DefaultSpaceParameter;

/**
 * TODO write here a description of the class
 */
public class HummingbirdParameterProducer extends AbstractProducer implements ParameterObserver {
	private static final Logger LOG = LoggerFactory.getLogger(HummingbirdParameterProducer.class);

	HummingbirdPacketProducer parent;

	public HummingbirdParameterProducer(SpaceSystemModelFactory containerFactory, HummingbirdPacketProducer parent) {
		super(containerFactory);

		this.parent = parent;

		// Register with all parameters corresponding to header fields.
		for (HummingbirdParameter parameter : containerFactory.getAllParameters().values()) {
			parameter.addParameterUpdateObserver(this);
		}
	}

	@Override
	public final void updated(String field, int value, String shortDescription, String longDescription) {
		parent.packet.addParameter(new DefaultSpaceParameter(field, Integer.class, value, shortDescription, longDescription));
		if (LOG.isDebugEnabled()) {
			LOG.debug("Updated Parameter: " + field + " : " + value + " and added to parent " + parent.getPacket().getName());
		}
	}

	@Override
	public final void updated(String field, String value, String shortDescription, String longDescription) {
		parent.packet.addParameter(new DefaultSpaceParameter(field, value.getClass(), value, shortDescription, longDescription));
		if (LOG.isDebugEnabled()) {
			LOG.debug("Updated Parameter: " + field + " : " + value + " and added to parent " + parent.getPacket().getName());
		}
	}

	@Override
	public final void updated(String field, double value, String shortDescription, String longDescription) {
		parent.packet.addParameter(new DefaultSpaceParameter(field, Double.class, value, shortDescription, longDescription));
		if (LOG.isDebugEnabled()) {
			LOG.debug("Updated Parameter: " + field + " : " + value + " and added to parent " + parent.getPacket().getName());
		}
	}

}