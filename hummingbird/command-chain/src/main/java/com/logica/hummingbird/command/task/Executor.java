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
package com.logica.hummingbird.command.task;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.logica.hummingbird.interfaces.ITask;
import com.logica.hummingbird.jmshelper.HeaderFields;


/**
 * The executor performs the tasks scheduled for a task. It waits until the
 * execution time arrives, then perform the task.
 */
public class Executor {

	
	/** Queue for the task schedule. */
	@Autowired
	protected ProducerTemplate producer = null;

	/** The context in which the component is running. */
	@Autowired
	protected CamelContext context = null;
	
	/** 
	 * Method for actually executing the task. The task will be extracted from the
	 * exchange body, which is expected to contain a task object.
	 * 
	 * @param arg0 The exchange carrying a task as its body.
	 */
	public void receive(Exchange arg0) {
		
		/** Get the task. */
		ITask task = (ITask) arg0.getIn().getBody();

		/** Wait until the execution time. */
		Date now = new Date();
		long executionTime = (Long) arg0.getIn().getHeader(HeaderFields.TASK_EXECUTIONTIME);
		
		if (executionTime > now.getTime()) {
			try {
				Thread.sleep(executionTime - now.getTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 

		/** Execute the task */
		task.execute(context, producer);
	}
}
