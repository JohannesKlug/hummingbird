package com.logica.hummingbird;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.BitSet;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;
import com.logica.hummingbird.util.BitSetUtility;
import com.logica.hummingbird.util.BitSetUtility.FloatSizeInBits;

/**
 * 
 * @author Mark Doyle
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
	
	
	private final static double ZERO = 0d;
	private final static String ZERO_AS_32BIT_STRING = "00000000000000000000000000000000";
	private final static String ZERO_AS_64BIT_STRING = "0000000000000000000000000000000000000000000000000000000000000000";

	private final static double THREE = 3.0d;
	private final static String THREE_AS_32BIT_STRING = "01000000010000000000000000000000";
	private final static String THREE_AS_64BIT_STRING = "0100000000001000000000000000000000000000000000000000000000000000";

	private final static double PI = 3.14159265d;
	private final static String PI_32BIT_STRING = "01000000010010010000111111011011";
	private final static String PI_64BIT_STRING = "0100000000001001001000011111101101010011110010001101010011110001";
	

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

	@Test
	public void testExtractSignedInteger() {
		BitSet signedIntegerInBitset = new BitSet(4);
		signedIntegerInBitset.set(0, 4);
		Long extractedInteger = BitSetUtility.extractInteger(signedIntegerInBitset, 0, 4, true);

		assertEquals("1111 as a signed Integer should be read as -7.", new Long(-7), extractedInteger);
	}

	@Test
	public void testExtractUnsignedInteger() {
		BitSet unsignedIntegerInBitset = new BitSet(4);
		unsignedIntegerInBitset.set(0, 4);
		Long extractedInteger = BitSetUtility.extractInteger(unsignedIntegerInBitset, 0, 4, false);

		assertEquals("1111 as an unsigned Integer should be read as 15.", new Long(15), extractedInteger);
	}

	@Test
	public void testExtractUnsigned1BitInteger() {
		BitSet unsignedIntegerInBitset = new BitSet(1);
		unsignedIntegerInBitset.set(0);
		Long extractedInteger = BitSetUtility.extractInteger(unsignedIntegerInBitset, 0, 1, false);

		assertEquals("1 as an unsigned Integer should be read as 1.", new Long(1), extractedInteger);

		unsignedIntegerInBitset = new BitSet(1);
		extractedInteger = BitSetUtility.extractInteger(unsignedIntegerInBitset, 0, 1, false);

		assertEquals("0 as an unsigned Integer should be read as 0.", new Long(0), extractedInteger);
	}

	@Ignore
	@Test
	public void testInsertInteger() {
//		BitSet bitSet = BitSetUtility.stringToBitSet(PI_32BIT_STRING);
//		Double actual = BitSetUtility.extractFloat(bitSet, 0, FloatSizeInBits.THIRTY_TWO);
//		System.out.println(actual);
//		assertEquals(PI, actual,0.01);
	}

	@Test
	public void testExtractFloat32() throws BitSetOperationException {
		BitSet bitSet = BitSetUtility.stringToBitSet(PI_32BIT_STRING);
		Double actual = BitSetUtility.extractFloat(bitSet, 0, FloatSizeInBits.THIRTY_TWO);
		System.out.println(actual);
		assertEquals(PI, actual,0.01);
	}

	@Test
	public void testExtractFloat64() throws BitSetOperationException {
		BitSet bitSet = BitSetUtility.stringToBitSet(PI_64BIT_STRING);
		Double actual = BitSetUtility.extractFloat(bitSet, 0, FloatSizeInBits.SIXTY_FOUR);
		System.out.println(actual);
		assertEquals(PI, actual,0.01);
	}

	@Test
	public void testInsertDouble32() throws BitSetOperationException {
		BitSet floatBitSet = new BitSet(0);
		BitSet actual = BitSetUtility.insertFloat(floatBitSet, 0, FloatSizeInBits.THIRTY_TWO, PI);
		
		BitSet expected = BitSetUtility.stringToBitSet(PI_32BIT_STRING);
		
		assertEquals(expected, actual);

	}
	
	@Test
	public void testInsertDouble64() throws BitSetOperationException {
		BitSet floatBitSet = new BitSet(0);
		BitSet actual = BitSetUtility.insertFloat(floatBitSet, 0, FloatSizeInBits.SIXTY_FOUR, PI);
		
		BitSet expected = BitSetUtility.stringToBitSet(PI_64BIT_STRING);
		
		assertEquals(expected, actual);

	}

	/**
	 * Tests if the creation of a BitSet from a valid string.
	 */
	@Test
	public void testFromString() throws BitSetOperationException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Test BitSet = " + TEST_BIT_SET_STR_VALID);
		}

		BitSet actual = BitSetUtility.stringToBitSet(TEST_BIT_SET_STR_VALID);

		if (LOG.isDebugEnabled()) {
			LOG.debug("BitSet created from a string = " + actual);
			LOG.debug(BitSetUtility.binDump(actual));
		}

		assertEquals("BitSet not equal", TEST_BIT_SET, actual);
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
			actual = BitSetUtility.stringToBitSet(TEST_BIT_SET_STR_INVALID);
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
	public void testFloatToBitSet() throws BitSetOperationException {

		// Testing the Float->Integer->BinaryString->Integer->Float chain
		Long longBits = Double.doubleToLongBits(PI);
		String binaryString = Long.toBinaryString(longBits);
		Long longBitsRecovered = Long.parseLong(binaryString, 2);
		assertEquals(longBits, longBitsRecovered);

		double piRecovered = Double.longBitsToDouble(longBitsRecovered);
		assertEquals(PI, piRecovered, 0.0);

		// Testing the actual BitSet conversion functions
		BitSet bitSet = new BitSet();

		bitSet = BitSetUtility.floatToBitSet(FloatSizeInBits.THIRTY_TWO, ZERO);
		assertEquals(BitSetUtility.stringToBitSet(ZERO_AS_32BIT_STRING), bitSet);

		bitSet = BitSetUtility.floatToBitSet(FloatSizeInBits.SIXTY_FOUR, ZERO);
		assertEquals(BitSetUtility.stringToBitSet(ZERO_AS_64BIT_STRING), bitSet);

		bitSet = BitSetUtility.floatToBitSet(FloatSizeInBits.THIRTY_TWO, THREE);
		assertEquals(BitSetUtility.stringToBitSet(THREE_AS_32BIT_STRING), bitSet);

		bitSet = BitSetUtility.floatToBitSet(FloatSizeInBits.SIXTY_FOUR, THREE);
		assertEquals(BitSetUtility.stringToBitSet(THREE_AS_64BIT_STRING), bitSet);

		bitSet = BitSetUtility.floatToBitSet(FloatSizeInBits.THIRTY_TWO, PI);
		assertEquals(BitSetUtility.stringToBitSet(PI_32BIT_STRING), bitSet);

		bitSet = BitSetUtility.floatToBitSet(FloatSizeInBits.SIXTY_FOUR, PI);
		assertEquals(BitSetUtility.stringToBitSet(PI_64BIT_STRING), bitSet);

		// 64bit pi result: 3.1415927410125732421875 → 0x400921FB60000000
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
}
