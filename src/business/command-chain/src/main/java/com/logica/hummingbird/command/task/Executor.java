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
package org.hbird.command.task;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.hbird.buffers.ObjectBuffer;
import org.hbird.formatter.ExchangeFormatter;
import org.hbird.formatter.HeaderFields;
import org.hbird.interfaces.ITask;


/**
 * The executor performs the tasks scheduled for a task. It waits until the
 * execution time arrives, then perform the task.
 */
public class Executor {

	protected static Logger logger = Logger.getLogger(Executor.class);
	
	/** Queue for the task schedule. */
	@Autowired
	protected ProducerTemplate producer = null;

	/** The context in which the component is running. */
	@Autowired
	protected CamelContext context = null;

	/** The context in which the component is running. */
	@Autowired
	protected ObjectBuffer buffer = null;

	/** 
	 * Method for actually executing the task. The task will be extracted from the
	 * exchange body, which is expected to contain a task object.
	 * 
	 * @param arg0 The exchange carrying a task as its body.
	 * @throws InterruptedException 
	 */
	public void receive(Exchange arg0) throws InterruptedException {

		/** Get the task. */
		ITask task = (ITask) arg0.getIn().getBody();

		/** Wait until the execution time. */
		Date now = new Date();
		long executionTime = (Long) arg0.getIn().getHeader(HeaderFields.EXECUTIONTIME);

		if (executionTime > now.getTime()) {
			logger.info("Delaying task '" + task.getClass().toString() + "' for " + (executionTime - now.getTime())/1000 + " seconds.");
			Thread.sleep(executionTime - now.getTime());
		} 

		logger.info("Executing task '" + task.getClass().toString() + "' with ID " + ExchangeFormatter.getMessageId(arg0) + "'.");
		
		/** Execute the task */
		task.execute(context, producer, buffer);
	}
}
