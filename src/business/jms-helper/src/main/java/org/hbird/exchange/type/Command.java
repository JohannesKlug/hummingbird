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
import java.util.ArrayList;
import java.util.List;

import org.hbird.exchange.tasks.ITask;

/**
 * @TITLE Command Definition
 * This object represents a command.
 * 
 * The lifecycle of a command is
 * 1) Creation.
 * 2) Release to the command queue. The command will wait in the queue until it is ready for release.
 * 3) Validation of the lock states of the command. If any of the lock states is 'false', then the command will not be released.
 * 4) Scheduling of all tasks needed to validate the command.
 * 5) Release, i.e. transfer to the system responsible for transfering the command to the satellite.
 *
 * h2. Arguments
 * 
 * A command can have zero or more arguments. An argument is simply a name / value pair.
 * 
 * h2. Lock States
 * 
 * A lock state is a parameter state, which must be true for the command to be released. This can be used to
 * define 
 * 1) Dependencies on limits (only release a command if a (set of) parameters is within a given limit).
 * 2) Define dependencies on other commands (interlock). The failure in a command should result in a command
 *    validation state parameter being set to false.
 * 3) Definition of general system locks (master mode) where no comamnds can be issued.
 *
 * h2. Tasks
 * 
 * The validation of the command is done through a number of validation tasks. Each task perform a specific
 * part of the validation at a given delta time compared to the release of the command. This can be used to
 * 1) Disable limit checking when it is known that it will change.
 * 2) Change the expected limit.
 * 3) Enable the limit again after the command propagation period has expired.
 * 4) Perform specific parameter checks at given points in time.
 * 
 * @CATEGORY Information Type
 * @END
 */
public class Command extends Named implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** List of arguments. The value is embedded in the header of the exchange. */
	protected List<Argument> arguments = new ArrayList<Argument>();
	
	/** List of states which at release time must all be 'true' for the comamnd to be released. */
	protected List<String> lockStates = new ArrayList<String>();
	
	/** List of tasks to be performed after the release of the command. */
	protected List<ITask> tasks = new ArrayList<ITask>();
	
	
	public Command(String name, String description) {
		super(name, description);
	}
	/**
	 * Basic constructor
	 * 
	 * @param name The name of the command.
	 * @param arguments The arguments of the command.
	 * @param lockStates The states of the command which must be true upon release.
	 * @param tasks The tasks to be performed as part of the command validation.
	 */
	public Command(String name, String description, List<Argument> arguments, List<String> lockStates, List<ITask> tasks) {
		super(name, description);
		this.arguments = arguments;
		this.lockStates = lockStates;
		this.tasks = tasks;
	}
	
	/**
	 * Method to get the list of arguments of the command.
	 * 
	 * @return Map keyed on the argument name and with the value of the argument.
	 */
	public List<Argument> getArguments() {
		return arguments;
	}

	/**
	 * Method to get the lock states of the command, i.e. a list of parameter state names that must all
	 * be true for the command to be released.
	 * 
	 * @return List of lock states.
	 */
	public List<String> getLockStates() {
		return lockStates;
	}

	/**
	 * Method to get the validation tasks of the command, i.e. a list of specific, timetagged tasks that
	 * will configure the system and perform the necesarry validation.
	 * 
	 * @return List of tasks.
	 */
	public List<ITask> getTasks() {
		return tasks;
	}
}
