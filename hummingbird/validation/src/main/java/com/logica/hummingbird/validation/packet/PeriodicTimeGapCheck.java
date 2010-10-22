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
package com.logica.hummingbird.validation.packet;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.logica.hummingbird.telemetry.DefaultSpaceParameter;
import com.logica.hummingbird.telemetry.HummingbirdPacket;

public class PeriodicTimeGapCheck implements Processor {

	static String stateName = "Continiuity";
	static String ruleName = "Packet Periodicity Based Check";
	
	protected long lastSsc = 0;
	protected long currentSsc = 0;
 	
	protected HummingbirdPacket packet = null;

	@Override
	public void process(Exchange arg0) throws Exception {
		HummingbirdPacket packet = (HummingbirdPacket) arg0.getIn(HummingbirdPacket.class);		
		currentSsc = packet.getSouceSequenceCounter();
		this.packet = packet;
	}
	
	/**
	 * Method to be called by timer. Will trigger the state evaluation and 
	 * the route.
	 */
	public void timer(Exchange arg0) {
		arg0.getIn().setBody(new DefaultSpaceParameter(stateName, Boolean.class, (lastSsc != currentSsc)));
		lastSsc = currentSsc;
	}
}
