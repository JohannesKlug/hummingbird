package org.hbird.transport.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parameter behaviour for an IEEE 754 32-bit precision Float.
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class Float32Behaviour extends AbstractFloatBehaviour {
	private final static Logger LOG = LoggerFactory.getLogger(Float32Behaviour.class);

	public Float32Behaviour() {
		super(Float.SIZE);
	}

	@Override
	public Float valueFromBitSet(final BitSet packet) {
		final int offset = 0;

		final BitSet actualBitSet = packet.get(offset, offset + getSizeInBits());

		LOG.debug("Float Parameter BitSet taken from bitset in = " + BitSetUtility.binDump(actualBitSet));

		return BitSetUtility.toFloat(actualBitSet);
	}

	@Override
	public BitSet insertIntoBitSet(final Number number, final BitSet bitSetTarget, final int offset) throws BitSetOperationException {
		final float value = number.floatValue();

		// Convert the value to a bitset
		// Parse as IEEE-754 Single Precision (32-bit) (Java Integer)
		final int intBits = Float.floatToIntBits(value);

		String binaryString = Integer.toBinaryString(intBits);
		LOG.debug("Float32 insertIntoBitSet - Binary string = " + binaryString);

		if (value >= 0) {
			// We have to add the Sign bit manually for positive Numbers
			binaryString = '0' + binaryString;
		}

		// Get the BitSet from the String.
		BitSet valueBitSet = this.bitSetFromString(binaryString);

		// If the floats has leading zeros the int conversion above will truncate them. This is expected as
		// the leading zeros are surplus for a Java big endian int. They are however vital to an IEEE-754 float
		// since they contain the sign, exponent and mantissa. We must repair the bitset in this case.
		if (valueBitSet.length() < Float.SIZE) {
			// int truncation = 32 - valueBitSet.length();
			String bitsetString = BitSetUtility.bitSetToBinaryString(valueBitSet, true);
			LOG.debug("Truncated bitset = " + bitsetString);
			bitsetString = BitSetUtility.padStringFromTheFront(bitsetString, Float.SIZE);
			LOG.debug("Repaired bitset = " + bitsetString);
			valueBitSet = BitSetUtility.stringToBitSet(bitsetString, true, true);
		}

		// Insert the value BitSet into the target BitSet and return
		for (int i = 0; i < getSizeInBits(); i++) {
			if (valueBitSet.get(i)) {
				bitSetTarget.set(i + offset);
			}
			else {
				bitSetTarget.clear(i + offset);
			}
		}

		LOG.debug("Returning BitSet = " + BitSetUtility.binDump(bitSetTarget));
		return bitSetTarget;
	}

	@Override
	public String getTypeName() {
		return "Float (IEEE754 Single precision 32-bit)";
	}

}
