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
import com.logica.hummingbird.spacesystemmodel.parameters.FloatParameter;
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
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testExtractFloat() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testInsertDouble() {
		BitSet floatBitSet = new BitSet(0);
//		BitSetUtility.insertFloat(floatBitSet, 0, 64, FloatSizeInBits.SIXTY_FOUR, value);
		fail("Not yet implemented");
	}

	/**
	 * Tests if the creation of a BitSet from a valid string.
	 */
	@Test
	public void testFromString() throws BitSetOperationException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Test BitSet = " + TEST_BIT_SET_STR_VALID);
		}

		BitSet actual = BitSetUtility.fromString(TEST_BIT_SET_STR_VALID);

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
			actual = BitSetUtility.fromString(TEST_BIT_SET_STR_INVALID);
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
	public void testToBinaryString() {
		BitSet data = new BitSet();
		data.set(0);
		data.set(1);
		data.set(5);
		
		String binaryString = BitSetUtility.toBinaryBigEndianString(data);
		
		String expected = "100011";
		
		assertEquals(expected, binaryString);
		
	}
	
	@Test
	public void testToLong() {
		BitSet data = new BitSet();
		data.set(2);
		data.set(3);
		
		assertEquals(12, BitSetUtility.toLong(data));
		
		data = new BitSet();
		data.set(0);
		data.set(1);
		
		assertEquals(3, BitSetUtility.toLong(data));
	}

	@Test
	public void testFloatToBitSet() throws BitSetOperationException {
		float originalFloat = 3f;
		
		BitSet bitSet = BitSetUtility.floatToBitSet(FloatSizeInBits.THIRTY_TWO, originalFloat);
		System.out.println(originalFloat + " as a BitSet:" + bitSet);
		
		System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(837483.125345323324f)));
		System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(-837483.125345323324f)));
		
		System.out.println(Long.toBinaryString(Double.doubleToLongBits(837483.125345323324d)));
		System.out.println(Long.toBinaryString(Double.doubleToLongBits(-837483.125345323324d)));
		
	}
}
