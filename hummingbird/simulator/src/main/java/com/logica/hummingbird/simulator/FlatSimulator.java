package com.logica.hummingbird.simulator;

import org.apache.camel.Endpoint;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;

public class FlatSimulator extends Simulator {
	
	private Number value;

	public FlatSimulator(Endpoint endpoint, Number value) {
		super(endpoint);
		this.value = value;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Message nextMessage() {
		Message message = new DefaultMessage();
		message.setBody(value);
		return message;
	}

}
