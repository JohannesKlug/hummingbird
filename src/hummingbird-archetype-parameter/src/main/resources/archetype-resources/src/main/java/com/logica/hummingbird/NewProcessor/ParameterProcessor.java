#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
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
package ${package}.NewProcessor;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @TITLE [Title] Configuration
 * [Description of the usage]
 * @CATEGORY Design
 * 
 * */

public abstract class ParameterProcessor {

	/** The class logger. */
	private static org.apache.log4j.Logger logger = Logger.getLogger(ParameterProcessor.class);
	
	/** An autowired producer, i.e. Spring will locate the bean named 'producer' in the XML file and set it automatically. */
	@Autowired
	protected ProducerTemplate producer = null;

	/** An autowired context, i.e. Spring will locate the bean named 'context' in the XML file and set it automatically. */
	@Autowired
	protected CamelContext context = null;
	
	/**
	 * Method to process messages from one route.
	 * 
	 * @param arg0 The message carrying a parameter.
	 * @throws Exception
	 */
	public void process(Exchange arg0) throws Exception {
		
		/** TODO Process parameter. */
		String parameterName = ExchangeFormatter.getParameterName();		
	}	
}
