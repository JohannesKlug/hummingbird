package com.logica.hummingbird.simulator;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.apache.camel.impl.DefaultProducerTemplate;

public class Simulator implements Runnable {
	
	private Endpoint endpoint;
	private DefaultProducerTemplate template;
	private CamelContext context;
	
	private boolean run; 
	
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
	
	public void sendMessage() {
		template.send(nextExchange());
	}
	

	public void stopSimulator() {
		run = false;
		System.out.println("Stopping");
	}

	public void run() {
		run = true;
		while (run) {
			System.out.println("sending the next message");
			sendMessage();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Simulator exiting.");
	}

}
