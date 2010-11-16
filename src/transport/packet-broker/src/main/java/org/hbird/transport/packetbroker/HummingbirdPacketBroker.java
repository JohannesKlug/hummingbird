/* ----------------------------------------------------------------------------
 * (c) Copyright Logica 2010
 *
 * All rights reserved. This document is protected by international copyright 
 * law and may not be reprinted, reproduced, copied or utilised in whole or in 
 * part by any means including electronic, mechanical, or other means without 
 * the prior written consent of Logica. 
 * Whilst reasonable care has been taken by Logica to ensure the information 
 * contained herein is reasonably accurate, Logica shall not, under any 
 * circumstances be liable for any loss or damage (direct or consequential) 
 * suffered by any party as a result of the contents of this publication or the 
 * reliance of any party thereon or any inaccuracy or omission therein. The 
 * information in this document is therefore provided on an "as is" basis 
 * without warranty and is subject to change without further notice and cannot 
 * be construed as a commitment by Logica. 
 * The products mentioned in this document are identified by the names, 
 * trademarks, service marks and logos of their respective companies or 
 * organisations and may not be used in any advertising or publicity or in any 
 * other way whatsoever without the prior written consent of those companies 
 * or organisations and Logica.
 * ----------------------------------------------------------------------------
 * System       : Hummingbird
 * Author       : VillemosG
 * Created on   : 08.01.2010
 * ----------------------------------------------------------------------------
 */
package org.hbird.transport.packetbroker;

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.packetbroker.producers.AbstractProducer;
import org.hbird.transport.packetbroker.producers.HummingbirdPacketProducer;
import org.hbird.transport.packetbroker.producers.HummingbirdParameterProducer;
import org.hbird.transport.spacesystemmodel.Container;
import org.hbird.transport.spacesystemmodel.ContainerFactory;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownContainerNameException;
import org.hbird.transport.telemetry.HummingbirdPacket;

/**
 * TODO Improve comment.
 * The notification model for observers could have been implemented in two ways;
 * Firstly we could notify the observer when it changes. This is architecturally
 * pleasing as there is a direct coupling between the 2. Notify the observers
 * when the complete container has been unmarshalled.
 */
public class HummingbirdPacketBroker implements PacketBroker {
	private static final Logger LOG = LoggerFactory.getLogger(HummingbirdPacketBroker.class);

	/** The factory used to locate the models. */
	protected ContainerFactory factory = null;

	protected AbstractProducer packetProducer;
	protected AbstractProducer parameterProducer;

	/**
	 * Constructor.
	 * 
	 * Set up the SpaceSystemModelFactory and the necessary message producers.
	 * 
	 * @param factory
	 *            The factory to be used to obtain references to the container.
	 * */
	public HummingbirdPacketBroker(ContainerFactory factory) {
		this.factory = factory;
		this.packetProducer = new HummingbirdPacketProducer(factory);
		this.parameterProducer = new HummingbirdParameterProducer(factory, (HummingbirdPacketProducer) packetProducer);
	}

	@Override
	public final void unmarshall(String packetname, BitSet packet) throws UnknownContainerNameException {
		if(LOG.isDebugEnabled()) {
			LOG.debug("Unmarshalling container " + packetname + " with BitSet " + packet);
		}
		factory.getContainer(packetname).unmarshall(packet);
	}

	@Override
	public final void marshall(String packetname, BitSet packet) throws UnknownContainerNameException, BitSetOperationException {
		if(LOG.isDebugEnabled()) {
			LOG.debug("Unmarshalling container " + packetname + " with BitSet " + packet + " at offset 0");
		}
		factory.getContainer(packetname).marshall(packet, 0);
	}

	@Override
	public final void marshall(String packetname, String packet) throws UnknownContainerNameException {
		packet = factory.getContainer(packetname).toString();
	}

	@Override
	public final Container getContainer(String container) throws UnknownContainerNameException {
		return factory.getContainer(container);
	}

	@Override
	public final ContainerFactory getFactory() {
		return factory;
	}

	@Override
	public final void setFactory(ContainerFactory factory) {
		this.factory = factory;
	}

	@Override
	public final HummingbirdPacket getPacket() {
		return this.packetProducer.getPacket();
	}
}
