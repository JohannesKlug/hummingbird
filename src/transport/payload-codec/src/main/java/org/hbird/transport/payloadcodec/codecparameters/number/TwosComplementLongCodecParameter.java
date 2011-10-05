package org.hbird.transport.payloadcodec.codecparameters.number;

import java.math.BigInteger;
import java.util.BitSet;

import org.apache.commons.lang.StringUtils;
import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
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
	/**
	 *
	 */
	private static final long serialVersionUID = -6520952692018179861L;
	/** Logger for this class */
	private final static Logger LOG = LoggerFactory.getLogger(TwosComplementLongCodecParameter.class);


	public TwosComplementLongCodecParameter(final Parameter<Long> hostParameter) {
		super(hostParameter);
	}


	@Override
	public void decode(final byte[] inBytes, final int offset) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException();
	}


	// FIXME String implementation for decoding is nasty!
	@Override
	public void decode(final BitSet inBitset,  final int offset) {
		long parameterValue = 0;

		String binaryString = BitSetUtility.bitSetToBinaryString(inBitset, false);

		binaryString = binaryString.substring(offset, offset + getSizeInBits());

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BitSet encodeToBitSet(final BitSet out, int offset) {
		long longValue = getValue();

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
			LOG.debug("Calculated Bitset from value " + longValue + " was: " + BitSetUtility.binDump(out));
		}

		return out;
	}

	 /**
	   * Byte swap a single long value.
	   *
	   * @param value  Value to byte swap.
	   * @return       Byte swapped representation.
	   */
	  public static long swap (final long value)
	  {
	    long b1 = (value >>  0) & 0xff;
	    long b2 = (value >>  8) & 0xff;
	    long b3 = (value >> 16) & 0xff;
	    long b4 = (value >> 24) & 0xff;
	    long b5 = (value >> 32) & 0xff;
	    long b6 = (value >> 40) & 0xff;
	    long b7 = (value >> 48) & 0xff;
	    long b8 = (value >> 56) & 0xff;

	    return b1 << 56 | b2 << 48 | b3 << 40 | b4 << 32 |
	           b5 << 24 | b6 << 16 | b7 <<  8 | b8 <<  0;
	  }

}
