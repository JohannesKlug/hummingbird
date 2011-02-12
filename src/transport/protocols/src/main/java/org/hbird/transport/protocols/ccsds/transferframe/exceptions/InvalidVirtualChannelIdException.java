package org.hbird.transport.protocols.ccsds.transferframe.exceptions;

public class InvalidVirtualChannelIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1087362588889501333L;

	public InvalidVirtualChannelIdException() {
	}

	public InvalidVirtualChannelIdException(String message) {
		super(message);
	}

	public InvalidVirtualChannelIdException(Throwable cause) {
		super(cause);
	}

	public InvalidVirtualChannelIdException(String message, Throwable cause) {
		super(message, cause);
	}

}
