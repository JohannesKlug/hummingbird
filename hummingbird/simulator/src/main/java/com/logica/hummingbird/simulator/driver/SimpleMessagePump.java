package com.logica.hummingbird.simulator.driver;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.logica.hummingbird.simulator.Simulator;
import com.logica.hummingbird.simulator.waveforms.LinearWaveform;

public class SimpleMessagePump {
	
	static CamelContext cc = new DefaultCamelContext();
	
	public static void main(String[] args) {
		String uri = args[0];
		String jmsLocation = args[1];
		int messageRate = Integer.parseInt(args[2]);
		
		try {
			cc.start();
		} catch (Exception e1) {
			System.err.println(e1);
		}
		
		cc.addComponent("activemq", ActiveMQComponent.activeMQComponent(uri));
		
		Simulator sim = new Simulator(cc.getEndpoint(jmsLocation));
		sim.sendMessage(messageRate);
		
		
		sim.addWaveform(new LinearWaveform(101, 0, 1));
		
		Thread simulatorThread = new Thread(sim);
		simulatorThread.start();
	}
}
