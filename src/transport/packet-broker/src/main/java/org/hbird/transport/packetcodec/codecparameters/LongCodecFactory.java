package org.hbird.transport.packetcodec.codecparameters;

import org.hbird.transport.packetcodec.codecparameters.number.TwosComplementLongCodecParameter;
import org.hbird.transport.packetcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.packetcodec.exceptions.UnknownParameterTypeException;
import org.hbird.transport.packetcodec.exceptions.UnsupportedParameterTypeException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Encoding;

public class LongCodecFactory {
	/**
	 * TODO update this doc
	 */
	public static CodecParameter<Long> decorateParameterWithCodec(final Parameter<Long> parameter)
			throws UnsupportedParameterTypeException, UnknownParameterTypeException, UnexpectedParameterTypeException {

		Encoding encoding = parameter.getEncoding();
		int sizeInBits = parameter.getSizeInBits();

		switch (encoding) {
			case onesComplement:
				throw new UnsupportedParameterTypeException("File a bug report :D");
			case twosComplement:
				if (sizeInBits > 64) {
					throw new UnexpectedParameterTypeException(
							"Size of this parameter is > 32 which is too big to be a signed long. Size = " + sizeInBits);
				}
				else {
					return new TwosComplementLongCodecParameter(parameter);
				}
			case unsigned:
				if (sizeInBits > 64) {
					throw new UnexpectedParameterTypeException(
							"Size of this parameter is > 64 which is too big to be an unsigned integer. Size = "
									+ sizeInBits);
				}
				else {
					throw new UnsupportedParameterTypeException("File a bug report :D");
				}
			case signMagnitude:
				throw new UnsupportedParameterTypeException("File a bug report :D");
			default:
				throw new UnknownParameterTypeException();
		}

	}
}
