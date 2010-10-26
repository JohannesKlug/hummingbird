package com.logica.hummingbird.validation;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.JndiRegistry;
import org.apache.camel.test.CamelTestSupport;
import org.apache.log4j.Logger;

import com.logica.hummingbird.validation.parameter.LowerLimit;

public class HumsatValidationTest extends CamelTestSupport {

	private static org.apache.log4j.Logger logger = Logger.getLogger(HumsatValidationTest.class);

	protected JndiRegistry registry = null;
	
	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	public void testEjectionMessage() throws Exception {
		
		fail("This is horrible code and not testing anything.");
		
		logger.info("Testing all simulators.");
		Thread.sleep(10000);
		
		while (true) {
			Thread.sleep(1000);
		}		
	}
	
	protected CamelContext createCamelContext() throws Exception {
		return new DefaultCamelContext(createRegistry());
	}

	protected JndiRegistry createRegistry() throws Exception {
		registry = new JndiRegistry(createJndiContext()); 
		return registry;
	}

	@SuppressWarnings("unchecked")
	protected Context createJndiContext() throws Exception {
		Properties properties = new Properties();

		// jndi.properties is optional
		InputStream in = getClass().getClassLoader().getResourceAsStream("jndi.properties");
		if (in != null) {
			log.debug("Using jndi.properties from classpath root");
			properties.load(in);
		} else {
			// set the default initial factory
			properties.put("java.naming.factory.initial", "org.apache.camel.util.jndi.CamelInitialContextFactory");
		}
		return new InitialContext(new Hashtable(properties));
	}


	@Override
	protected RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			public void configure() {
				LowerLimit warningLimit = new LowerLimit("batteryWarningLevel", 30);
				LowerLimit errorLimit = new LowerLimit("batteryErrorLevel", 20);
				
				registry.bind("warningLimit", warningLimit);
				registry.bind("errorLimit", errorLimit);
				
				from("activemq:topic:Parameter?selector=Name='battery'").bean(warningLimit, "processParameter").to("activemq:topic:Parameter");
				from("activemq:topic:Parameter?selector=Name='battery'").bean(errorLimit, "processParameter").to("activemq:topic:Parameter");
				
				from("activemq:topic:Parameter?selector=Name='batteryWarningLimit'").bean(warningLimit, "processLimit").to("activemq:topic:Parameter");
				from("activemq:topic:Parameter?selector=Name='batteryErrorLimit'").bean(errorLimit, "processLimit").to("activemq:topic:Parameter");
				
				from("activemq:topic:Parameter?selector=Name='batteryWarningEnabled'").bean(warningLimit, "processEnabled").to("activemq:topic:Parameter");
				from("activemq:topic:Parameter?selector=Name='batteryErrorEnabled'").bean(errorLimit, "processEnabled").to("activemq:topic:Parameter");
			}
		};
	}
}
