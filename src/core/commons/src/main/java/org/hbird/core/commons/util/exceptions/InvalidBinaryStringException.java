package org.hbird.core.commons.util.exceptions;

public class InvalidBinaryStringException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5587651701214652273L;
	
	public InvalidBinaryStringException(int length) {
		super("Binary string of length " + length + " encountered. This is invalid. Length must be a multiple of " + Byte.SIZE + ".");
	}

}
