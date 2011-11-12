package org.hbird.transport.payloadcodec;

import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.hbird.transport.commons.data.GenericPayload;
import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.BytesUtility;
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

public class InMemoryPayloadCodec implements PayloadCodec {

	private static final Logger LOG = LoggerFactory.getLogger(InMemoryPayloadCodec.class);

	private SpaceSystemModel spaceSystemModel = null;
	private SpaceSystemModel codecAwareSpaceSystemModel = null;
	private final Map<String, Encoding> encodings;
	private final Map<String, List<String>> restrictions;

	// FIXME change to accept list of parameter groups instead of entire space szstem model.
	public InMemoryPayloadCodec(final SpaceSystemModel spaceSystemModel, final Map<String, Encoding> encodings) {
		this.spaceSystemModel = spaceSystemModel;
		this.encodings = encodings;
		this.restrictions = spaceSystemModel.getAllPayloadRestrictions();

		SpaceSystemModelCodecDecorator decorator = new SpaceSystemModelCodecDecorator();
		try {
			this.codecAwareSpaceSystemModel = decorator.decorateSpaceSystemModel(spaceSystemModel, this.encodings);
		}
		catch (UnsupportedParameterEncodingException e) {
			LOG.error(e.toString());
			System.exit(-1);
		}
		catch (UnknownParameterEncodingException e) {
			LOG.error(e.toString());
			System.exit(-1);
		}
		catch (UnexpectedParameterTypeException e) {
			LOG.error(e.toString());
			System.exit(-1);
		}
		catch (UnknownParameterGroupException e) {
			LOG.error(e.toString());
			System.exit(-1);
		}
		catch (ParameterNotInGroupException e) {
			LOG.error(e.toString());
			System.exit(-1);
		}
		catch (NoEncodingException e) {
			LOG.error(e.toString());
			System.exit(-1);
		}
		catch (UnknownParameterException e) {
			LOG.error(e.toString());
			System.exit(-1);
		}
		catch (ParameterNotInModelException e) {
			LOG.error(e.toString());
			System.exit(-1);
		}
	}

	@Override
	public ParameterGroup decode(final byte[] payload, final String payloadLayoutId, long timeStamp) throws UnknownParameterGroupException {
		return decode(BitSetUtility.fromByteArray(payload), payloadLayoutId, timeStamp);
	}

	@Override
	public ParameterGroup decode(final BitSet payload, final String payloadLayoutId, long timeStamp) throws UnknownParameterGroupException {
		ParameterGroup decodedGroup = null;
		if (payloadLayoutId == null) {
			// no restrictions, decode all everything!
			for (ParameterGroup pg : codecAwareSpaceSystemModel.getParameterGroupsCollection()) {
				decodedGroup = decodeParameterGroup(payload, pg);
			}
		}
		else {
			for (Entry<String, List<String>> restrictionEntry : codecAwareSpaceSystemModel.getAllPayloadRestrictions().entrySet()) {
				if (restrictionEntry.getValue().contains(payloadLayoutId)) {
					// we found the correct PG
					String pgName = restrictionEntry.getKey();
					ParameterGroup pg = codecAwareSpaceSystemModel.getParameterGroup(pgName);
					decodedGroup = decodeParameterGroup(payload, pg);
				}
			}
		}
		decodedGroup.setTimeStamp(timeStamp);
		return decodedGroup;
	}

	private ParameterGroup decodeParameterGroup(final BitSet payload, final ParameterGroup pg) {
		int offset = 0;
		int previousSize = 0;
		int count = 0;
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
	public GenericPayload encodeToGenericPayload(final ParameterGroup parameterGroup) {
		BitSet encoded = new BitSet();

		String undecoratedGroupName = parameterGroup.getName();
		ParameterGroup decoratedGroup = null;
		// for each parameter group in the decorated codec aware model
		for (ParameterGroup pg : codecAwareSpaceSystemModel.getParameterGroupsCollection()) {
			// if we find the equivalent group we must transfer the set values
			if (StringUtils.equals(pg.getName(), undecoratedGroupName)) {
				decoratedGroup = pg;

				// Integers
				Map<String, Parameter<Integer>> integerParameters = parameterGroup.getIntegerParameters();
				if (integerParameters != null) {
					for (Parameter<Integer> undecoratedParameter : integerParameters.values()) {
						for (Parameter<Integer> decoratedParameter : pg.getIntegerParameters().values()) {
							if (StringUtils.equals(undecoratedParameter.getName(), decoratedParameter.getName())) {
								decoratedParameter.setValue(undecoratedParameter.getValue());
							}
						}
					}
				}

				// Longs
				Map<String, Parameter<Long>> longParameters = parameterGroup.getLongParameters();
				if (longParameters != null) {
					for (Parameter<Long> undecoratedParameter : longParameters.values()) {
						for (Parameter<Long> decoratedParameter : pg.getLongParameters().values()) {
							if (StringUtils.equals(undecoratedParameter.getName(), decoratedParameter.getName())) {
								decoratedParameter.setValue(undecoratedParameter.getValue());
							}
						}
					}
				}

				// FIXME Support for other types

				// We have transfered the values to the correct group so we can
				// exit the loop
				break;
			}
		}

		// Carry out the encode
		int count = 0;
		int offset = 0;
		int previousSize = 0;
		int totalSize = 0;
		for (Parameter<?> p : decoratedGroup.getAllParameters().values()) {
			LOG.debug("Encoding parameter " + p.getName());
			if (count != 0) {
				offset += previousSize;
			}
			Encoding enc = spaceSystemModel.getEncodings().get(p.getQualifiedName());
			((CodecParameter<?>) p).encodeToBitSet(encoded, offset);
			previousSize = enc.getSizeInBits();
			totalSize += enc.getSizeInBits();
			count++;
		}

		byte[] encodedBytes = BitSetUtility.toByteArray(encoded, totalSize);
		List<String> layoutIdList = restrictions.get(parameterGroup.getQualifiedName());
		String layoutId = "";
		if (layoutIdList != null) {
			layoutId = layoutIdList.get(0);
		}
		if (encodedBytes == null) {
			LOG.error("byte array is null!");
		}

		// GenericPayload encodedGroup = new GenericPayload(encodedBytes, layoutId); // FIXME this is crap, says Mark.
		GenericPayload encodedGroup = new GenericPayload(encodedBytes, layoutId, System.currentTimeMillis()); // FIXME this is crap, says Mark. JK 2011-11-12: added timeStamp. Can't remember why this is crap?
		return encodedGroup;
	}

	private Encoding findEncoding(final String qualifiedName) throws NoEncodingException {
		if (encodings.containsKey(qualifiedName)) {
			return encodings.get(qualifiedName);
		}
		else {
			throw new NoEncodingException(qualifiedName);
		}
	}

	@Override
	public ParameterGroup decode(final GenericPayload payload) throws UnknownParameterGroupException {
		LOG.debug("Decoding: " + BytesUtility.decimalDump(payload.payload) + " with payload ID " + payload.layoutIdentifier);
		return decode(payload.payload, payload.layoutIdentifier, payload.timeStamp);
	}

}
