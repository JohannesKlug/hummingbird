package com.logica.hummingbird.simulator;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.apache.camel.impl.DefaultProducer;

public class Simulator extends DefaultProducer {
	
	public Simulator(Endpoint endpoint) {
		super(endpoint);
		// TODO Auto-generated constructor stub
	}

	public Message nextMessage() {
		Message message = new DefaultMessage();
		
		message.setHeader("test header", "test value");
		message.setBody("Message body (String)");
		
		return message;
		
	}
	
	public Exchange nextExchange() {
		
		CamelContext context = new DefaultCamelContext();
		Exchange exchange = new DefaultExchange(context);
		
		
		return exchange;
	}

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
