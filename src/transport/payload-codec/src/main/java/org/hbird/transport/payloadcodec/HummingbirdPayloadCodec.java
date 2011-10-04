package org.hbird.transport.payloadcodec;

import java.util.BitSet;
import java.util.Collection;

import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HummingbirdPayloadCodec implements PayloadCodec {

	private static final Logger LOG = LoggerFactory.getLogger(HummingbirdPayloadCodec.class);

	private SpaceSystemModel spaceSystemModel = null;

	public HummingbirdPayloadCodec(final SpaceSystemModel spaceSystemModel) throws UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException, UnknownParameterGroupException, ParameterNotInGroupException {
		this.spaceSystemModel = SpaceSystemModelCodecDecorator.decorateSpaceSystemModel(spaceSystemModel);
	}

	@Override
	public ParameterGroup decode(final byte[] payload, final Object payloadLayoutId) {
		if(payloadLayoutId == null) {
			// no restrictions, decode all everything!
			int offset = 0;
			int previousSize = 0;
			int count = 0;
			for(ParameterGroup pg : spaceSystemModel.getAllParameterGroups()) {
				for(Parameter<?> p : pg.getAllParameters().values()) {
					if(count != 0) {
						offset += previousSize;
					}
					System.out.println(p.getName() + " : " + p.getValue());
					((CodecParameter<?>)p).decode(payload, offset);
					previousSize = p.getSizeInBits();
					count++;
				}
			}
		}
		else {
			// decode only the relevant parametergroups
		}
		return null;
	}

	@Override
	public ParameterGroup decode(final BitSet payload, final Object payloadLayoutId) {
		if(payloadLayoutId == null) {
			// no restrictions, decode all everything!
			int offset = 0;
			int previousSize = 0;
			int count = 0;
			for(ParameterGroup pg : spaceSystemModel.getAllParameterGroups()) {
				for(Parameter<?> p : pg.getAllParameters().values()) {
					if(count != 0) {
						offset += previousSize;
					}
					System.out.println(p.getName() + " : " + p.getValue());
					((CodecParameter<?>)p).decode(payload, offset);
					previousSize = p.getSizeInBits();
					count++;
				}
				return pg; //FIXME dirty hack. Warum dreckig?
			}
		}
		else {
			// decode only the relevant parametergroups
		}
		return null;
	}

	@Override
	public Byte[] encodeToByteArray(final ParameterGroup parameterGroup) {
		BitSet encoded = new BitSet();
//		ParameterGroupReport groupDetailReport = parameterGroup.getParameterReport();

		Collection<Parameter<?>> parameters = parameterGroup.getAllParameters().values();
		int count = 0;
		int offset = 0;
		int previousSize = 0;
		for(Parameter<?> p : parameters) {
			if(count != 0) {
				offset += previousSize;
			}
			((CodecParameter<?>)p).encodeToBitSet(encoded, offset);
			previousSize = p.getSizeInBits();
			count++;
		}
		return null;
	}

}
