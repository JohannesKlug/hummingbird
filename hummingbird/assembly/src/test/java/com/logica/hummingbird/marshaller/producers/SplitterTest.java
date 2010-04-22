package com.logica.hummingbird.marshaller.producers;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultMessage;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;




/*
 * 
 * Example taken from Camel documentation.
 * 
 */


public class SplitterTest extends CamelTestSupport {

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce(uri = "direct:start")
    protected ProducerTemplate template;
    
    protected static SplitterTest splitter;

    @Test
    public void testSendMessageToSplitter() throws Exception {

        resultEndpoint.expectedMessageCount(5);

        template.sendBodyAndHeader("test", "foo", "bar");

        resultEndpoint.assertIsSatisfied();
        for (Exchange exchange : resultEndpoint.getReceivedExchanges()) {
        	System.out.println(exchange.getIn().getHeaders());
        	System.out.println(exchange.getIn());
        }
    }


    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
            	
            	splitter = new SplitterTest();
            	
                from("direct:start").split().method(splitter, "split").to(resultEndpoint);
            }
        };
    }
    
    public static List<Message> split() {
    	List<Message> messages = new ArrayList<Message>();
    	
    	for (int i=0; i<5; i++) {
    		Message message = new DefaultMessage();
    		message.setBody("This is message # "+ i);
    		message.setHeader("seq", i);
    		messages.add(message);
    	}
		return messages;
    	
    }
}

