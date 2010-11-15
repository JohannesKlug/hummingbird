package org.hbird;

import org.springframework.beans.BeansException;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import org.hbird.simulator.Simulator;

/**
 * Simple driver for the Simulator bean. Will assemble the simulator based on a spring XML 
 * bean file, whose path can be parsed as the first argument to the application.
 * 
 * To change the simulator output, edit the Spring XML bean file. 
 * 
 */
public class SimulatorRunner {
	
	/**
	 * Main method for starting the simulator.
	 * 
	 * @param args The path to the Spring assembly file. Must be in the format 'classpath:[relative path]' or 'file:[full path]'.
	 */
	public static void main(String[] args) {
		
		/** Read the configuration file as the first argument. If not set, then we try the default name. */
		String assemblyFile = "classpath:SimulatorRunner-context.xml";		
		if (args.length > 0) {
			assemblyFile = args[0];
		}
		
		System.out.println("Starting simulator runner based on assembly file '" + assemblyFile + "'.");

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
