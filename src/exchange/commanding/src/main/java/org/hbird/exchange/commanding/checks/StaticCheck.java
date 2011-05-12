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
package org.hbird.exchange.commanding.checks;

import org.hbird.exchange.type.Comperator;
import org.hbird.exchange.type.Parameter;
import org.hbird.exchange.type.StateParameter;

/** A check that validates the parameter against a static, preconfigured, value. */
public class StaticCheck extends AbstractCheck {

	/** The unique UID. */
	private static final long serialVersionUID = 7253442557939480209L;

	/** The value object to be checked against. */
	protected Object staticValue = null; 
	
	public StaticCheck(String name, String description, long deltaTime, StateParameter stateParameter, Object staticValue) {
		super(name, description, deltaTime, stateParameter);
		this.staticValue = staticValue;
	}

	@Override
	protected boolean validate(Parameter parameter) {
		return Comperator.compare(parameter.getValue(), staticValue) == 0;
	} 
}
