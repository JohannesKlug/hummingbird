package org.hbird.transport.payloadcodec;

import org.hbird.transport.payloadcodec.codecparameters.IntegerCodecFactory;
import org.hbird.transport.payloadcodec.codecparameters.LongCodecFactory;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;

public class SpaceSystemModelCodecDecorator {

	private SpaceSystemModelCodecDecorator() {
		// No need for public constructor.
	}

	public static SpaceSystemModel decorateSpaceSystemModel(final SpaceSystemModel spaceSystemModel) throws UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException, UnknownParameterGroupException, ParameterNotInGroupException {

		SpaceSystemModel newModel = spaceSystemModel.deepClone(spaceSystemModel);

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



		// Decorate all parameter group parameters.
		//FIXME Find a way to link the parameters and parameter group parameters in the space system model layer.
		for(ParameterGroup pg : newModel.getAllParameterGroups()) {
			// Decorate all integer parameters...
			for (Parameter<Integer> parameter : pg.getIntegerParameters()) {
				parameter = IntegerCodecFactory.decorateParameterWithCodec(parameter);
				pg.replaceParameterInGroup(parameter);
				System.out.println();
			}

			// Decorate all long parameters...
			for (Parameter<Long> parameter : pg.getLongParameters()) {
				parameter = LongCodecFactory.decorateParameterWithCodec(parameter);
				pg.replaceParameterInGroup(parameter);
			}
		}

		return newModel;
	}
}
