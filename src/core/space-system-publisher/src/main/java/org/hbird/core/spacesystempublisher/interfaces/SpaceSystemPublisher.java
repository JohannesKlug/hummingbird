package org.hbird.core.spacesystempublisher.interfaces;

import java.util.List;
import java.util.Map;

import org.hbird.core.spacesystemmodel.calibration.Calibrator;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.hbird.core.spacesystempublisher.exceptions.UnavailableSpaceSystemModelException;

public interface SpaceSystemPublisher {

	// Model state propagation related
	void fireUpdate();

	void modelUpdated() throws UnavailableSpaceSystemModelException;

	// Parameter related
	Map<String, ParameterGroup> getParameterGroups() throws UnavailableSpaceSystemModelException;

	List<ParameterGroup> getParameterGroupList() throws UnavailableSpaceSystemModelException;

	List<Parameter<?>> getAllParameters() throws UnavailableSpaceSystemModelException;

	// Command related
	Map<String, CommandGroup> getCommands() throws UnavailableSpaceSystemModelException;

	List<CommandGroup> getCommandList() throws UnavailableSpaceSystemModelException;

	CommandGroup getCommand(String qualifiedName) throws UnavailableSpaceSystemModelException;

	ParameterGroup getParameterGroup(String qualifiedName) throws UnknownParameterGroupException, UnavailableSpaceSystemModelException;

	// Encoding related
	Map<String, Encoding> getEncodings() throws UnavailableSpaceSystemModelException;

	// Restriction/Payload Id related
	Map<String, List<String>> getRestrictions() throws UnavailableSpaceSystemModelException;

	Map<String, String> getCommandVerifiers(String qualifiedName) throws UnavailableSpaceSystemModelException;

	Map<String, Calibrator> getAllCalibrators() throws UnavailableSpaceSystemModelException;

	Map<String, String> getAllUnitDescriptions() throws UnavailableSpaceSystemModelException;

	String getUnitDescription(String qualifiedName) throws UnavailableSpaceSystemModelException;

}
