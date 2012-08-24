package org.hbird.application.commanding.provided.processing;

import java.util.List;

import org.hbird.application.commanding.interfaces.processing.CommandChecker;
import org.hbird.core.commons.tmtc.ParameterGroup;

public class CommandInModelChecker implements CommandChecker {

	private List<ParameterGroup> commands;

	/**
	 * Checks if the given command is present in the {@link CommandList}.
	 *
	 * @{inheritDoc}
	 */
	@Override
	public boolean checkCommand(final ParameterGroup command) {
		boolean result = false;
		for(ParameterGroup cmd : commands) {
			// TODO Assumes ParameterGroup has a valid equality implementation with corresponding hashcode method.
			if(cmd.equals(command)) {
				result = true;
				break;
			}
		}

		return result;
	}

}
