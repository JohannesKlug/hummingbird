package com.logica.hummingbird.interfaces;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

public interface ITask {

	public long deltaTime();

	
	/**
	 * Method for running the task.
	 * 
	 * @param producer The producer template to be used to send any exchanges.
	 */
	public void execute(CamelContext context, ProducerTemplate producer);

}
