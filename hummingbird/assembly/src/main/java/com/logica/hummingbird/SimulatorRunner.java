package com.logica.hummingbird;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.logica.hummingbird.simulator.Simulator;
import com.logica.hummingbird.simulator.waveforms.FlatWaveform;

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
		context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://10.48.18.28:61616"));
		
		
		try {
			Simulator simulator = new Simulator(context.getEndpoint("activemq:topic:newtopic"));
			simulator.addWaveform(new FlatWaveform(100, 2));
			
			Thread simulatorThread = new Thread(simulator);
			simulatorThread.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
