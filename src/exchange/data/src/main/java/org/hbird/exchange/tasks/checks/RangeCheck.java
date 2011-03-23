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
package org.hbird.exchange.tasks.checks;

import org.apache.log4j.Logger;
import org.hbird.exchange.tasks.actions.SetParameter;
import org.hbird.exchange.type.Comperator;
import org.hbird.exchange.type.Parameter;
import org.hbird.exchange.type.StateParameter;


/**
 * This validation step validates that a specific parameter has a specific value
 * at the expected time.
 *
 */
public class RangeCheck extends AbstractCheck {

	/** The unique UID. */
	private static final long serialVersionUID = 7471839659877039842L;

	/** The class logger. */
	protected static Logger logger = Logger.getLogger(SetParameter.class);

	/** The lower value of the range. If NULL, then there is no lower range. */
	protected Parameter lowerValue = null;
	
	/** The upper value of the range. If NULL, then there is no upper range. */
	protected Parameter upperValue = null;

	public RangeCheck(String name, String description, long executionTime, StateParameter stateParameter, Parameter lowerValue, Parameter upperValue) {
		super(name, description, executionTime, stateParameter);

		this.lowerValue = lowerValue;
		this.upperValue = upperValue;
	}

	public boolean validate(Parameter parameter) {
		
		/** Check states. */
		boolean inLower = lowerValue.getValue() == null || Comperator.compare(lowerValue.getValue(), parameter.getValue()) < 0;
		boolean inUpper = upperValue.getValue() == null || Comperator.compare(parameter.getValue(), upperValue.getValue()) < 0;
		
		logger.info("Performing range check on parameter '" + parameter.getName() + "'. Parameter state is  '" + (inLower && inUpper) + "'.");
		
		return inLower && inUpper;
	}
}
