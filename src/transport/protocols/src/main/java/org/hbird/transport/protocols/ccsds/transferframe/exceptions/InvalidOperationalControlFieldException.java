package org.hbird.transport.protocols.ccsds.transferframe.exceptions;

public class InvalidOperationalControlFieldException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1087362588889501333L;

	public InvalidOperationalControlFieldException() {
	}

	public InvalidOperationalControlFieldException(int erroneousLength) {
		super("An invalid Operational Control Field was encountered while encoding a CCSDS Transfer Frame. " +
				"The OCF must be a byte array of length 4. Passed byte array was: " + erroneousLength + " bytes long.");
	}

}
