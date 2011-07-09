package org.hbird.transport.packetbroker;

import java.util.BitSet;

import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;

public class ParallelPacketCodec implements SpaceSystemModelCodec {
	
	SpaceSystemModel spaceSystemModel;
	
	public ParallelPacketCodec(SpaceSystemModel spaceSystemModel) {
		this.spaceSystemModel = spaceSystemModel;
	}

	@Override
	public ParameterGroup decode(Byte[] inStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParameterGroup decode(BitSet inStream) {
		for(ParameterGroup parameterGroup: spaceSystemModel.getAllParameterGroups()) {
			
		}
	}

	@Override
	public Byte[] encodeToByteArray(ParameterGroup parameterGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BitSet encodeToBitSet(ParameterGroup parameterGroup) {
		// TODO Auto-generated method stub
		return null;
	}

}
