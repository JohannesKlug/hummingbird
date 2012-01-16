package org.hbird.core.spacesystemmodel;

import org.hbird.core.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.core.spacesystemmodel.exceptions.InvalidSpaceSystemDefinitionException;

public interface SpaceSystemModelFactory {

	SpaceSystemModel createSpaceSystemModel(final String spaceSystemmodelFilename) throws InvalidParameterTypeException, InvalidSpaceSystemDefinitionException;

}