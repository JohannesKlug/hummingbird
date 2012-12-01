package org.hbird.transport.payloadcodec.codecparameters.number;

import java.nio.ByteBuffer;
import java.util.BitSet;

import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.commons.util.BytesUtility;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mark Doyle
 * @author Johannes Klug (John Clever)
 */
public class UnsignedIntegerCodecParameter extends CodecParameter<Integer> {
	private static final long serialVersionUID = 6820348312687042896L;
	private static final Logger LOG = LoggerFactory.getLogger(UnsignedIntegerCodecParameter.class);

	public UnsignedIntegerCodecParameter(final Parameter<Integer> hostParameter, final Encoding encoding) {
		super(hostParameter, encoding);
	}

	@Override
	public void decode(final byte[] inBytes, final int bitOffset) {
		// TODO Do this without BitSet.
		decode(BitSetUtility.fromByteArray(inBytes), bitOffset);
	}

	@Override
	public void decode(final BitSet inBitset, final int bitOffset) {
		final BitSet actualParameter = inBitset.get(bitOffset, bitOffset + encoding.getSizeInBits());
		if (LOG.isTraceEnabled()) {
			LOG.trace("Extracted " + encoding.getSizeInBits() + " bit int value from " + BitSetUtility.binDump(actualParameter));
		}

		final byte[] byteArray = BitSetUtility.toByteArray(actualParameter, encoding.getSizeInBits(), encoding.getByteOrder(), true);
		ByteBuffer endianBytes = ByteBuffer.wrap(byteArray).order(encoding.getByteOrder());

		if (LOG.isTraceEnabled()) {
			LOG.trace("Byte array = " + BytesUtility.hexDump(byteArray));
			LOG.trace("Endianness applied byte array = " + BytesUtility.hexDump(endianBytes.array()));
		}

		// final int output = BytesUtility.combine(endianBytes.array(), encoding.getSizeInBits(), false).intValue();
		int output = 0;
		if (encoding.getSizeInBits() <= 8) {
			byte byteValue = endianBytes.get();
			output = byteValue & 0xff;
		}
		else if (encoding.getSizeInBits() <= 16) {
			short shortValue = endianBytes.getShort();
			output = shortValue & 0xffff;
		}
		else if (encoding.getSizeInBits() <= 32) {
			int intValue = endianBytes.getInt();
			output = intValue & 0xffff;
		}
		else if (encoding.getSizeInBits() > 32) {
			// PROBLEM?
		}

		if (LOG.isTraceEnabled()) {
			LOG.trace("Output(bin) = " + Long.toBinaryString(output));
			LOG.trace("Output(dec) = " + output);
		}

		this.setValue(output);
	}

	@Override
	public BitSet encodeToBitSet(final BitSet out, final int offset) {
		final long unsignedInt = getValue();

		// checking whether the value fits into the bit string of length - 1
		long absValue = Math.abs(unsignedInt);
		if (absValue > Math.pow(2.0, encoding.getSizeInBits()) - 1 || unsignedInt == Long.MIN_VALUE) {
			throw new RuntimeException("The value of " + unsignedInt + " does not fit into a bit string of " + encoding.getSizeInBits() + " bits.");
		}

		// Split into Bytes.
		int numberOfBytes = encoding.getSizeInBits() / Byte.SIZE;
		// Any remaining bits require an extra Byte
		if (encoding.getSizeInBits() % Byte.SIZE != 0) {
			numberOfBytes++;
		}
		ByteBuffer littleEndianBuffer = ByteBuffer.allocate(numberOfBytes);
		if (encoding.getSizeInBits() <= 8) {
			littleEndianBuffer.put((byte) absValue).flip();
			absValue = littleEndianBuffer.order(encoding.getByteOrder()).get();
		}
		else if (encoding.getSizeInBits() <= 16) {
			littleEndianBuffer.putShort((short) absValue).flip();
			absValue = littleEndianBuffer.order(encoding.getByteOrder()).getShort();
		}
		else if (encoding.getSizeInBits() <= 32) {
			littleEndianBuffer.putInt((int) absValue).flip();
			absValue = littleEndianBuffer.order(encoding.getByteOrder()).getInt();
		}
		else if (encoding.getSizeInBits() > 32) {
			// PROBLEM?
		}

		// setting all bits to zero
		out.clear(offset, offset + encoding.getSizeInBits() - 1);

		// setting up the number in reverse order which allows us to map the number to a BitSet
		// in big endian order.
		long mask = 1;

		final int encodingOffset = offset + encoding.getSizeInBits() - 1;

		for (int i = 0; i < encoding.getSizeInBits(); i++, mask <<= 1) {
			if ((mask & absValue) > 0) {
				out.set(encodingOffset - i);
			}
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Calculated encoded Bitset from value " + getValue() + " was: " + BitSetUtility.binDump(out));
		}

		if (out.length() > encoding.getSizeInBits()) {
			LOG.trace("bitset too large");
		}
		return out;
	}

	@Override
	public byte[] encodeToByteArray(final byte[] targetBytes, final int offset) {
		throw new UnsupportedOperationException();
	}

	// @Override
	// public BitSet insertIntoBitSet(final Number number, final BitSet bitSetTarget, int offset) {
	//
	// final long unsignedInt = number.longValue();
	//
	// // checking whether the value fits into the bit string of length - 1
	// final long absValue = Math.abs(unsignedInt);
	// if (absValue > Math.pow(2.0, getSIZE_IN_BITS()) - 1 || unsignedInt == Long.MIN_VALUE) {
	// throw new RuntimeException("The value of " + unsignedInt + " does not fit into a bit string of "
	// + (getSIZE_IN_BITS() - 1) + " bits.");
	// }
	//
	// // setting all bits to zero
	// bitSetTarget.clear(offset, offset + getSIZE_IN_BITS() - 1);
	//
	// // setting up the number in reverse order
	// int mask = 1;
	// if (isBigEndian) {
	// offset += getSIZE_IN_BITS() - 1;
	// }
	// for (int i = 0; i < getSIZE_IN_BITS(); i++, mask <<= 1) {
	// if ((mask & absValue) > 0) {
	// if (isBigEndian) {
	// bitSetTarget.set(offset - i);
	// }
	// else {
	// bitSetTarget.set(offset + i);
	// }
	// }
	// }
	//
	// if (LOG.isDebugEnabled()) {
	// LOG.debug("Calculated Bitset from value " + number.intValue() + " was: " + BitSetUtility.binDump(bitSetTarget));
	// }
	//
	// return bitSetTarget;
	// }

	// @Override
	// public BitSet insertIntoBitSet(final Number number, final BitSet bitSetTarget, int offset) {
	//
	// final long unsignedInt = number.longValue();
	//
	// // checking whether the value fits into the bit string of length - 1
	// final long absValue = Math.abs(unsignedInt);
	// if (absValue > Math.pow(2.0, getSIZE_IN_BITS()) - 1 || unsignedInt == Long.MIN_VALUE) {
	// throw new RuntimeException("The value of " + unsignedInt + " does not fit into a bit string of "
	// + (getSIZE_IN_BITS() - 1) + " bits.");
	// }
	//
	// // setting all bits to zero
	// bitSetTarget.clear(offset, offset + getSIZE_IN_BITS() - 1);
	//
	// // setting up the number in reverse order
	// int mask = 1;
	// if (isBigEndian) {
	// offset += getSIZE_IN_BITS() - 1;
	// }
	//
	// for (int i = 0; i < getSIZE_IN_BITS(); i++, mask <<= 1) {
	// if ((mask & absValue) > 0) {
	// if (isBigEndian) {
	// bitSetTarget.set(offset - i);
	// }
	// else {
	// bitSetTarget.set(offset + i);
	// }
	// }
	// }
	// }
}
