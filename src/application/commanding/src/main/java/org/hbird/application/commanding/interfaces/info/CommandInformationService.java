package org.hbird.application.commanding.interfaces.info;

import java.util.List;

import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.hbird.core.spacesystempublisher.exceptions.UnavailableSpaceSystemModelException;

public interface CommandInformationService {

	/**
	 * Returns a list of {@link ParameterGroup}s representing all commands in the space system model
	 * 
	 * @return {@link ParameterGroup} list of all commands
	 * @throws UnavailableSpaceSystemModelException
	 */
	List<CommandGroup> getAllAllowedCommands() throws UnavailableSpaceSystemModelException;

	CommandGroup getCommand(String qualifiedName) throws UnavailableSpaceSystemModelException;
}
