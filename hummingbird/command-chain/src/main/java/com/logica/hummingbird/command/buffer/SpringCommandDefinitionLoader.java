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
package com.logica.hummingbird.command.buffer;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.springframework.beans.factory.annotation.Autowired;

import com.logica.hummingbird.command.CommandDefinition;
import com.logica.hummingbird.jmshelper.ExchangeFormatter;

/**
 * Camel 'Splitter' for loading command definitions from a Spring bean file and inject
 * them into a route, for example to a ActiveMQ queue.
 */
public class SpringCommandDefinitionLoader {
	
	/** The context in which the component is running. */
	@Autowired
	protected CamelContext context = null;

	/** List of command definitions to be injected. */
	@Autowired
	protected List<CommandDefinition> definitions = null;
		
	/**
	 * Method to split the message. The returned message list is actually loaded
	 * from a Spring file, i.e. the original Exchange is ignored.
	 * 
	 * @param arg0 Exchange triggering the loading. The message itself is ignored.
	 * @return A list of messages, carrying as the body a command definition.
	 */
	public List<Message> process(Exchange arg0) {

		/** Iterate through definitions and create Messages. */
		List<Message> messages = new ArrayList<Message>();
		for (CommandDefinition definition : definitions) {
			messages.add(ExchangeFormatter.createCommandDefinition(definition.getName(), definition));
		}
		
		return messages;
	}
}
