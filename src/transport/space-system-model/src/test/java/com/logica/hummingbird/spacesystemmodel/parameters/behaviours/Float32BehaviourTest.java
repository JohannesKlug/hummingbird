/**
 * 
 */
package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.util.BitSetUtility;
import com.logica.hummingbird.util.exceptions.BitSetOperationException;

/**
 * @author doylemr
 * 
 */
public class Float32BehaviourTest {
	/** Logger for this class */
	private final static Logger LOG = LoggerFactory.getLogger(Float32BehaviourTest.class);

	private Float32Behaviour float32behaviour = null;

	private final static Float GOLDEN_RATIO = 1.61803398874f;
	private final static BitSet GOLDEN_RATIO_TEST_BITSET = new BitSet(32);
	private final static String GOLDEN_RATIO_TEST_BITSET_STRING = "00111111110011110001101110111101";

	public static final Float BOUNDARY_SET_TEST_FLOAT = -6.0000005f;
	public static final String BOUNDARY_SET_TEST_FLOAT_STRING = "11000000110000000000000000000001";
	private final static BitSet BOUNDARY_SET_TEST_FLOAT_BITSET = new BitSet(32);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		GOLDEN_RATIO_TEST_BITSET.set(2, 10);
		GOLDEN_RATIO_TEST_BITSET.set(12, 16);
		GOLDEN_RATIO_TEST_BITSET.set(19, 21);
		GOLDEN_RATIO_TEST_BITSET.set(22, 25);
		GOLDEN_RATIO_TEST_BITSET.set(26, 30);
		GOLDEN_RATIO_TEST_BITSET.set(31);
		String binString = BitSetUtility.bitSetToBinaryString(GOLDEN_RATIO_TEST_BITSET, true);
		binString = BitSetUtility.padStringFromTheBack(binString, 32);
		assertEquals(GOLDEN_RATIO_TEST_BITSET_STRING, binString);

		BOUNDARY_SET_TEST_FLOAT_BITSET.set(0, 2);
		BOUNDARY_SET_TEST_FLOAT_BITSET.set(8, 10);
		BOUNDARY_SET_TEST_FLOAT_BITSET.set(31);
		binString = BitSetUtility.bitSetToBinaryString(BOUNDARY_SET_TEST_FLOAT_BITSET, true);
		binString = BitSetUtility.padStringFromTheBack(binString, 32);
		assertEquals(BOUNDARY_SET_TEST_FLOAT_STRING, binString);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Setup Golden ratio BitSet: " + BitSetUtility.binDump(GOLDEN_RATIO_TEST_BITSET));
			LOG.debug("Setup boundary value BitSet: " + BitSetUtility.binDump(BOUNDARY_SET_TEST_FLOAT_BITSET));
		}
	}

	@Before
	public void setUpForTest() {
		float32behaviour = new Float32Behaviour();
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.spacesystemmodel.parameters.behaviours.Float32Behaviour#valueFromBitSet(java.util.BitSet)}
	 * .
	 */
	@Test
	public void testValueFromBitSet() {
		Float actual = float32behaviour.valueFromBitSet(GOLDEN_RATIO_TEST_BITSET);
		assertEquals("Extracted value must match", GOLDEN_RATIO, actual);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.spacesystemmodel.parameters.behaviours.Float32Behaviour#valueFromBitSet(java.util.BitSet)}
	 * .
	 */
	@Test
	public void testBoundaryValueFromBitSet() {
		Float myFloat = new Float(BOUNDARY_SET_TEST_FLOAT);
		Integer myInt = Float.floatToIntBits(myFloat);
		System.out.println(myFloat);
		System.out.println(myInt);

		assertEquals(BOUNDARY_SET_TEST_FLOAT, Float.intBitsToFloat(myInt), 0.00001);

		Float actual = float32behaviour.valueFromBitSet(BOUNDARY_SET_TEST_FLOAT_BITSET);
		assertEquals("Extracted value must match", BOUNDARY_SET_TEST_FLOAT, actual);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.spacesystemmodel.parameters.behaviours.Float32Behaviour#insertIntoBitSet(java.lang.Number, java.util.BitSet, int)}
	 * .
	 * 
	 * @throws BitSetOperationException
	 */
	@Test
	public void testInsertIntoBitSet() throws BitSetOperationException {
		BitSet actual = new BitSet();
		actual = float32behaviour.insertIntoBitSet(GOLDEN_RATIO, actual, 0);
		assertEquals(actual, GOLDEN_RATIO_TEST_BITSET);
	}

	@Test
	public void testInsertIntoBitSetBoundaryTest() throws BitSetOperationException {
		BitSet actual = new BitSet();
		actual = float32behaviour.insertIntoBitSet(BOUNDARY_SET_TEST_FLOAT, actual, 0);
		assertEquals(actual, BOUNDARY_SET_TEST_FLOAT_BITSET);
	}

	@Test(expected = BitSetOperationException.class)
	public void testBitSetFromStringTooLong() throws BitSetOperationException {
		final String TOO_LONG = "10101010100000000000000000000011111111111111100000000000000000000000000000000000011111";
		float32behaviour.bitSetFromString(TOO_LONG);
	}

	@Test(expected = BitSetOperationException.class)
	public void testBitSetFromStringInvalidChar() throws BitSetOperationException {
		final String INVALID_CHAR = "11010101010105010101010101010101";
		float32behaviour.bitSetFromString(INVALID_CHAR);
	}

	@Test()
	public void testBitSetFromStringShortInput() throws BitSetOperationException {
		final String SHORT_INPUT = "1";
		BitSet expected = new BitSet(32);
		expected.set(0);
		BitSet actual = float32behaviour.bitSetFromString(SHORT_INPUT);
		assertEquals(expected, actual);
	}
}
