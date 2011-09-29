package org.hbird.transport.packetcodec.codecparameters.number;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.payloadcodec.codecparameters.number.UnsignedIntegerCodecParameter;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Encoding;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Endianness;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnsignedIntegerCodecParameterTest {
	private final static Logger LOG = LoggerFactory.getLogger(UnsignedIntegerCodecParameterTest.class);

	private final static String TEST_STR_VALUE_LE_555 = "1101010001";
	private final static int TEST_VALUE_LENGTH_LE_555 = 10;
	private static BitSet TEST_BITSET_VALUE_LE_555;

	private final static String TEST_STR_VALUE_BE_555 = "1000101011";
	private final static int TEST_VALUE_LENGTH_BE_555 = 10;
	private static BitSet TEST_BITSET_VALUE_BE_555;

	private final static String TEST_STR_VALUE_BE_1024 = "10000000000";
	private final static String TEST_STR_VALUE_LE_1024 = "00000000001";
	private final static int TEST_VALUE_LENGTH_1024 = 11;
	private static BitSet TEST_BITSET_VALUE_BE_1024;
	private static BitSet TEST_BITSET_VALUE_LE_1024;

	private static final String TEST_STR_VALUE_BE_123_32bit = "00000000000000000000000001111011";
	private static final int TEST_VALUE_LENGTH_BE_123_32bit = 32;
	private static BitSet TEST_BITSET_VALUE_123_32bit;

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
		LOG.debug("Creating LE 555 Bitset");
		TEST_BITSET_VALUE_LE_555 = new BitSet();
		TEST_BITSET_VALUE_LE_555.set(0);
		TEST_BITSET_VALUE_LE_555.set(1);
		TEST_BITSET_VALUE_LE_555.set(3);
		TEST_BITSET_VALUE_LE_555.set(5);
		TEST_BITSET_VALUE_LE_555.set(9);
		assertEquals(TEST_STR_VALUE_LE_555, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_LE_555, true));

		LOG.debug("Creating BE 555 Bitset");
		TEST_BITSET_VALUE_BE_555 = new BitSet();
		TEST_BITSET_VALUE_BE_555.set(0);
		TEST_BITSET_VALUE_BE_555.set(4);
		TEST_BITSET_VALUE_BE_555.set(6);
		TEST_BITSET_VALUE_BE_555.set(8);
		TEST_BITSET_VALUE_BE_555.set(9);
		assertEquals(TEST_STR_VALUE_BE_555, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_555, true));

		TEST_BITSET_VALUE_BE_999 = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_999, true, true);
		assertEquals(TEST_STR_VALUE_BE_999, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_999, true));

		LOG.debug("Creating BE 123 32bit Bitset");
		TEST_BITSET_VALUE_123_32bit = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_123_32bit, true, true);
		assertEquals(TEST_STR_VALUE_BE_123_32bit, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_123_32bit, true));

		LOG.debug("Creating BE 1024 Bitset");
		TEST_BITSET_VALUE_BE_1024 = new BitSet(TEST_VALUE_LENGTH_1024);
		TEST_BITSET_VALUE_BE_1024.set(0);
		assertEquals(TEST_STR_VALUE_BE_1024,
				BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_1024, false).substring(0, TEST_VALUE_LENGTH_1024));

		LOG.debug("Creating LE 1024 Bitset");
		TEST_BITSET_VALUE_LE_1024 = new BitSet(TEST_VALUE_LENGTH_1024);
		TEST_BITSET_VALUE_LE_1024.set(10);
		assertEquals(TEST_STR_VALUE_LE_1024,
				BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_LE_1024, false).substring(0, TEST_VALUE_LENGTH_1024));
		LOG.debug("Test bitsets set-up completed successfully");
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLittleEndianValueFromBitSet() throws InvalidParameterTypeException {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", TEST_VALUE_LENGTH_LE_555, Endianness.LITTLE,
				Encoding.unsigned);
		UnsignedIntegerCodecParameter codec = new UnsignedIntegerCodecParameter(p);
		Number actual = codec.decode(TEST_BITSET_VALUE_LE_555);
		assertEquals(555, actual);
	}

	@Test
	public void testBigEndianValueFromBitSet() throws InvalidParameterTypeException {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", TEST_VALUE_LENGTH_BE_555, Endianness.BIG,
				Encoding.unsigned);
		UnsignedIntegerCodecParameter codec = new UnsignedIntegerCodecParameter(p);
		Number actual = codec.decode(TEST_BITSET_VALUE_BE_555);
		assertEquals(555, actual);
	}

	@Test
	public void testBigEndianBoundaryValueFromBitSet() throws InvalidParameterTypeException {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", TEST_VALUE_LENGTH_1024, Endianness.BIG,
				Encoding.unsigned);
		UnsignedIntegerCodecParameter codec = new UnsignedIntegerCodecParameter(p);
		Number actual = codec.decode(TEST_BITSET_VALUE_BE_1024);
		assertEquals(1024, actual);
	}

	@Test
	public void testLittleEndianBoundaryValueFromBitSet() throws InvalidParameterTypeException {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", TEST_VALUE_LENGTH_1024, Endianness.LITTLE,
				Encoding.unsigned);
		UnsignedIntegerCodecParameter codecParam = new UnsignedIntegerCodecParameter(p);
		Number actual = codecParam.decode(TEST_BITSET_VALUE_LE_1024);
		assertEquals(1024, actual);
	}

	@Test
	public void testZeroByteContainingValueFromBitSet() throws InvalidParameterTypeException {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", TEST_VALUE_LENGTH_BE_123_32bit, Endianness.BIG,
				Encoding.unsigned);
		UnsignedIntegerCodecParameter codecParam = new UnsignedIntegerCodecParameter(p);
		Number actual = codecParam.decode(TEST_BITSET_VALUE_123_32bit);
		assertEquals(123, actual);
	}

	@Test
	public final void testLeadingZeroBE999ValueFromBitSet() throws InvalidParameterTypeException {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", TEST_VALUE_LENGTH_BE_999, Endianness.BIG,
				Encoding.unsigned);
		UnsignedIntegerCodecParameter behaviour = new UnsignedIntegerCodecParameter(p);
		Number actual = behaviour.decode(TEST_BITSET_VALUE_BE_999);
		assertEquals(999, actual);
	}

	//
	// @Test
	// public final void testInsertIntoBitSetBE555() throws BitSetOperationException, InvalidParameterTypeException {
	// LOG.info("###################### Beginning test #######################");
	// BitSet actual = new BitSet();
	// UnsignedIntegerCodecParameter behaviour = new UnsignedIntegerCodecParameter(TEST_VALUE_LENGTH_BE_555, true);
	// actual = behaviour.insertIntoBitSet(555, actual, 0);
	// assertEquals(actual, TEST_BITSET_VALUE_BE_555);
	// }
	//
	// @Test
	// public final void testInsertIntoBitSetLE555() throws BitSetOperationException, InvalidParameterTypeException {
	// LOG.info("###################### Beginning test #######################");
	// BitSet actual = new BitSet();
	// UnsignedIntegerCodecParameter behaviour = new UnsignedIntegerCodecParameter(TEST_VALUE_LENGTH_LE_555, false);
	// actual = behaviour.insertIntoBitSet(555, actual, 0);
	// assertEquals(actual, TEST_BITSET_VALUE_LE_555);
	// }
}
