package org.hbird.transport.assembly;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Simple driver for any route that demands no specific start. Will assemble the simulator based on a spring XML 
 * bean file, whose path can be parsed as the first argument to the application.
 * 
 * To change the simulator output, edit the Spring XML bean file. 
 * 
 */
public class SpringRunner {

	/**
	 * Main method for starting the simulator.
	 * 
	 * @param args The path to the Spring assembly file. Must be in the format 'classpath:[relative path]' or 'file:[full path]'.
	 */
	public static void main(String[] args) {
		
		/** Read the configuration file as the first argument. If not set, then we try the default name. */
		String assemblyFile = "classpath:PacketDispatcher.xml";
		if (args.length > 0) {
			assemblyFile = args[0];
		}
		
		System.out.println("Starting simulator runner based on assembly file '" + assemblyFile + "'.");

		new FileSystemXmlApplicationContext(assemblyFile);
	}
}
