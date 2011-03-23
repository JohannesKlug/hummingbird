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
package org.hbird.exchange.type;

import org.hbird.exchange.tasks.checks.RangeCheck;


/**
 * A command argument definition. The value itself is maintained some where else,
 * most likely in the header of an exchange.
 * 
 * The argument definition has a name which is a unique identification of the definition. A
 * description can be used to describe the type.
 * 
 * The bit length defines the min / max value of the type.
 *
 */
public class Argument extends Parameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1006111372069943447L;

	/** The range defines the minimum and maximum values allowed for this value. */
	protected RangeCheck range;
	
	/**
	 * Creates a new argument. 
	 * 
	 * @param name The name of the argument
	 * @param description The description of the argument.
	 * @param bitLength The length in bits of the argument.
	 */
	public Argument(String name, String description, Object value, String unit, RangeCheck range) {
		super(name, description, value, unit);
		this.range = range;
	}

	public String getUnit() {
		return unit;
	}

	public RangeCheck getRange() {
		return range;
	}
}
