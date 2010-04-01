package com.logica.hummingbird.example;

import java.io.PrintStream;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ExampleEndpoint implements Processor {
	
	private PrintStream outStream = System.out;
	
	public void setOutStream(PrintStream outStream) {
		this.outStream = outStream;
	}
	
	public void process(Exchange exchange) {
		
		String message = "Message received:\n";
		message += exchange.getIn().getHeaders() + "\n";
		message += exchange.getIn().getBody() + "\n";
		message += "=================================\n";
		
		outStream.println(message);
	}

}
