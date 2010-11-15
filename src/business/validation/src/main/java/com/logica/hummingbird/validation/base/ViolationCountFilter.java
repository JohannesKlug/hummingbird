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
package org.hbird.validation.base;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;


/**
 * Handler which only triggers the next downstream handler if a specific number
 * of violations have occurred.
 * 
 * The handler counts the number of violations, i.e. is state full. As long as the count is
 * below the trigger limit, the route will be stopped. If the count is equal to or above, then
 * the message is parsed on.
 * 
 * The counter is reset automatically when a valid parameter state is received.
 *
 */
public class ViolationCountFilter {

	/** The class logger. */
	private static org.apache.log4j.Logger logger = Logger.getLogger(ViolationCountFilter.class);
	
	/** The number of consecutive violations. Will be reset to 0 when the first non-violation is received. */
	protected long violations = 0;

	/** Flag setting whether all states recalculation should be stored. */
	protected boolean storeOnlyChanges = true;
	
	/** Limit when to trigger the next downstream handler. Default value is 2 because a value 
	 * of 1 is the same as no limit handler... */
	protected long triggerLimit = 2;

	public ViolationCountFilter() {};
	
	public ViolationCountFilter(long triggerLimit) {
		this.triggerLimit = triggerLimit;
	}
	
	public void process(Exchange arg0) throws Exception {
		Boolean state = (Boolean) arg0.getIn().getHeader("Value") ;
		String name = (String) arg0.getIn().getHeader("Name") ;

		if (state == false) {
			violations++;

			if (violations >= triggerLimit) {
				logger.debug(violations + " registered. Forwarding state " + name + " with value " + state);
				/** Continue route... */
			}
			else {
				logger.info("State change filtered out as number of violtions (" + violations + ") is below trigger limit (" + triggerLimit + ").");
				arg0.setProperty(Exchange.ROUTE_STOP, true);
			}
		}
		else {
			/** In case the state is valid, then all violations are cleared. */
			logger.debug("Resetting violation counter");
			violations = 0;
		}
	}

	public void reset() {
		violations = 0;
	}

	public long getViolations() {
		return violations;
	}

	public void setViolations(long violations) {
		this.violations = violations;
	}

	public long getTriggerLimit() {
		return triggerLimit;
	}

	public void setTriggerLimit(long triggerLimit) {
		this.triggerLimit = triggerLimit;
	}

	public boolean isStoreOnlyChanges() {
		return storeOnlyChanges;
	}

	public void setStoreOnlyChanges(boolean storeOnlyChanges) {
		this.storeOnlyChanges = storeOnlyChanges;
	}
}
