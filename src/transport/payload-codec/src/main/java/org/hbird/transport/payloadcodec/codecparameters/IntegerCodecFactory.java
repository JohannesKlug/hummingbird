package org.hbird.transport.payloadcodec.codecparameters;

import org.hbird.transport.payloadcodec.codecparameters.number.TwosComplementIntegerCodecParameter;
import org.hbird.transport.payloadcodec.codecparameters.number.UnsignedIntegerCodecParameter;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterTypeException;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Encoding;

public class IntegerCodecFactory {
	/**
	 * TODO update this doc
	 * 
	 * For example, the values for unsigned, signMagnitude, twosComplement, and onesComplement are all stored in the
	 * Java Integer type. The codec deals with calculating the correct parameter value as Integer from the binary input
	 * and also calculating the binary output version of the java Integer value. Obviously, for twos complement we can
	 * simply use the toByteArray methods provided with the Java libs since Java Integers are stored as big endian twos
	 * complement.
	 * 
	 * @author Mark Doyle
	 * @throws UnknownParameterTypeException
	 * @throws UnexpectedParameterTypeException
	 * @throws InvalidParameterTypeException
	 * 
	 */
	public static CodecParameter<Integer> decorateParameterWithCodec(final Parameter<Integer> parameter)
			throws UnsupportedParameterTypeException, UnknownParameterTypeException, UnexpectedParameterTypeException {

		Encoding encoding = parameter.getEncoding();
		int sizeInBits = parameter.getSizeInBits();

		switch (encoding) {
			case onesComplement:
				throw new UnsupportedParameterTypeException("File a bug report :D");
			case twosComplement:
				if (sizeInBits > 32) {
					throw new UnexpectedParameterTypeException(
							"Size of this parameter is > 32 which is too big to be an integer. Size = " + sizeInBits);
				}
				else {
					return new TwosComplementIntegerCodecParameter(parameter);
				}
			case unsigned:
				if (sizeInBits > 32) {
					throw new UnexpectedParameterTypeException(
							"Size of this parameter is > 32 which is too big to be an integer. Size = " + sizeInBits);
				}
				else {
					// Cast can only be correct at this point but this does not smell good.
					return new UnsignedIntegerCodecParameter(parameter);
				}
			case signMagnitude:
				throw new UnsupportedParameterTypeException("File a bug report :D");
			default:
				throw new UnknownParameterTypeException();
		}

	}
}
