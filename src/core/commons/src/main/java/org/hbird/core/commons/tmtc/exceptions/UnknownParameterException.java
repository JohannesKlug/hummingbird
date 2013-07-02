package org.hbird.core.commons.tmtc.exceptions;

public class UnknownParameterException extends Exception {
	private static final long serialVersionUID = -4995261690395548584L;

	private String nameOfRequestedParameter;

	public UnknownParameterException(final String msg) {
		super(msg);
	}

	public UnknownParameterException(final String msg, String nameOfRequestedParameter) {
		super(msg);
		this.nameOfRequestedParameter = nameOfRequestedParameter;
	}

	public final String getNameOfRequestedParameter() {
		return nameOfRequestedParameter;
	}

}
