package org.hbird.transport.payloadcodec;

import org.hbird.transport.payloadcodec.codecparameters.IntegerCodecFactory;
import org.hbird.transport.payloadcodec.codecparameters.LongCodecFactory;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;

public class SpaceSystemModelCodecDecorator {

	public static SpaceSystemModel decorateSpaceSystemModel(final SpaceSystemModel spaceSystemModel) throws UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException, UnknownParameterGroupException {

		SpaceSystemModel newModel = MockSpaceSystemModel.deepClone(spaceSystemModel);

		// Decorate all integer parameters...
		for (Parameter<Integer> parameter : newModel.getIntegerParameters()) {
			parameter = IntegerCodecFactory.decorateParameterWithCodec(parameter);
			newModel.replaceParameterInModel(parameter);
		}

		// Decorate all long parameters...
		for (Parameter<Long> parameter : newModel.getLongParameters()) {
			parameter = LongCodecFactory.decorateParameterWithCodec(parameter);
			newModel.replaceParameterInModel(parameter);
		}

		// TODO BigDecimal, Float, Double, String, Binary




		return newModel;
	}
}
