package com.logica.hummingbird;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.logica.hummingbird.simulator.Simulator;
import com.logica.hummingbird.simulator.waveforms.FlatWaveform;
import com.logica.hummingbird.simulator.waveforms.LinearWaveform;

public class SimulatorRunner {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CamelContext context = new DefaultCamelContext();
		try {
			context.start();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// TODO Make broker URL configurable via Spring
		context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://127.0.0.1:61616"));
		
		
		try {
			// TODO Make Topic configurable via Spring
//			Simulator simulator = new Simulator(context.getEndpoint("activemq:topic:newtopic"));
			Simulator simulator = new Simulator(context.getEndpoint("activemq:q1"));
			simulator.addWaveform(new LinearWaveform(101, 0, 1));
			
			simulator.setMessageInterval(0);
			
			Thread simulatorThread = new Thread(simulator);
			simulatorThread.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
