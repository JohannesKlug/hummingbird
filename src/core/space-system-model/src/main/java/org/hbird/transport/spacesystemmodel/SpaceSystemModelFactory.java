package org.hbird.transport.spacesystemmodel;

import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidSpaceSystemDefinitionException;

public interface SpaceSystemModelFactory {

	SpaceSystemModel createSpaceSystemModel(final String spaceSystemmodelFilename) throws InvalidParameterTypeException, InvalidSpaceSystemDefinitionException;

}