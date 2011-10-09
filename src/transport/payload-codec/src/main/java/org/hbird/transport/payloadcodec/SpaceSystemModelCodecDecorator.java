package org.hbird.transport.payloadcodec;

import java.util.Map;

import org.hbird.transport.payloadcodec.codecparameters.IntegerCodecFactory;
import org.hbird.transport.payloadcodec.codecparameters.LongCodecFactory;
import org.hbird.transport.payloadcodec.exceptions.NoEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;

public final class SpaceSystemModelCodecDecorator {

	private Map<String, Encoding> encodings;

	public SpaceSystemModelCodecDecorator() {
	}


	public SpaceSystemModel decorateSpaceSystemModel(final SpaceSystemModel spaceSystemModel, final Map<String, Encoding> encodings) throws UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException, UnknownParameterGroupException, ParameterNotInGroupException, NoEncodingException, UnknownParameterException {
		this.encodings = encodings;

//		SpaceSystemModel newModel = spaceSystemModel.deepClone(spaceSystemModel);
		// deep clone not required? We can simply replace the parameters in the copy, i.e., change the pointers.
		SpaceSystemModel newModel = spaceSystemModel;

		// Decorate all integer parameters...
		for (Parameter<Integer> parameter : newModel.getAllIntegerParameters().values()) {
			Encoding enc = findEncoding(parameter.getQualifiedName());
			parameter = IntegerCodecFactory.decorateParameterWithCodec(parameter, enc);
			newModel.replaceParameterInModel(parameter.getQualifiedName(), parameter);
		}

		// Decorate all long parameters...
		for (Parameter<Long> parameter : newModel.getAllLongParameters().values()) {
			Encoding enc = findEncoding(parameter.getQualifiedName());
			parameter = LongCodecFactory.decorateParameterWithCodec(parameter, enc);
			newModel.replaceParameterInModel(parameter.getQualifiedName(), parameter);
		}

		// FIXME BigDecimal, Float, Double, String, Binary



		// Decorate all parameter group parameters.
		//FIXME Find a way to link the parameters and parameter group parameters in the space system model layer. Done?
//		for(ParameterGroup pg : newModel.getParameterGroupsCollection()) {
//			// Decorate all integer parameters...
//			for (Parameter<Integer> parameter : pg.getIntegerParameters()) {
//				parameter = IntegerCodecFactory.decorateParameterWithCodec(parameter);
//				pg.replaceParameterInGroup(parameter);
//			}
//
//			// Decorate all long parameters...
//			for (Parameter<Long> parameter : pg.getLongParameters()) {
//				parameter = LongCodecFactory.decorateParameterWithCodec(parameter);
//				pg.replaceParameterInGroup(parameter);
//			}
//		}

		return newModel;
	}

	private  Encoding findEncoding(final String qualifiedName) throws NoEncodingException {
		if(encodings.containsKey(qualifiedName)) {
			return encodings.get(qualifiedName);
		}
		else {
			throw new NoEncodingException(qualifiedName);
		}
	}
}
