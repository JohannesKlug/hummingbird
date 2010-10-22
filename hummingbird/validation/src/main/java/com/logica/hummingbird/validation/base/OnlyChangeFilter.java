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
package com.logica.hummingbird.validation.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;

import com.logica.hummingbird.telemetry.HummingbirdParameter;

public class OnlyChangeFilter {

	private static org.apache.log4j.Logger logger = Logger.getLogger(OnlyChangeFilter.class);
	
	protected Map<String, Boolean> currentState = new HashMap<String, Boolean>();
	
	public void process(Exchange arg0) throws Exception {
		HummingbirdParameter state = (HummingbirdParameter) arg0.getIn().getBody(HummingbirdParameter.class) ;
		
		if (currentState.containsKey(state.getName()) == true) {
			if (currentState.get(state.getName()) != state.asBoolean()) {
				logger.debug("Setting state " + state.getName() + " to " + state.asBoolean() + " as it has changed.");
				currentState.put(state.getName(), state.asBoolean());
			}
			else {
				logger.info("State change filtered out as not delta change.");
				arg0.setProperty(Exchange.ROUTE_STOP, true);
			}
		}
		else {
			logger.debug("Setting state " + state.getName() + " to " + state.asBoolean() + " as it is new.");
			currentState.put(state.getName(), state.asBoolean());
		}
	}
}
