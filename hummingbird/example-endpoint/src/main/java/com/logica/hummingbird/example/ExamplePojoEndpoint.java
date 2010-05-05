package com.logica.hummingbird.example;

import java.io.PrintStream;

import org.apache.camel.Message;

public class ExamplePojoEndpoint {
	
	private PrintStream outStream = System.out;
	
	private long startTime = 0;
	private long numberOfMessagesReceived;
	
	public ExamplePojoEndpoint() {
		startTime = System.currentTimeMillis();
	}
	
	public void setOutStream(PrintStream outStream) {
		this.outStream = outStream;
	}
	
	public void onMessage(Message message) {
		
		numberOfMessagesReceived++;
		
//		String out = "Message received (by POJO endpoint):\n";
//		out += message.getHeaders() + "\n";
//		out += message.getBody() + "\n";
//		out += "=================================\n";
		
		String body = message.getBody().toString();
		
		if (numberOfMessagesReceived%1000 == 0) {
			long delta = System.currentTimeMillis() - startTime;
			outStream.println(numberOfMessagesReceived + " messages received in " + delta + " ms. Overall rate: " + numberOfMessagesReceived*1000/delta + "messages/s.");	
		}
		
		
	}

}
