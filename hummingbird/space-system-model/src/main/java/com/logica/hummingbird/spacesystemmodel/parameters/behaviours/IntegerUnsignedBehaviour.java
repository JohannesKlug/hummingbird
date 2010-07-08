package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.util.BitSetUtility;
import com.logica.hummingbird.util.exceptions.BitSetOperationException;

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
	public Long valueFromBitSet(BitSet packet) {
		long parameterValue = 0;
		if (LOG.isDebugEnabled()) {
			LOG.debug("Extracting " + getSizeIntBits() + " bit int value from " + BitSetUtility.binDump(packet));
		}

		if (!isBigEndian) {
			// TODO Not the most elegant solution with all the conversions to strings, reversals, reparsing etc.
			if (LOG.isDebugEnabled()) {
				LOG.debug("Extracting little endian value");
			}

			for (int i = getSizeIntBits() - 1; i >= 0; i--) {
				if (packet.get(i)) {
					parameterValue |= (1 << i);
				}
				if (LOG.isDebugEnabled()) {
					LOG.debug("Parameter value construction steps = " + Long.toBinaryString(parameterValue));
				}
			}

			parameterValue = parameterValue & Long.MAX_VALUE;

			if (LOG.isDebugEnabled()) {
				LOG.debug("Parameter value = " + Long.toBinaryString(parameterValue));
			}

			try {
				// Note, we have reverse the bitset in the above loop so the stringToBitSet must be passed true for
				// isBigEndian
				BitSet paramBitset = BitSetUtility.stringToBitSet(Long.toBinaryString(parameterValue), true);
				String finalParam = BitSetUtility.bitSetToBinaryString(paramBitset, false);
				parameterValue = Long.parseLong(finalParam, 2);
			}
			catch (BitSetOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOG.error(e.getMessage());
			}
		}
		else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Extracting big endian value");
			}

			String binString = BitSetUtility.bitSetToBinaryString(packet, true);
			if (binString.length() < getSizeIntBits()) {
				binString = BitSetUtility.padStringFromTheBack(binString, getSizeIntBits());
			}
			else if (binString.length() > getSizeIntBits()) {
				if(LOG.isDebugEnabled()) {
					LOG.debug("THe binary string is too long, we must not parse past the size of the parameter.  Chomping string now...");
				}
				binString = binString.substring(0, getSizeIntBits());
			}
			parameterValue = Long.parseLong(binString, 2);

			if (LOG.isDebugEnabled()) {
				LOG.debug("Calculated value from bitset was: " + parameterValue);
			}
		}
		
		return parameterValue;
	}

	@Override
	public BitSet insertIntoBitSet(Number number, BitSet bitSetTarget, int offset) {
		int length = getSizeIntBits();

		long unsignedInt = number.longValue();

		// checking whether the value fits into the bit string of length - 1
		long absValue = Math.abs(unsignedInt);
		if (absValue > Math.pow(2.0, length) - 1 || unsignedInt == Long.MIN_VALUE) {
			throw new RuntimeException("The value of " + unsignedInt + " does not fit into a bit string of " + (length - 1) + " bits.");
		}

		// setting all bits to zero
		bitSetTarget.clear(offset, offset + length - 1);

		// setting up the number in reverse order
		int mask = 1;
		for (int i = 0; i < length; ++i, mask <<= 1) {
			if ((mask & absValue) > 0) {
				bitSetTarget.set(offset + i);
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Calculated Bitset from value " + number.intValue() + " was: " + BitSetUtility.binDump(bitSetTarget));
		}

		return bitSetTarget;
	}

	@Override
	public String getTypeName() {
		return getSizeIntBits() + "bit Unsigned integer";
	}

}
