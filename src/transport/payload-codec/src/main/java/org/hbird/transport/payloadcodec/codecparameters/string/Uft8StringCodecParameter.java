/**
 * 
 */
package org.hbird.transport.payloadcodec.codecparameters.string;

import java.util.BitSet;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

/**
 * @author Mark Doyle
 * 
 */
public class Uft8StringCodecParameter extends CodecParameter<String> {
	private static final long serialVersionUID = -2533245564627019039L;
	private final static Logger LOG = LoggerFactory.getLogger(Uft8StringCodecParameter.class);

	public Uft8StringCodecParameter(final Parameter<String> hostParameter, final Encoding encoding) {
		super(hostParameter, encoding);
	}

	@Override
	public void decode(final byte[] inBytes, final int offset) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void decode(final BitSet inBitset, final int offset) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public byte[] encodeToByteArray(final byte[] targetBytes, final int offset) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Encoding value: " + getValue() + " to byte array at offset " + offset);
		}
		final byte[] bytes = this.getValue().getBytes(Charsets.UTF_8);
		System.arraycopy(bytes, 0, targetBytes, offset, encoding.getSizeInBits() / Byte.SIZE);
		return targetBytes;
	}

	@Override
	public BitSet encodeToBitSet(final BitSet targetBitSet, final int offset) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
