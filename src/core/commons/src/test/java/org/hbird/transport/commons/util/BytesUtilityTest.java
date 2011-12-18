package org.hbird.transport.commons.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.BitSet;

import org.hbird.core.commons.util.BitSetUtility;
import org.hbird.core.commons.util.BytesUtility;
import org.hbird.core.commons.util.exceptions.InvalidBinaryStringException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BytesUtilityTest {
	private static final Logger LOG = LoggerFactory.getLogger(BytesUtilityTest.class);

	private final static String TEST_STR_VALUE_BE_180NEG_16BIT = "1111111101001100";
	private final static int TEST_VALUE_LENGTH_BE_180NEG_16BIT = 16;
	private static BitSet TEST_BITSET_VALUE_BE_180NEG_16BIT;
	private static byte[] BYTES_180NEG_16BIT;

	private final static String TEST_STR_VALUE_BE_180NEG_32BIT = "11111111111111111111111101001100";
	private final static int TEST_VALUE_LENGTH_BE_180NEG_32BIT = 32;
	private static BitSet TEST_BITSET_VALUE_BE_180NEG_32BIT;
	private static byte[] BYTES_180NEG_32BIT;

	private final static String TEST_STR_VALUE_BE_64NEG_8BIT = "11000000";
	private final static int TEST_VALUE_LENGTH_BE_64NEG_8BIT = 8;
	private static BitSet TEST_BITSET_VALUE_BE_64NEG_8BIT;
	private static byte[] BYTES_64NEG_8BIT;

	private final static String TEST_STR_VALUE_BE_19BIT = "0111100000101101000";
	private final static int TEST_VALUE_LENGTH_BE_19BIT = 19;
	private static BitSet TEST_BITSET_VALUE_BE_19BIT;
	private static byte[] BYTES_19BIT;

	private final static String TEST_STR_VALUE_BE_UNSIGNED_CHAR_154 = "10011010";
	private final static int TEST_VALUE_LENGTH_BE_UNSIGNED_CHAR_154 = 8;
	private static BitSet TEST_BITSET_VALUE_BE_UNSIGNED_CHAR_154;
	private static byte[] BYTES_UNSIGNED_CHAR_154;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.debug("########### Creating BE -180  ##########");
		TEST_BITSET_VALUE_BE_180NEG_16BIT = new BitSet(TEST_VALUE_LENGTH_BE_180NEG_16BIT);
		TEST_BITSET_VALUE_BE_180NEG_16BIT = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_180NEG_16BIT, true, true);
		assertEquals(TEST_STR_VALUE_BE_180NEG_16BIT, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_180NEG_16BIT, TEST_VALUE_LENGTH_BE_180NEG_16BIT));
		BYTES_180NEG_16BIT = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_180NEG_16BIT, TEST_VALUE_LENGTH_BE_180NEG_16BIT);
		LOG.debug(BytesUtility.decimalDump(BYTES_180NEG_16BIT));

		LOG.debug("########### Creating BE -180 32bit  ##########");
		TEST_BITSET_VALUE_BE_180NEG_32BIT = new BitSet(TEST_VALUE_LENGTH_BE_180NEG_32BIT);
		TEST_BITSET_VALUE_BE_180NEG_32BIT = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_180NEG_32BIT, true, true);
		assertEquals(TEST_STR_VALUE_BE_180NEG_32BIT, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_180NEG_32BIT, TEST_VALUE_LENGTH_BE_180NEG_32BIT));
		BYTES_180NEG_32BIT = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_180NEG_32BIT, TEST_VALUE_LENGTH_BE_180NEG_32BIT);
		LOG.debug(BytesUtility.decimalDump(BYTES_180NEG_32BIT));

		LOG.debug("########### Creating BE -64 8 bit  ##########");
		TEST_BITSET_VALUE_BE_64NEG_8BIT = new BitSet(TEST_VALUE_LENGTH_BE_64NEG_8BIT);
		TEST_BITSET_VALUE_BE_64NEG_8BIT = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_64NEG_8BIT, true, true);
		assertEquals(TEST_STR_VALUE_BE_64NEG_8BIT, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_64NEG_8BIT, TEST_VALUE_LENGTH_BE_64NEG_8BIT));
		BYTES_64NEG_8BIT = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_64NEG_8BIT, TEST_VALUE_LENGTH_BE_64NEG_8BIT);
		LOG.debug(BytesUtility.decimalDump(BYTES_64NEG_8BIT));

		LOG.debug("########### Creating BE 246120 18bit  ##########");
		TEST_BITSET_VALUE_BE_19BIT = new BitSet(TEST_VALUE_LENGTH_BE_19BIT);
		TEST_BITSET_VALUE_BE_19BIT = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_19BIT, true, true);
		assertEquals(TEST_STR_VALUE_BE_19BIT, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_19BIT, TEST_VALUE_LENGTH_BE_19BIT));
		BYTES_19BIT = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_19BIT, TEST_VALUE_LENGTH_BE_19BIT);
		LOG.debug(BytesUtility.decimalDump(BYTES_19BIT));

		LOG.debug("########### Creating 154 Unsigned char ##########");
		TEST_BITSET_VALUE_BE_UNSIGNED_CHAR_154 = new BitSet(TEST_VALUE_LENGTH_BE_UNSIGNED_CHAR_154);
		TEST_BITSET_VALUE_BE_UNSIGNED_CHAR_154 = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_UNSIGNED_CHAR_154, true, true);
		assertEquals(TEST_STR_VALUE_BE_UNSIGNED_CHAR_154,
				BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_UNSIGNED_CHAR_154, TEST_VALUE_LENGTH_BE_UNSIGNED_CHAR_154));
		BYTES_UNSIGNED_CHAR_154 = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_UNSIGNED_CHAR_154, TEST_VALUE_LENGTH_BE_UNSIGNED_CHAR_154);
		LOG.debug(BytesUtility.decimalDump(BYTES_UNSIGNED_CHAR_154));
	}

	@Test
	public void testCombine16() {
		Number result = BytesUtility.combine(BYTES_180NEG_16BIT, TEST_VALUE_LENGTH_BE_180NEG_16BIT, true);
		assertEquals(-180, result.intValue());
		assertEquals(-180, result.longValue());
	}

	@Test
	public void testCombine32() {
		Number result = BytesUtility.combine(BYTES_180NEG_32BIT, TEST_VALUE_LENGTH_BE_180NEG_32BIT, true);
		assertEquals(-180, result.intValue());
		assertEquals(-180, result.longValue());
	}


	@Test
	public void testCombine8() {
		Number result = BytesUtility.combine(BYTES_64NEG_8BIT, TEST_VALUE_LENGTH_BE_64NEG_8BIT, true);
		assertEquals(-64, result.shortValue());
		assertEquals(-64, result.intValue());
		assertEquals(-64, result.longValue());
	}

	@Test
	public void testCombinePositive() {
		Number result = BytesUtility.combine(BYTES_19BIT, TEST_VALUE_LENGTH_BE_19BIT, true);
		assertEquals(246120, result.intValue());
		assertEquals(246120, result.longValue());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTooLargeNumber() {
		byte[] bytes = new byte[10];
		BytesUtility.combine(bytes, 80, true);
	}

	@Test
	public void testCombineUChar() {
		Number result = BytesUtility.combine(BYTES_UNSIGNED_CHAR_154, TEST_VALUE_LENGTH_BE_UNSIGNED_CHAR_154, false);
		assertEquals(154, result.shortValue());
		assertEquals(154, result.intValue());
		assertEquals(154, result.longValue());
	}
	
	@Test
	public void testByteFromBinaryString() throws InvalidBinaryStringException {
		String zero = "00000000";
		String ff = "11111111";
		String zeroff = zero + ff;
		
		assertEquals((byte) 0x00, BytesUtility.binaryStringToByteArray(zero)[0]);
		assertEquals((byte) 0xFF & 0xFF, BytesUtility.binaryStringToByteArray(ff)[0] & 0xFF);
		assertEquals((byte) 0x00, BytesUtility.binaryStringToByteArray(zeroff)[0]);
		assertEquals((byte) 0xFF & 0xFF, BytesUtility.binaryStringToByteArray(zeroff)[1] & 0xFF);
	}
	
	@Test(expected = InvalidBinaryStringException.class)
	public void testByteFromBinaryStringWithMalformedString() throws InvalidBinaryStringException {
		BytesUtility.binaryStringToByteArray("0");
		fail();
	}

}
