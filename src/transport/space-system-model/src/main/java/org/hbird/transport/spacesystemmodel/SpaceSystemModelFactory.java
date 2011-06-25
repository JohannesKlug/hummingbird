package org.hbird.transport.spacesystemmodel;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.DefaultParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;

/**
 * Interface to create Space System Model factories.
 * 
 * The models are created based on an underlying space system model, defining the structure of the space system,
 * including the telemetry and command structures. The space system can be expressed in different ways, such as through
 * the OMG/CCSDS XTCE or the ESA MIB/PUS model. The model factory implementation will depend on a data structure in a
 * specific format, but hides this implementation to the monitoring component.
 * 
 */
public interface SpaceSystemModelFactory {
	/**
	 * Retrieves a container.
	 * 
	 * @param name
	 *            The unique name of the container to be returned.
	 * @return IContainer Returns the container identified through the name or throws an UnknownParameterGroupException.
	 * @throws UnknownParameterGroupException
	 * 
	 */
	ParameterGroup getParameterGroup(String name) throws UnknownParameterGroupException;

	/**
	 * get all {@link ParameterGroup}s in the SpaceSystemModel.
	 * 
	 * @return collection of parameter groups.
	 */
	Collection<ParameterGroup> getAllParameterGroups();


	/**
	 * Retrieves a parameter container.
	 * 
	 * @param name
	 *            The unique name of the parameter container to be returned.
	 * @return Parameter Returns the parameter container identified through the name, or null.
	 * 
	 */
	DefaultParameter getParameter(String name);

	/**
	 * Get all {@link Parameter}s in the Space System Model
	 * 
	 * @return Map of all parameters
	 */
	Map<String, DefaultParameter> getAllParameters();

	/**
	 * Get all restrictions in the Space System Model
	 * 
	 * @return map of all restrictions.
	 */
	Map<Parameter, List<String>> getAllParameterRestrictions();

	// FIXME Remove this? ParameterGroup model does not necessarily have to have a corresponding file.
	String getSpaceSystemModelFilePath();

}