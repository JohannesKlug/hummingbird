package com.logica.hummingbird.packetbroker;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;

import com.logica.hummingbird.MessageType;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.telemetry.HummingbirdPacket;
import com.logica.hummingbird.telemetry.HummingbirdParameter;

public class HummingbirdCamelPacketBroker extends HummingbirdPacketBroker {

	public HummingbirdCamelPacketBroker(ContainerFactory factory) {
		super(factory);
	}

	/**
	 * Split takes a Packet and calls unmarshall. The messages produced by the various producers listening to the
	 * unmarshalling are then returned to the caller. Since this ContainerProcessor contains a packetProducer and 
	 * parameterProducer, which all register themselves are listeners, it will return a list of
	 * messages identified by their headers for each type. Note, the individual producers set the header to the required
	 * type for the messages they create.
	 * 
	 * @param camelExchange
	 *            the camel exchange container
	 * @return a list of camel messages
	 * @throws UnknownContainerNameException
	 */
	public List<Message> split(Exchange camelExchange) throws UnknownContainerNameException {
		this.unmarshall("TMPacket", (BitSet) camelExchange.getIn().getBody());

		HummingbirdPacket packet = packetProducer.getPacket();
		
		List<Message> messages = new ArrayList<Message>();

		Message packetMessage = new DefaultMessage();
		packetMessage.setHeader("Type", MessageType.TMPacket);
		
		packetMessage.setBody(packet);
		messages.add(packetMessage);

		for (HummingbirdParameter parameter : packet.getParameters()) {
			Message parameterMessage = new DefaultMessage();
			parameterMessage.setHeader("Type", MessageType.TMParameter);
			parameterMessage.setBody(parameter);
			messages.add(parameterMessage);
		}

		return messages;
	}

}
