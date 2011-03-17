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

import org.apache.camel.Exchange;
import org.hbird.exchange.tasks.AbstractTask;
import org.hbird.exchange.type.Parameter;
import org.hbird.exchange.type.StateParameter;

/** Abstract base class for all parameter checks. A parameter check is a task that
 *  validates a parameter, such as a range check or a check against a static value. */
public abstract class AbstractCheck extends AbstractTask {

	/** The unique UID. */
	private static final long serialVersionUID = -140685919241520588L;

	public AbstractCheck(long deltaTime, StateParameter stateParameter) {
		super(deltaTime);
		this.stateParameter = stateParameter;
	}

	/** The state that shall be set. */
	protected StateParameter stateParameter = null;

	/** The provider to be used to retrieve the current value of the parameter than needs to be checked. */
	protected IDataProvider provider;
	
	/** The selector that will be parsed to the provider to perform the retrieval of the parameter. */
	protected String selector;
	
	public void execute(Exchange exchange) {
		
		/** Get the parameter to be checked. */
		Parameter parameter = provider.getParameter(selector);
		
		/** Check the parameter, and set the value as well as the parameter that the state is a state of. */		
		stateParameter.setValue(validate(parameter));
		stateParameter.setIsStateOff(parameter);
		
		/** Create exchange and send. */
		exchange.getIn().setBody(stateParameter);
	}

	/** Validates whether the check is valid against the provided parameter. The specific
	 *  algorithm used to check the parameter depends on the implementation and can be
	 *  a fixed value, a range or a dynamically changing value. */
	protected abstract boolean validate(Parameter parameter);
}
