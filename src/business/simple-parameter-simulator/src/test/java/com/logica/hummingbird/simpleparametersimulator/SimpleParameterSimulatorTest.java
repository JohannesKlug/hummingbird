package org.hbird.simpleparametersimulator;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration (locations={"/SimpleParameterSimulatorTest-context.xml"})
public class SimpleParameterSimulatorTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Commands")
    protected ProducerTemplate template;

	@Autowired
    protected CamelContext context;
	
	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	@DirtiesContext
	@Test
	public void testParameterGeneration() throws Exception {
		logger.info("Testing all simulators.");
		Thread.sleep(10000);
		
		for (int counter = 0; counter < 100; counter++) {
			// System.out.println("Testing for counter " + counter + " equals " + resultEndpoint.message(counter).body().toString());
		}		
		
		logger.info("Works fine.");
	}
	
	@DirtiesContext
	@Test
	public void testCommanding() throws Exception {
	
		Exchange exchange = new DefaultExchange(context);
		
		exchange.getIn().setHeader("Bean", "Parameter1");
		exchange.getIn().setHeader("Attribute", "Value");
		exchange.getIn().setHeader("Value", false);
		
		template.send(exchange);
		
		assertTrue( ((BooleanParameter) context.getRegistry().lookup("Parameter1")).getValue() == false);
	}
}
