package org.hbird.core.spacesystemmodel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.hbird.core.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.core.spacesystemmodel.exceptions.InvalidSpaceSystemDefinitionException;

@Path("ssmfactory")
public interface SpaceSystemModelFactory {

	@GET
	@Path("model")
	SpaceSystemModel createSpaceSystemModel() throws InvalidParameterTypeException, InvalidSpaceSystemDefinitionException;

}