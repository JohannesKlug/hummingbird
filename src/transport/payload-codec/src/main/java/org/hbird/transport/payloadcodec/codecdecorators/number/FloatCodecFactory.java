package org.hbird.transport.payloadcodec.codecdecorators.number;

import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.transport.payloadcodec.codecparameters.number.Float32ParameterCodec;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;

public class FloatCodecFactory {

	private FloatCodecFactory() {
		// Utility class
	}

	public static Parameter<Float> decorateParameterWithCodec(Parameter<Float> hostParameter, Encoding enc) throws UnsupportedParameterEncodingException,
			UnknownParameterEncodingException, UnexpectedParameterTypeException {
		switch (enc.getBinaryRepresentation()) {
			case IEEE754_1985:
				if (enc.getSizeInBits() == Float.SIZE) {
					return new Float32ParameterCodec(hostParameter, enc);
				}
				throw new UnexpectedParameterTypeException("Expected float to be size " + Float.SIZE + " but it was " + enc.getSizeInBits());
			case MILSTD_1750A:
				throw new UnsupportedParameterEncodingException("File a bug report :D");
			default:
				throw new UnknownParameterEncodingException("Unknown binary representation", enc.getBinaryRepresentation());
		}
	}

}
