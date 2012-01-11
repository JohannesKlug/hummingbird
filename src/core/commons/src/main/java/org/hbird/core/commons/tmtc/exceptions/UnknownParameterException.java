package org.hbird.core.commons.tmtc.exceptions;

public class UnknownParameterException extends Exception {
	private static final long serialVersionUID = -4995261690395548584L;

	public UnknownParameterException(final String msg) {
		super(msg);
	}

	public UnknownParameterException(final long id) {
		super("Parameter ID requested = " + id);
	}

}
