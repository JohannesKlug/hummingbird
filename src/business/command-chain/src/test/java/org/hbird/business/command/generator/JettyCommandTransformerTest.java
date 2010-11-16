package org.hbird.business.command.generator;

import java.util.Arrays;
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

import org.hbird.business.buffers.CommandBuffer;
import org.hbird.business.formatter.HeaderFields;
import org.hbird.business.tasks.checks.Range;
import org.hbird.business.tasks.checks.StaticValue;
import org.hbird.business.type.Argument;
import org.hbird.business.type.CommandDefinition;

@ContextConfiguration (locations={"/JettyCommandTransformerTest-context.xml"})
public class JettyCommandTransformerTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:HttpCommands")
    protected ProducerTemplate template;

	@EndpointInject(uri = "mock:HttpCommands")
	protected MockEndpoint httpQueue;

	@EndpointInject(uri = "mock:Commands")
	protected MockEndpoint releaseQueue;

	@Autowired
    protected CamelContext context;
	
	@Autowired
	protected CommandBuffer buffer;
	
	@Test
	public void testReceive() {
		Range range = new Range(0, "TestStateParameter", "TestParameter", new StaticValue(0d), new StaticValue(10d));
		CommandDefinition definition = new CommandDefinition("TestCommand", "Test description", Arrays.asList(new Argument[]{new Argument("TestArgument1", "Test description", Long.class.toString(), 64l, "m/s", range), new Argument("TestArgument2", "Test description", Long.class.toString(), 64l, "m/s", range), new Argument("TestArgument3", "Test description", Long.class.toString(), 64l, "m/s", range)}), null, null); 
		
		Date now = new Date();
		
		Exchange exchange = new DefaultExchange(context);
		exchange = new DefaultExchange(context);
		exchange.getIn().setHeader(HeaderFields.NAME, "TestCommand");
		exchange.getIn().setHeader(HeaderFields.RELEASETIME, Long.toString(now.getTime()));
		exchange.getIn().setHeader("TestArgument1", "1");
		exchange.getIn().setHeader("TestArgument2", "2");
		exchange.getIn().setHeader("TestArgument3", "3");
		exchange.getIn().setBody(definition);
		
		buffer.addEntry(exchange);
		template.send(exchange);
		
		assertTrue(releaseQueue.getReceivedCounter() == 1);
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader(HeaderFields.NAME)).equals("TestCommand"));
		assertTrue((((CommandDefinition) releaseQueue.getReceivedExchanges().get(0).getIn().getBody()) != null));
		
		assertTrue(releaseQueue.getReceivedCounter() == 1);
	}		
}
