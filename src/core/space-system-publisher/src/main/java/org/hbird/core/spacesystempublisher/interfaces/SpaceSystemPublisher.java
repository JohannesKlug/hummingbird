package org.hbird.core.spacesystempublisher.interfaces;

import java.util.List;
import java.util.Map;

import org.hbird.core.commons.tmtc.CommandGroup;
import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;


public interface SpaceSystemPublisher {

	// Parameter related
	Map<String, ParameterGroup> getParameterGroups();
	List<ParameterGroup> getParameterGroupList();
	List<Parameter<?>> getAllParameters();

	// Command related
	Map<String, CommandGroup> getCommands();
	List<CommandGroup> getCommandList();
	CommandGroup getCommand(String qualifiedName);
	ParameterGroup getParameterGroup(String qualifiedName) throws UnknownParameterGroupException;

	// Encoding related
	Map<String, Encoding> getEncodings();

	// Restriction/Payload Id related
	Map<String, List<String>> getRestrictions();


	// Model state propagation related
	void fireUpdate(SpaceSystemModelUpdate update);
	void modelUpdated();
}
