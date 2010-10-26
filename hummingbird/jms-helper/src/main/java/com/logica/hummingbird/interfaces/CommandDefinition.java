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
package com.logica.hummingbird.interfaces;

import java.io.Serializable;
import java.util.List;


public class CommandDefinition implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected List<String> lockStates = null;
	
	protected List<ITask> tasks = null;
	
	protected String name;

	public CommandDefinition(String name, List<String> lockStates, List<ITask> tasks) {
		super();
		this.lockStates = lockStates;
		this.tasks = tasks;
		this.name = name;
	}

	public List<String> getLockStates() {
		return lockStates;
	}

	public List<ITask> getTasks() {
		return tasks;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
