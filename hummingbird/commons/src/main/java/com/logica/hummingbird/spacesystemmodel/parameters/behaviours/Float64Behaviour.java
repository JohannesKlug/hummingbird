package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.util.BitSetUtility;
import com.logica.hummingbird.util.BitSetUtility.FloatSizeInBits;

/**
 * Parameter behaviour for an IEEE 754 64-bit precision Float.
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class Float64Behaviour extends AbstractFloatBehaviour {
	private final static Logger LOG = LoggerFactory.getLogger(Float64Behaviour.class);

	public Float64Behaviour() {
		super(64l);
	}

	@Override
	public Double valueFromBitSet(BitSet packet) {
		// The technique this method uses is to convert the bitset to a string and then parse it as a double
		// Awesome tekkers.
		
		int offset = 0;

		BitSet actualBitSet = packet.get(offset, offset + (int) getSizeIntBits());

		if (LOG.isDebugEnabled()) {
			LOG.debug("Float Parameter BitSet taken from bitset in = " + BitSetUtility.binDump(actualBitSet));
		}

		int length = actualBitSet.size();
		if (length != FloatSizeInBits.THIRTY_TWO.getSize() && length != FloatSizeInBits.SIXTY_FOUR.getSize()) {
			LOG.error("A float BitSet of invalid length was passed. This is an error! Size is: " + length);
		}

		String actualBitSetString = BitSetUtility.bitSetToBinaryString(actualBitSet, false);

		if (LOG.isDebugEnabled()) {
			LOG.debug("BinaryString representation of actual bitset = " + actualBitSetString);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Extracting value using longBitsToDouble");
		}
		
		// Float 64 so convert to a Double
		return Double.longBitsToDouble(Long.parseLong(actualBitSetString, 2));

	}

	@Override
	public BitSet getRawParameterBinary(BitSet packet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BitSet insertIntoBitSet(Number number, BitSet bitSetTarget, int offset) {
		return bitSetTarget;
		// TODO Auto-generated method stub

	}

	@Override
	public String getTypeName() {
		return "Double (IEEE754 Double precision 64-bit)";
	}

}
