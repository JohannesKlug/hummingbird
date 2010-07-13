package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.util.BitSetUtility;
import com.logica.hummingbird.util.exceptions.BitSetOperationException;

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
		super(32);
	}

	@Override
	public Float valueFromBitSet(BitSet packet) {
		int offset = 0;

		BitSet actualBitSet = packet.get(offset, offset + (int) getSizeIntBits());

		if (LOG.isDebugEnabled()) {
			LOG.debug("Float Parameter BitSet taken from bitset in = " + BitSetUtility.binDump(actualBitSet));
		}

		return Float.intBitsToFloat(BitSetUtility.toInt(actualBitSet));
	}

	@Override
	public BitSet insertIntoBitSet(Number number, BitSet bitSetTarget, int offset) throws BitSetOperationException {
		float value = number.floatValue();

		// Convert the value to a bitset
		// Parse as IEEE-754 Single Precision (32-bit) (Java Integer)
		int intBits = Float.floatToIntBits(value);

		String binaryString = Integer.toBinaryString(intBits);

		if (value >= 0) {
			// We have to add the Sign bit manually for positive Numbers
			binaryString = '0' + binaryString;
		}

		// Get the BitSet from the String.
		BitSet valueBitSet = this.bitSetFromString(binaryString);

		// Insert the value BitSet into the target BitSet and return
		for (int i = 0; i < getSizeIntBits(); i++) {
			if (valueBitSet.get(i)) {
				bitSetTarget.set(i + offset);
			}
			else {
				bitSetTarget.clear(i + offset);
			}
		}
		return bitSetTarget;
	}

	@Override
	public String getTypeName() {
		return "Float (IEEE754 Single precision 32-bit)";
	}

}
