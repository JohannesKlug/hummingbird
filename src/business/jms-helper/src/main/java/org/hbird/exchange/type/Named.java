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

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/** The super class of all types being exchanged. Contains the information needed to uniquely identify
 *  an object as well as describe it.
 *  
 *  The class is intended to be subtyped, into specific types exchanged within the system such as 
 *  parameters, commands and tasks. Each subtype thus share a set of attributes. 
 * */
public abstract class Named implements Serializable {

	private static final long serialVersionUID = -5803219773253020746L;

	/** A unique identifier of this object. The name identify the type of the object. The timestamp
	 *  the time at which the object represent the state of the type in the system. The name and
	 *  the timestamp is thus in principle enough to uniquely identify the object. The objectid simplifies
	 *  the identification of the object. */
	protected String objectid = UUID.randomUUID().toString();
	
	/** The time at which this object represented a valid state of the system. Default value is the
	 *  time of creation. */
	protected long timestamp = (new Date()).getTime();
	
	/** The name of the type.*/
	protected String name;

	/** A description of the object type. */
	protected String description;
	
	
	/**
	 * Constructor of a Named object. The timestamp will be set to the creation time.
	 * 
	 * @param name The name of the object.
	 * @param description The description of the object.
	 */
	public Named(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
	 * Constructor of a Named object with a specific timestamp. 
	 * 
	 * @param name The name of the object.
	 * @param description The description of the object.
	 * @param timestamp The timestamp of the object.
	 */
	public Named(String name, String description, long timestamp) {
		this.name = name;
		this.description = description;
		this.timestamp = timestamp;
	}

	/**
	 * Default comparator of all Named objects. Should be overridden by specific subclasses
	 * to implement specific ways of comparing objects. The comparison is based on the criterions;
	 * - If the names are the same and the timestamps are the same, then rhs == lhs (0).
	 * - If the names are the same, but the timestamp aint, then the timestamp is used to evaluate.
	 * - If the names are not the same, then the timestamp is used for evaluation. 0 will not be returned, i.e. the 
	 *   objects will always be considered different.
	 * 
	 * @param rhs The object that this object should be compared against. 
	 * @return Value defining whether this object is less (-1), equal (0) or more (1) than the parsed object.
	 */
	public int compareTo(Named rhs) {
		if (this.name.equals(rhs.getName())) {
			if (this.timestamp == rhs.timestamp) {
				return 0;
			}
			else {
				return this.timestamp < rhs.timestamp? -1: 1;
			}
		}
		else {
			return this.timestamp < rhs.timestamp? -1: 1;
		}
	}

	/**
	 * Getter of the object name.
	 * 
	 * @return The name of the object.
	 */
	public String getName() {
		return name;
	}
		
	/**
	 * Getter of the description of the object.
	 * 
	 * @return The description of the object.
	 */
	public String getDescription() {
		return description;
	}

	
	/**
	 * Setter of the object timestamp.
	 * 
	 * @param timestamp The time of the object. Default value is the creation time of the object.
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
