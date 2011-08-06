package org.hbird.transport.packetcodec;

import java.util.BitSet;

import org.hbird.transport.packetcodec.codecparameters.CodecParameter;
import org.hbird.transport.packetcodec.codecparameters.IntegerCodecFactory;
import org.hbird.transport.packetcodec.codecparameters.LongCodecFactory;
import org.hbird.transport.packetcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.packetcodec.exceptions.UnknownParameterTypeException;
import org.hbird.transport.packetcodec.exceptions.UnsupportedParameterTypeException;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecursivePacketCodec implements SpaceSystemModelCodec {
	private static final Logger LOG = LoggerFactory.getLogger(RecursivePacketCodec.class);

	private final SpaceSystemModel spaceSystemModel;


	public RecursivePacketCodec(final SpaceSystemModel spaceSystemModel) {
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
	public ParameterGroup decode(final ParameterGroup parameterGroup, final Byte[] inStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParameterGroup decode(final ParameterGroup parameterGroup, final BitSet inStream) {
		recursiveDecode(parameterGroup, inStream, 0);
		return parameterGroup;
	}

	@Override
	public Byte[] encodeToByteArray(final ParameterGroup parameterGroup) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public BitSet encodeToBitSet(final ParameterGroup parameterGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	private final int recursiveDecode(final ParameterGroup parameterGroup, final BitSet inStream, int offset) {
		// Decode all the parameters belonging to this group.
		for (Parameter<?> parameter : parameterGroup.getParameters()) {
			offset = decodeParameter((CodecParameter<?>) parameter, inStream, offset);
		}

		// Then for each sub parameter group...
		for (ParameterGroup subParameterGroup : spaceSystemModel.getAllParameterGroups()) {
			// decode the sub-parameter group..
			offset = recursiveDecode(subParameterGroup, inStream, offset);
		}

		return offset;
	}


	private final int decodeParameter(final CodecParameter<?> parameter, final BitSet inStream, final int offset) {
		parameter.decode(inStream);
		return offset;
	}


}
