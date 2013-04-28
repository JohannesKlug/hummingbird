package org.hbird.transport.payloadcodec.codecdecorators.number;

import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.payloadcodec.codecparameters.number.TwosComplementIntegerCodecParameter;
import org.hbird.transport.payloadcodec.codecparameters.number.UnsignedIntegerCodecParameter;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;

public final class IntegerCodecFactory {

	private IntegerCodecFactory() {
		// Utility class
	}

	/**
	 * TODO update this doc
	 * 
	 * For example, the values for unsigned, signMagnitude, twosComplement, and onesComplement are all stored in the
	 * Java Integer type. The codec deals with calculating the correct parameter value as an Integer from the binary
	 * input
	 * and also calculating the binary output version of the java Integer value. Obviously, for twos complement we can
	 * simply use the toByteArray methods provided with the Java libs since Java Integers are stored as big endian twos
	 * complement.
	 * FIXME This is "javadocing" (too briefly) the entire process, not what this class does.
	 * 
	 * @author Mark Doyle
	 * @throws UnknownParameterEncodingException
	 * @throws UnexpectedParameterTypeException
	 * @throws InvalidParameterTypeException
	 * 
	 */
	public static CodecParameter<Integer> decorateParameterWithCodec(final Parameter<Integer> parameter, final Encoding enc)
			throws UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException {

		switch (enc.getBinaryRepresentation()) {
			case onesComplement:
				throw new UnsupportedParameterEncodingException("File a bug report :D");
			case twosComplement:
				if (enc.getSizeInBits() > Integer.SIZE) {
					throw new UnexpectedParameterTypeException("Size of this parameter is > " + Integer.SIZE + " which is too big to be an integer. Size = "
							+ enc.getSizeInBits());
				}
				return new TwosComplementIntegerCodecParameter(parameter, enc);
			case unsigned:
				if (enc.getSizeInBits() > Integer.SIZE) {
					throw new UnexpectedParameterTypeException("Size of this parameter is > " + Integer.SIZE + " 32 which is too big to be an integer. Size = "
							+ enc.getSizeInBits());
				}
				return new UnsignedIntegerCodecParameter(parameter, enc);
			case signMagnitude:
				throw new UnsupportedParameterEncodingException("File a bug report :D", enc.getBinaryRepresentation());
			default:
				throw new UnknownParameterEncodingException("Unknown binary representation", enc.getBinaryRepresentation());
		}

	}

}
