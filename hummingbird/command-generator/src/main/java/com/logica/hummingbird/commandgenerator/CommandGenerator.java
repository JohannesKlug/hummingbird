package com.logica.hummingbird.commandgenerator;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.spring.Main;


public class CommandGenerator {

	protected String commandQueryEndpoint = "";

	protected ProducerTemplate producer = null;
	
	protected CamelContext context = null;
	
	public void getCommandDefinition() {
		
	}
	
	
	public void injectCommand(String name, Map<String, Object> arguments) {
				
		/** Release the command to the command query, i.e. schedule it. */
		Exchange exchange = new DefaultExchange(context);
		
		
		
		producer.sendBody(commandQueryEndpoint, exchange);
	}
}
