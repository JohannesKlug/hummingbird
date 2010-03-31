package com.logica.hummingbird.simulator;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;

public class Simulator {
	
	public Message nextMessage() {
		Message message = new DefaultMessage();
		
		message.setHeader("test header", "test value");
		message.setBody("Message body (String)");
		
		return message;
		
	}

}
