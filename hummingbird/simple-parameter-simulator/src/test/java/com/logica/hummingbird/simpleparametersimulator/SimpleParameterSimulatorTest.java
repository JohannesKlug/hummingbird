package com.logica.hummingbird.simpleparametersimulator;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.CamelTestSupport;
import org.apache.log4j.Logger;

public class SimpleParameterSimulatorTest extends CamelTestSupport {

	private static org.apache.log4j.Logger logger = Logger.getLogger(SimpleParameterSimulatorTest.class);
	
	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	public void testEjectionMessage() throws Exception {
		logger.info("Testing all simulators.");
		Thread.sleep(10000);
		
		for (int counter = 0; counter < 100; counter++) {
			// System.out.println("Testing for counter " + counter + " equals " + resultEndpoint.message(counter).body().toString());
		}		
		
		logger.info("Works fine.");
	}

	@Override
	protected RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			public void configure() {
				from("timer://timer1?fixedRate=true&period=1000").bean(new BooleanParameter(true, "BINARY1_PER_1000M"), "process").to("mock:result");
				from("timer://timer2?fixedRate=true&period=100").bean(new LinearParameter(0, 1, 1000, "LINEAR1_PER_100M"), "process").to("mock:result");
				from("timer://timer3?fixedRate=true&period=1000").bean(new LinearParameter(0, 1, 1000, "LINEAR1_PER_1000M"), "process").to("mock:result");
				from("timer://timer4?fixedRate=true&period=1000").bean(new SinusCurveParameter(0.01, 10, 0, 0, 100, "SINUS1_PER_SECOND"), "process").to("mock:result");
			}
		};
	}

}
