package org.hbird.transport.packetcodec.codecparameters.number;

import java.util.BitSet;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.BytesUtility;
import org.hbird.transport.packetcodec.codecparameters.CodecParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mark Doyle
 * @param <T>
 */
public class TwosComplementIntegerCodecParameter extends CodecParameter<Integer> {
	private static final Logger LOG = LoggerFactory.getLogger(TwosComplementIntegerCodecParameter.class);

	public TwosComplementIntegerCodecParameter(final Parameter<Integer> hostParameter) {
		super(hostParameter);
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
		final Integer output = new Integer(BytesUtility.combine(byteArray, getSizeInBits(), true).intValue());

		return output;
	}

	@Override
	public Byte[] encodeToByteArray(final Integer value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BitSet encodeToBitSet(final Integer value) {
		BitSet result = new BitSet();
		// TODO this method
		// final long unsignedInt = value.longValue();
		//
		// // checking whether the value fits into the bit string of length - 1
		// final long absValue = Math.abs(unsignedInt);
		// if (absValue > Math.pow(2.0, getSizeInBits()) - 1 || unsignedInt == Long.MIN_VALUE) {
		// throw new RuntimeException("The value of " + unsignedInt + " does not fit into a bit string of "
		// + (getSizeInBits() - 1) + " bits.");
		// }
		//
		// // setting all bits to zero
		// // bitSetTarget.clear(offset, offset + getSizeInBits() - 1);
		//
		// // setting up the number in reverse order
		// int mask = 1;
		// if (isBigEndian()) {
		// offset += getSizeInBits() - 1;
		// }
		// for (int i = 0; i < getSizeInBits(); i++, mask <<= 1) {
		// if ((mask & absValue) > 0) {
		// if (isBigEndian()) {
		// result.set(offset - i);
		// }
		// else {
		// result.set(offset + i);
		// }
		// }
		// }
		//
		// if (LOG.isDebugEnabled()) {
		// LOG.debug("Calculated Bitset from value " + value.intValue() + " was: " + BitSetUtility.binDump(result));
		// }

		return result;
	}


}
