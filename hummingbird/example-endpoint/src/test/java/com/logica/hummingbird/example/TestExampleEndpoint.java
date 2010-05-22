package com.logica.hummingbird.example;


import groovyjarjarantlr.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

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
		exampleEndpoint = new ExampleEndpoint();
		exampleEndpoint.setOutStream(new PrintStream(outStream));
	}
	
	@Test
	public void testExampleExchangeHandling() throws UnsupportedEncodingException {
		
//		TEST FAILS BREAKING BUILD
//		Looks like the Strings are equal but are still not matching in the assert.
//		Also, the junit view shows two sqaure brackets in different positions in the two strings
//		I have no idea where these come from...Perhaps they are just for the junit display?
//		Also, double clicking the assert failure brings up a comparision viewer which shows no differences.
//		It could be related to the ByteArrayOutputStream, this may use a different format to String...
//		Ok it looks like it's related to newline, carriage returns.  Must be format mismatches between the
//		System Strings and the ByteStream String.
		
		Message message = new DefaultMessage();
		message.setHeader("test header", "test value");
		message.setBody("Message body (String)");
		
		Exchange exchange = new DefaultExchange(mockEndpoint);
		exchange.setIn(message);
		
//		String newline = System.getProperty("line.separator");
		String newline = "\n";
		
		String expectedOutput = 
		"Message received:" + newline +
		"{test header=test value}" + newline +
		"Message body (String)" + newline +
		"=================================" + newline + newline;
		
		exampleEndpoint.process(exchange);
		
		String output = outStream.toString();
		
		// Trim off the crap.
		output.trim();
		expectedOutput.trim();
		
		// Process the strings to remove any new lines and replace with spaces.
		String processedOutput = output.replaceAll("\\s\\s+|\\n|\\r", " ");
		String processedExpected = expectedOutput.replaceAll("\\s\\s+|\\n|\\r", " ");
		
		// Compare the processed strings
		assertEquals(processedExpected, processedOutput);
	}

}
