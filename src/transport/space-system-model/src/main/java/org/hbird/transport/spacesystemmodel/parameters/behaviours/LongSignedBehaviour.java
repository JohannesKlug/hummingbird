package org.hbird.transport.spacesystemmodel.parameters.behaviours;

import java.math.BigInteger;
import java.util.BitSet;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * How do we handle unsigned longs in Java? Long is always signed. Perhaps some math package?
 * Mark:  Looks like we must use {@link BigInteger}
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class LongSignedBehaviour extends AbstractIntegerBehaviour {
	/** Logger for this class */
	private final static Logger LOG = LoggerFactory.getLogger(LongSignedBehaviour.class);

	public LongSignedBehaviour(final int sizeInBits, final boolean isBigEndian) throws InvalidParameterTypeException {
		super(sizeInBits, isBigEndian);
		// TODO Should we say a 1 bit long is wrong? Technically it is I guess but in practice it
		// shouldn't matter what you call it.
		if (sizeInBits <= Integer.SIZE || sizeInBits > Long.SIZE) {
			throw new InvalidParameterTypeException(this.getClass().getName() + "size in bits cannot be less than 33 or greater than 64-bits in size.");
		}
	}

	// TODO Ditch strings, use bytes instead (like in the integer behv.)
	@Override
	public Long valueFromBitSet(final BitSet packet) {
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
	public BitSet insertIntoBitSet(final Number number, final BitSet bitSetTarget, int offset) throws BitSetOperationException {

		final long longValue = number.longValue();

		// setting all bits to zero
		bitSetTarget.clear(offset, offset + SIZE_IN_BITS - 1);

		// setting up the number in reverse order
		long mask = 1;

		offset += SIZE_IN_BITS - 1;
		for (int i = 0; i < SIZE_IN_BITS; i++, mask <<= 1) {
			if ((mask & longValue) > 0) {
				bitSetTarget.set(offset - i);
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Calculated Bitset from value " + number.longValue() + " was: " + BitSetUtility.binDump(bitSetTarget));
		}

		return bitSetTarget;
	}

	@Override
	public String getTypeName() {
		return "Signed long";
	}

}
