package org.hbird.transport.packetbroker;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.hbird.transport.spacesystemmodel.ContainerFactory;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownContainerNameException;
import org.hbird.transport.telemetry.HummingbirdPacket;
import org.hbird.transport.telemetry.HummingbirdParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class HummingbirdCamelPacketBroker extends HummingbirdPacketBroker {
	private final static Logger LOG = LoggerFactory.getLogger(HummingbirdCamelPacketBroker.class);

	private String packetContainerName;

	public HummingbirdCamelPacketBroker(final ContainerFactory factory, String packetContainerName) {
		super(factory);
		this.setPacketContainerName(packetContainerName);
	}

	public HummingbirdCamelPacketBroker(final ContainerFactory factory) {
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
	public final synchronized List<Message> split(final Exchange camelExchange) throws UnknownContainerNameException {
		// Clear the previous packet
		packetProducer.clearPacket();

		final Object msgBody = camelExchange.getIn().getBody();
		if (msgBody == null) {
			LOG.warn("message body is null");
			return null;
		}
		this.unmarshall(this.packetContainerName, (BitSet) msgBody);

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
	 * TODO finish is necessary. What do we want from the packet? We could create a few types of output.
	 * 
	 * @param packet
	 * @return
	 */
	private Message createCamelMessage(final HummingbirdPacket packet) {
		final Message msg = new DefaultMessage();

		// Create a map containing all the message header information
		final Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("PacketName", packet.getName());
		headers.put("NumOfParameters", packet.getParameters().size());
		// set message headers
		msg.setHeaders(headers);

		return msg;
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
		headers.put("Type", "TMParameter");
		headers.put("ParameterName", parameter.getName());
		headers.put("ParameterShortDescription", parameter.getShortDescription());
		headers.put("ParameterLongDescription", parameter.getLongDescription());
		headers.put("ValueType", parameter.getClassType());

		msg.setHeaders(headers);
		msg.setBody(parameter.getValue());

		if (LOG.isDebugEnabled()) {
			LOG.debug("Created camel message: " + msg);
		}

		return msg;
	}

	public void setPacketContainerName(String packetContainerName) {
		this.packetContainerName = packetContainerName;
	}

	public String getPacketContainerName() {
		return packetContainerName;
	}
}
