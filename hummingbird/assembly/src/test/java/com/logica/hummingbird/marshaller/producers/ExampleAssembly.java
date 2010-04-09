package com.logica.hummingbird.marshaller.producers;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.logica.hummingbird.example.ExampleEndpoint;
import com.logica.hummingbird.simulator.Simulator;

public class ExampleAssembly extends CamelTestSupport{
	
	Simulator simulator;
	
	ExampleEndpoint exampleEndpoint = new ExampleEndpoint();
	
	@Produce(uri = "direct:start")
    protected ProducerTemplate template;
	
    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;
	
    protected CamelContext createCamelContext() throws Exception {
        CamelContext camelContext = super.createCamelContext();

        // START SNIPPET: example
        camelContext.addComponent("activemq", new ActiveMQComponent());
        // END SNIPPET: example

        return camelContext;
    }

    
    
    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
        	
            public void configure() throws Exception {
            	
//            	from("direct:start").to(resultEndpoint);
            	
            	from("direct:start").to("activemq:queue:example");
            	
            	//from("activemq:queue:example").process(exampleEndpoint);
            	from("activemq:queue:example").to(resultEndpoint);

            	}
            };
    }
    

    
    @Test
    public void runExampleAssembly() throws Exception {

	//	template.sendBody("Test");
		
		resultEndpoint.setMinimumExpectedMessageCount(1);
		resultEndpoint.assertIsSatisfied();
    }
}
