/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.packetbroker.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hbird.transport.spacesystemmodel.Container;
import org.hbird.transport.spacesystemmodel.ContainerFactory;
import org.hbird.transport.spacesystemmodel.PacketObserver;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownContainerNameException;

/**
 * The packet consists of a sequence of packet header fields, which are parameters, and a 
 * packet body which is binary data. This producer registers for the parameters in the 
 * header, and for the packet itself to get the raw data.
 */
public class HummingbirdPacketProducer extends AbstractProducer implements PacketObserver {
	private final static Logger LOG = LoggerFactory.getLogger(HummingbirdPacketProducer.class);

	public HummingbirdPacketProducer(ContainerFactory containerFactory) {
		super(containerFactory);

		/** The packet base container (should have the name TMPacket by convention) contains as sub containers;
		 *   1. A parameter per header field. For example CCSDS_APID
		 *   2. A container per layout of a packet. The layout to be used is defined as a constraint, i.e. for example if
		 *      the header parameter 'CCSDS_APID == 123' is valid, then a specific layout will be used. */
		try {
			for (Container sub : containerFactory.getContainer("TMPacket").getSubContainers()) {
				sub.addPacketObserver(this);
			}
			containerFactory.getContainer("TMPacket").addPacketObserver(this);
		}
		catch (UnknownContainerNameException e) {
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