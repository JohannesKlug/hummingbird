package org.hbird.transport.payloadcodec.codecparameters.number;

import static org.junit.Assert.assertEquals;

import java.nio.ByteOrder;
import java.util.BitSet;

import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.encoding.Encoding.BinaryRepresentation;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.provided.TelemeteredParameter;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwosComplementLongCodecParameterTest {
	private final static Logger LOG = LoggerFactory.getLogger(TwosComplementLongCodecParameterTest.class);

	private static CodecParameter<Long> codec;

	private static final long TEST_LONG = 2305843397479642193l;

	private static final String TEST_LONG_STR_BE = "0010000000000000000000000101101001100110011101000011010001010001";

	private static BitSet TEST_LONG_BITSET_BE;

	private static final String TEST_MAX_LONG_STR = "0111111111111111111111111111111111111111111111111111111111111111";

	private static BitSet TEST_MAX_LONG_BITSET;

	private static final String TEST_MIN_LONG_STR = "1000000000000000000000000000000000000000000000000000000000000000";

	private static BitSet TEST_MIN_LONG_BITSET;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TEST_LONG_BITSET_BE = BitSetUtility.stringToBitSet(TEST_LONG_STR_BE, true, true);
		TEST_MAX_LONG_BITSET = BitSetUtility.stringToBitSet(TEST_MAX_LONG_STR, true, true);
		TEST_MIN_LONG_BITSET = BitSetUtility.stringToBitSet(TEST_MIN_LONG_STR, true, true);
	}

	@Before
	public void setUp() {
		Parameter<Long> parameterBigEndian = new TelemeteredParameter<Long>("test.beLongParameter", "beLongParameter", "", "");
		Encoding enc = new Encoding(64, BinaryRepresentation.twosComplement);
		parameterBigEndian.setValue(TEST_LONG);
		codec = new TwosComplementLongCodecParameter(parameterBigEndian, enc);
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testValueFromBitSet() {
		codec.decode(TEST_LONG_BITSET_BE, 0);
		assertEquals(TEST_LONG, codec.getValue().longValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testMaxValueDecodeBitSet() {
		codec.decode(TEST_MAX_LONG_BITSET, 0);
		assertEquals(Long.MAX_VALUE, codec.getValue().longValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testMinValueDecodeBitSet() {
		codec.decode(TEST_MIN_LONG_BITSET, 0);
		assertEquals(Long.MIN_VALUE, codec.getValue().longValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testEncodetoBitSet() {
		codec.setValue(TEST_LONG);
		BitSet actual = new BitSet();
		codec.encodeToBitSet(actual, 0);

		assertEquals(actual, TEST_LONG_BITSET_BE);
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testDecodeByteArrayFullSizeByteBoundExact64Long() {
		Parameter<Long> hostParameter = new TelemeteredParameter<Long>("", "", "", "");
		Long testValue = 1252009l;

		byte[] bigEndianBytes = new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x13, 0x1A, (byte) 0xA9 };
		Encoding enc = new Encoding(bigEndianBytes.length * Byte.SIZE, BinaryRepresentation.twosComplement, ByteOrder.BIG_ENDIAN);
		TwosComplementLongCodecParameter codec = new TwosComplementLongCodecParameter(hostParameter, enc);
		codec.decode(bigEndianBytes, 0);
		assertEquals("", testValue, hostParameter.getValue());

		byte[] littleEndianBytes = new byte[] { (byte) 0xA9, 0x1A, 0x13, 0x00, 0x00, 0x00, 0x00, 0x00 };
		Encoding lendianEnc = new Encoding(littleEndianBytes.length * Byte.SIZE, BinaryRepresentation.twosComplement, ByteOrder.LITTLE_ENDIAN);
		TwosComplementLongCodecParameter lendianCodec = new TwosComplementLongCodecParameter(hostParameter, lendianEnc);
		lendianCodec.decode(littleEndianBytes, 0);
		assertEquals("", testValue, hostParameter.getValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testDecodeByteArrayFullSizeByteBoundLessThan64() {
		Parameter<Long> hostParameter = new TelemeteredParameter<Long>("", "", "", "");
		Long testValue = 1252009l;

		byte[] bigEndianBytes = new byte[] { 0x00, 0x00, 0x00, 0x13, 0x1A, (byte) 0xA9 };
		Encoding enc = new Encoding(bigEndianBytes.length * Byte.SIZE, BinaryRepresentation.twosComplement, ByteOrder.BIG_ENDIAN);
		TwosComplementLongCodecParameter codec = new TwosComplementLongCodecParameter(hostParameter, enc);
		codec.decode(bigEndianBytes, 0);
		assertEquals("", testValue, hostParameter.getValue());

		byte[] littleEndianBytes = new byte[] { (byte) 0xA9, 0x1A, 0x13, 0x00, 0x00, 0x00 };
		Encoding lendianEnc = new Encoding(littleEndianBytes.length * Byte.SIZE, BinaryRepresentation.twosComplement, ByteOrder.LITTLE_ENDIAN);
		TwosComplementLongCodecParameter lendianCodec = new TwosComplementLongCodecParameter(hostParameter, lendianEnc);
		lendianCodec.decode(littleEndianBytes, 0);
		assertEquals("", testValue, hostParameter.getValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testDecodeByteArrayFullSizeNonBound() {
		Parameter<Long> hostParameter = new TelemeteredParameter<Long>("", "", "", "");
		Long testValue = 68719476736l;
		final int BIT_PACKED_LENGTH = 37;

		byte[] bigEndianBytes = new byte[] { 0x10, 0x00, 0x00, 0x00, 0x00 };
		Encoding enc = new Encoding(BIT_PACKED_LENGTH, BinaryRepresentation.twosComplement, ByteOrder.BIG_ENDIAN);
		TwosComplementLongCodecParameter codec = new TwosComplementLongCodecParameter(hostParameter, enc);
		codec.decode(bigEndianBytes, 0);
		assertEquals("", testValue, hostParameter.getValue());

		byte[] littleEndianBytes = new byte[] { 0x00, 0x00, 0x00, 0x00, 0x10 };
		Encoding lendianEnc = new Encoding(BIT_PACKED_LENGTH, BinaryRepresentation.twosComplement, ByteOrder.LITTLE_ENDIAN);
		TwosComplementLongCodecParameter lendianCodec = new TwosComplementLongCodecParameter(hostParameter, lendianEnc);
		lendianCodec.decode(littleEndianBytes, 0);
		assertEquals("", testValue, hostParameter.getValue());
	}
}
