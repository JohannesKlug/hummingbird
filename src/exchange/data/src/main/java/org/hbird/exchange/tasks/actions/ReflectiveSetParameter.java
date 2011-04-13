package org.hbird.exchange.tasks.actions;

import org.hbird.exchange.type.Argument;
import org.hbird.exchange.type.Command;
import org.hbird.exchange.type.Parameter;

/**
 * A reflective set parameter sets the value of a parameter based on a value
 * defined when the task was scheduled. This can be used to reflect a value
 * based on the argument of a command, i.e. ensure that a given value has
 * changed as expected.
 */
public class ReflectiveSetParameter extends SetParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2247014379748682184L;

	/** The name of the argument that this parameter should reflect. */
	protected String argumentname;

	
	/**
	 * Constructor of a reflective parameter.
	 * 
	 * @param name
	 * @param description
	 * @param executionTime
	 * @param parameter
	 * @param parametername
	 */
	public ReflectiveSetParameter(String name, String description, long executionTime, Parameter parameter, String argumentname) {
		super(name, description, executionTime, parameter);
		this.argumentname = argumentname;
	}

	
	/* (non-Javadoc)
	 * @see org.hbird.exchange.tasks.AbstractTask#setValue(org.hbird.exchange.type.Command)
	 */
	public void configure(Command command) {
		
		/** Find the argument which should be reflected. */
		for (Argument argument : command.getArguments()) {
			if (argument.getName().equals(argumentname)) {
				
				/** Set the value and break. */
				this.parameter.setValue(argument.getValue());
				break;
			}
		}
	}	
}
