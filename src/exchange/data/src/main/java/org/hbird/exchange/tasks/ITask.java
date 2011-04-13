/**
 * Licensed to the Hummingbird Foundation (HF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The HF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hbird.exchange.tasks;

import java.io.Serializable;

import org.apache.camel.Exchange;
import org.hbird.exchange.dataprovider.IDataProvider;
import org.hbird.exchange.type.Command;

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
public interface ITask extends Serializable {

	/** The scheduled execution time of the task.
	 *  
	 *  @return long The delta time (ms) until execution.
	 */
	public long getExecutionTime();

	/**
	 * Method for running the task.
	 * 
	 * @param context The camel context within which the task must be executed. The context contains the 
	 * routes that are used, and manages the exchange and producer template.
	 */
	public void execute(Exchange exchange, IDataProvider provider);
	
	
	/**
	 * Method used to configure the task based on a command. Is used by for example the
	 * 'reflectiveSetParameter'.
	 * 
	 * @param command The command triggering the task configuration.
	 */
	public void configure(Command command);
	
	
	/**
	 * Returns the unique object ID of the task.
	 * 
	 * @return The unique object ID of this task instance.
	 */
	public String getObjectid();
}
