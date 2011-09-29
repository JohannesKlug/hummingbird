package org.hbird.transport.protocols.ccsds.spacepacket.exceptions;

public class PayloadNullException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4575264678404016108L;

	public PayloadNullException() {
		super("Packet Payload may not be null.");
	}

}
