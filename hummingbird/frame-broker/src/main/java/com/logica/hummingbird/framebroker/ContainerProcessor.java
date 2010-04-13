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
package com.logica.hummingbird.framebroker;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.framebroker.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.framebroker.producers.FrameProducer;
import com.logica.hummingbird.framebroker.producers.IProducer;
import com.logica.hummingbird.framebroker.producers.PacketProducer;
import com.logica.hummingbird.framebroker.producers.ParameterProducer;
import com.logica.hummingbird.framebroker.producers.CamelMessageProducer;

/**
 * 
 * 
 * The notification model for observers could have been implemented in two ways;
 * Firstly we could notify the observer when it changes. This is architecturally
 * pleasing as there is a direct coupling between the 2. Notify the observers
 * when the complete container has been unmarshalled.
 * 
 */
public class ContainerProcessor implements IFrameBroker {
	private final static Logger LOG = LoggerFactory.getLogger(ContainerProcessor.class);

	/** The factory used to locate the models. */
	protected IContainerFactory factory = null;

	IProducer frameProducer;
	IProducer packetProducer;
	IProducer parameterProducer;

	/**
	 * Constructor.
	 * 
	 * @param factory
	 *            The factory to be used to obtain references to the container.
	 * */
	public ContainerProcessor(IContainerFactory factory) {
		this.factory = factory;

		frameProducer = new FrameProducer(factory);
		packetProducer = new PacketProducer(factory);
		parameterProducer = new ParameterProducer(factory);
	}

	@Override
	public void unmarshall(String packetname, BitSet packet) throws UnknownContainerNameException {
		factory.getContainer(packetname).unmarshall(packet);
	}

	@Override
	public void marshall(String packetname, BitSet packet) throws UnknownContainerNameException {
		factory.getContainer(packetname).marshall(packet, 0);
	}

	@Override
	public void marshall(String packetname, String packet) throws UnknownContainerNameException {
		packet = factory.getContainer(packetname).toString();
	}

	public IContainer getContainer(String container) throws UnknownContainerNameException {
		return factory.getContainer(container);
	}

	public IContainerFactory getFactory() {
		return factory;
	}

	public void setFactory(IContainerFactory factory) {
		this.factory = factory;
	}

	/**
	 * Split takes a TMFrame and calls unmarshall.  The messages produced buy the various producers listening
	 * to the unmarshalling are then returned to the caller.  Since this ContainerProcessor contains
	 * a frameProducer, packetProducer, and parameterProducer which all register themselves are listeners it will
	 * return a list of messages identified by their headers for each type.  Note, the individual producers
	 * set the header to the required type for the messages they create.
	 * @param camelExchange the camel exchange container
	 * @return a list of camel messages
	 * @throws UnknownContainerNameException 
	 * @throws Exception
	 */
	public List<Message> split(Exchange camelExchange) throws UnknownContainerNameException {
		this.unmarshall("TMFrame", (BitSet) camelExchange.getIn().getBody());

		List<Message> messages = new ArrayList<Message>(CamelMessageProducer.getMessages());

		CamelMessageProducer.clearMessages();

		return messages;
	}

}
