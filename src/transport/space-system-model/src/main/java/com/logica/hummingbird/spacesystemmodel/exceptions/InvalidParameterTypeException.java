package com.logica.hummingbird.spacesystemmodel.exceptions;

public class InvalidParameterTypeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7277675037604948522L;

	public InvalidParameterTypeException(String message) {
		super(message);
	}
	
	public InvalidParameterTypeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidParameterTypeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
