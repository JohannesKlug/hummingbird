package com.logica.hummingbird.simulator;

import org.apache.camel.CamelContext;
import org.apache.camel.Consumer;
import org.apache.camel.EndpointInject;
import org.apache.camel.Processor;
import org.apache.camel.Produce;
import org.apache.camel.Producer;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.bean.BeanProcessor;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultEndpoint;
import org.apache.camel.impl.DefaultProducerTemplate;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.util.jndi.JndiContext;
import org.junit.Test;

public class SimulatorTest extends CamelTestSupport {
	
	
	
    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;
    
//    @Override
//    protected RouteBuilder createRouteBuilder() throws Exception {
//    	
//        return new RouteBuilder() {
//            public void configure() {
//                //from("direct:start").bean(Simulator.class, "nextMessage");
//            }
//        };
//    }
    
    @Test
    public void TestSimulator() throws Exception {
    	

    	//DefaultProducerTemplate.newInstance(new DefaultCamelContext(), "direct:start").sendBody("test");
    	
    	Simulator simulator = new Simulator(resultEndpoint);
    	
    	simulator.sendMessage();
    	

    	
    	resultEndpoint.setExpectedMessageCount(1);
    	resultEndpoint.assertIsSatisfied();
    }

}
