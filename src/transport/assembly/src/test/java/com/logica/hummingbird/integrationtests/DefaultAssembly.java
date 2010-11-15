package org.hbird.integrationtests;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import org.hbird.example.ExampleEndpoint;
import org.hbird.simulator.Simulator;

public class DefaultAssembly extends CamelTestSupport{
	
	Simulator simulator;
	
	ExampleEndpoint exampleEndpoint = new ExampleEndpoint();
	
    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;
    
    @EndpointInject(uri = "mock:result2")
    protected MockEndpoint secondResultEndpoint;
    
    @EndpointInject(uri = "activemq:topic:newtopic")
    protected Endpoint activeMqEndpoint;
    	
    protected CamelContext createCamelContext() throws Exception {
        CamelContext camelContext = super.createCamelContext();
        camelContext.addComponent("activemq", ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));
        return camelContext;
    }

    
    
    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
        	
            public void configure() throws Exception {
            	
            	// Feeds into the topic
            	from("direct:start").to("activemq:topic:example");
            	
            	// Three subscribers for that topic:
            	
            	// a mock endpoint (data sink)
            	from("activemq:topic:example").to(resultEndpoint);
            	
            	// ExampleEndpoint, as a processor object
            	from("activemq:topic:example").process(exampleEndpoint);
            	
            	// ExampleEndpoint as a bean
            	from("activemq:topic:example").bean(ExampleEndpoint.class);
            	
            	
            	// Forward to new activemq topic by endpoint reference
            	from("activemq:topic:example").to(activeMqEndpoint);
            	
            	// Result Endpoint for second activemq topic
            	from("activemq:topic:newtopic").to(secondResultEndpoint);
            	
            	}
            };
    }
    

    
    @Test
    public void runExampleAssembly() throws Exception {

    	sendBody("direct:start", "Test");
    	
		resultEndpoint.setExpectedMessageCount(1);
		resultEndpoint.assertIsSatisfied();
		
		secondResultEndpoint.setExpectedMessageCount(1);
		secondResultEndpoint.assertIsSatisfied();
    }
    
    
}
