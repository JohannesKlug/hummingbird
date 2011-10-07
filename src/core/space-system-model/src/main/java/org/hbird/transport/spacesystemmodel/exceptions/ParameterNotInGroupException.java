package org.hbird.transport.spacesystemmodel.exceptions;

import org.hbird.transport.spacesystemmodel.parameters.Parameter;

public class ParameterNotInGroupException extends Exception {
	private static final long serialVersionUID = -8596416130459378174L;

	private Parameter<?> p;

	public ParameterNotInGroupException(final Parameter<?> p) {
		super();
		this.p = p;
	}

	public ParameterNotInGroupException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParameterNotInGroupException(final String message, final Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ParameterNotInGroupException(final String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ParameterNotInGroupException(final Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public Parameter<?> getParameter() {
		return p;
	}

}
