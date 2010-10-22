package com.logica.hummingbird.simpleparametersimulator;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.CamelTestSupport;
import org.apache.log4j.Logger;

public class SimpleParameterSimulatorLinearTest extends CamelTestSupport {

	private static org.apache.log4j.Logger logger = Logger.getLogger(SimpleParameterSimulatorLinearTest.class);
	
	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	public void testEjectionMessage() throws Exception {
		logger.info("Testing linear simulator.");
		Thread.sleep(10000);
		
		for (int counter = 0; counter < 100; counter++) {
			resultEndpoint.message(counter).body(double.class).equals(new Double(counter));
		}		
		logger.info("Works fine.");
	}

	@Override
	protected RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			public void configure() {
				from("timer://timer1?fixedRate=true&period=100").bean(new LinearParameter(0, 1, 1000, "LINEAR_P1_PER_SECOND"), "process").to("mock:result");
			}
		};
	}

}
