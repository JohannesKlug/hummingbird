package org.hbird.transport.payloadcodec;

import org.hbird.transport.payloadcodec.codecparameters.IntegerCodecFactory;
import org.hbird.transport.payloadcodec.codecparameters.LongCodecFactory;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterTypeException;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecoratingPayloadCodec implements PayloadCodec {

	private static final Logger LOG = LoggerFactory.getLogger(DecoratingPayloadCodec.class);

	private final SpaceSystemModel spaceSystemModel;

	public DecoratingPayloadCodec(final SpaceSystemModel spaceSystemModel) {
		this.spaceSystemModel = spaceSystemModel;
		try {
			decorateSpaceSystemModel(spaceSystemModel);
		}
		catch (UnsupportedParameterTypeException e) {
			LOG.error("Unsupported Parameter Type in space system model. Cannot create codec");
		}
		catch (UnknownParameterTypeException e) {
			LOG.error("Unknown Parameter Type in space system model. Cannot create codec");
		}
		catch (UnexpectedParameterTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void decorateSpaceSystemModel(final SpaceSystemModel spaceSystemModel) throws UnsupportedParameterTypeException,
			UnknownParameterTypeException, UnexpectedParameterTypeException {

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

	@Override
	public ParameterGroup decode(final Byte[] payload, final Object payloadLayoutId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Byte[] encodeToByteArray(final ParameterGroup parameterGroup) {
		// TODO Auto-generated method stub
		return null;
	}

}
