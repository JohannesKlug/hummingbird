package org.hbird.transport.payloadcodec.codecparameters.string;

import java.util.Arrays;
import java.util.BitSet;

import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class AsciiStringCodecParameter extends CodecParameter<String> {
	private static final long serialVersionUID = -1408848190073495601L;
	private final static Logger LOG = LoggerFactory.getLogger(AsciiStringCodecParameter.class);

	public AsciiStringCodecParameter(final Parameter<String> hostParameter, final Encoding encoding) {
		super(hostParameter, encoding);
	}

	@Override
	public void decode(final byte[] inBytes, final int offset) {
		// TODO from offset to encoding length or simply to end of array?
		final byte[] actualBytes = Arrays.copyOfRange(inBytes, offset, encoding.getSizeInBits() / Byte.SIZE);
		this.setValue(new String(actualBytes, Charsets.US_ASCII));
	}

	@Override
	public void decode(final BitSet inBitset, final int offset) {
		final BitSet actualParameter = inBitset.get(offset, offset + encoding.getSizeInBits());
		final byte[] actualBytes = BitSetUtility.toByteArray(actualParameter, encoding.getSizeInBits());
		this.setValue(new String(actualBytes, Charsets.US_ASCII));
	}

	@Override
	public byte[] encodeToByteArray(final byte[] targetBytes, final int offset) {
		if(LOG.isDebugEnabled()) {
			LOG.debug("Encoding value: " + getValue() + " to byte array at offset " + offset);
		}
		final byte[] bytes = this.getValue().getBytes(Charsets.US_ASCII);
		System.arraycopy(bytes, 0, targetBytes, offset, encoding.getSizeInBits() / Byte.SIZE);
		return targetBytes;
	}

	@Override
	public BitSet encodeToBitSet(final BitSet targetBitSet, final int offset) {
		if(LOG.isDebugEnabled()) {
			LOG.debug("Encoding value: " + getValue() + " to BitSet at offset " + offset);
		}

		final byte[] bytes = this.getValue().getBytes(Charsets.US_ASCII);
		final BitSet srcBitSet = BitSetUtility.fromByteArray(bytes);

		// setting all bits to zero
		targetBitSet.clear(offset, offset + encoding.getSizeInBits() - 1);

		for(int i = 0; i < encoding.getSizeInBits(); i++ ) {
			if(srcBitSet.get(i))  {
				targetBitSet.set(i);
			}
			else {
				targetBitSet.clear(i);
			}
		}

		return targetBitSet;
	}

}
