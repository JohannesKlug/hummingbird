package com.logica.hummingbird.simpleparameterreader;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.JndiRegistry;
import org.apache.camel.test.CamelTestSupport;

import com.logica.humminbgird.simpleparameterreader.ParameterPrinter;

public class HumsatReaderTest extends CamelTestSupport {

	protected JndiRegistry registry = null;
	
	
	public void testReceiveMessage() throws Exception {

		System.out.println("Starting reader...");
		
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


		/**
		 *  [upperLimit1]        {upperLimit1}
		 *  [enabled1]
		 *  [parameter1]
		 *  [lowerLimit1]        {lowerLimit1}
		 * 
		 *  [upperLimit2]        {upperLimit2}
		 *  [enabled1]
		 *  [parameter2]
		 *  [lowerLimit2]        {lowerLimit2}
		 * 
		 * */
		return new RouteBuilder() {

			public void configure() {

				ParameterPrinter printer = new ParameterPrinter();
				
				registry.bind("printer", printer);

				/** Routes to enable / disable the processing. */
				from("activemq:topic:Parameter?selector=StateOff='battery'").to("bean:printer");				
			}
		};
	}
}
