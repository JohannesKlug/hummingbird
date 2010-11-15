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
package com.logica.hummingbird.simpleparametersimulator;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;

import com.logica.hummingbird.formatter.ExchangeFormatter;


/**
 * Class simulating a boolean parameter. The parameter flips each time the process
 * method is called, i.e. value = !value.
 */
public class BooleanParameter extends BaseParameter {

	/** The class logger. */
	protected static Logger logger = Logger.getLogger(BooleanParameter.class);

	/** The boolean value of the last send parameter.*/
	protected Boolean value = true;


	/**
	 * Basic constructor, setting the initial value and the name of the boolean
	 * parameter.  
	 * 
	 * @param value The initial value of the parameter.
	 * @param name The name of the parameter to be generated.
	 */
	public BooleanParameter(boolean value, String name) {
		super(name);
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.logica.hummingbird.simpleparametersimulator.BaseParameter#process(org.apache.camel.Exchange)
	 */
	public void process(Exchange arg0) {
		try {
			logger.debug("Sending new boolean value with name '" + name + "'.");
			arg0.setIn(ExchangeFormatter.createParameterMessage(name, Boolean.class.toString(), value = !value));
		} 
		catch (Exception e) {
			logger.error("Courght exception " + e);
			e.printStackTrace();
		}
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}
}
