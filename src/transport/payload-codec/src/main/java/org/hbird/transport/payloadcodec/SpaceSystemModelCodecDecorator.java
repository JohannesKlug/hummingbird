package org.hbird.transport.payloadcodec;

import org.hbird.transport.payloadcodec.codecparameters.IntegerCodecFactory;
import org.hbird.transport.payloadcodec.codecparameters.LongCodecFactory;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;

public class SpaceSystemModelCodecDecorator {

	public static void decorateSpaceSystemModel(final SpaceSystemModel spaceSystemModel) throws UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException {

		// Decorate all integer parameters...
		for (Parameter<Integer> parameter : spaceSystemModel.getIntegerParameters()) {
			parameter = IntegerCodecFactory.decorateParameterWithCodec(parameter);
		}

		// Decorate all long parameters...
		for (Parameter<Long> parameter : spaceSystemModel.getLongParameters()) {
			parameter = LongCodecFactory.decorateParameterWithCodec(parameter);
		}

		// TODO BigDecimal, Float, Double, String, Binary
	}
}
