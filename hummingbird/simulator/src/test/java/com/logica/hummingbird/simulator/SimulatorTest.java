package com.logica.hummingbird.simulator;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.util.jndi.JndiContext;
import org.junit.Test;

public class SimulatorTest extends CamelTestSupport {
	
    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;
    
    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
    	
    	JndiContext context = new JndiContext();
    	context.bind("simulator", new Simulator(resultEndpoint));
    	CamelContext camelContext = new DefaultCamelContext(context);
    	
        return new RouteBuilder() {
            public void configure() {
                from("bean:simulator").to("mock:result");
            }
        };
    }
    
    @Test
    public void TestSimulator() throws Exception {
    	


    	
    	resultEndpoint.setExpectedMessageCount(1);
    	resultEndpoint.assertIsSatisfied();
    }

}
