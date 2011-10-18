package org.hbird.transport.payloadcodec;

import java.util.BitSet;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.payloadcodec.exceptions.NoEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInModelException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HummingbirdPayloadCodec implements PayloadCodec {

	private static final Logger LOG = LoggerFactory.getLogger(HummingbirdPayloadCodec.class);

	private SpaceSystemModel spaceSystemModel = null;
	private SpaceSystemModel codecAwareSpaceSystemModel = null;
	private final Map<String, Encoding> encodings;

	public HummingbirdPayloadCodec(final SpaceSystemModel spaceSystemModel, final Map<String, Encoding> encodings) {
		this.spaceSystemModel = spaceSystemModel;
		this.encodings = encodings;

		SpaceSystemModelCodecDecorator decorator = new SpaceSystemModelCodecDecorator();
		try {
			this.codecAwareSpaceSystemModel = decorator.decorateSpaceSystemModel(spaceSystemModel, this.encodings);
		}
		catch (UnsupportedParameterEncodingException e) {

		}
		catch (UnknownParameterEncodingException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		catch (UnexpectedParameterTypeException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		catch (UnknownParameterGroupException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		catch (ParameterNotInGroupException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		catch (NoEncodingException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		catch (UnknownParameterException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		catch (ParameterNotInModelException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@Override
	public ParameterGroup decode(final byte[] payload, final Object payloadLayoutId) {
		if (payloadLayoutId == null) {
			// no restrictions, decode all everything!
			int offset = 0;
			int previousSize = 0;
			int count = 0;
			for (ParameterGroup pg : codecAwareSpaceSystemModel.getParameterGroupsCollection()) {
				for (Parameter<?> p : pg.getAllParameters().values()) {
					if (count != 0) {
						offset += previousSize;
					}
					((CodecParameter<?>) p).decode(payload, offset);
					Encoding enc = spaceSystemModel.getEncodings().get(p.getQualifiedName());
					previousSize = enc.getSizeInBits();
					count++;
				}
			}
		}
		// FIXME else only decode only the relevant parametergroups. That is, those restricted by a parameter e.g. APID
		return null;
	}

	@Override
	public ParameterGroup decode(final BitSet payload, final Object payloadLayoutId) {
		if (payloadLayoutId == null) {
			// no restrictions, decode all everything!
			int offset = 0;
			int previousSize = 0;
			int count = 0;
			for (ParameterGroup pg : codecAwareSpaceSystemModel.getParameterGroupsCollection()) {
				for (Parameter<?> p : pg.getAllParameters().values()) {
					if (count != 0) {
						offset += previousSize;
					}
					Encoding enc = spaceSystemModel.getEncodings().get(p.getQualifiedName());
					((CodecParameter<?>) p).decode(payload, offset);
					previousSize = enc.getSizeInBits();
					count++;
				}
				return getUndecoratedVersion(pg);
			}
		}
		// FIXME else only decode only the relevant parametergroups. That is, those restricted by a parameter e.g. APID
		return null;
	}

	private ParameterGroup getUndecoratedVersion(final ParameterGroup pg) {
		// get the name of the pg
		String name = pg.getName();
		// find it in the undecorated version
		ParameterGroup undecoratedGroup = null;
		for (ParameterGroup group : spaceSystemModel.getParameterGroupsCollection()) {
			if (StringUtils.equals(group.getName(), name)) {
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

		String undecoratedGroupName = parameterGroup.getName();
		ParameterGroup decoratedGroup = null;
		// for each parameter group in the decorated codec aware model
		for (ParameterGroup pg : codecAwareSpaceSystemModel.getParameterGroupsCollection()) {
			// if we find the equivalent group we must transfer the set values
			if (StringUtils.equals(pg.getName(), undecoratedGroupName)) {
				decoratedGroup = pg;

				// Integers
				for (Parameter<Integer> undecoratedParameter : parameterGroup.getIntegerParameters().values()) {
					for (Parameter<Integer> decoratedParameter : pg.getIntegerParameters().values()) {
						if (StringUtils.equals(undecoratedParameter.getName(), decoratedParameter.getName())) {
							decoratedParameter.setValue(undecoratedParameter.getValue());
						}
					}
				}
				// Longs
				for (Parameter<Long> undecoratedParameter : parameterGroup.getLongParameters().values()) {
					for (Parameter<Long> decoratedParameter : pg.getLongParameters().values()) {
						if (StringUtils.equals(undecoratedParameter.getName(), decoratedParameter.getName())) {
							decoratedParameter.setValue(undecoratedParameter.getValue());
						}
					}
				}

				// FIXME Support for other types

				// We have transfered the values to the correct group so we can exit the loop
				break;
			}
		}

		// Carry out the encode
		int count = 0;
		int offset = 0;
		int previousSize = 0;
		for (Parameter<?> p : decoratedGroup.getAllParameters().values()) {
			LOG.debug("Encoding parameter " + p.getName());
			if (count != 0) {
				offset += previousSize;
			}
			Encoding enc = spaceSystemModel.getEncodings().get(p.getQualifiedName());
			((CodecParameter<?>) p).encodeToBitSet(encoded, offset);
			previousSize = enc.getSizeInBits();
			count++;
		}

		return encoded;
	}

	private Encoding findEncoding(final String qualifiedName) throws NoEncodingException {
		if (encodings.containsKey(qualifiedName)) {
			return encodings.get(qualifiedName);
		}
		else {
			throw new NoEncodingException(qualifiedName);
		}
	}

}
