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
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.logica.hummingbird.buffers.CommandBuffer;
import com.logica.hummingbird.formatter.ExchangeFormatter;
import com.logica.hummingbird.formatter.HeaderFields;
import com.logica.hummingbird.type.Argument;
import com.logica.hummingbird.type.CommandDefinition;

/**
 * @TITLE Command Generator Design
 * The command generator is a simple tool for creating commands and injecting them
 * in the command topic. Currently it sends a predefined command.
 * @CATEGORY Component Design
 * @END
 */
public class JettyCommandTransformer {

	protected static Logger logger = Logger.getLogger(JettyCommandTransformer.class);
	
	/** The buffer holding the command definitions. */
	@Autowired
	protected CommandBuffer buffer = null;

	/** Queue for the scheduled commands. */
	@Autowired
	protected ProducerTemplate producer = null;

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
	public void process(Exchange arg0) throws Exception {


		CommandDefinition definition = buffer.getCommandDefinition(ExchangeFormatter.getName(arg0));
		
		/** Create exchange holding the command. */
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(definition);
		exchange.getIn().setHeader(HeaderFields.NAME, ExchangeFormatter.getName(arg0));
		
		if (arg0.getIn().getHeader(HeaderFields.RELEASETIME) != null) {
			exchange.getIn().setHeader(HeaderFields.RELEASETIME, Long.parseLong(ExchangeFormatter.getReleaseTime(arg0)));
		}
		else {
			exchange.getIn().setHeader(HeaderFields.RELEASETIME, 0l);
		}
		
		/** Convert arguments from String to their real type. */
		for (Argument argument : definition.getArguments()) { 
			Object value = ExchangeFormatter.convert(argument.getType(), (String) arg0.getIn().getHeader(argument.getName()));
			exchange.getIn().setHeader(argument.getName(), value);
		}

		/** Release the command to the command query, i.e. schedule it for release to the spacecraft. */
		logger.info("Scheduling command '" + ExchangeFormatter.getName(exchange) + "' with ID " + ExchangeFormatter.getMessageId(exchange) + "'.");
		producer.send("direct:Commands", exchange);
		
		/** send a html response back to the GUI. */
        arg0.getOut().setBody("HTTP/1.1 200 OK");
	}
}
