package com.logica.hummingbird.commandgenerator;


import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.test.CamelTestSupport;

public class RequestResponseTest extends CamelTestSupport {

	class dummyProcessor implements Processor {

		@Override
		public void process(Exchange arg0) throws Exception {
			System.out.println("Dummy receiving exchange");
			Exchange exc = arg0;			
		}
		
	}
	
	public void testEjectionMessage() throws Exception {	
		template.sendBodyAndHeader("activemq:topic:Parameter", "Message1", "Name", 1);
        template.sendBodyAndHeader("activemq:topic:Parameter", "Message3", "Name", 2);
        template.sendBodyAndHeader("activemq:topic:Parameter", "Message2", "Name", 3);

        dummyProcessor processor = new dummyProcessor();
        
		// as opposed to the CamelClientRemoting example we need to define the service URI in this java code		
        try {
			Object response = consumer.receiveNoWait("activemq:topic:Parameter?selector=Name<2");
			System.out.println("Received response");
		}
		catch(Exception e) {
			System.out.println("Exception " + e);
			e.printStackTrace();
		} 
	}
}
