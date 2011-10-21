package org.hbird.transport.payloadcodec.codecparameters.number;

import java.util.BitSet;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.BytesUtility;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mark Doyle
 * @author Johannes Klug (John Clever)
 */
public class UnsignedIntegerCodecParameter extends CodecParameter<Integer> {
	/**
	 *
	 */
	private static final long serialVersionUID = 6820348312687042896L;
	private static final Logger LOG = LoggerFactory.getLogger(UnsignedIntegerCodecParameter.class);

	public UnsignedIntegerCodecParameter(final Parameter<Integer> hostParameter, final Encoding encoding) {
		super(hostParameter, encoding);
	}

	// @Override
	// public BitSet insertIntoBitSet(final Number number, final BitSet bitSetTarget, int offset) {
	//
	// final long unsignedInt = number.longValue();
	//
	// // checking whether the value fits into the bit string of length - 1
	// final long absValue = Math.abs(unsignedInt);
	// if (absValue > Math.pow(2.0, getSIZE_IN_BITS()) - 1 || unsignedInt == Long.MIN_VALUE) {
	// throw new RuntimeException("The value of " + unsignedInt + " does not fit into a bit string of "
	// + (getSIZE_IN_BITS() - 1) + " bits.");
	// }
	//
	// // setting all bits to zero
	// bitSetTarget.clear(offset, offset + getSIZE_IN_BITS() - 1);
	//
	// // setting up the number in reverse order
	// int mask = 1;
	// if (isBigEndian) {
	// offset += getSIZE_IN_BITS() - 1;
	// }
	// for (int i = 0; i < getSIZE_IN_BITS(); i++, mask <<= 1) {
	// if ((mask & absValue) > 0) {
	// if (isBigEndian) {
	// bitSetTarget.set(offset - i);
	// }
	// else {
	// bitSetTarget.set(offset + i);
	// }
	// }
	// }
	//
	// if (LOG.isDebugEnabled()) {
	// LOG.debug("Calculated Bitset from value " + number.intValue() + " was: " + BitSetUtility.binDump(bitSetTarget));
	// }
	//
	// return bitSetTarget;
	// }

	// @Override
	// public BitSet insertIntoBitSet(final Number number, final BitSet bitSetTarget, int offset) {
	//
	// final long unsignedInt = number.longValue();
	//
	// // checking whether the value fits into the bit string of length - 1
	// final long absValue = Math.abs(unsignedInt);
	// if (absValue > Math.pow(2.0, getSIZE_IN_BITS()) - 1 || unsignedInt == Long.MIN_VALUE) {
	// throw new RuntimeException("The value of " + unsignedInt + " does not fit into a bit string of "
	// + (getSIZE_IN_BITS() - 1) + " bits.");
	// }
	//
	// // setting all bits to zero
	// bitSetTarget.clear(offset, offset + getSIZE_IN_BITS() - 1);
	//
	// // setting up the number in reverse order
	// int mask = 1;
	// if (isBigEndian) {
	// offset += getSIZE_IN_BITS() - 1;
	// }
	//
	// for (int i = 0; i < getSIZE_IN_BITS(); i++, mask <<= 1) {
	// if ((mask & absValue) > 0) {
	// if (isBigEndian) {
	// bitSetTarget.set(offset - i);
	// }
	// else {
	// bitSetTarget.set(offset + i);
	// }
	// }
	// }
	// }

	@Override
	public void decode(final byte[] inBytes, final int offset) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void decode(final BitSet inBitset, final int offset) {
		BitSet actualParameter = inBitset.get(offset, offset + encoding.getSizeInBits());

		if (LOG.isDebugEnabled()) {
			LOG.debug("Extracting " + encoding.getSizeInBits() + " bit int value from " + BitSetUtility.binDump(actualParameter));
		}

		final byte[] byteArray = BitSetUtility.toByteArray(actualParameter, encoding.getSizeInBits());
		if (LOG.isDebugEnabled()) {
			LOG.debug("Byte array = " + BytesUtility.decimalDump(byteArray));
		}

		final int output = BytesUtility.combine(byteArray, encoding.getSizeInBits(), false).intValue();
		if (LOG.isDebugEnabled()) {
			LOG.debug("Testing combine.  Output(bin) = " + Long.toBinaryString(output));
			LOG.debug("Testing combine.  Output(dec) = " + output);
		}

		this.setValue(output);
	}

	@Override
	public BitSet encodeToBitSet(final BitSet out, final int offset) {
		final long unsignedInt = getValue();

		// checking whether the value fits into the bit string of length - 1
		final long absValue = Math.abs(unsignedInt);
		if (absValue > Math.pow(2.0, encoding.getSizeInBits()) - 1 || unsignedInt == Long.MIN_VALUE) {
			throw new RuntimeException("The value of " + unsignedInt + " does not fit into a bit string of " + encoding.getSizeInBits() + " bits.");
		}

		// setting all bits to zero
		out.clear(offset, offset + encoding.getSizeInBits() - 1);

		// setting up the number in reverse order
		int mask = 1;

		int encodingOffset = offset + encoding.getSizeInBits() - 1;

		for (int i = 0; i < encoding.getSizeInBits(); i++, mask <<= 1) {
			if ((mask & absValue) > 0) {
				out.set(encodingOffset - i);
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Calculated encoded Bitset from value " + getValue() + " was: " + BitSetUtility.binDump(out));
		}

		return out;
	}

	@Override
	public Byte[] encodeToByteArray(final Byte[] targetBytes, final int offset) {
		throw new UnsupportedOperationException();
	}
}
