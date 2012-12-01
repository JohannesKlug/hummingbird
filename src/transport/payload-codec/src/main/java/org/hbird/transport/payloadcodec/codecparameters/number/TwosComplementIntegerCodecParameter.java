package org.hbird.transport.payloadcodec.codecparameters.number;

import java.util.BitSet;

import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.commons.util.BytesUtility;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mark Doyle
 * @param <T>
 */
public class TwosComplementIntegerCodecParameter extends CodecParameter<Integer> {
	private static final long serialVersionUID = 4601475539675898978L;
	private static final Logger LOG = LoggerFactory.getLogger(TwosComplementIntegerCodecParameter.class);

	public TwosComplementIntegerCodecParameter(final Parameter<Integer> hostParameter, final Encoding encoding) {
		super(hostParameter, encoding);
	}

	@Override
	public void decode(final byte[] inBytes, final int offset) {
		// TODO Auto-generated method stub

	}

	@Override
	public void decode(final BitSet inBitset, final int offset) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Extracting " + encoding.getSizeInBits() + " bit int value from " + BitSetUtility.binDump(inBitset));
		}

		BitSet actualParameter = inBitset.get(0, encoding.getSizeInBits());

		int numBytes = (encoding.getSizeInBits() + Byte.SIZE - 1) / Byte.SIZE;
		int byteBoundLength = numBytes * Byte.SIZE;

		actualParameter = BitSetUtility.padToByteBoundary(actualParameter, encoding.getSizeInBits(), byteBoundLength, true);

		final byte[] byteArray = BitSetUtility.toByteArray(actualParameter, byteBoundLength);
		final Integer output = Integer.valueOf(BytesUtility.combine(byteArray, encoding.getSizeInBits(), true).intValue());

		this.setValue(output);
	}

	@Override
	public byte[] encodeToByteArray(final byte[] targetBytes, final int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BitSet encodeToBitSet(final BitSet out, final int originalOffset) {
		final BitSet result = out;
		final Integer value = getValue();
		int offset = originalOffset;

		// TODO this method

		// checking whether the value fits into the bit string of length - 1
		// final long absValue = Math.abs(value);
		// if (absValue > Math.pow(2.0, encoding.getSizeInBits()) - 1 || value == Long.MIN_VALUE) {
		// // TODO Could indicate a programming or configuration bug which is not recoverable. Maybe System.exit?
		// throw new IllegalArgumentException("The value of " + value + " does not fit into a bit string of " +
		// (encoding.getSizeInBits() - 1) + " bits.");
		// }

		// setting up the number in reverse order
		long mask = 1;
		offset += encoding.getSizeInBits() - 1;

		for (int i = 0; i < encoding.getSizeInBits(); i++, mask <<= 1) {
			if ((mask & value) > 0) {
				result.set(offset - i);
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Calculated Bitset from value " + value + " was: " + BitSetUtility.binDump(result));
		}

		return result;
	}

}
