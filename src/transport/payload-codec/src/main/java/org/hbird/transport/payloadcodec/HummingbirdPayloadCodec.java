package org.hbird.transport.payloadcodec;

import java.util.BitSet;

import org.apache.commons.lang.StringUtils;
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
	private SpaceSystemModel codecAwareSpaceSystemModel = null;

	public HummingbirdPayloadCodec(final SpaceSystemModel spaceSystemModel) throws UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException, UnknownParameterGroupException, ParameterNotInGroupException {
		this.spaceSystemModel = spaceSystemModel;
		this.codecAwareSpaceSystemModel = SpaceSystemModelCodecDecorator.decorateSpaceSystemModel(spaceSystemModel);
	}

	@Override
	public ParameterGroup decode(final byte[] payload, final Object payloadLayoutId) {
		if(payloadLayoutId == null) {
			// no restrictions, decode all everything!
			int offset = 0;
			int previousSize = 0;
			int count = 0;
			for(ParameterGroup pg : codecAwareSpaceSystemModel.getAllParameterGroups()) {
				for(Parameter<?> p : pg.getAllParameters().values()) {
					if(count != 0) {
						offset += previousSize;
					}
					((CodecParameter<?>)p).decode(payload, offset);
					previousSize = p.getSizeInBits();
					count++;
				}
			}
		}
		// FIXME else only decode only the relevant parametergroups. That is, those restricted by a parameter e.g. APID
		return null;
	}

	@Override
	public ParameterGroup decode(final BitSet payload, final Object payloadLayoutId) throws UnknownParameterGroupException {
		if(payloadLayoutId == null) {
			// no restrictions, decode all everything!
			int offset = 0;
			int previousSize = 0;
			int count = 0;
			for(ParameterGroup pg : codecAwareSpaceSystemModel.getAllParameterGroups()) {
				for(Parameter<?> p : pg.getAllParameters().values()) {
					if(count != 0) {
						offset += previousSize;
					}
					((CodecParameter<?>)p).decode(payload, offset);
					previousSize = p.getSizeInBits();
					count++;
				}
				return getUndecoratedVersion(pg);
			}
		}
		// FIXME else only decode only the relevant parametergroups. That is, those restricted by a parameter e.g. APID
		return null;
	}

	private ParameterGroup getUndecoratedVersion(final ParameterGroup pg) throws UnknownParameterGroupException {
		// get the name of the pg
		String name = pg.getName();
		// find it in the undecorated version
		ParameterGroup undecoratedGroup = null;
		for(ParameterGroup group : spaceSystemModel.getAllParameterGroups()) {
			if(StringUtils.equals(group.getName(), name)) {
				// set the value of the parameters in the undecorated version
				undecoratedGroup = group.copyAllParameterValues(pg);
			}
		}
		// return the undecorated version
		return undecoratedGroup;
	}



	@Override
	public byte[] encodeToByteArray(final ParameterGroup parameterGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BitSet encodeToBitSet(final ParameterGroup parameterGroup) {
		BitSet encoded = new BitSet();
//		ParameterGroupReport groupDetailReport = parameterGroup.getParameterReport();

		String undecoratedGroupName = parameterGroup.getName();
		ParameterGroup decoratedGroup = null;
		for(ParameterGroup pg : codecAwareSpaceSystemModel.getAllParameterGroups()) {
			if(StringUtils.equals(pg.getName(), undecoratedGroupName)) {
				decoratedGroup = pg;
				// Set parameter values in decorated group to the same as those in the parameterGroup

				// Integers First
				for(Parameter<Integer> undecoratedParameter : parameterGroup.getIntegerParameters()) {
					for(Parameter<Integer> decoratedParameter : pg.getIntegerParameters()) {
						if(StringUtils.equals(undecoratedParameter.getName(), decoratedParameter.getName())) {
							decoratedParameter.setValue(undecoratedParameter.getValue());
						}
					}
				}

				// Longs next
				for(Parameter<Long> undecoratedParameter : parameterGroup.getLongParameters()) {
					for(Parameter<Long> decoratedParameter : pg.getLongParameters()) {
						if(StringUtils.equals(undecoratedParameter.getName(), decoratedParameter.getName())) {
							decoratedParameter.setValue(undecoratedParameter.getValue());
						}
					}
				}

				// FIXME Support for other types
				break;
			}
		}

		int count = 0;
		int offset = 0;
		int previousSize = 0;
		for(Parameter<?> p : decoratedGroup.getAllParameters().values()) {
			LOG.debug("Encoding parameter " + p.getName());
			if(count != 0) {
				offset += previousSize;
			}
			((CodecParameter<?>)p).encodeToBitSet(encoded, offset);
			previousSize = p.getSizeInBits();
			count++;
		}

		return encoded;
	}

}
