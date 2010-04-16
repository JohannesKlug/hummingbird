package com.logica.hummingbird.simulator;

import org.apache.camel.EndpointInject;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.logica.hummingbird.simulator.waveforms.FlatWaveform;

public class SimulatorTest extends CamelTestSupport {
	
    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;
    
    @Test
    public void TestSimulator() throws Exception {
    	
    	resultEndpoint.reset();
    	
    	Simulator simulator = new Simulator(resultEndpoint);
    	
    	resultEndpoint.setExpectedMessageCount(0);
    	resultEndpoint.assertIsSatisfied();
    	
    	simulator.sendMessage(0);
    	
    	resultEndpoint.setExpectedMessageCount(1);
    	resultEndpoint.assertIsSatisfied();
    	
    	simulator.sendMessage(0);
    	
    	resultEndpoint.setExpectedMessageCount(2);
    	resultEndpoint.assertIsSatisfied();
    	
    	simulator.sendMessage(0);
    	simulator.sendMessage(0);
    	simulator.sendMessage(0);
    	
    	resultEndpoint.setExpectedMessageCount(5);
    	resultEndpoint.assertIsSatisfied();
    }
    
    @Test
    public void TestRunningSimulator() throws Exception {
    	
    	resultEndpoint.reset();
    	
    	Simulator simulator = new Simulator(resultEndpoint);
    	simulator.addWaveform(new FlatWaveform(100, 2));
    	
    	Thread simulatorThread = new Thread(simulator);
    	simulatorThread.start();
    	Thread.sleep(2500);
    	simulator.stopSimulator();
    	
    	resultEndpoint.setMinimumExpectedMessageCount(2);
    	resultEndpoint.assertIsSatisfied();
    	
    }

}
