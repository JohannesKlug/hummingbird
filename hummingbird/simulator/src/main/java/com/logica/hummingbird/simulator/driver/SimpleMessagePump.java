package com.logica.hummingbird.simulator.driver;

import org.springframework.beans.BeansException;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.logica.hummingbird.simulator.Simulator;


/**
 * Driver for creating a simulator from a spring assembly file and starting it.
 *
 */
public class SimpleMessagePump {
	
	/**
	 * Main method for starting the simulator.
	 * 
	 * @param args First parameter must be the name of the Spring assembly file. Default is 'classpath:Simulator-context.xml'. 
	 */
	public static void main(String[] args) {
		
		/** Read the configuration file as the first argument. If not set, then we try the default name. */
		String assemblyFile = "classpath:Simulator-context.xml";		
		if (args.length > 0) {
			assemblyFile = args[0];
		}

		/** Assemble the simulator and start it. */
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(assemblyFile);
		try {
			((Simulator) context.getBean("simulator")).run();
		}
		catch (BeansException e) {
			e.printStackTrace();
		}
	}
}
