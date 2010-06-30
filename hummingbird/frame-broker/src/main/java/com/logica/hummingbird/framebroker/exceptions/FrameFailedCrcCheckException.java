package com.logica.hummingbird.framebroker.exceptions;

public class FrameFailedCrcCheckException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5750908427846801404L;

	public FrameFailedCrcCheckException() {
	}

	public FrameFailedCrcCheckException(String message) {
		super(message);
	}

	public FrameFailedCrcCheckException(Throwable cause) {
		super(cause);
	}

	public FrameFailedCrcCheckException(String message, Throwable cause) {
		super(message, cause);
	}

}
