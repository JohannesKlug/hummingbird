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
package com.logica.hummingbird.validation.parameter;

import com.logica.hummingbird.telemetry.NotComparableTypeException;

/**
 * Limit class for checking whether a lower end limit has been violated.
 */
public class UpperLimit extends BaseLimit {

	/**
	 * Constructor with no initial limit value. The limit will NOT start processing
	 * before a limit value has been received through the processLimit() method.
	 * 
	 * @param stateName Name of the state parameter that will be issued.
	 */
	public UpperLimit(String stateName) {
		super(stateName);
	}
	
	/**
	 * Constructor with an initial limit value. The limit will start processing
	 * Immediately. The limit value may later be changed through the processLimit() method.
	 * 
	 * @param stateName Name of the state parameter that will be issued.
	 * @param limit Initial limit value.
	 */
	public UpperLimit(String stateName, double value) {
		super(stateName);
		limit = value;
	}

	/* (non-Javadoc)
	 * @see com.logica.hummingbird.validation.parameter.BaseLimit#checkLimit()
	 */
	protected boolean checkLimit() throws NotComparableTypeException {
		return (Double) parameter > limit;
	}	
}
