/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage;

import static org.junit.Assert.assertTrue;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.hbird.business.parameterstorage.ConvertBodyToOrFromXml;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/*
 * Tests Hummingbird's 'ConvertBodyToOrFromXml' Bean
 */
@ContextConfiguration(locations = { "/ConvertBodyToOrFromXmlTest-context.xml" })
public class ConvertBodyToOrFromXmlTest extends
		AbstractJUnit4SpringContextTests {

	@Produce(uri = "direct:Parameter")
	protected ProducerTemplate producer = null;

	@EndpointInject(uri = "mock:Result")
	protected MockEndpoint result = null;

	@Autowired
	protected CamelContext convertBodyToOrFromXmlContext = null;

	protected double testDouble = 123456.7890123;
	protected String testXml = "<double>123456.7890123</double>";
	protected ConvertBodyToOrFromXml convertBodyToOrFromXml = new ConvertBodyToOrFromXml();

	/*
	 * Tests the 'fromXml' method: An Object (Double) is created from an XML
	 * string.
	 */
	@Test
	public void testFromXml() {
		Double generatedDouble = (Double) convertBodyToOrFromXml
				.fromXml(testXml);

		assert (generatedDouble.doubleValue() == testDouble);
	}

	/*
	 * Tests the bean in a route: An Object (Double) is converted to an XML
	 * string.
	 */
	@Test
	public void testRouteToXml() {
		result.reset();

		// Prepare exchange
		Exchange exchange = new DefaultExchange(convertBodyToOrFromXmlContext);
		exchange.getIn().setBody(new Double(testDouble));

		// Send exchange and wait 0.1sec.
		producer.send(exchange);

		try {
			// Wait until there is 1 message in 'result', but max 4ms + 8 + 16ms + 32ms + 64ms + 128ms = 252ms
			for(int i = 4; result.getReceivedCounter() != 1 && i <= 128; i *= 2) {
				Thread.sleep( i );
			}
		} catch (Exception e) {
		}

		// Execute tests
		assertTrue(result.getReceivedCounter() == 1);

		assertTrue(testXml.equals(result.getReceivedExchanges().get(0).getIn()
				.getBody(String.class)));
	}

	/*
	 * Tests the bean in a route: An Object (Double) is created from an XML
	 * string.
	 */
	@Test
	public void testRouteFromXml() {
		result.reset();

		// Prepare exchange
		Exchange exchange = new DefaultExchange(convertBodyToOrFromXmlContext);
		exchange.getIn().setBody(testXml);

		// Send exchange and wait 0.1sec.
		producer.send(exchange);

		try {
			// Wait until there is 1 message in 'result', but max 4ms + 8 + 16ms + 32ms + 64ms + 128ms = 252ms
			for(int i = 4; result.getReceivedCounter() != 1 && i <= 128; i *= 2) {
				Thread.sleep( i );
				System.out.println(i);
			}
		} catch (Exception e) {
		}

		// Execute tests
		assertTrue(result.getReceivedCounter() == 1);
		assertTrue(result.getReceivedExchanges().get(0).getIn().getBody()
				.getClass().getName() == "java.lang.Double");
		assertTrue(testDouble == result.getReceivedExchanges().get(0).getIn()
				.getBody(Double.class).doubleValue());
	}
	
	/*
	 * Tests the 'toXml' method: An Object (Double) is converted to an XML
	 * string.
	 */
	@Test
	public void testToXml() {
		String generatedXml = convertBodyToOrFromXml.toXml(new Double(
				testDouble));

		assert (generatedXml.equals(testXml));
	}
}
