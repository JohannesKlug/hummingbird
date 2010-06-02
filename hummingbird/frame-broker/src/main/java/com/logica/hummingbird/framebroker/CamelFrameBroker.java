package com.logica.hummingbird.framebroker;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;

import com.logica.hummingbird.MessageType;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.telemetry.ccsds.CcsdsTmPacket;
import com.logica.hummingbird.telemetry.ccsds.CcsdsTmParameter;

public class CamelFrameBroker extends FrameBrokerImpl {

	public CamelFrameBroker(ContainerFactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Split takes a TMFrame and calls unmarshall. The messages produced buy the various producers listening to the
	 * unmarshalling are then returned to the caller. Since this ContainerProcessor contains a frameProducer,
	 * packetProducer, and parameterProducer which all register themselves are listeners it will return a list of
	 * messages identified by their headers for each type. Note, the individual producers set the header to the required
	 * type for the messages they create.
	 * 
	 * @param camelExchange
	 *            the camel exchange container
	 * @return a list of camel messages
	 * @throws UnknownContainerNameException
	 */
	public List<Message> split(Exchange camelExchange) throws UnknownContainerNameException {
		this.unmarshall("TMFrame", (BitSet) camelExchange.getIn().getBody());

		// List<Message> messages = new ArrayList<Message>(CamelMessageProducer.getMessages());
		// CamelMessageProducer.clearMessages();

		List<Message> messages = new ArrayList<Message>();

		// Prepare the frame message - with POJO structure as payload (as opposed to uninterpreted BitSet)
		Message frameMessage = new DefaultMessage();
		frameMessage.setHeader("Type", MessageType.TMFrame);
		// frameMessage.setBody(CcsdsProducer.getFrame());
		frameMessage.setBody(frameProducer.getFrame());
		messages.add(frameMessage);

		// for (CcsdsTmPacket packet : CcsdsProducer.getFrame().getPackets()) {
		for (CcsdsTmPacket packet : frameProducer.getFrame().getPackets()) {
			Message packetMessage = new DefaultMessage();
			packetMessage.setHeader("Type", MessageType.TMPacket);
			packetMessage.setBody(packet);
			messages.add(packetMessage);

			for (CcsdsTmParameter parameter : packet.getParameters()) {
				Message parameterMessage = new DefaultMessage();
				parameterMessage.setHeader("Type", MessageType.TMParameter);
				parameterMessage.setBody(parameter);
				messages.add(parameterMessage);
			}
		}

		return messages;
	}

}
