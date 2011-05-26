/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.spacesystemmodel;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.exceptions.UnknownContainerNameException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.ParameterContainer;

/**
 * Interface to create monitoring models.
 * 
 * The monitoring models are created based on an underlying space system model, defining the structure of the space
 * system, including the telemetry and command structures. The space system can be expressed in different ways, such as
 * through the OMG/CCSDS XTCE or the ESA MIB/PUS model. The model factory implementation will depend on a data structure
 * in a specific format, but hides this implementation to the monitoring component.
 * 
 */
public interface ContainerFactory {
	/**
	 * Retrieves a container.
	 * 
	 * @param name
	 *            The unique name of the container to be returned.
	 * @return IContainer Returns the container identified through the name or throws an UnknownContainerNameException.
	 * @throws UnknownContainerNameException
	 * 
	 */
	Container getContainer(String name) throws UnknownContainerNameException;

	/**
	 * Retrieves a parameter container.
	 * 
	 * @param name
	 *            The unique name of the parameter container to be returned.
	 * @return Parameter Returns the parameter container identified through the name, or null.
	 * 
	 */
	ParameterContainer getParameter(String name);

	Map<String, ParameterContainer> getAllParameters();

	Map<Parameter, List<String>> getAllParameterRestrictions();

	// FIXME Remove this? Container model does not necessarily have to have a corresponding file.
	String getSpaceSystemModelFilePath();

	Collection<Container> getAllContainers();
}