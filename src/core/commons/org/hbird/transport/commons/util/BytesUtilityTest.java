package org.hbird.core.commons.util;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.commons.util.BytesUtility;

/**
 * ACRONYMS USED:
 * BE = Big Endian
 * LE = Little Endian
 *
 * @author Johannes Klug
 * @author Mark Doyle
 *
 */
public class BytesUtilityTest {
	private final static Logger LOG = LoggerFactory.getLogger(BytesUtilityTest.class);

	private final static String TEST_STR_VALUE_BE_555 = "1000101011";
	private static BitSet TEST_BITSET_VALUE_BE_555 = new BitSet();
	private static byte[] BYTE_ARRAY_555_10bit;
	private static byte[] BYTE_ARRAY_555_32bit;

	private final static String TEST_STR_VALUE_BE_NEG_28895 = "1000111100100001";
	private static BitSet TEST_BITSET_VALUE_BE_NEG_28895 = new BitSet();
	private static byte[] BYTE_ARRAY_NEG_28895_16bit;

	// 2147483647
	private final static String TEST_STR_VALUE_BE_MAX_32bit = "01111111111111111111111111111111";
	private static BitSet TEST_BITSET_VALUE_BE_MAX_32bit = new BitSet();
	private static byte[] BYTE_ARRAY_BE_MAX_32bit;
	
	private final static String TEST_STR_VALUE_BE_MIN_32bit = "10000000000000000000000000000000";
	private static BitSet TEST_BITSET_VALUE_BE_MIN_32bit = new BitSet();
	private static byte[] BYTE_ARRAY_BE_MIN_32bit;
	
	private final static String TEST_STR_VALUE_BE_NEG_127_8bit = "10000001";
	private static BitSet TEST_BITSET_VALUE_BE_NEG_127_8bit = new BitSet();
	private static byte[] BYTE_ARRAY_BE_NEG_127_8bit;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.debug("Setting up test bitsets....");

		// Set up the BE 555 bitset
		TEST_BITSET_VALUE_BE_555 = new BitSet();
		TEST_BITSET_VALUE_BE_555.set(0);
		TEST_BITSET_VALUE_BE_555.set(4);
		TEST_BITSET_VALUE_BE_555.set(6);
		TEST_BITSET_VALUE_BE_555.set(8);
		TEST_BITSET_VALUE_BE_555.set(9);
		assertEquals(TEST_STR_VALUE_BE_555, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_555, true));

		// Set-up the 555 10bit int byte array
		BYTE_ARRAY_555_10bit = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_555, 10);
		LOG.info("Decimal dump of 10bit 555 array = " + BytesUtility.decimalDump(BYTE_ARRAY_555_10bit));

		// Set-up the 555 32bit int byte array
		BYTE_ARRAY_555_32bit = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_555, 32);
		LOG.debug("Decimal dump of 32bit 555 array = " + BytesUtility.decimalDump(BYTE_ARRAY_555_32bit));

		// Set-up BE -28895 bitset
		TEST_BITSET_VALUE_BE_NEG_28895 = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_NEG_28895, true, true);

		// Set-up the BE -28895 16bit int byte array
		BYTE_ARRAY_NEG_28895_16bit = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_NEG_28895, 16);
		LOG.debug("Decimal dump of 32bit -28895 array = " + BytesUtility.decimalDump(BYTE_ARRAY_NEG_28895_16bit));

		// Set-up the MAX (2147483647) BE 32 bit int (signed in this case) and the corresponding byte arrays.
		TEST_BITSET_VALUE_BE_MAX_32bit = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_MAX_32bit, true, true);
		BYTE_ARRAY_BE_MAX_32bit = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_MAX_32bit, 32);
		LOG.debug("Decimal dump of Max 32bit array = " + BytesUtility.decimalDump(BYTE_ARRAY_BE_MAX_32bit));
		
		// Set-up the MIN (-2147483648) BE 32 bit int (signed in this case) and the corresponding byte arrays.
		TEST_BITSET_VALUE_BE_MIN_32bit = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_MIN_32bit, true, true);
		BYTE_ARRAY_BE_MIN_32bit = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_MIN_32bit, 32);
		LOG.debug("Decimal dump of Min 32bit array = " + BytesUtility.decimalDump(BYTE_ARRAY_BE_MIN_32bit));
		
		// Set-up the -127 8bit int (signed in this case) and the corresponding byte arrays.
		TEST_BITSET_VALUE_BE_NEG_127_8bit = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_NEG_127_8bit, true, true);
		BYTE_ARRAY_BE_NEG_127_8bit = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_NEG_127_8bit, 32);
		LOG.debug("Decimal dump of -127 8bit array = " + BytesUtility.decimalDump(BYTE_ARRAY_BE_NEG_127_8bit));
	}

	@Test
	public void testCombineSimple() {
		int actual = BytesUtility.combine(BYTE_ARRAY_555_10bit, 10).intValue();
		assertEquals(555, actual);
	}

	@Test
	public void testCombine32bit() {
		int actual = BytesUtility.combine(BYTE_ARRAY_555_32bit, 10).intValue();
		LOG.debug("Expected = 0000000000000000000000" + TEST_STR_VALUE_BE_555); // 32bit rep (intValue) of 10 bit int
		LOG.debug("Actual = " + Integer.toBinaryString(actual));
		assertEquals(555, actual);
	}

	@Test
	public void testCombine32bitBoundarys() {
		short actual = (short) BytesUtility.combine(BYTE_ARRAY_NEG_28895_16bit, 16).shortValue();
		LOG.debug("Expected = " + TEST_STR_VALUE_BE_NEG_28895);
		LOG.debug("Actual = " + Integer.toBinaryString(actual).substring(16)); //yeah,there's probably a better way to handle short to bin str.TEST_STR_VALUE_BE_555
		assertEquals(-28895, actual);
	}
	
	@Test
	public void testCombineMax32bit() {
		int actual = BytesUtility.combine(BYTE_ARRAY_BE_MAX_32bit, 32).intValue();
		LOG.debug("Expected = " + TEST_STR_VALUE_BE_MAX_32bit);
		LOG.debug("Actual = 0" + Integer.toBinaryString(actual)); // toBinaryStirng cuts off the first zero if positive.
		assertEquals(2147483647, actual);
	}

	@Test
	public void testCombineMin32bit() {
		int actual = BytesUtility.combine(BYTE_ARRAY_BE_MIN_32bit, 32).intValue();
		LOG.debug("Expected = " + TEST_STR_VALUE_BE_MIN_32bit);
		LOG.debug("Actual = " + Integer.toBinaryString(actual)); // toBinaryStirng cuts off the first zero if positive.
		assertEquals(-2147483648, actual);
	}
	
	@Test
	public void testCombine8bitBoundary() {
		byte actual = (byte) BytesUtility.combine(BYTE_ARRAY_BE_NEG_127_8bit, 8).byteValue();
		LOG.debug("Expected = " + TEST_STR_VALUE_BE_NEG_127_8bit);
		LOG.debug("Actual = " + Integer.toBinaryString(actual).substring(24)); // toBinaryStirng cuts off the first zero if positive.
		assertEquals(-127, actual);
	}
}
