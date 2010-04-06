package com.logica.hummingbird.simulator;

import org.apache.camel.EndpointInject;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SimulatorTest extends CamelTestSupport {
	
    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;
    
    @Test
    public void TestSimulator() throws Exception {
    	
    	Simulator simulator = new Simulator(resultEndpoint);
    	
    	resultEndpoint.setExpectedMessageCount(0);
    	resultEndpoint.assertIsSatisfied();
    	
    	simulator.sendMessage();
    	
    	resultEndpoint.setExpectedMessageCount(1);
    	resultEndpoint.assertIsSatisfied();
    	
    	simulator.sendMessage();
    	
    	resultEndpoint.setExpectedMessageCount(2);
    	resultEndpoint.assertIsSatisfied();
    	
    	simulator.sendMessage();
    	simulator.sendMessage();
    	simulator.sendMessage();
    	
    	resultEndpoint.setExpectedMessageCount(5);
    	resultEndpoint.assertIsSatisfied();
    }

}
