package org.hbird.transport.commons.util;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitSetUtilityTest {
	private static final Logger LOG = LoggerFactory.getLogger(BitSetUtilityTest.class);

	private static final String BIT_STR_BE_123 = "1111011";
	private static BitSet BITSET_BE_123;

	private static final String BIT_STR_LE_123 = "1101111";
	private static BitSet BITSET_LE_123;

	private static final String BIT_STR_BE_999 = "01111100111";
	private static BitSet BITSET_BE_999;

	private static final String BIT_STR_LE_999 = "11100111110";
	private static BitSet BITSET_LE_999;

	private static final String BIT_STR_BE_69BIT = "110000000000000000000000000000000000000000000000000000000000000000001";
	private static BitSet BITSET_BE_69BIT;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.info("############ Setting up before all tests #################");
		BITSET_BE_123 = new BitSet(BIT_STR_BE_123.length());
		BITSET_BE_123.set(0, 4);
		BITSET_BE_123.set(5, 7);
		assertEquals(BIT_STR_BE_123, BitSetUtility.bitSetToBinaryString(BITSET_BE_123, true));

		BITSET_LE_123 = new BitSet(BIT_STR_LE_123.length());
		BITSET_LE_123.set(0, 2);
		BITSET_LE_123.set(3, 7);
		assertEquals(BIT_STR_LE_123, BitSetUtility.bitSetToBinaryString(BITSET_LE_123, true));

		BITSET_BE_999 = new BitSet(BIT_STR_BE_999.length());
		BITSET_BE_999.set(1, 6);
		BITSET_BE_999.set(8, 11);
		assertEquals(BIT_STR_BE_999, BitSetUtility.bitSetToBinaryString(BITSET_BE_999, true));

		BITSET_LE_999 = new BitSet(BIT_STR_LE_999.length());
		BITSET_LE_999.set(0, 3);
		BITSET_LE_999.set(5, 10);
		assertEquals(BIT_STR_LE_999, BitSetUtility.bitSetToBinaryString(BITSET_LE_999, BIT_STR_LE_999.length()));

		BITSET_BE_69BIT = new BitSet(BIT_STR_BE_69BIT.length());
		BITSET_BE_69BIT.set(0, 2);
		BITSET_BE_69BIT.set(68);
		assertEquals(BIT_STR_BE_69BIT, BitSetUtility.bitSetToBinaryString(BITSET_BE_69BIT, BIT_STR_BE_69BIT.length()));
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testStringToBitSetBE69BIT() throws BitSetOperationException {
		LOG.info("############ Starting test #################");
		BitSet actual = BitSetUtility.stringToBitSet(BIT_STR_BE_69BIT, true, true);
		assertEquals(BITSET_BE_69BIT, actual);
	}

	@Test
	public final void testStringToBitSetBE123() throws BitSetOperationException {
		BitSet actual = BitSetUtility.stringToBitSet(BIT_STR_BE_123, true, true);
		assertEquals(BITSET_BE_123, actual);
	}

	@Test
	public final void testStringToBitSetLE123() throws BitSetOperationException {
		BitSet actual = BitSetUtility.stringToBitSet(BIT_STR_LE_123, false, false);
		assertEquals(BITSET_LE_123, actual);
	}


	@Test
	public final void testStringToBitSetBE999() throws BitSetOperationException {
		LOG.debug("############ Starting test #################");
		BitSet actual = BitSetUtility.stringToBitSet(BIT_STR_BE_999, true, true);
		assertEquals(BITSET_BE_999, actual);
	}

	@Test
	public final void testStringToBitSetLE999() throws BitSetOperationException {
		LOG.debug("############ Starting test #################");
		BitSet actual = BitSetUtility.stringToBitSet(BIT_STR_LE_999, false, false);
		assertEquals(BITSET_LE_999, actual);
	}

	@Test
	public final void testBitSetToBinaryStringFixedSize() {
		LOG.debug("############ Starting test #################");
		String actual = BitSetUtility.bitSetToBinaryString(BITSET_BE_123, 1);
		assertEquals(BIT_STR_BE_123.subSequence(0, 1), actual);

		actual = BitSetUtility.bitSetToBinaryString(BITSET_BE_123, 5);
		assertEquals(BIT_STR_BE_123.subSequence(0, 5), actual);

		actual = BitSetUtility.bitSetToBinaryString(BITSET_BE_123, 7);
		assertEquals(BIT_STR_BE_123, actual);
	}

	@Test
	public final void testPadStringFromTheBack() {
		LOG.debug("############ Starting test #################");
		String actual = BitSetUtility.padStringFromTheBack(BIT_STR_BE_123, 25);
		assertEquals(25, actual.length());
		StringBuilder expected = new StringBuilder();
		expected.append(BIT_STR_BE_123);
		expected.append("000000000000000000");
		assertEquals(expected.toString(), actual);
	}

}
