package org.hbird.protocols.ccsds.transferframe.exceptions;

public class InvalidFrameLengthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1087362588889501333L;

	public InvalidFrameLengthException() {
	}

	public InvalidFrameLengthException(String message) {
		super(message);
	}

	public InvalidFrameLengthException(Throwable cause) {
		super(cause);
	}

	public InvalidFrameLengthException(String message, Throwable cause) {
		super(message, cause);
	}

}
