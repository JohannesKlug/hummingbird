package org.hbird.transport.payloadcodec.exceptions;


public class UnexpectedParameterTypeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2743141196177763942L;

	public UnexpectedParameterTypeException(final String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnexpectedParameterTypeException [;");
		builder.append(getMessage());
		builder.append(" ])");
		return builder.toString();
	}
	
	
}
