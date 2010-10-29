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
package com.logica.hummingbird.command.releaser;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.logica.hummingbird.command.CommandDefinition;
import com.logica.hummingbird.interfaces.IParameterStateConnector;
import com.logica.hummingbird.interfaces.ITask;
import com.logica.hummingbird.jmshelper.ExchangeFormatter;
import com.logica.hummingbird.jmshelper.HeaderFields;

/**
 * @TITLE Command Releaser Design
 * The command releaser reads commands from the 'Command' queue, validate that they 
 * can be released, schedule the tasks to be done in the system as a result of the command
 * and then release the command.
 * 
 * h2. Command Execution Time
 * 
 * The header of the command message contains the execution time of the command. The releaser will
 * wait until then to actually process the command.
 * 
 * h2. Release Validation
 * 
 * A [[Command Definition]] can contains any number of 'lock states', being state parameters
 * (true / false). In case any of these are false at the time of execution, the command wont
 * be released. 
 * 
 * h2. Schedule Tasks
 * 
 * A command will affect the satellite in some way. Thats means that the ground system(s) most likely
 * also have to be reconfigured; limits may need to be disabled, changed and at some point enabled again and
 * specific checks may need to be done to validate that the command was send, executed and succeeded.   
 * 
 * 
 * @CATEGORY Component Design
 * @END
 */
public class CommandReleaser {

	/** Queue for the task schedule. */
	@Autowired
	protected ProducerTemplate producer = null;

	/** The context in which the component is running. */
	@Autowired
	protected CamelContext context = null;

	/** Provider of state parameters*/
	@Autowired
	protected IParameterStateConnector stateConnector = null;

	/**
	 * Processor for the scheduling of validation task for a command as well as the
	 * release of the command.
	 * 
	 * @param arg0
	 * @throws InterruptedException 
	 */
	public void process(Exchange arg0) throws InterruptedException {

		/** Get the command definition. */
		CommandDefinition definition = (CommandDefinition) arg0.getIn().getBody();

		/** Wait until the execution time. */
		Date now = new Date();
		long executionTime = (Long) arg0.getIn().getHeader(HeaderFields.TASK_EXECUTIONTIME);

		if (executionTime > now.getTime()) {
			Thread.sleep(executionTime - now.getTime());
		} 

		/** Validate the lock state(s). */
		for (String state : definition.getLockStates()) {
			if (stateConnector.getState(state) == false) {				
				/** Stop the release of the command. */
				arg0.setProperty(Exchange.ROUTE_STOP, true);
				return;
			}
		}

		/** Schedule all tasks. */
		for (ITask task : definition.getTasks()) {
			Exchange exchange = new DefaultExchange(context);
			exchange.setIn(ExchangeFormatter.createTask("Task", (Long) arg0.getIn().getHeader(HeaderFields.RELEASETIME) + task.deltaTime(), (String) arg0.getIn().getHeader(HeaderFields.NAME), task));
			producer.send("direct:tasks", exchange);			
		}

		/** Command is forwarded in the route, i.e. released. */
	}
}
