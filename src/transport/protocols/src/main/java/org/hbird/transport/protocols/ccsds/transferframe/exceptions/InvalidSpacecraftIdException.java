package org.hbird.transport.protocols.ccsds.transferframe.exceptions;

public class InvalidSpacecraftIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2727615613955734535L;

	public InvalidSpacecraftIdException() {
	}

	public InvalidSpacecraftIdException(int erroneousId) {
		super("An invalid Spacecraft ID was encountered. " +
				"It must be in the range [0,1023] (10 bits). Passed id was: " + 
				erroneousId);
	}

}
