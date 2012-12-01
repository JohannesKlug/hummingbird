package org.hbird.transport.payloadcodec.codecparameters.number;

import static org.junit.Assert.assertEquals;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.BitSet;

import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.encoding.Encoding.BinaryRepresentation;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.provided.HummingbirdParameter;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnsignedIntegerCodecParameterTest {
	private final static Logger LOG = LoggerFactory.getLogger(UnsignedIntegerCodecParameterTest.class);

	private final static int MIN_UNSIGNED_ALL = 0;
	private final static int MAX_UNSIGNED_BYTE = 255;
	private final static int MAX_UNSIGNED_SHORT = 65535;

	private UnsignedIntegerCodecParameter codec;

	private final static String TEST_STR_VALUE_BE_555 = "1000101011";
	private final static int TEST_VALUE_LENGTH_BE_555 = 10;
	private static BitSet TEST_BITSET_VALUE_BE_555;

	private final static String TEST_STR_VALUE_LE_555 = "0010101110";
	private final static int TEST_VALUE_LENGTH_LE_555 = 10;
	private static BitSet TEST_BITSET_VALUE_LE_555;

	private final static String TEST_STR_VALUE_BE_1024 = "10000000000";
	private final static int TEST_VALUE_LENGTH_1024 = 11;
	private static BitSet TEST_BITSET_VALUE_BE_1024;

	private static final String TEST_STR_VALUE_BE_123_32bit = "00000000000000000000000001111011";
	private static final int TEST_VALUE_LENGTH_BE_123_32bit = 32;
	private static BitSet TEST_BITSET_VALUE_123_32bit;

	private static final String TEST_STR_VALUE_LE_123_32bit = "01111011000000000000000000000000";
	private static final int TEST_VALUE_LENGTH_LE_123_32bit = 32;
	private static BitSet TEST_BITSET_VALUE_123_LE_32bit;

	/**
	 * The BE 999 is consists of a leading 0. Testing with this value will confirm whether we deal with this as it could
	 * cause issues with the BitSet
	 **/
	private final static String TEST_STR_VALUE_BE_999 = "01111100111";
	private final static int TEST_VALUE_LENGTH_BE_999 = 11;

	private static BitSet TEST_BITSET_VALUE_BE_999;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.debug("Setting up test bitsets....");

		LOG.debug("Creating BE 555 Bitset");
		TEST_BITSET_VALUE_BE_555 = new BitSet();
		TEST_BITSET_VALUE_BE_555.set(0);
		TEST_BITSET_VALUE_BE_555.set(4);
		TEST_BITSET_VALUE_BE_555.set(6);
		TEST_BITSET_VALUE_BE_555.set(8);
		TEST_BITSET_VALUE_BE_555.set(9);
		assertEquals(TEST_STR_VALUE_BE_555, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_555, true));

		LOG.debug("Creating LE 555 Bitset");
		// 0010101110
		TEST_BITSET_VALUE_LE_555 = new BitSet();
		TEST_BITSET_VALUE_LE_555.set(2);
		TEST_BITSET_VALUE_LE_555.set(4);
		TEST_BITSET_VALUE_LE_555.set(6);
		TEST_BITSET_VALUE_LE_555.set(7);
		TEST_BITSET_VALUE_LE_555.set(8);
		assertEquals(TEST_STR_VALUE_LE_555, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_LE_555, TEST_VALUE_LENGTH_LE_555));

		TEST_BITSET_VALUE_BE_999 = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_999, true, true);
		assertEquals(TEST_STR_VALUE_BE_999, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_999, true));

		LOG.debug("Creating BE 123 32bit Bitset");
		TEST_BITSET_VALUE_123_32bit = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_123_32bit, true, true);
		assertEquals(TEST_STR_VALUE_BE_123_32bit, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_123_32bit, true));

		LOG.debug("Creating BE 1024 Bitset");
		TEST_BITSET_VALUE_BE_1024 = new BitSet(TEST_VALUE_LENGTH_1024);
		TEST_BITSET_VALUE_BE_1024.set(0);
		assertEquals(TEST_STR_VALUE_BE_1024, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_1024, false).substring(0, TEST_VALUE_LENGTH_1024));

		TEST_BITSET_VALUE_123_LE_32bit = new BitSet(TEST_VALUE_LENGTH_LE_123_32bit);
		TEST_BITSET_VALUE_123_LE_32bit.set(1);
		TEST_BITSET_VALUE_123_LE_32bit.set(2);
		TEST_BITSET_VALUE_123_LE_32bit.set(3);
		TEST_BITSET_VALUE_123_LE_32bit.set(4);
		TEST_BITSET_VALUE_123_LE_32bit.set(6);
		TEST_BITSET_VALUE_123_LE_32bit.set(7);
		assertEquals(TEST_STR_VALUE_LE_123_32bit,
				BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_123_LE_32bit, false).substring(0, TEST_VALUE_LENGTH_LE_123_32bit));

		LOG.debug("Test bitsets set-up completed successfully");
	}

	@Test
	public void testBigEndianValueFromBitSet() {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("test.unit", "uint", "", "");
		Encoding enc = new Encoding(TEST_VALUE_LENGTH_BE_555, BinaryRepresentation.unsigned);
		UnsignedIntegerCodecParameter codec = new UnsignedIntegerCodecParameter(p, enc);
		codec.decode(TEST_BITSET_VALUE_BE_555, 0);
		assertEquals(555, codec.getValue().intValue());
	}

	@Test
	public void testLittleEndianValueFromBitSet() {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("test.unit", "uint", "", "");
		Encoding enc = new Encoding(TEST_VALUE_LENGTH_LE_555, BinaryRepresentation.unsigned, ByteOrder.LITTLE_ENDIAN);
		UnsignedIntegerCodecParameter codec = new UnsignedIntegerCodecParameter(p, enc);
		codec.decode(TEST_BITSET_VALUE_LE_555, 0);
		assertEquals(555, codec.getValue().intValue());
	}

	@Test
	public void testBigEndianBoundaryValueFromBitSet() {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", "");
		Encoding enc = new Encoding(TEST_VALUE_LENGTH_1024, BinaryRepresentation.unsigned);
		UnsignedIntegerCodecParameter codec = new UnsignedIntegerCodecParameter(p, enc);
		codec.decode(TEST_BITSET_VALUE_BE_1024, 0);
		assertEquals(1024, codec.getValue().intValue());
	}

	@Test
	public void testLitteEndianFromBitSet() {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", "");
		Encoding enc = new Encoding(TEST_VALUE_LENGTH_LE_123_32bit, BinaryRepresentation.unsigned, ByteOrder.LITTLE_ENDIAN);
		UnsignedIntegerCodecParameter codec = new UnsignedIntegerCodecParameter(p, enc);
		codec.decode(TEST_BITSET_VALUE_123_LE_32bit, 0);
		assertEquals(123, codec.getValue().intValue());
	}

	@Test
	public void testZeroByteContainingValueFromBitSet() {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", "");
		Encoding enc = new Encoding(TEST_VALUE_LENGTH_BE_123_32bit, BinaryRepresentation.unsigned);
		UnsignedIntegerCodecParameter codecParam = new UnsignedIntegerCodecParameter(p, enc);
		codecParam.decode(TEST_BITSET_VALUE_123_32bit, 0);
		assertEquals(123, codecParam.getValue().intValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testLeadingZeroBE999ValueFromBitSet() {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", "");
		Encoding enc = new Encoding(TEST_VALUE_LENGTH_BE_999, BinaryRepresentation.unsigned);
		UnsignedIntegerCodecParameter behaviour = new UnsignedIntegerCodecParameter(p, enc);
		behaviour.decode(TEST_BITSET_VALUE_BE_999, 0);
		assertEquals(999, behaviour.getValue().intValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testInsertIntoBitSetBE555() {
		LOG.info("###################### Beginning test #######################");
		BitSet actual = new BitSet();

		Parameter<Integer> parameter = new HummingbirdParameter<Integer>("", "", "", "");
		parameter.setValue(555);
		Encoding enc = new Encoding(TEST_VALUE_LENGTH_BE_555, BinaryRepresentation.unsigned);
		UnsignedIntegerCodecParameter codecParameter = new UnsignedIntegerCodecParameter(parameter, enc);

		actual = codecParameter.encodeToBitSet(actual, 0);
		assertEquals(actual, TEST_BITSET_VALUE_BE_555);
	}

	@Test
	public final void testByteFullRangeEncode() {
		Parameter<Integer> p = new HummingbirdParameter<Integer>("test.p", "byteGaben", "", "");
		Encoding enc = new Encoding(Byte.SIZE, BinaryRepresentation.twosComplement);
		codec = new UnsignedIntegerCodecParameter(p, enc);

		for (int i = MIN_UNSIGNED_ALL; i <= MAX_UNSIGNED_BYTE; i++) {
			p.setValue(i);
			byte[] value = { (byte) i };
			BitSet expected = BitSetUtility.fromByteArray(value);
			encodeAndAssert(codec, expected);
		}
	}

	@Test
	public final void testShortFullRangeEncode() {
		Parameter<Integer> p = new HummingbirdParameter<Integer>("test.p", "byteGaben", "", "");
		Encoding enc = new Encoding(Short.SIZE, BinaryRepresentation.twosComplement);
		codec = new UnsignedIntegerCodecParameter(p, enc);

		for (int i = MIN_UNSIGNED_ALL; i <= MAX_UNSIGNED_SHORT; i++) {
			p.setValue(i);
			ByteBuffer buffer = ByteBuffer.allocate(2);
			buffer.putShort((short) i);
			BitSet expected = BitSetUtility.fromByteArray(buffer.array());
			encodeAndAssert(codec, expected);
		}
	}

	@Test
	public final void testIntLargeRangeEncode() {
		Parameter<Integer> p = new HummingbirdParameter<Integer>("test.p", "byteGaben", "", "");
		Encoding enc = new Encoding(Integer.SIZE, BinaryRepresentation.twosComplement);
		codec = new UnsignedIntegerCodecParameter(p, enc);

		for (int i = MIN_UNSIGNED_ALL; i <= 120509; i++) {
			p.setValue(i);
			ByteBuffer buffer = ByteBuffer.allocate(4);
			buffer.putInt(i);
			BitSet expected = BitSetUtility.fromByteArray(buffer.array());
			encodeAndAssert(codec, expected);
		}
	}

	@Test
	public final void testLittleEndianShortFullRangeEncode() {
		Parameter<Integer> p = new HummingbirdParameter<Integer>("test.p", "byteGaben", "", "");
		Encoding enc = new Encoding(Short.SIZE, BinaryRepresentation.twosComplement, ByteOrder.LITTLE_ENDIAN);
		codec = new UnsignedIntegerCodecParameter(p, enc);

		for (int i = MIN_UNSIGNED_ALL; i <= MAX_UNSIGNED_SHORT; i++) {
			p.setValue(i);

			// Create little endian version of the short and a little endian version of the short
			// as a BitSet for the assert.
			ByteBuffer buffer = ByteBuffer.allocate(2);
			buffer.putShort((short) i).flip();
			buffer.order(ByteOrder.LITTLE_ENDIAN);
			short littleEndianValue = buffer.getShort();
			ByteBuffer littleEndianBuffer = ByteBuffer.allocate(2);
			littleEndianBuffer.putShort(littleEndianValue);
			BitSet expected = BitSetUtility.fromByteArray(littleEndianBuffer.array());

			encodeAndAssert(codec, expected);
		}
	}

	@Test
	public final void testLittleEndianByteFullRangeEncode() {
		Parameter<Integer> p = new HummingbirdParameter<Integer>("test.p", "byteGaben", "", "");
		Encoding enc = new Encoding(Byte.SIZE, BinaryRepresentation.twosComplement, ByteOrder.LITTLE_ENDIAN);
		codec = new UnsignedIntegerCodecParameter(p, enc);

		for (int i = MIN_UNSIGNED_ALL; i <= MAX_UNSIGNED_BYTE; i++) {
			p.setValue(i);

			LOG.info("Encoding: " + i);

			// Create little endian version of the short and a little endian version of the short
			// as a BitSet for the assert.
			ByteBuffer buffer = ByteBuffer.allocate(1);
			buffer.put((byte) i).flip();
			buffer.order(ByteOrder.LITTLE_ENDIAN);
			byte littleEndianValue = buffer.get();
			ByteBuffer littleEndianBuffer = ByteBuffer.allocate(1);
			littleEndianBuffer.put(littleEndianValue);
			BitSet expected = BitSetUtility.fromByteArray(littleEndianBuffer.array());

			encodeAndAssert(codec, expected);
		}
	}

	private static void encodeAndAssert(CodecParameter<Integer> codec, BitSet expected) {
		BitSet actual = new BitSet();
		codec.encodeToBitSet(actual, 0);
		assertEquals("The codec encoding result should match this bitset: " + expected, expected, actual);
	}
}
