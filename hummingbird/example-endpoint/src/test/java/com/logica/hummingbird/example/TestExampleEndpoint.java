package com.logica.hummingbird.example;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.Test;

public class TestExampleEndpoint extends CamelTestSupport {
	
    @EndpointInject(uri = "mock:endpoint")
    protected MockEndpoint mockEndpoint;
	
	private ExampleEndpoint exampleEndpoint;
	private ByteArrayOutputStream outStream = new ByteArrayOutputStream();

	@Before
	public void localSetUp() throws Exception {
		System.out.println("Before");
		exampleEndpoint = new ExampleEndpoint();
		exampleEndpoint.setOutStream(new PrintStream(outStream));
	}
	
	@Test
	public void testExampleExchangeHandling() {
		
		Message message = new DefaultMessage();
		message.setHeader("test header", "test value");
		message.setBody("Message body (String)");
		
		Exchange exchange = new DefaultExchange(mockEndpoint);
		exchange.setIn(message);
		
		String expectedOutput = "Message received:\n"
			+ "{test header=test value}\n"
			+ "Message body (String)\n"
			+ "=================================\n\n";
		
		exampleEndpoint.process(exchange);
		
		String output = outStream.toString();
		
		assertEquals(expectedOutput, output);
	}

}
