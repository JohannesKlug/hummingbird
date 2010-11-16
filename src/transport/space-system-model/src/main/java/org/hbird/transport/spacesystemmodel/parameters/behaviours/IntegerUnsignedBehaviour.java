package org.hbird.transport.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.BytesUtility;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;

//TODO javadoc
//TODO 32 bit sized int test.  will need to convert to use a long otherwise the sign bit will be set in java int.
public class IntegerUnsignedBehaviour extends AbstractIntegerBehaviour {
	private static final Logger LOG = LoggerFactory.getLogger(IntegerUnsignedBehaviour.class);

	public IntegerUnsignedBehaviour(int sizeInBits, boolean isBigEndian) throws InvalidParameterTypeException {
		super(sizeInBits, isBigEndian);
		if (sizeInBits > 32) {
			throw new InvalidParameterTypeException("Integer unsigned cannot be greater than 32-bits in size.");
		}
	}

	@Override
	public Number valueFromBitSet(BitSet packet) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Extracting " + this.SIZE_IN_BITS + " bit int value from " + BitSetUtility.binDump(packet));
		}

		BitSet actualParameter = packet.get(0, this.SIZE_IN_BITS);

		if (!isBigEndian) {
			actualParameter = BitSetUtility.reverse(actualParameter, this.SIZE_IN_BITS);
		}
		byte[] byteArray = BitSetUtility.toByteArray(actualParameter, this.SIZE_IN_BITS);
		LOG.debug("Byte array = " + BytesUtility.decimalDump(byteArray));

		long output = BytesUtility.combine(byteArray, this.SIZE_IN_BITS).longValue();
		LOG.debug("Testing combine.  Output(bin) = " + Long.toBinaryString(output));
		LOG.debug("Testing combine.  Output(dec) = " + output);

		return output;
	}

	@Override
	public BitSet insertIntoBitSet(Number number, BitSet bitSetTarget, int offset) {

		long unsignedInt = number.longValue();

		// checking whether the value fits into the bit string of length - 1
		long absValue = Math.abs(unsignedInt);
		if (absValue > Math.pow(2.0, SIZE_IN_BITS) - 1 || unsignedInt == Long.MIN_VALUE) {
			throw new RuntimeException("The value of " + unsignedInt + " does not fit into a bit string of " + (SIZE_IN_BITS - 1) + " bits.");
		}

		// setting all bits to zero
		bitSetTarget.clear(offset, offset + SIZE_IN_BITS - 1);

		// setting up the number in reverse order
		int mask = 1;
		if (isBigEndian) {
			offset += SIZE_IN_BITS - 1;
		}
		for (int i = 0; i < SIZE_IN_BITS; i++, mask <<= 1) {
			if ((mask & absValue) > 0) {
				if (isBigEndian) {
					bitSetTarget.set(offset - i);
				}
				else {
					bitSetTarget.set(offset + i);
				}
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Calculated Bitset from value " + number.intValue() + " was: " + BitSetUtility.binDump(bitSetTarget));
		}

		return bitSetTarget;
	}

	@Override
	public String getTypeName() {
		return getSizeInBits() + "bit Unsigned integer";
	}

}
