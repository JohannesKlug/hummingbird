package org.hbird.transport.payloadcodec.codecparameters.number;

import java.math.BigInteger;
import java.util.BitSet;

import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
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
	private static final long serialVersionUID = -6520952692018179861L;
	/** Logger for this class */
	private static final Logger LOG = LoggerFactory.getLogger(TwosComplementLongCodecParameter.class);


	public TwosComplementLongCodecParameter(final Parameter<Long> hostParameter, final Encoding encoding) {
		super(hostParameter, encoding);
	}


	@Override
	public void decode(final byte[] inBytes, final int offset) {
		throw new UnsupportedOperationException();
	}


	// FIXME String implementation for decoding is nasty!
	@Override
	public void decode(final BitSet inBitset,  final int offset) {
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
	public Byte[] encodeToByteArray(final Byte[] targetBytes, final int offset) {
		throw new UnsupportedOperationException();
	}

	@Override
	public BitSet encodeToBitSet(final BitSet out, final int offset) {
		long longValue = getValue();
		int endLocation = offset + encoding.getSizeInBits() - 1;

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
