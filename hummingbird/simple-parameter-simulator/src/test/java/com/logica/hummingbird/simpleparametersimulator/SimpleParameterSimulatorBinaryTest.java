package com.logica.hummingbird.simpleparametersimulator;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.CamelTestSupport;
import org.apache.log4j.Logger;

public class SimpleParameterSimulatorBinaryTest extends CamelTestSupport {

	private static org.apache.log4j.Logger logger = Logger.getLogger(SimpleParameterSimulatorBinaryTest.class);
	
	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	public void testEjectionMessage() throws Exception {
		logger.info("Testing the boolean simulator.");
		
		Thread.sleep(10000);
		
		boolean value = false;
		for (int counter = 0; counter < 100; counter++) {
			assertTrue("Expected value " + value + " received " + !value, ((Boolean)resultEndpoint.getReceivedExchanges().get(counter).getIn().getHeaders().get("Value")) == value);
			value = !value;
		}		
		logger.info("Works fine.");
	}

	@Override
	protected RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			public void configure() {
				from("timer://timer1?fixedRate=true&period=100").bean(new BooleanParameter(true, "LINEAR_P1_PER_SECOND"), "process").to("mock:result");
			}
		};
	}

}
