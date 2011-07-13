package org.hbird.transport.packetbroker;

import java.util.BitSet;

import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Encoding;

public class RecursivePacketCodec implements SpaceSystemModelCodec {

	private final SpaceSystemModel spaceSystemModel;
	private ParameterGroup currentDecode;

	public RecursivePacketCodec(final SpaceSystemModel spaceSystemModel) {
		this.spaceSystemModel = spaceSystemModel;
	}

	@Override
	public ParameterGroup decode(final ParameterGroup parameterGroup, final Byte[] inStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParameterGroup decode(final ParameterGroup parameterGroup, final BitSet inStream) {
		this.currentDecode = null;
		this.recursiveDecode(parameterGroup, inStream, 0);
		return this.currentDecode;
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
		// then decode all the parameters belonging to this group.
		for (Parameter<?> parameter : parameterGroup.getParameters()) {
			offset = decodeParameter(parameter, inStream, offset);
		}

		// For each sub parameter group...
		for (ParameterGroup subParameterGroup : spaceSystemModel.getAllParameterGroups()) {
			// decode the sub-parameter group first..
			offset = recursiveDecode(subParameterGroup, inStream, offset);

		}
		return offset;
	}


	private final int decodeParameter(final Parameter<?> parameter, final BitSet inStream, final int offset) {
		Encoding encoding = parameter.getEncoding();

		return offset;
	}


}
