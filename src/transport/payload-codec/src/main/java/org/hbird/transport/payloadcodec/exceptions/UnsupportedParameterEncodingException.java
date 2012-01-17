package org.hbird.transport.payloadcodec.exceptions;

import org.hbird.core.spacesystemmodel.encoding.Encoding.BinaryRepresentation;

public class UnsupportedParameterEncodingException extends Exception {
	private static final long serialVersionUID = 5931397913867898970L;

	public UnsupportedParameterEncodingException(final String msg) {
		super(msg);
	}

	public UnsupportedParameterEncodingException(final String msg, final BinaryRepresentation encoding) {
		super(msg + " [ENCODING = " + encoding + "]");
	}
}
