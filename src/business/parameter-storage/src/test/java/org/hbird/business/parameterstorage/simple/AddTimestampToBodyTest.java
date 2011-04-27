/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage.simple;

import static org.junit.Assert.*;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/*
 * Tests Hummingbird's 'AddTimestampToBody' Processor.
 */
@ContextConfiguration(locations = { "/simple/AddTimestampToBodyTest-context.xml" })
public class AddTimestampToBodyTest extends AbstractJUnit4SpringContextTests {

	@Produce(uri = "direct:Parameter")
	protected ProducerTemplate producer = null;

	@EndpointInject(uri = "mock:Result")
	protected MockEndpoint result = null;

	@Autowired
	protected CamelContext context = null;

	protected long testTimestamp = 123456789;
	protected String testPayload = "Test_Payload";
	protected String newPayload = testTimestamp + ";" + testPayload + "\n";

	/*
	 * Tests the processor in a camel route.
	 */
	@Test
	public void testRoute() {
		// Prepare Exchange
		Exchange exchange = new DefaultExchange(
				context);
		exchange.getIn().setHeader("Timestamp", testTimestamp);
		exchange.getIn().setBody(testPayload);

		// Send exchange and wait 0.1sec.
		producer.send(exchange);

		try {
			// Wait until there is 1 message in 'result', but max 4ms + 8 + 16ms + 32ms + 64ms + 128ms = 252ms
			for(int i = 4; result.getReceivedCounter() != 1 && i <= 128; i *= 2) {
				Thread.sleep( i );
			}
		} catch (InterruptedException e) {
		}

		// Execute tests
		assertTrue(result.getReceivedCounter() == 1);
		assertTrue(newPayload.equals(result.getReceivedExchanges().get(0)
				.getIn().getBody(String.class)));
	}

}
