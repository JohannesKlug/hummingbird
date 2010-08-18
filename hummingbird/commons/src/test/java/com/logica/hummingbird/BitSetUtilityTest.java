package com.logica.hummingbird;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.BitSet;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.util.BitSetUtility;
import com.logica.hummingbird.util.exceptions.BitSetOperationException;

/**
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class BitSetUtilityTest {
	/**
	 * Logger for this class.
	 */
	private final static Logger LOG = LoggerFactory.getLogger(BitSetUtilityTest.class);

	/**
	 * Test BitSet. Initialised once for all tests in the @BeforeClass method.
	 */
	private static final BitSet TEST_BIT_SET = new BitSet(128);

	/**
	 * Test BitSet encoded as a String. Bits 0, 1, 3, 5, 9, 11, 12, 14, 15, 16, 17 are set. Initialised once for all
	 * tests in the @BeforeClass method.
	 */
	private static String TEST_BIT_SET_STR_VALID = new String();

	/**
	 * Test BitSet encoded with an invalid String. Will contain characters other than 1 or 0. Initialised once for all
	 * tests in the @BeforeClass method.
	 */
	private static String TEST_BIT_SET_STR_INVALID = new String();
	
	
//	TEST DATA FOR REMOVED TESTS -  CAN EVENTUALLY BE REMOVED.
//	private final static double ZERO = 0d;
//	private final static String ZERO_AS_32BIT_STRING = "00000000000000000000000000000000";
//	private final static String ZERO_AS_64BIT_STRING = "0000000000000000000000000000000000000000000000000000000000000000";
//
//	private final static double THREE = 3.0d;
//	private final static String THREE_AS_32BIT_STRING = "01000000010000000000000000000000";
//	private final static String THREE_AS_64BIT_STRING = "0100000000001000000000000000000000000000000000000000000000000000";
//
//	private final static double PI = 3.14159265d;
//	private final static String PI_32BIT_STRING = "01000000010010010000111111011011";
//	private final static String PI_64BIT_STRING = "0100000000001001001000011111101101010011110010001101010011110001";
//	
//	private final static double MINUS_FIFTYFOUR_SEVENEIGHT = -54.78;
//	private final static String MINUS_FIFTYFOR_SEVENEIGHT_32BIT_STRING = "11000010010110110001111010111000";
//	private final static String MINUS_FIFTYFOR_SEVENEIGHT_64BIT_STRING= "1100000001001011011000111101011100001010001111010111000010100100";
	

	/**
	 * Sets up the Test BitSet and configures the test bit set string.
	 */
	@BeforeClass
	public final static void setUp() {
		// Create the test bit set as a BitSet and a String.
		// The test bit set has the following indexes in the set state, that is, set to 1 {0, 1, 3, 5, 9, 11, 12, 14,
		// 15, 16, 17}
		TEST_BIT_SET.flip(0);
		TEST_BIT_SET.flip(1);
		TEST_BIT_SET.flip(3);
		TEST_BIT_SET.flip(5);
		TEST_BIT_SET.flip(9);
		TEST_BIT_SET.flip(11);
		TEST_BIT_SET.flip(12);
		TEST_BIT_SET.flip(14);
		TEST_BIT_SET.flip(15);
		TEST_BIT_SET.flip(16);
		TEST_BIT_SET.flip(17);

		TEST_BIT_SET_STR_VALID = "11010100010110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		TEST_BIT_SET_STR_INVALID = "11015100010110111150000000900000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
	}

	/**
	 * Tests if the creation of a BitSet from a valid string.
	 */
	@Test
	public void testFromString() throws BitSetOperationException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Test BitSet = " + TEST_BIT_SET_STR_VALID);
		}

		BitSet actual = BitSetUtility.stringToBitSet(TEST_BIT_SET_STR_VALID, true, true);

		if (LOG.isDebugEnabled()) {
			LOG.debug("BitSet created from a string = " + actual);
			LOG.debug(BitSetUtility.binDump(actual));
		}

		assertEquals("BitSet not equal", TEST_BIT_SET, actual);
	}
	
	/**
	 * Tests from big endian to big endian
	 * @throws BitSetOperationException 
	 */
	@Test
	public void testStringToBitSetBigEndianToBigEndian() throws BitSetOperationException {
		String string = "10";
		
		BitSet resultBitSet = BitSetUtility.stringToBitSet(string, true, true);
		
		BitSetUtility.binDump(resultBitSet);
		
		assertTrue(resultBitSet.get(0));
		assertFalse(resultBitSet.get(1));
		
	}
	
	/**
	 * Tests from little endian to big endian
	 * @throws BitSetOperationException 
	 */
	@Test
	public void testStringToBitSetLittleEndianToBigEndian() throws BitSetOperationException {
		String string = "01";
		
		BitSet resultBitSet = BitSetUtility.stringToBitSet(string, false, true);
		
		BitSetUtility.binDump(resultBitSet);
		
		assertTrue(resultBitSet.get(0));
		assertFalse(resultBitSet.get(1));
		
	}
	
	/**
	 * Tests from big endian to little endian
	 * @throws BitSetOperationException 
	 */
	@Test
	public void testStringToBitSetBigEndianToLittleEndian() throws BitSetOperationException {
		String string = "10";
		
		BitSet resultBitSet = BitSetUtility.stringToBitSet(string, true, false);
		
		BitSetUtility.binDump(resultBitSet);
		
		assertTrue(resultBitSet.get(62));
		assertFalse(resultBitSet.get(63));
		
	}
	
	/**
	 * Tests from little endian to little endian
	 * @throws BitSetOperationException 
	 */
	@Test
	public void testStringToBitSetLittleEndianToLittleEndian() throws BitSetOperationException {
		String string = "01";
		
		BitSet resultBitSet = BitSetUtility.stringToBitSet(string, true, false);
		
		BitSetUtility.binDump(resultBitSet);
		
		assertTrue(resultBitSet.get(63));
		assertFalse(resultBitSet.get(62));
		
	}

	/**
	 * Tests the creation of a BitSet from an illegal String is not possible.
	 */
	@Test
	public void testFromStringError() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Test BitSet = " + TEST_BIT_SET_STR_INVALID);
		}

		BitSet actual = null;
		try {
			actual = BitSetUtility.stringToBitSet(TEST_BIT_SET_STR_INVALID, true, true);
		}
		catch (BitSetOperationException e) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Exception thrown as expected");
			}
			return;
		}

		fail("BitSetOperationException exception was not thrown for " + TEST_BIT_SET_STR_INVALID + ". BitSetUtility.fromString created " + actual);
	}
	
	@Test
	public void testBitSetToBinaryString() {
		BitSet data = new BitSet();
		data.set(0);
		data.set(1);
		data.set(5);
		
		String binaryString = BitSetUtility.bitSetToBinaryString(data, false);
		
		String expected = "1100010000000000000000000000000000000000000000000000000000000000";
		
		assertEquals(expected, binaryString);
	}
	
	@Test
	public void testBitSetToBinaryString2() {
		String result = BitSetUtility.bitSetToBinaryString(TEST_BIT_SET, false);
		result = BitSetUtility.padStringFromTheFront(result, 129);
		String expected = "0" + TEST_BIT_SET_STR_VALID;
		assertEquals(129, result.length());
		assertEquals("Strings expected to be equal", expected, result);
		
		result = BitSetUtility.bitSetToBinaryString(TEST_BIT_SET, false);
		assertEquals("Strings expected to be equal", TEST_BIT_SET_STR_VALID, result);
	}
	
	@Test
	public void testToInt() {
		BitSet bits = new BitSet();
		assertEquals(0, BitSetUtility.toInt(bits));
		
		bits.set(31);
		assertEquals(1, BitSetUtility.toInt(bits));
		
		bits.set(0);
		assertEquals(-2147483647, BitSetUtility.toInt(bits));
	}
	
	@Test
	public void testToLong() {
		BitSet bits = new BitSet();
		assertEquals(0, BitSetUtility.toLong(bits));
		
		bits.set(63);
		assertEquals(1, BitSetUtility.toLong(bits));
		
		bits.set(0);
		assertEquals(-9223372036854775807l, BitSetUtility.toLong(bits));
	}
	
	
	@Test
	public void testToByteArrayZero() {
		BitSet bitSet = new BitSet();
		
		byte[] bytes = BitSetUtility.toByteArray(bitSet, 8);
		assertEquals(0, bytes[0]);
	}
	
	
	
}
