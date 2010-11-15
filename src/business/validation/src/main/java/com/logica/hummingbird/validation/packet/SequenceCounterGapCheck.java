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
package org.hbird.validation.packet;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.hbird.telemetry.DefaultSpaceParameter;
import org.hbird.telemetry.HummingbirdPacket;


/**
 * Rule class for checking for gaps in the parameter stream.
 * 

 * @author Villemosg
 *
 */
public class SequenceCounterGapCheck implements Processor {

	static String stateName = "Continiuity";
	static String ruleName = "Sequence Counter Based Check";

	
	/** The counter at which the SSC wraps. The last value is NOT included, i.e. the 
	 * counter goes {0, 1, 2, ... , 65533, 65534, 0, 1, 2, ...}. */
	private int wrapCount = 65535;

	/** The next expected SSC. Calculated based in the last received + 1. If the checker has
	 * been reset, then the value will be 0, but any value will be accepted. */
	protected long expectedSsc = 0;

	/** Markes the gap as reset. A reset gapchecker will automatically return true for
	 * the first packet received. */
	protected boolean initialised = false;

	/** How many packets (based on the SSC) must be lost to trigger the rule? */
	protected long triggerLimit = 1;
	
	@Override
	public void process(Exchange arg0) throws Exception {
		HummingbirdPacket packet = (HummingbirdPacket) arg0.getIn(HummingbirdPacket.class); 
		boolean ruleParsed = true;
		
		if (initialised == false) {
			initialised = true;
		}
		else {			
			/** Only trigger an alarm if more packets have been lost than the 
			 * minimum trigger limit. */
			if (triggerLimit <= packet.getSouceSequenceCounter()%getWrapCount() - expectedSsc) {
				ruleParsed = false;	
			}	
		}				
				
		expectedSsc = (packet.getSouceSequenceCounter() + 1)%getWrapCount();
		
		arg0.getIn().setBody(new DefaultSpaceParameter(stateName, Boolean.class, ruleParsed));
	}

	public void reset() {
		initialised = false;
	}

	public long getTriggerLimit() {
		return triggerLimit;
	}

	public void setTriggerLimit(long triggerLimit) {
		this.triggerLimit = triggerLimit;
	}

	public void setWrapCount(int wrapCount) {
		this.wrapCount = wrapCount;
	}

	public int getWrapCount() {
		return wrapCount;
	}
}
