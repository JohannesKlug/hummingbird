package org.hbird.core.spacesystempublisher.exceptions;

import org.hbird.core.spacesystemmodel.exceptions.InvalidSpaceSystemDefinitionException;

public class UnavailableSpaceSystemModelException extends Exception {
	private static final long serialVersionUID = 6280024845858806053L;

	public UnavailableSpaceSystemModelException(String message, InvalidSpaceSystemDefinitionException e) {
		super(message, e);
	}

}
