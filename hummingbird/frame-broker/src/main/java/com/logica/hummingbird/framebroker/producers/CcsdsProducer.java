package com.logica.hummingbird.framebroker.producers;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Message;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultMessage;

import com.logica.hummingbird.MessageType;
import com.logica.hummingbird.ccsds.TmFrame;
import com.logica.hummingbird.framebroker.IContainerFactory;

/**
 * 
 * @author Gert Villemos
 *
 */
public abstract class CcsdsProducer implements IProducer {
//	/**
//	 * This identifies the type of message we are dealing with.  The header of the Camel message is set
//	 * to this type.
//	 */
//	protected MessageType messageType;

//	private DefaultCamelContext context = new DefaultCamelContext();
//	
//	protected ProducerTemplate producerTemplate = context.createProducerTemplate();
	
	// FIXME TmFrame being static is not a good design!
	protected static TmFrame frame;
	
	public static TmFrame getFrame() {
		return frame;
	}

	public static void setFrame(TmFrame tmFrame) {
		CcsdsProducer.frame = tmFrame;
	}

	private IContainerFactory containerFactory;

	/**
	 * A List of Camel messages produced by this producer.
	 */
	protected static List<Message> messages = new ArrayList<Message>();	
	
	protected Map<String, Object> headers = new HashMap<String, Object>();
	
	private Object body;

	public CcsdsProducer(IContainerFactory containerFactory) {
		this.setContainerFactory(containerFactory);
	}

	@Override
	public void updated(String field, BitSet value) {
		body = value;
	}

	@Override
	public void updated(String field, int value) {
		headers.put(field, value);
	}

	@Override
	public void updated(String field, String value) {
		headers.put(field, value);
	}

	@Override
	public void updated(String field, double value) {
		headers.put(field, value);
	}

	@Override
	public void completed() {
		// Set the correct header type.
//		headers.put("Type", messageType);

		// Create a new message, set the body and headers
		Message message = new DefaultMessage();
		message.setBody(body);
		message.setHeaders(headers);

		// Add the new message to the list
		messages.add(message);

		// Clean up body and headers
		body = null;
		headers.clear();
	}

	public static List<Message> getMessages() {
		return messages;
	}

	public static void clearMessages() {
		messages.clear();
	}

	public void setContainerFactory(IContainerFactory containerFactory) {
		this.containerFactory = containerFactory;
	}

	public IContainerFactory getContainerFactory() {
		return containerFactory;
	}

}
