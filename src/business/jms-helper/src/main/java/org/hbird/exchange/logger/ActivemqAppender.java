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
package org.hbird.exchange.logger;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/** A log4j appender for injecting log messages into a route.
 *  The class can be used in a log4j configuration file, such as a 
 *  'log4j.properties' or 'log4j.xml' file, and configured as art of the 
 *  standard log4j logger hierarchy.   
 *  The appender will create an Exchange and set the logging event as the
 *  body of the IN message. The exchange will thereafter be submitted to
 *  the route entry point defined by the 'from' field. */
public class ActivemqAppender extends AppenderSkeleton {

	/** The route entry point to which the exchanges will be injected. */
	protected String from = "direct:Logging";

	/** The Camel context to be used to send the exchanges. */
	protected CamelContext context;

	/** The producer of the exchanges. */
	protected ProducerTemplate producer;
	
	/**
	 * Default constructor. Will create the default context and procedure.
	 */
	public ActivemqAppender() {
		context = new DefaultCamelContext();
		producer = context.createProducerTemplate();		
	}

	/* (non-Javadoc)
	 * @see org.apache.log4j.AppenderSkeleton#append(org.apache.log4j.spi.LoggingEvent)
	 */
	@Override
	public void append(LoggingEvent event) {
		try {
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(event);
		producer.send(from, exchange);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		/** Do null */		
	}

	@Override
	public boolean requiresLayout() {
		return false;
	}
}