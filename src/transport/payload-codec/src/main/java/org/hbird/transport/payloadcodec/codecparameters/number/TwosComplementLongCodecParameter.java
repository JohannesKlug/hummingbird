package org.hbird.transport.payloadcodec.codecparameters.number;

import java.math.BigInteger;
import java.util.BitSet;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
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
	/** Logger for this class */
	private final static Logger LOG = LoggerFactory.getLogger(TwosComplementLongCodecParameter.class);


	public TwosComplementLongCodecParameter(final Parameter<Long> hostParameter) {
		super(hostParameter);
	}


	@Override
	public void decode(Byte[] inBytes) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException();
	}

	// FIXME String implementation for decoding is nasty!
	@Override
	public void decode(final BitSet inBitset) {
		long parameterValue = 0;

		String binaryString = BitSetUtility.bitSetToBinaryString(inBitset, false);

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
	public Byte[] encodeToByteArray(final Long value) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BitSet encodeToBitSet(BitSet out, int offset) {
		final long longValue = getValue();

		// setting all bits to zero
		out.clear(offset, offset + getSizeInBits() - 1);

		// setting up the number in reverse order
		long mask = 1;

		offset += getSizeInBits() - 1;
		for (int i = 0; i < getSizeInBits(); i++, mask <<= 1) {
			if ((mask & longValue) > 0) {
				out.set(offset - i);
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Calculated Bitset from value " + getValue() + " was: " + BitSetUtility.binDump(out));
		}

		return out;
	}

}
