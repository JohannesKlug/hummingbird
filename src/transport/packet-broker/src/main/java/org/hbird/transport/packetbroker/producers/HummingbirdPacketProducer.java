/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.packetbroker.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.ParameterGroupObserver;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;

/**
 * The packet consists of a sequence of packet header fields, which are parameters, and a 
 * packet body which is binary data. This producer registers for the parameters in the 
 * header, and for the packet itself to get the raw data.
 */
public class HummingbirdPacketProducer extends AbstractProducer implements ParameterGroupObserver {
	private final static Logger LOG = LoggerFactory.getLogger(HummingbirdPacketProducer.class);

	public HummingbirdPacketProducer(SpaceSystemModel containerFactory) {
		super(containerFactory);

		/** The packet base container (should have the name TMPacket by convention) contains as sub containers;
		 *   1. A parameter per header field. For example CCSDS_APID
		 *   2. A container per layout of a packet. The layout to be used is defined as a constraint, i.e. for example if
		 *      the header parameter 'CCSDS_APID == 123' is valid, then a specific layout will be used. */
		try {
			for (ParameterGroup sub : containerFactory.getParameterGroup("TMPacket").getSubParameterGroups()) {
				sub.addPacketObserver(this);
			}
			containerFactory.getParameterGroup("TMPacket").addPacketObserver(this);
		}
		catch (UnknownParameterGroupException e) {
			LOG.error(e.toString());
		}
	}
	
	@Override
	public void completed(String name) {
		packet.setName(name);
		if(LOG.isDebugEnabled()) {
			LOG.debug("TmPacket " + name + " completely updated");
			LOG.debug("TmPacket = " + packet);
		}
	}

}