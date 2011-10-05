package org.hbird.transport.payloadcodec.codecparameters.number;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Encoding;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnsignedIntegerCodecParameterTest {
	private final static Logger LOG = LoggerFactory.getLogger(UnsignedIntegerCodecParameterTest.class);

	private final static String TEST_STR_VALUE_BE_555 = "1000101011";
	private final static int TEST_VALUE_LENGTH_BE_555 = 10;
	private static BitSet TEST_BITSET_VALUE_BE_555;
	
	private final static String TEST_STR_VALUE_BE_1024 = "10000000000";
	private final static int TEST_VALUE_LENGTH_1024 = 11;
	private static BitSet TEST_BITSET_VALUE_BE_1024;

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
		assertEquals(TEST_STR_VALUE_BE_1024, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_1024, false).substring(0, TEST_VALUE_LENGTH_1024));

		LOG.debug("Test bitsets set-up completed successfully");
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBigEndianValueFromBitSet() throws InvalidParameterTypeException {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", TEST_VALUE_LENGTH_BE_555, Encoding.unsigned);
		UnsignedIntegerCodecParameter codec = new UnsignedIntegerCodecParameter(p);
		codec.decode(TEST_BITSET_VALUE_BE_555, 0);
		assertEquals(555, codec.getValue().intValue());
	}

	@Test
	public void testBigEndianBoundaryValueFromBitSet() throws InvalidParameterTypeException {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", TEST_VALUE_LENGTH_1024, Encoding.unsigned);
		UnsignedIntegerCodecParameter codec = new UnsignedIntegerCodecParameter(p);
		codec.decode(TEST_BITSET_VALUE_BE_1024, 0);
		assertEquals(1024, codec.getValue().intValue());
	}


	@Test
	public void testZeroByteContainingValueFromBitSet() throws InvalidParameterTypeException {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", TEST_VALUE_LENGTH_BE_123_32bit, Encoding.unsigned);
		UnsignedIntegerCodecParameter codecParam = new UnsignedIntegerCodecParameter(p);
		codecParam.decode(TEST_BITSET_VALUE_123_32bit, 0);
		assertEquals(123, codecParam.getValue().intValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testLeadingZeroBE999ValueFromBitSet() throws InvalidParameterTypeException {
		LOG.info("###################### Beginning test #######################");
		Parameter<Integer> p = new HummingbirdParameter<Integer>("", "", "", TEST_VALUE_LENGTH_BE_999, Encoding.unsigned);
		UnsignedIntegerCodecParameter behaviour = new UnsignedIntegerCodecParameter(p);
		behaviour.decode(TEST_BITSET_VALUE_BE_999, 0);
		assertEquals(999, behaviour.getValue().intValue());
	}

	@SuppressWarnings("static-method")
	@Test
	public final void testInsertIntoBitSetBE555() {
		LOG.info("###################### Beginning test #######################");
		BitSet actual = new BitSet();
		
		Parameter<Integer> parameter = new HummingbirdParameter<Integer>("", "", "", TEST_VALUE_LENGTH_BE_555, Encoding.unsigned);
		parameter.setValue(555);
		UnsignedIntegerCodecParameter codecParameter = new UnsignedIntegerCodecParameter(parameter);
		
		actual = codecParameter.encodeToBitSet(actual, 0);
		assertEquals(actual, TEST_BITSET_VALUE_BE_555);
		
		System.out.println(BitSetUtility.binDump(TEST_BITSET_VALUE_BE_555));
		System.out.println(BitSetUtility.binDump(actual));
	}
	
	//
	// @Test
	// public final void testInsertIntoBitSetLE555() throws
	// BitSetOperationException, InvalidParameterTypeException {
	// LOG.info("###################### Beginning test #######################");
	// BitSet actual = new BitSet();
	// UnsignedIntegerCodecParameter behaviour = new
	// UnsignedIntegerCodecParameter(TEST_VALUE_LENGTH_LE_555, false);
	// actual = behaviour.insertIntoBitSet(555, actual, 0);
	// assertEquals(actual, TEST_BITSET_VALUE_LE_555);
	// }
}
