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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.camel.Exchange;


/**
 * Class acting as a buffer of parameters. Inserting this in a route will ensure that
 * the latest value of a parameter is always available.
 */
public class ParameterBuffer {

	/** Map of parameters, keyed on the name and holding the actual value. */
	protected Map<String, Object> values = new ConcurrentHashMap<String, Object>();
	
	
	/** 
	 * Method for receiving a parameter update. The parameter value is buffered.
	 * 
	 * @param arg0 The exchange carrying a parameter.
	 */
	public void process(Exchange arg0) {
		values.put((String) arg0.getIn().getHeader("Name"), arg0.getIn().getHeader("Value"));
	} 

	
	/**
	 * Method to get a buffered parameter.
	 * 
	 * @param parameterName The name of the parameter to retrieve.
	 * @return The value as an object.
	 */
	public Object getValue(String parameterName) {
		return values.get(parameterName);
	}
}
