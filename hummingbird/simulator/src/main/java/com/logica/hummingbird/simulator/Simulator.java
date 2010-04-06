package com.logica.hummingbird.simulator;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.component.bean.BeanEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.apache.camel.impl.DefaultProducerTemplate;

public class Simulator {
	
	Endpoint endpoint;
	
	public Simulator(Endpoint endpoint)  {
		this.endpoint = endpoint;
		System.out.println("Simulator constructed");
	}
	
	public Message nextMessage() {
		Message message = new DefaultMessage();
		
		message.setHeader("test header", "test value");
		message.setBody("Message body (String)");
		
		System.out.println(message);
		
		return message;
		
	}
	
	public String sayHello() {
		System.out.println("HELLO");
		return "Hello";
	}
	
	public Exchange nextExchange() {
		
		CamelContext context = new DefaultCamelContext();
		Exchange exchange = new DefaultExchange(context);
		
		exchange.setOut(nextMessage());
		
		return exchange;
	}
	
	public void sendMessage() throws Exception {
		//endpoint.createProducer().createExchange().setOut(nextMessage());
		
		DefaultProducerTemplate template = new DefaultProducerTemplate(new DefaultCamelContext(), endpoint);
		template.send(nextExchange());
	}

}
