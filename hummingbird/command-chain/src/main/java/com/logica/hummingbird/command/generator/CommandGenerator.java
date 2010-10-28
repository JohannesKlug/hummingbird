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

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.logica.hummingbird.interfaces.CommandDefinition;


/**
 * @TITLE Command Generator Design
 * The command generator is a simple tool for creating commands and injecting them
 * in the command topic. Currently it sends a predefined command.
 * @CATEGORY Component Design
 * @END
 */
public class CommandGenerator {

	/** The context in which the component is running. */
	@Autowired
	protected CamelContext context = null;

	/**
	 * Method for creating and sending a command. The command generator can be linked
	 * to a Camel Jetty component, routing HTTP requests to the component.
	 * 
	 * The HTTP request can contain command values as options in the request. Each
	 * option is mapped to a JMS header field. A request such as 
	 * 		http://myserver/myserver?name=testcommand&argument1=10
	 * Will thus result in a exchange having a header field 'name' with value 'TestCommand' and
	 * 'argument1' with value '10'.
	 * 
	 * The generator simply attach the command definition to the exchange body
	 * and forward the request to the release queue.
	 * 
	 * @param arg0 The exchange triggering the command. Can be a timer or a request.
	 */
	public void process(Exchange arg0) {
		
		/** TODO get the command definition from the command buffer. */
		CommandDefinition definition = new CommandDefinition();
		
		/** Release the command to the command query, i.e. schedule it for release to the spacecraft. */
		arg0.getIn().setBody(definition);
	}
}
