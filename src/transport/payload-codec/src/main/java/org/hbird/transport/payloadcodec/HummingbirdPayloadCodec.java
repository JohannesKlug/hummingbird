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

	public HummingbirdPayloadCodec(final SpaceSystemModel spaceSystemModel) {
		try {
			this.spaceSystemModel = SpaceSystemModelCodecDecorator.decorateSpaceSystemModel(spaceSystemModel);
		}
		catch (UnsupportedParameterEncodingException e) {
			LOG.error("UnsupportedParameterEncodingException in space system model");
			LOG.equals(e.getMessage());
			e.printStackTrace();
		}
		catch (UnknownParameterEncodingException e) {
			LOG.error("UnknownParameterEncodingException in space system model");
			LOG.error(e.getMessage());
		}
		catch (UnexpectedParameterTypeException e) {
			LOG.error("UnexpectedParameterTypeException in space system model");
			LOG.error(e.getMessage());
		}
		catch (UnknownParameterGroupException e) {
			LOG.error("UnknownParameterGroupException in space system model");
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		catch (ParameterNotInGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ParameterGroup decode(final byte[] payload, final Object payloadLayoutId) {
		if(payloadLayoutId == null) {
			// no restrictions, decode all everything!
			int offset = 0;
			int previousSize = 0;
			int count = 0;
			for(ParameterGroup pg : spaceSystemModel.getAllParameterGroups()) {
				for(Parameter<?> p : pg.getAllParameters()) {
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
				for(Parameter<?> p : pg.getAllParameters()) {
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
	public Byte[] encodeToByteArray(final ParameterGroup parameterGroup) {
		BitSet encoded = new BitSet();
//		ParameterGroupReport groupDetailReport = parameterGroup.getParameterReport();

		Collection<Parameter<?>> parameters = parameterGroup.getAllParameters();
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
