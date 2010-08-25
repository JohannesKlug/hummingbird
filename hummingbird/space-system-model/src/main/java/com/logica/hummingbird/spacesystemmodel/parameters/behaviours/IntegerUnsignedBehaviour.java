package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.math.BigInteger;
import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.util.BitSetUtility;

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
			LOG.debug("Extracting " + getSizeIntBits() + " bit int value from " + BitSetUtility.binDump(packet));
		}
		
		BitSet actualParameter = packet.get(0, getSizeIntBits());
				
		byte[] byteArray = BitSetUtility.toByteArray(actualParameter, this.SIZE_IN_BITS);
		
		long output = BitSetUtility.combine(byteArray, this.isBigEndian, this.SIZE_IN_BITS);
		LOG.debug("Testing combine.  Output(bin) = " + Long.toBinaryString(output));
		LOG.debug("Testing combine.  Output(dec) = "  + output);
		
//		boolean signedBit = ((byteArray[0] & 0x80) == 0x80);
//		
//		if (signedBit) {
//			if(LOG.isDebugEnabled()) {
//				LOG.debug("Detected set sign bit in unsigned number.  Setting signBit flag and clearing sign...");
//			}
//			byteArray[0] = (byte) (byteArray[0] ^ 0x80);
//		}
//		
//		BigInteger parameterValue = new BigInteger(byteArray);
//		
//		if(LOG.isDebugEnabled()) {
//			LOG.debug("BigInt minus the sign value = " + parameterValue);
//		}
//		
//		if (signedBit) {
//			// we have to add 2^SizeInBits-1
//			if(LOG.isDebugEnabled()) {
//				LOG.debug("Sign bit was detected.  Adding 2^" + (getSizeIntBits()-1) + " to value");
//			}
//			BigInteger powValue = new BigInteger("2");
//			powValue = powValue.pow(getSizeIntBits()-1);
//			parameterValue.add(powValue);
//		}

		
//		return parameterValue.longValue();
		return output;
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
