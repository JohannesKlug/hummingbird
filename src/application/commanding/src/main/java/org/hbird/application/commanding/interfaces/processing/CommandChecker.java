package org.hbird.application.commanding.interfaces.processing;

import org.hbird.core.commons.tmtc.CommandGroup;

public interface CommandChecker {
	/**
	 * Runs any type of check (implementation specific) on a given command returning a boolean
	 * representing success or failure of the check. Success and failure is mapped to
	 * the boolean return by the implementation. This interface defines no rules regarding that mapping.
	 * Check the implementation of CommandCheck when using the classes.
	 *
	 * @param command
	 * @return
	 */
	boolean checkCommand(CommandGroup command);
}
