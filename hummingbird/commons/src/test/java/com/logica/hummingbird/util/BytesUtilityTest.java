package com.logica.hummingbird.util;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.util.BitSetUtility;
import com.logica.hummingbird.util.BytesUtility;

public class BytesUtilityTest {
	private final static Logger LOG = LoggerFactory.getLogger(BytesUtilityTest.class);

	private final static String TEST_STR_VALUE_BE_555 = "1000101011";
	private static BitSet TEST_BITSET_VALUE_BE_555 = new BitSet();
	private static byte[] BYTE_ARRAY_555_10bit;
	private static byte[] BYTE_ARRAY_555_32bit;
	private static byte[] BYTE_ARRAY_NEG_28895_16bit;
	
	private final static String TEST_STR_VALUE_BE_NEG_28895 = "1000111100100001";
	private static BitSet TEST_BITSET_VALUE_BE_NEG_28895 = new BitSet();

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.debug("Setting up test bitsets....");
		
		TEST_BITSET_VALUE_BE_555 = new BitSet();
		TEST_BITSET_VALUE_BE_555.set(0);
		TEST_BITSET_VALUE_BE_555.set(4);
		TEST_BITSET_VALUE_BE_555.set(6);
		TEST_BITSET_VALUE_BE_555.set(8);
		TEST_BITSET_VALUE_BE_555.set(9);
		assertEquals(TEST_STR_VALUE_BE_555, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_555, true));
		
		BYTE_ARRAY_555_10bit = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_555, 10);
		LOG.info("Decimal dump of 10bit 555 array = " + BytesUtility.decimalDump(BYTE_ARRAY_555_10bit));
		BYTE_ARRAY_555_32bit = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_555, 32);
		LOG.debug("Decimal dump of 32bit 555 array = " + BytesUtility.decimalDump(BYTE_ARRAY_555_32bit));
		
		TEST_BITSET_VALUE_BE_NEG_28895 = BitSetUtility.stringToBitSet(TEST_STR_VALUE_BE_NEG_28895, true, true);
		
		BYTE_ARRAY_NEG_28895_16bit = BitSetUtility.toByteArray(TEST_BITSET_VALUE_BE_NEG_28895, 16);
		LOG.debug("Decimal dump of 32bit -28895 array = " + BytesUtility.decimalDump(BYTE_ARRAY_NEG_28895_16bit));
		
		
		
	}
	
	@Test
	public void testCombineSimple() {
		int actual = BytesUtility.combine(BYTE_ARRAY_555_10bit, 10);
		assertEquals(555, actual);
	}
	
	@Test
	public void testCombine32bit() {
		int actual = BytesUtility.combine(BYTE_ARRAY_555_32bit, 10);
		assertEquals(555, actual);
	}
	
	@Test
	public void testCombine32bitBoundary() {
		short actual = (short) BytesUtility.combine(BYTE_ARRAY_NEG_28895_16bit, 16);
		LOG.debug("Expected = 1000111100100001");
		LOG.debug("Actual = " + Integer.toBinaryString(actual));
		assertEquals(-28895, actual);
	}
	

}
