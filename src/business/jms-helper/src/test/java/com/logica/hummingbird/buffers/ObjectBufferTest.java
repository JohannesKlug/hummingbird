package org.hbird.buffers;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import org.hbird.formatter.ExchangeFormatter;
import org.hbird.type.CommandDefinition;

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

	@DirtiesContext
	@Test
	public void testCommandDefinitions() {
		Exchange exchange = new DefaultExchange(context);
		exchange.setIn(ExchangeFormatter.createCommandDefinition("CommandDefinition1", new CommandDefinition("CommandDefinition1", "Description")));
		commandBuffer.addEntry(exchange);
		assertTrue(commandBuffer.buffer.size() == 1);
		
		exchange.setIn(ExchangeFormatter.createCommandDefinition("CommandDefinition2", new CommandDefinition("CommandDefinition2", "Description")));
		commandBuffer.addEntry(exchange);
		assertTrue(commandBuffer.buffer.size() == 2);
		
		exchange.setIn(ExchangeFormatter.createCommandDefinition("CommandDefinition3", new CommandDefinition("CommandDefinition3", "Description")));
		commandBuffer.addEntry(exchange);
		assertTrue(commandBuffer.buffer.size() == 3);

		/** Resend same message, buffer should be overridem. */
		exchange.setIn(ExchangeFormatter.createCommandDefinition("CommandDefinition2", new CommandDefinition("CommandDefinition2", "Description")));		
		commandBuffer.addEntry(exchange);
		assertTrue(commandBuffer.buffer.size() == 3);
	}
	
	@DirtiesContext
	@Test
	public void testParameterState() {
		Exchange exchange = new DefaultExchange(context);
		exchange.setIn(ExchangeFormatter.createCommandDefinition("ParameterState1", new CommandDefinition("ParameterState1", "Description")));
		stateBuffer.addEntry(exchange);
		assertTrue(stateBuffer.buffer.size() == 1);
		
		exchange.setIn(ExchangeFormatter.createCommandDefinition("ParameterState2", new CommandDefinition("ParameterState2", "Description")));
		stateBuffer.addEntry(exchange);
		assertTrue(stateBuffer.buffer.size() == 2);
		
		exchange.setIn(ExchangeFormatter.createCommandDefinition("ParameterState3", new CommandDefinition("ParameterState3", "Description")));
		stateBuffer.addEntry(exchange);
		assertTrue(stateBuffer.buffer.size() == 3);

		/** Resend same message, buffer should be overridem. */
		exchange.setIn(ExchangeFormatter.createCommandDefinition("ParameterState2", new CommandDefinition("ParameterState2", "Description")));
		stateBuffer.addEntry(exchange);
		assertTrue(stateBuffer.buffer.size() == 3);
	}
}
