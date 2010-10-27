package com.logica.hummingbird.simpleparametersimulator;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.CamelTestSupport;
import org.apache.log4j.Logger;

public class HumsatSimulationTest extends CamelTestSupport {

	private static org.apache.log4j.Logger logger = Logger.getLogger(HumsatSimulationTest.class);
	
	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	public void testEjectionMessage() throws Exception {
		logger.info("Testing all simulators.");
		// Thread.sleep(10000);
		
//		while (true) {
//			Thread.sleep(1000);
//		}		
	}

	@Override
	protected RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			public void configure() {
				from("timer://latitude?fixedRate=true&period=1000").bean(new SinusCurveParameter(0.000010472, 180, 4.71238898, 0, 300000, "longitude"), "process").to("activemq:topic:Parameter");
				from("timer://longitude?fixedRate=true&period=1000").bean(new SinusCurveParameter(0.000020944, 30, 0, 0, 300000, "latitude"), "process").to("activemq:topic:Parameter");
				from("timer://elevation?fixedRate=true&period=1000").bean(new SinusCurveParameter(0.000020944, 30000, 0, 300000, 300000, "elevation"), "process").to("activemq:topic:Parameter");
				from("timer://battery?fixedRate=true&period=1000").bean(new SinusCurveParameter(0.000020944, 40, 0, 50, 300000, "battery"), "process").to("activemq:topic:Parameter");
			}
		};
	}

}
