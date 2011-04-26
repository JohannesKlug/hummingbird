package org.hbird.exchange.commanding;

import java.io.Serializable;

/** A task is a timed activity to be performed, something that can be executed in isolation.
 * 
 *  The task is intended to form part of a camel route, most likely based on a timer. The route will
 *  trigger the 'execute' method, which performs the actual task.
 *  
 *  The task has been designed to be used in a distributed environment, i.e. it may be created in
 *  one process, transfered through some communication mean, and executed in another environment.
 *  This means the task cant depend on local attributes, such as the local camel context. 
 *  
 *  */
public interface Task extends Serializable {

	/**
	 * Method for running the task.
	 * 
	 * @param context The camel context within which the task must be executed. The context contains the 
	 * routes that are used, and manages the exchange and producer template.
	 */
	public Object execute();
	
	
	/**
	 * Returns the unique object ID of the task.
	 * 
	 * @return The unique object ID of this task instance.
	 */
	public String getObjectid();
	
	
	/**
	 * Method to get the tim (ms) until the task should be executed.
	 * 
	 * @return The time (ms) until the task should be executed. 
	 */
	public long getExecutionDelay();
}
