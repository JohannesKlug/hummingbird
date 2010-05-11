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
    
    @Test
    public void TestRunningSimulatorPerformance() throws Exception {
    	
    	resultEndpoint.reset();
    	
    	resultEndpoint.setExpectedMessageCount(0);
    	resultEndpoint.assertIsSatisfied();
    	
    	resultEndpoint.reset();
    	
    	Simulator simulator = new Simulator(resultEndpoint);
    	simulator.addWaveform(new FlatWaveform(100, 2));
    	simulator.setMessageInterval(0);
    	
    	Thread simulatorThread = new Thread(simulator);
    	
    	long startTime = System.currentTimeMillis();
    	simulatorThread.start();
    	for (int i = 0; i< 1; i++) {
    		Thread.sleep(1000);
    		long delta = System.currentTimeMillis() - startTime;
    		int received = resultEndpoint.getReceivedCounter();
    		System.out.println(received + " messages received in " + delta/1000 + " seconds → " + received * 1000 / delta + " messages/s; " + Math.round(((double)delta / (double)received * 1000)) + " µs/message.");
    		
    	}
    	
    	simulator.stopSimulator();
    	
    	resultEndpoint.setMinimumExpectedMessageCount(2);
    	resultEndpoint.assertIsSatisfied();
    	
    }

}
