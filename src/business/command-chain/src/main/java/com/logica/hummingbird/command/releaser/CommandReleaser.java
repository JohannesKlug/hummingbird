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
package org.hbird.command.releaser;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.hbird.buffers.StateBuffer;
import org.hbird.formatter.ExchangeFormatter;
import org.hbird.formatter.HeaderFields;
import org.hbird.interfaces.ITask;
import org.hbird.type.CommandDefinition;

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

	protected static Logger logger = Logger.getLogger(CommandReleaser.class);
	
	/** Queue for the task schedule. */
	@Autowired
	protected ProducerTemplate producer = null;

	/** The context in which the component is running. */
	@Autowired
	protected CamelContext context = null;

	/** Provider of state parameters*/
	@Autowired
	protected StateBuffer stateBuffer = null;

	/**
	 * Processor for the scheduling of validation task for a command as well as the
	 * release of the command.
	 * 
	 * @param arg0
	 * @throws InterruptedException 
	 */
	public void process(Exchange arg0) throws InterruptedException {

		logger.info("Processing command '" + ExchangeFormatter.getName(arg0) + "' with ID " + ExchangeFormatter.getMessageId(arg0) + "'.");
		
		/** Get the command definition. */
		CommandDefinition definition = (CommandDefinition) arg0.getIn().getBody();

		/** Wait until the execution time. */
		Date now = new Date();
		long releaseTime = (Long) arg0.getIn().getHeader(HeaderFields.RELEASETIME);

		if (releaseTime > now.getTime()) {
			logger.info("Delaying command for " + (releaseTime - now.getTime())/1000 + " seconds.");
			Thread.sleep(releaseTime - now.getTime());
		} 

		/** Validate the lock state(s). */
		for (String state : definition.getLockStates()) {
			if (stateBuffer.getState(state) == false) {				
				/** Stop the release of the command. */
				arg0.setProperty(Exchange.ROUTE_STOP, true);
				return;
			}
		}

		/** Schedule all tasks. */
		for (ITask task : definition.getTasks()) {
			task.configure(arg0.getIn());
			
			Exchange exchange = new DefaultExchange(context);
			exchange.setIn(ExchangeFormatter.createTask("Task", (Long) arg0.getIn().getHeader(HeaderFields.RELEASETIME) + task.deltaTime(), (String) arg0.getIn().getHeader(HeaderFields.NAME), task));
			producer.send("direct:tasks", exchange);
			
			logger.info("Scheduling task '" + task.getClass().toString() + "' with ID " + ExchangeFormatter.getMessageId(exchange) + "'.");
		}

		/** Command is forwarded in the route, i.e. released. */
	}
}
