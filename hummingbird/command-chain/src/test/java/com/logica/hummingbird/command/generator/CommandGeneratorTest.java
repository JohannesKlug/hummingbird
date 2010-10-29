package com.logica.hummingbird.command.generator;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import com.logica.hummingbird.command.CommandDefinition;
import com.logica.hummingbird.command.buffer.CommandBuffer;
import com.logica.hummingbird.jmshelper.HeaderFields;

@ContextConfiguration (locations={"/CommandGeneratorTest-context.xml"})
public class CommandGeneratorTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Commands")
    protected ProducerTemplate template;

	@EndpointInject(uri = "mock:ReleasedCommands")
	protected MockEndpoint releaseQueue;

	@Autowired
    protected CamelContext context;
	
	@Autowired
	protected CommandBuffer buffer;
	
	@Test
	public void testReceive() {
		
		CommandDefinition definition = new CommandDefinition("TestCommand"); 
		buffer.addEntry(definition.getName(), definition);
		
		Date now = new Date();
		
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setHeader(HeaderFields.NAME, "TestCommand");
		exchange.getIn().setHeader(HeaderFields.EXECUTIONTIME, now.getTime());
		exchange.getIn().setHeader("TestArgument1", 1d);
		exchange.getIn().setHeader("TestArgument2", 1d);
		exchange.getIn().setHeader("TestArgument3", 1d);
		
		template.send(exchange);
		
		assertTrue(releaseQueue.getReceivedCounter() == 1);
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader(HeaderFields.NAME)).equals("TestCommand"));
		assertTrue((((CommandDefinition) releaseQueue.getReceivedExchanges().get(0).getIn().getBody()) != null));
	}		
}
