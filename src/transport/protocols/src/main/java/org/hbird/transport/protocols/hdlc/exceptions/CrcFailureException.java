package org.hbird.transport.protocols.hdlc.exceptions;

public class CrcFailureException extends Exception {
	private static final long serialVersionUID = 2669111048455976454L;

	public CrcFailureException() {
		super();
	}

	public CrcFailureException(String message) {
		super(message);
	}

}
