package org.hbird.transport.packetcodec.codecparameters.number;

import java.math.BigInteger;
import java.util.BitSet;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.packetcodec.codecparameters.CodecParameter;
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
	public Long decode(final Byte[] inBytes) {
		// TODO Auto-generated method stub
		return null;
	}


	// FIXME String implementation for decoding is nasty!
	@Override
	public Long decode(final BitSet inBitset) {
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

		return parameterValue;
	}


	@Override
	public Byte[] encodeToByteArray(final Long value) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BitSet encodeToBitSet(final Long value) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public BitSet insertIntoBitSet(final Number number, final BitSet bitSetTarget, int offset)
	// throws BitSetOperationException {
	//
	// final long longValue = number.longValue();
	//
	// // setting all bits to zero
	// bitSetTarget.clear(offset, offset + getSIZE_IN_BITS() - 1);
	//
	// // setting up the number in reverse order
	// long mask = 1;
	//
	// offset += getSIZE_IN_BITS() - 1;
	// for (int i = 0; i < getSIZE_IN_BITS(); i++, mask <<= 1) {
	// if ((mask & longValue) > 0) {
	// bitSetTarget.set(offset - i);
	// }
	// }
	//
	// if (LOG.isDebugEnabled()) {
	// LOG.debug("Calculated Bitset from value " + number.longValue() + " was: " + BitSetUtility.binDump(bitSetTarget));
	// }
	//
	// return bitSetTarget;
	// }


}
