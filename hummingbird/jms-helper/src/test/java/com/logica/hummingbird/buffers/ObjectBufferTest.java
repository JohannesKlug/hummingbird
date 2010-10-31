package com.logica.hummingbird.buffers;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import com.logica.hummingbird.jmshelper.HeaderFields;
import com.logica.hummingbird.type.CommandDefinition;

@ContextConfiguration (locations={"/ObjectBufferTest-context.xml"})
public class ObjectBufferTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:start")
    protected ProducerTemplate template;
	
	@Autowired
    protected CamelContext context;
	
	@Autowired
    protected CommandBuffer commandBuffer;	

	@Autowired
    protected StateBuffer stateBuffer;	

	@Test
	public void testCommandDefinitions() {
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setHeader(HeaderFields.NAME, "CommandDefinition1");
		exchange.getIn().setBody(new CommandDefinition("CommandDefinition1", "Description"));
		
		commandBuffer.addEntry(exchange);

		assertTrue(commandBuffer.buffer.size() == 1);
		
		exchange = new DefaultExchange(context);
		exchange.getIn().setHeader(HeaderFields.NAME, "CommandDefinition2");
		exchange.getIn().setBody(new CommandDefinition("CommandDefinition2", "Description"));
		
		commandBuffer.addEntry(exchange);

		assertTrue(commandBuffer.buffer.size() == 2);
		
		exchange = new DefaultExchange(context);
		exchange.getIn().setHeader(HeaderFields.NAME, "CommandDefinition3");
		exchange.getIn().setBody(new CommandDefinition("CommandDefinition3", "Description"));
		
		commandBuffer.addEntry(exchange);

		assertTrue(commandBuffer.buffer.size() == 3);

		/** Resend same message, buffer should be overridem. */
		exchange = new DefaultExchange(context);
		exchange.getIn().setHeader(HeaderFields.NAME, "CommandDefinition2");
		exchange.getIn().setBody(new CommandDefinition("CommandDefinition2", "Description"));
		
		commandBuffer.addEntry(exchange);

		assertTrue(commandBuffer.buffer.size() == 3);
	}
	
	public void testParameterState() {
	}
}
