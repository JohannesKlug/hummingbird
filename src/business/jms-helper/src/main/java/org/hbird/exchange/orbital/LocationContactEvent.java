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
package org.hbird.exchange.orbital;

import org.hbird.exchange.type.Location;
import org.hbird.exchange.type.Named;

public class LocationContactEvent extends Named {

	private static final long serialVersionUID = 6129893135305263533L; 

	protected Location location = null;
	
	protected Satellite satellite = null;
	 
	protected boolean isVisible = true;
	
	public LocationContactEvent(String name, String description, long timestamp, Location location, Satellite satellite) {
		super(name, description, timestamp);

		this.location = location;
		this.satellite = satellite;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Location getLocation() {
		return location;
	}

	public Satellite getSatellite() {
		return satellite;
	}

	public boolean isVisible() {
		return isVisible;
	}
}
