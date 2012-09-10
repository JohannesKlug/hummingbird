package org.hbird.transport.payloadcodec.codecparameters.string;

import java.util.BitSet;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;

import com.google.common.base.Charsets;

public class AsciiStringCodecParameter extends CodecParameter<String> {
	private static final long serialVersionUID = -1408848190073495601L;

	public AsciiStringCodecParameter(final Parameter<String> hostParameter, final Encoding encoding) {
		super(hostParameter, encoding);
	}

	@Override
	public void decode(final byte[] inBytes, final int offset) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException();
	}

	@Override
	public void decode(final BitSet inBitset, final int offset) {
		final BitSet actualParameter = inBitset.get(offset, offset + encoding.getSizeInBits());
		final byte[] actualBytes = BitSetUtility.toByteArray(actualParameter, encoding.getSizeInBits());
		this.setValue(new String(actualBytes, Charsets.US_ASCII));
	}

	@Override
	public Byte[] encodeToByteArray(final Byte[] targetBytes, final int offset) {
		// TODO Auto-generated method stub
		//return null;
		throw new UnsupportedOperationException();
	}

	@Override
	public BitSet encodeToBitSet(final BitSet targetBitSet, final int offset) {
		// TODO Auto-generated method stub
		//return null;
		throw new UnsupportedOperationException();
	}

}
