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


/**
 * Base type for all simulated parameters. Holds the name and implements the Camel
 * callback method. 
 *
 */
public abstract class BaseParameter {

	/** The name of the parameter being generated. */
	protected String name = "";
		
	/**
	 * Basic constructor, taking the name of the parameter to be generated as an argument.
	 * 
	 * @param name The name of the parameter to be created.
	 */
	public BaseParameter(String name) {
		this.name = name;
	}
	
	/**
	 * Method to be implemented by specific base classes. Creates the actual parameter
	 * and sets it in the Exchange as the 'in -> body'
	 * 
	 * @param arg0 The exchange into which the parameter should be inserted. To insert a 
	 * parameter into the exchange, use the ExchangeFormatter class.
	 */
	protected abstract void process(Exchange arg0);
}
