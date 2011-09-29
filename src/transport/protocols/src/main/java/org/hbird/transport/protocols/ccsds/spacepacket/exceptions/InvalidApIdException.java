package org.hbird.transport.protocols.ccsds.spacepacket.exceptions;

public class InvalidApIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5267933171443567049L;

	public InvalidApIdException() {
	}

	public InvalidApIdException(int erroneousId) {
		super("An invalid ApId was encountered. " +
				"It must be in the range [0,2047] (11 bits). Passed id was: " + 
				erroneousId);
	}

}
