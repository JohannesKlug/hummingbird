package org.hbird.transport.payloadcodec.codecparameters.number;

import static java.nio.ByteOrder.LITTLE_ENDIAN;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.BitSet;

import org.apache.commons.lang.ArrayUtils;
import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * How do we handle unsigned longs in Java? Long is always signed. Perhaps some math package? Mark: Looks like we must
 * use {@link BigInteger}
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class TwosComplementLongCodecParameter extends CodecParameter<Long> {
	private static final byte ZERO_BYTE = (byte) 0x00;

	private static final long serialVersionUID = -6520952692018179861L;

	/** Logger for this class */
	private static final Logger LOG = LoggerFactory.getLogger(TwosComplementLongCodecParameter.class);

	public TwosComplementLongCodecParameter(final Parameter<Long> hostParameter, final Encoding encoding) {
		super(hostParameter, encoding);
	}

	@Override
	public void decode(final byte[] inBytes, final int offset) {
		// We are going to use Bytebuffer to eventually read out a long value so we need a long sized buffer.

		ByteBuffer fullLengthLongBuf = ByteBuffer.allocate(Long.SIZE);

		// First grab the byte array version of the value.
		ByteBuffer buf = ByteBuffer.wrap(inBytes);
		// Work out how many bytes we need to hold the value first
		int requiredBytes = encoding.getSizeInBits() / Byte.SIZE;
		if (encoding.getSizeInBits() % Byte.SIZE != 0) {
			requiredBytes++;
		}
		// Now create the array and grab the value
		byte[] longBytes = new byte[requiredBytes];
		buf.get(longBytes, offset, requiredBytes);

		// If it's a little endian representation then reverse it so we can work in big-endian (easier for ByteBuffer)
		if (encoding.getByteOrder() == LITTLE_ENDIAN) {
			ArrayUtils.reverse(longBytes);
		}

		// work out if we need to pad and how much.
		int pad = Long.SIZE - encoding.getSizeInBits();

		if (pad > 0) {
			// pad left to 64 i.e. byte 8. We have reversed any little-endian data so we cna pad left.
			for (int i = 0; i < pad / Byte.SIZE; i++) {
				fullLengthLongBuf.put(ZERO_BYTE);
			}
		}
		fullLengthLongBuf.put(longBytes, 0, requiredBytes).flip();

		setValue(fullLengthLongBuf.getLong());
	}

	// FIXME String implementation for decoding is nasty!
	@Override
	public void decode(final BitSet inBitset, final int offset) {
		long parameterValue = 0;

		String binaryString = BitSetUtility.bitSetToBinaryString(inBitset, false);

		binaryString = binaryString.substring(offset, offset + encoding.getSizeInBits());

		// If we are dealing with a negative number...
		if (binaryString.startsWith("1")) {
			// We must prepend a minus sign for the valueOf method used later.
			binaryString = "-" + binaryString;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("BitSet string = " + binaryString);
		}

		parameterValue = Long.valueOf(binaryString, 2);

		this.setValue(parameterValue);
	}

	@Override
	public byte[] encodeToByteArray(final byte[] targetBytes, final int offset) {
		throw new UnsupportedOperationException();
	}

	@Override
	public BitSet encodeToBitSet(final BitSet out, final int offset) {
		final long longValue = getValue();
		final int endLocation = offset + encoding.getSizeInBits() - 1;

		// setting all bits to zero
		out.clear(offset, endLocation);

		// setting up the number in reverse order
		long mask = 1;

		for (int i = 0; i < encoding.getSizeInBits(); i++, mask <<= 1) {
			if ((mask & longValue) > 0) {
				out.set(endLocation - i);
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Calculated Bitset from value " + longValue + " was: " + BitSetUtility.binDump(out));
		}

		return out;
	}

}
