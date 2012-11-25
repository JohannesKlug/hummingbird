package org.hbird.transport.payloadcodec.codecdecorators.string;

import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.transport.payloadcodec.codecparameters.string.AsciiStringCodecParameter;
import org.hbird.transport.payloadcodec.codecparameters.string.Uft8StringCodecParameter;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;

/**
 * 
 * @author Mark Doyle
 * 
 */
public class StringCodecFactory {

	public static Parameter<String> decorateParameterWithCodec(final Parameter<String> parameter, final Encoding enc) throws UnknownParameterEncodingException,
			UnsupportedParameterEncodingException {
		switch (enc.getBinaryRepresentation()) {
			case ASCII:
				return new AsciiStringCodecParameter(parameter, enc);
			case UTF8:
				return new Uft8StringCodecParameter(parameter, enc);
			case UTF16:
				throw new UnsupportedParameterEncodingException("Not implemented codec yet, file a bug report :D", enc.getBinaryRepresentation());
			default:
				throw new UnknownParameterEncodingException("Unknown/Unsupported binary representation for String: ", enc.getBinaryRepresentation());

		}
	}
}
