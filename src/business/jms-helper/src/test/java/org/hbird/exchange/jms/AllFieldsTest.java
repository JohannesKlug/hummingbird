package org.hbird.exchange.jms;

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

import org.hbird.exchange.type.StateParameter;

@ContextConfiguration (locations={"/AllFieldsTest-context.xml"})
public class AllFieldsTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Start")
    protected ProducerTemplate template;

	@EndpointInject(uri = "mock:End")
	protected MockEndpoint releaseQueue;

	@Autowired
    protected CamelContext context;
	
	@Test
	public void testAllFields() {
		
		Exchange exchange = new DefaultExchange(context);
		exchange = new DefaultExchange(context);
		exchange.getIn().setBody(new StateParameter("parameter1", "test description", "parameter2", true));
				
		template.send(exchange);
		
		assertTrue(releaseQueue.getReceivedCounter() == 1);
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("name")).equals("parameter1"));
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("description")).equals("test description"));
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("isStateOff")).equals("parameter2"));
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("clazz")).equals("java.lang.Boolean"));
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("value")).equals("true"));
	}	
}
