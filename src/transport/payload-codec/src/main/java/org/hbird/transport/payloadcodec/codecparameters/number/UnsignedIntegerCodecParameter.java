package org.hbird.transport.payloadcodec.codecparameters.number;

import java.util.BitSet;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.BytesUtility;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mark Doyle
 * @author Johannes Klug (John Clever)
 */
public class UnsignedIntegerCodecParameter extends CodecParameter<Integer> {
	private static final Logger LOG = LoggerFactory.getLogger(UnsignedIntegerCodecParameter.class);


	public UnsignedIntegerCodecParameter(final Parameter<Integer> hostParameter) {
		super(hostParameter);
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
	public Byte[] encodeToByteArray(final Integer value) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer decode(final Byte[] inBytes) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer decode(final BitSet inBitset) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Extracting " + getSizeInBits() + " bit int value from " + BitSetUtility.binDump(inBitset));
		}

		BitSet actualParameter = inBitset.get(0, getSizeInBits());

		if (getEndianness() == Endianness.LITTLE) {
			actualParameter = BitSetUtility.reverse(actualParameter, getSizeInBits());
		}
		final byte[] byteArray = BitSetUtility.toByteArray(actualParameter, getSizeInBits());
		LOG.debug("Byte array = " + BytesUtility.decimalDump(byteArray));

		final int output = BytesUtility.combine(byteArray, getSizeInBits(), false).intValue();
		LOG.debug("Testing combine.  Output(bin) = " + Long.toBinaryString(output));
		LOG.debug("Testing combine.  Output(dec) = " + output);

		return output;
	}

	@Override
	public BitSet encodeToBitSet(BitSet out, int offset) {
		final long unsignedInt = getValue();

		// checking whether the value fits into the bit string of length - 1
		final long absValue = Math.abs(unsignedInt);
		if (absValue > Math.pow(2.0, getSizeInBits()) - 1
				|| unsignedInt == Long.MIN_VALUE) {
			throw new RuntimeException("The value of " + unsignedInt
					+ " does not fit into a bit string of "
					+ (getSizeInBits() - 1) + " bits.");
		}

		// setting all bits to zero
		out.clear(offset, offset + getSizeInBits() - 1);

		// setting up the number in reverse order
		int mask = 1;
		if (getEndianness() == Endianness.BIG) {
			offset += getSizeInBits() - 1;
		}

		for (int i = 0; i < getSizeInBits(); i++, mask <<= 1) {
			if ((mask & absValue) > 0) {
				if (getEndianness() == Endianness.BIG) {
					out.set(offset - i);
				} else {
					out.set(offset + i);
				}
			}
		}
		return out;
	}
}
