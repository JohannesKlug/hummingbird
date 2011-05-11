/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage.simple;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.CamelTestSupport;
import org.junit.Test;

/*
 * Tests Hummingbird's 'AddTimestampToBody' Processor.
 */
public class AddTimestampToBodyTest extends CamelTestSupport {

	@Produce(uri = "direct:Start")
	protected ProducerTemplate producer = null;

	@EndpointInject(uri = "mock:Result")
	protected MockEndpoint result = null;

	protected long testTimestamp = 123456789;
	protected String testPayload = "Test_Payload";
	protected String newPayload = testTimestamp + ";" + testPayload + "\n";

	/*
	 * Tests the addTimestampToBody bean in a camel route.
	 */
	@Test
	public void testAddTimestamp() throws Exception {
		// Set expectations
		result.expectedBodiesReceived(newPayload);

		// Send Exchange
		producer.sendBodyAndHeader(testPayload, "Timestamp", testTimestamp);

		// Wait until there is 1 message in 'result', but max 4ms + 8 + 16ms +
		// 32ms + 64ms + 128ms = 252ms
		for (int i = 4; result.getReceivedCounter() != 1 && i <= 128; i *= 2) {
			Thread.sleep(i);
		}

		result.assertIsSatisfied();
	}

	@Override
	protected RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			public void configure() {
				from("direct:Start").bean(new AddTimestampToBody()).to("mock:Result");
			}
		};
	}
}
