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
		if(LOG.isDebugEnabled()) {
			LOG.debug("Extracting value from " + BitSetUtility.binDump(packet));
		}

		if (!isBigEndian) {
			// TODO Not the most elegant solution with all the conversions to strings, reversals, reparsing etc.
			if(LOG.isDebugEnabled()) {
				LOG.debug("Extracting little endian value");
			}

            for(int i = packet.length(); i >= 0; i--) {
                if (packet.get(i)) {
                	parameterValue |= (1 << i); 
                }
                if(LOG.isDebugEnabled()) {
                	LOG.debug("Bit position " + i + " parameter value = " + Long.toBinaryString(parameterValue));
                }
            }
            parameterValue = parameterValue & Long.MAX_VALUE;
            LOG.debug("Extracted parameter value with max long anded = " + Long.toBinaryString(parameterValue));
            parameterValue = Long.reverse(parameterValue);
            LOG.debug("Reversed Long = " + Long.toBinaryString(parameterValue));
            try {
				BitSet paramBitset = BitSetUtility.stringToBitSet(Long.toBinaryString(parameterValue), false);
				BitSet paraBitSet = paramBitset.get(0, getSizeIntBits()+1);
				String finalParam = BitSetUtility.bitSetToBinaryString(paraBitSet, true);
				parameterValue = Long.parseLong(finalParam, 2);
			}
			catch (BitSetOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			if(LOG.isDebugEnabled()) {
				LOG.debug("Extracting big endian value");
			}
			for(int i = 0;i < packet.length();i++) {
                if (packet.get(i)) {
                	parameterValue |= (1 << i); 
                }
            }
            parameterValue = parameterValue & Long.MAX_VALUE;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Calculated value from bitset was: " + parameterValue);
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
