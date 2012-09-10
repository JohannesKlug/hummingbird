package org.hbird.transport.payloadcodec.codecparameters.number;

import java.util.BitSet;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parameter behaviour for an IEEE 754 64-bit precision Float.
 *
 * @author Mark Doyle
 * @author Johannes Klug
 *
 */
public class Double64ParameterCodec extends CodecParameter<Double> {
	private static final Logger LOG = LoggerFactory.getLogger(Double64ParameterCodec.class);

	public Double64ParameterCodec(final Parameter<Double> hostParameter, final Encoding encoding) {
		super(hostParameter, encoding);
	}

	@Override
	public void decode(final byte[] inBytes, final int offset) {
		// TODO Auto-generated method stub

	}

	@Override
	public void decode(final BitSet inBitset, final int offset) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] encodeToByteArray(final byte[] targetBytes, final int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BitSet encodeToBitSet(final BitSet targetBitSet, final int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public Double valueFromBitSet(final BitSet packet) {
	// // The technique this method uses is to convert the bitset to a string and then parse it as a double
	// // Awesome tekkers.
	//
	// final int offset = 0;
	//
	// final BitSet actualBitSet = packet.get(offset, offset + getSizeInBits());
	//
	// if (LOG.isDebugEnabled()) {
	// LOG.debug("Float Parameter BitSet taken from bitset in = " + BitSetUtility.binDump(actualBitSet));
	// }
	//
	// // Float 64 so convert to a Double
	// return BitSetUtility.toDouble(actualBitSet);
	// }



	// @Override
	// public BitSet insertIntoBitSet(final Number number, final BitSet bitSetTarget, final int offset)
	// throws BitSetOperationException {
	// final double value = number.doubleValue();
	//
	// // Convert the value to a bitset
	// // Parse as IEEE-754 Double Precision (64-bit) (Java Double)
	// final Long longBits = Double.doubleToLongBits(value);
	//
	// String binaryString = Long.toBinaryString(longBits);
	//
	// if (value >= 0) {
	// // We have to add the Sign bit manually for positive Numbers
	// binaryString = '0' + binaryString;
	// }
	//
	// // Get the BitSet from the String.
	// final BitSet valueBitSet = this.bitSetFromString(binaryString);
	//
	// // Insert the value BitSet into the target BitSet and return
	// for (int i = 0; i < getSizeInBits(); i++) {
	// if (valueBitSet.get(i)) {
	// bitSetTarget.set(i + offset);
	// }
	// else {
	// bitSetTarget.clear(i + offset);
	// }
	// }
	// return bitSetTarget;
	// }

}
