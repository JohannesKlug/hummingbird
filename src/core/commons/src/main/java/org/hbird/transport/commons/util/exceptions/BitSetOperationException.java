/**
 * 
 */
package org.hbird.transport.commons.util.exceptions;


/** TODO Put in the transport.common */
/**
 * This is a checked exception class which will allow the client to take steps to 
 * rectify the situation or display useful information to the user.
 * 
 * @author Mark Doyle
 */
public class BitSetOperationException extends Exception {
	private static final long serialVersionUID = 3499163979287233832L;

	/**
	 * 
	 */
	public BitSetOperationException() {
	}

	/**
	 * @param message
	 */
	public BitSetOperationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BitSetOperationException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BitSetOperationException(String message, Throwable cause) {
		super(message, cause);
	}
}
