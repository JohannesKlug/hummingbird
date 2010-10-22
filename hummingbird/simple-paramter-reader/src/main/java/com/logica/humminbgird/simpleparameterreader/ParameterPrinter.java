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
package com.logica.humminbgird.simpleparameterreader;

import org.apache.camel.Exchange;


/**
 * A very simple Camel bean for printing the name + value of a parameter to system log. 
 */
public class ParameterPrinter {

	
	/**
	 * Method printing the parameter name and value, plus meta data if a specific type of parameter,
	 * to system out.
	 * 
	 * @param arg0
	 */
	public void process(Exchange arg0) {
		String message = arg0.getIn().getHeaders().get("Name") + " = " + arg0.getIn().getHeaders().get("Value");
			
		if (arg0.getIn().getHeaders().containsKey("StateOff")) {
			message += " is state of " + arg0.getIn().getHeaders().get("StateOff");
		}
		
		System.out.println(message);
	}
}
