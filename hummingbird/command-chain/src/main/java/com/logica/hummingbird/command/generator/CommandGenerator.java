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
package com.logica.hummingbird.command.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.log4j.Logger;

import com.logica.hummingbird.interfaces.ITask;
import com.logica.hummingbird.jmshelper.ExchangeFormatter;
import com.logica.hummingbird.tasks.actions.SetParameter;


/**
 * @TITLE Command Generator Design
 * The command generator is a simple tool for creating commands and injecting them
 * in the command topic.
 * @CATEGORY Component Design
 * @END
 */
public class CommandGenerator {

	/** The class logger. */
	private static org.apache.log4j.Logger logger = Logger.getLogger(CommandGenerator.class);

	
	protected CamelContext context = null;
	
	protected String name = "";
	
	protected long releaseDelta = 0;
	
	public CommandGenerator(CamelContext context, String name, long releaseDelta) {
		this.context = context;
		this.name = name;
	}
	
	public void process(Exchange arg0) {

		Date now = new Date();
		
		/** Create the command. */
		
		/** First create the tasks. The tasks are;
		 *   1. Immediatly disable limit checking. 
		 *   2. Immediatly set expected limit to '1'.
		 *   3. Later enable limit checking again.  */
		List<ITask> tasks = new ArrayList<ITask>();
		tasks.add(new SetParameter(0, "valveLimitEnabled", false, Boolean.class.toString()));
		tasks.add(new SetParameter(0, "valveLimit", 1, Double.class.toString()));
		tasks.add(new SetParameter(5000, "valveLimitEnabled", true, Boolean.class.toString()));

		List<String> lockStates = new ArrayList<String>();
		
		/** Release the command to the command query, i.e. schedule it for release to the spacecraft. */
		arg0.setIn(ExchangeFormatter.createCommand(context, name, now.getTime() + releaseDelta, lockStates, tasks));
		logger.info("Queueing command with in message " + arg0.getIn());
	}
}
