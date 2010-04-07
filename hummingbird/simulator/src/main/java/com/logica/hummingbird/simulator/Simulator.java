package com.logica.hummingbird.simulator;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.apache.camel.impl.DefaultProducerTemplate;

public class Simulator {
	
	Endpoint endpoint;
	DefaultProducerTemplate template;
	CamelContext context; 
	
	public Simulator(Endpoint endpoint)  {
		this.endpoint = endpoint;
		this.context = new DefaultCamelContext();
		this.template = new DefaultProducerTemplate(context, endpoint);
	}
	
	public Message nextMessage() {
		Message message = new DefaultMessage();
		message.setHeader("test header", "test value");
		message.setBody("Message body (String)");
		return message;
		
	}
	
	public Exchange nextExchange() {
		Exchange exchange = new DefaultExchange(context);
		exchange.setOut(nextMessage());
		return exchange;
	}
	
	public void sendMessage() throws Exception {
		template.send(nextExchange());
	}

}
