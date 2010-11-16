package org.hbird.gmap;

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

public class HumsatGmapTest extends CamelTestSupport {

	private static org.apache.log4j.Logger logger = Logger.getLogger(HumsatGmapTest.class);
	
	protected JndiRegistry registry = null;

	
	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	public void testEjectionMessage() throws Exception {
		
		// FIXME fails on Hudson
		fail("Fails on Hudson. FIXME!");		
		logger.info("Testing gmap.");
	
		/** TODO */
//		while (true) {
//			Thread.sleep(1000);
//		}
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
				
				PositionSender sender = new PositionSender();
				sender.setTemplate(template);
				registry.bind("sender", sender);
				
				from("timer://timer1?fixedRate=true&period=1000").bean(sender, "processSend").to("cometd://0.0.0.0:8888/service/test?baseResource=classpath:webapp");
				// from("timer://timer1?fixedRate=true&period=1000").bean(sender, "processSend").to("cometd://localhost:8888/service/test");
				
				from("activemq:topic:Parameter?selector=Name='latitude'").bean(sender, "processLatitude");
				from("activemq:topic:Parameter?selector=Name='longitude'").bean(sender, "processLongitude");
				from("activemq:topic:Parameter?selector=Name='elevation'").bean(sender, "processElevation");				
				
				from("activemq:topic:Parameter?selector=StateOff='battery'").bean(sender, "processState");
			}
		};
	}

}
