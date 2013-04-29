package org.hbird.transport.payloadcodec.codecparameters.number;

import java.nio.ByteBuffer;
import java.util.BitSet;

import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parameter behaviour for an IEEE 754 32-bit precision Float.
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class Float32ParameterCodec extends CodecParameter<Float> {
	private static final long serialVersionUID = -8334901457487780586L;

	private static final Logger LOG = LoggerFactory.getLogger(Float32ParameterCodec.class);

	public Float32ParameterCodec(final Parameter<Float> hostParameter, final Encoding encoding) {
		super(hostParameter, encoding);
	}

	@Override
	public void decode(final BitSet inBitset, final int offset) {
		BitSet value = inBitset.get(offset, offset + encoding.getSizeInBits() + 1);
		decode(BitSetUtility.toByteArray(value, encoding.getSizeInBits()), 0);
	}

	@Override
	public void decode(final byte[] inBytes, final int offset) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Decoding parameter " + getQualifiedName() + " offset: " + offset / Byte.SIZE);
		}
		ByteBuffer buf = ByteBuffer.wrap(inBytes);
		float value = buf.getFloat(offset / Byte.SIZE);
		setValue(value);
	}

	@Override
	public byte[] encodeToByteArray(final byte[] targetBytes, final int offset) {
		throw new UnsupportedOperationException("Not implemented yet, file an issue :)");
	}

	@Override
	public BitSet encodeToBitSet(final BitSet out, final int offset) {
		throw new UnsupportedOperationException("Not implemented yet, file an issue :)");
	}
}
