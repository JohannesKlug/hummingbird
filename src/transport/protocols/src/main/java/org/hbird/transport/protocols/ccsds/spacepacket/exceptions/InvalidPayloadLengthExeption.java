package org.hbird.transport.protocols.ccsds.spacepacket.exceptions;

public class InvalidPayloadLengthExeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4575264678404016108L;
	
	public InvalidPayloadLengthExeption() {
	}

	public InvalidPayloadLengthExeption(long length) {
		super("An invalid payload length was encountered. " +
				"It must be in the range [1,65536]. Passed length was: " + 
				length);
	}

}
