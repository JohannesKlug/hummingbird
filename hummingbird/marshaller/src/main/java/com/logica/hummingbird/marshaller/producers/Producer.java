package com.logica.hummingbird.marshaller.producers;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Message;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultMessage;

import com.logica.hummingbird.marshaller.IContainerFactory;

public abstract class Producer implements IProducer {

DefaultCamelContext context = new DefaultCamelContext();

	protected static List<Message> messages = new ArrayList<Message>();

	protected ProducerTemplate producerTemplate = context.createProducerTemplate();
	private IContainerFactory containerFactory;

	protected Map<String,Object> headers = new HashMap<String, Object>();
	private Object body;
	
	// TODO Refactor messageType to enum in commons
	protected String messageType;

	
	public Producer(IContainerFactory containerFactory) {
		this.containerFactory = containerFactory;
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

		/**
		 * This sets the correct header type.
		 * */
		headers.put("Type", messageType);
		
		Message message = new DefaultMessage();
		message.setBody(body);
		message.setHeaders(headers);
		
		messages.add(message);
		
		/** Clean up body and headers */
		body = null;
		headers.clear();
		
	}


	public static List<Message> getMessages() {		
		return messages;
	}
	
	public static void clearMessages() {
		messages.clear();
	}

}
