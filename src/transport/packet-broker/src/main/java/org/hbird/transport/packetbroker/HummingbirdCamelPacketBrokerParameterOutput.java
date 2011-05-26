/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.packetbroker;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.hbird.exchange.type.Parameter;
import org.hbird.transport.spacesystemmodel.ContainerFactory;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownContainerNameException;
import org.hbird.transport.telemetry.HummingbirdPacket;
import org.hbird.transport.telemetry.HummingbirdParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This packet broker does the same job as HummingbirdCamelPacketBroker. The only difference
 * is the output, so that it can communicate with the business tier.
 * 
 * TODO Delete as soon as everyone has agreed on what to put into the body of a parameter message.
 */
public class HummingbirdCamelPacketBrokerParameterOutput extends HummingbirdPacketBroker {
	private final static Logger LOG = LoggerFactory.getLogger(HummingbirdCamelPacketBroker.class);

	private String packetContainerName;

	public HummingbirdCamelPacketBrokerParameterOutput(final ContainerFactory factory, final String packetContainerName) {
		super(factory);
		this.setPacketContainerName(packetContainerName);
	}

	public HummingbirdCamelPacketBrokerParameterOutput(final ContainerFactory factory) {
		super(factory);
		packetContainerName = "TMPacket";
	}

	/**
	 * Split takes a Packet and calls unmarshall. The messages produced by the various producers listening to the
	 * unmarshalling are then returned to the caller. Since this ContainerProcessor contains a packetProducer and
	 * parameterProducer, which all register themselves are listeners, it will return a list of messages identified by
	 * their headers for each type. Note, the individual producers set the header to the required type for the messages
	 * they create.
	 * 
	 * @param camelExchange
	 *            the camel exchange container
	 * @return a list of camel messages
	 * @throws UnknownContainerNameException
	 */
	public final synchronized List<Message> decodeBinaryTelemetry(final BitSet telemetryBitSet) throws UnknownContainerNameException {
		// Clear the previous packet
		packetProducer.clearPacket();

		this.unmarshall(this.packetContainerName, telemetryBitSet);

		final HummingbirdPacket packet = packetProducer.getPacket();

		final List<Message> messages = new ArrayList<Message>();

		final Message packetMessage = new DefaultMessage();
		packetMessage.setHeader("Type", "TMPacket");

		packetMessage.setBody(packet);
		messages.add(packetMessage);

		if (LOG.isDebugEnabled()) {
			LOG.debug("packet contains " + packet.getParameters().size());
		}

		for (final HummingbirdParameter parameter : packet.getParameters()) {
			messages.add(createCamelMessage(parameter));
		}

		return messages;
	}

	/**
	 * Creates a Camel {@link DefaultMessage} of the parameter. This message can then be routed by Camel to any
	 * endpoint. The actual created of the endpoint specific message , e.g. jms message, file, or an email, is handled
	 * by Camel.
	 * 
	 * The header holds all the properties of the message and the body holds the actual value.
	 * 
	 * @param parameter
	 * @return
	 */
	private Message createCamelMessage(final HummingbirdParameter parameter) {
		final Message msg = new DefaultMessage();

		final Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("type", "TMParameter");
		headers.put("timestamp", System.currentTimeMillis());
		headers.put("name", parameter.getName());
		
		Parameter newParameter = new Parameter(
				parameter.getName(),
				parameter.getLongDescription(),
				parameter.getValue(),
				parameter.getClassType().toString()
				);

		msg.setHeaders(headers);
		msg.setBody(newParameter);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Created camel message: " + msg);
		}

		return msg;
	}

	public void setPacketContainerName(final String packetContainerName) {
		this.packetContainerName = packetContainerName;
	}

	public String getPacketContainerName() {
		return packetContainerName;
	}
}
