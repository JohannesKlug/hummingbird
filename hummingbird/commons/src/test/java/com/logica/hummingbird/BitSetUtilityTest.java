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
		Integer extractedInteger = BitSetUtility.extractInteger(signedIntegerInBitset, 0, 4, true);
		
		assertEquals("1111 as a signed Integer should be read as -7.", new Integer(-7), extractedInteger);
	}
	
	@Test
	public void testExtractUnsignedInteger() {
		BitSet unsignedIntegerInBitset = new BitSet(4);
		unsignedIntegerInBitset.set(0, 4);
		Integer extractedInteger = BitSetUtility.extractInteger(unsignedIntegerInBitset, 0, 4, false);
		
		assertEquals("1111 as an unsigned Integer should be read as 15.", new Integer(15), extractedInteger);
	}
	
	@Test
	public void testExtractUnsigned1BitInteger() {
		BitSet unsignedIntegerInBitset = new BitSet(1);
		unsignedIntegerInBitset.set(0);
		Integer extractedInteger = BitSetUtility.extractInteger(unsignedIntegerInBitset, 0, 1, false);
		
		assertEquals("1 as an unsigned Integer should be read as 1.", new Integer(1), extractedInteger);
		
		unsignedIntegerInBitset = new BitSet(1);
		extractedInteger = BitSetUtility.extractInteger(unsignedIntegerInBitset, 0, 1, false);
		
		assertEquals("0 as an unsigned Integer should be read as 0.", new Integer(0), extractedInteger);
	}
	
	@Ignore
	@Test
	public void testInsertInteger() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testExtractDouble() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public void testInsertDouble() {
		fail("Not yet implemented"); // TODO
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

}
