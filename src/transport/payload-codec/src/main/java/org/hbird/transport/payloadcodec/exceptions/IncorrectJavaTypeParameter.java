package org.hbird.transport.payloadcodec.exceptions;

public class IncorrectJavaTypeParameter extends RuntimeException {
	private static final long serialVersionUID = 7378817413143781313L;

	public IncorrectJavaTypeParameter(String parameterName, int sizeInBits) {
		super("The parameter " + parameterName + " has is typed to a Java primitive that cannot handle a " + "parameter type it's size (" + sizeInBits + ")");
	}
}
