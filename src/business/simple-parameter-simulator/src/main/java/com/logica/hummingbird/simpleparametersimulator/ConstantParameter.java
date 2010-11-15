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
package org.hbird.simpleparametersimulator;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;

import org.hbird.formatter.ExchangeFormatter;



/**
 * A constant parameter. Every time process is called, a new instance of the
 * parameter is send.
 */
public class ConstantParameter extends BaseParameter {

	/** The class logger. */
	protected static Logger logger = Logger.getLogger(ConstantParameter.class);

	/** The value of the constant. */
	protected Double value = 0d;	

	/**
	 * Simple constructor, setting the constant value to be send and the name of the parameter.
	 * 
	 * @param value The value of the constant
	 * @param name The name of the parameter
	 */
	public ConstantParameter(double value, String name) {
		super(name);
		this.value = value;
	}


	/* (non-Javadoc)
	 * @see org.hbird.simpleparametersimulator.BaseParameter#process(org.apache.camel.Exchange)
	 */
	public void process(Exchange arg0) {
		try {
			logger.debug("Sending new constant value with name '" + name + "'.");
			arg0.setIn(ExchangeFormatter.createParameterMessage(name, Double.class.toString(), value));
		} 
		catch (Exception e) {
			logger.error("Courght exception " + e);
			e.printStackTrace();
		}
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
