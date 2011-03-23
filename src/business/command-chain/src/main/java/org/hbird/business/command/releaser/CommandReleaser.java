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
package org.hbird.business.command.releaser;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.hbird.exchange.dataprovider.IDataProvider;
import org.hbird.exchange.tasks.ITask;
import org.hbird.exchange.type.Command;
import org.hbird.exchange.type.StateParameter;

/**
 * The command releaser reads commands from the 'Command' queue, validate that they 
 * can be released, schedule the tasks to be done in the system as a result of the command
 * and then release the command.
 * 
 * The command releaser do not use the 'releaseTime' scheduling for command release. This
 * is expected done prior to reception by this bean. A command received by this class will
 * thus be processed immediately.
 * 
 * A Command can contains any number of 'lock states', being state parameters
 * (true / false). In case any of these are false at the time of execution, the command wont
 * be released, i.e. the route will be stopped. 
 * 
 * A command will affect the satellite in some way. Thats means that the ground system(s) most likely
 * also have to be reconfigured; limits may need to be disabled, changed and at some point enabled again and
 * specific checks may need to be done to validate that the command was send, executed and succeeded. To
 * release tasks, the command releaser uses the route entry point 'begin:Tasks'. This must be available
 * in the route configuration.
 * 
 * The command releaser thereafter parses the command on in the route.
 * 
 * Example of Usage:
 * 
 * <bean id="commandReleaser" class="org.hbird.business.command.releaser.CommandReleaser"/>
 * 
 * <route>
 *   <from uri="activemq:queue:Commands"/>
 *   <to uri="bean:commandReleaser"/>
 *   <to uri="activemq:queue:ReleasedCommands"/>
 * </route>
 * 
 */
public class CommandReleaser {

	/** The object logger. */
	protected static Logger logger = Logger.getLogger(CommandReleaser.class);
	
	/** Queue for the task schedule. */
	@Autowired
	protected ProducerTemplate producer = null;

	/** The context in which the component is running. */
	@Autowired
	protected CamelContext context = null;

	/** A provider of data. Is used to retrieve parameter state information. */
	@Autowired
	protected IDataProvider provider = null;
	
	/**
	 * Processor for the scheduling of validation task for a command as well as the
	 * release of the command.
	 * 
	 * @param exchange
	 * @throws InterruptedException 
	 */
	public void process(Exchange exchange) throws InterruptedException {

		/** Get the command definition. */
		Command definition = (Command) exchange.getIn().getBody();
		logger.info("Processing command '" + definition.getName() + "' with ID " + definition.getObjectid() + "'.");
		
		/** Validate the lock state(s). */
		for (String state : definition.getLockStates()) {
			StateParameter parameter = (StateParameter) provider.getParameter("name=" + state);
			if ((Boolean) parameter.getValue() == false) {				
				/** Stop the release of the command. */
				exchange.setProperty(Exchange.ROUTE_STOP, true);
				return;
			}
		}

		/** Schedule all tasks. */
		for (ITask task : definition.getTasks()) {
			Exchange taskExchange = new DefaultExchange(context);
			taskExchange.getIn().setBody(task);
			taskExchange.getIn().setHeader("AMQ_SCHEDULED_DELAY", task.getExecutionTime());
			producer.send("direct:Tasks", taskExchange);
			
			logger.info("Scheduling task '" + task.getClass().toString() + "' with ID " + task.getObjectid() + "'.");
		}

		/** Command is forwarded in the route, i.e. released. */
	}
}
