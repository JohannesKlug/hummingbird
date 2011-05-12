package org.hbird.transport.protocols.ccsds.transferframe.exceptions;

public class InvalidVirtualChannelIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1087362588889501333L;

	public InvalidVirtualChannelIdException() {
	}

	public InvalidVirtualChannelIdException(int erroneousId) {
		super("An invalid Virtual Channel ID was encountered. " +
				"It must be in the range [0,7] (3 bits). Passed id was: " + 
				erroneousId);
	}

}
