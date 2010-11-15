package org.hbird.interfaces;

import org.apache.camel.CamelContext;
import org.apache.camel.Message;
import org.apache.camel.ProducerTemplate;

import org.hbird.buffers.ObjectBuffer;

public interface ITask {

	public long deltaTime();

	
	/**
	 * Method for running the task.
	 * 
	 * @param producer The producer template to be used to send any exchanges.
	 */
	public void execute(CamelContext context, ProducerTemplate producer, ObjectBuffer buffer);


	
	/**
	 * Method to configure the task based on the command message. This can be used to
	 * configure for example limits based on specific command arguments known to be embedded
	 * in the command.
	 * 
	 * @param in The message with headers that can be used to configure the task. The body is not read, only the headers.
	 */
	public void configure(Message in);
}
