package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;
import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.util.BitSetUtility;

/**
 * How do we handle unsigned longs in Java? Long is always signed. Perhaps some math package?
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class LongSignedBehaviour extends AbstractIntegerBehaviour {
	/** Logger for this class */
	private final static Logger LOG = LoggerFactory.getLogger(LongSignedBehaviour.class);

	public LongSignedBehaviour(int sizeInBits, boolean isBigEndian) throws InvalidParameterTypeException {
		super(sizeInBits, isBigEndian);
		// TODO Should we say a 1 bit long is wrong? Technically it is I guess but in practice it
		// shouldn't matter what you call it.
		if (sizeInBits <= 32 || sizeInBits > 64) {
			throw new InvalidParameterTypeException(this.getClass().getName() + "size in bits cannot be less than 33 or greater than 64-bits in size.");
		}
	}

	@Override
	public Long valueFromBitSet(BitSet packet) {
		long parameterValue = 0;
		
		String binaryString = BitSetUtility.bitSetToBinaryString(packet, false);
		
		// IF we are dealing with a negative number...
		if(binaryString.startsWith("1")) {
			// We must prepend a minus sign for the valueOf method used later.
			binaryString = "-" + binaryString;
		}
		
		if(LOG.isDebugEnabled()) {
			LOG.debug("BitSet string = " +  binaryString);
		}
		
		parameterValue = Long.valueOf(binaryString, 2);

		return parameterValue;
	}

	@Override
	public BitSet insertIntoBitSet(Number number, BitSet bitSetTarget, int offset) throws BitSetOperationException {		
		int length = getSizeIntBits();
		long longValue = number.longValue();

		String bitString = Long.toBinaryString(longValue);
		
		BitSet bitset = BitSetUtility.stringToBitSet(bitString, isBigEndian);

		// Set all the target area bits to zero
		bitSetTarget.clear(offset, offset + length - 1);

		// setting up the number in reverse order
		int mask = 1;
		for (int i = 0; i < length; ++i, mask <<= 1) {
			if (bitset.get(i)) {
				bitSetTarget.set(offset + i);
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Calculated Bitset from value " + longValue + " was: " + BitSetUtility.binDump(bitSetTarget));
		}

		return bitSetTarget;
	}

	@Override
	public String getTypeName() {
		return "Signed long";
	}

}
