package org.hbird.transport.payloadcodec.codecdecorators.number;

import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.transport.payloadcodec.codecparameters.number.Double64ParameterCodec;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;

public class DoubleCodecFactory {

	private DoubleCodecFactory() {
		// Utility class
	}

	public static Parameter<Double> decorateParameterWithCodec(Parameter<Double> hostParameter, Encoding enc) throws UnsupportedParameterEncodingException,
			UnknownParameterEncodingException, UnexpectedParameterTypeException {
		switch (enc.getBinaryRepresentation()) {
			case IEEE754_1985:
				if (enc.getSizeInBits() == Double.SIZE) {
					return new Double64ParameterCodec(hostParameter, enc);
				}
				throw new UnexpectedParameterTypeException("Expected double to be size " + Double.SIZE + " but it was " + enc.getSizeInBits());
			case MILSTD_1750A:
				throw new UnsupportedParameterEncodingException("File a bug report :D");
			default:
				throw new UnknownParameterEncodingException("Unknown binary representation", enc.getBinaryRepresentation());
		}
	}

}
