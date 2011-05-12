package org.hbird.transport.spacesystemmodel.parameters.behaviours;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.LongSignedBehaviour;

public class LongSignedBehaviourTest {
	private final static Logger LOG = LoggerFactory.getLogger(LongSignedBehaviourTest.class);
	
	private static LongSignedBehaviour longSignedBehaviour;
	
	private static final long TEST_LONG = 2305843397479642193l;
	private static final String TEST_LONG_STR = "0010000000000000000000000101101001100110011101000011010001010001";
	private static BitSet TEST_LONG_BITSET;
	
	private static final String TEST_MAX_LONG_STR = "0111111111111111111111111111111111111111111111111111111111111111";
	private static BitSet TEST_MAX_LONG_BITSET;
	private static final String TEST_MIN_LONG_STR = "1000000000000000000000000000000000000000000000000000000000000000";
	private static BitSet TEST_MIN_LONG_BITSET;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.info("--------- Setup stuff -------------------------");
		TEST_LONG_BITSET = BitSetUtility.stringToBitSet(TEST_LONG_STR, true, true);
		TEST_MAX_LONG_BITSET = BitSetUtility.stringToBitSet(TEST_MAX_LONG_STR, true, true);
		TEST_MIN_LONG_BITSET = BitSetUtility.stringToBitSet(TEST_MIN_LONG_STR, true, true);
		LOG.info("-----------------------------------------------");
	}

	@Before
	public void setUp() throws Exception {
		longSignedBehaviour = new LongSignedBehaviour(64, true);
	}

	@Test(expected=InvalidParameterTypeException.class)
	public final void testLongSignedBehaviourTooSmall() throws InvalidParameterTypeException {
		new LongSignedBehaviour(12, true);
	}
	
	@Test(expected=InvalidParameterTypeException.class)
	public final void testLongSignedBehaviourTooBig() throws InvalidParameterTypeException {
		new LongSignedBehaviour(74, true);
	}

	@Test
	public final void testValueFromBitSet() {
		long actual = longSignedBehaviour.valueFromBitSet(TEST_LONG_BITSET);
		assertEquals(TEST_LONG, actual);
	}
	
	@Test
	public final void testMaxValueFromBitSet() {
		long actual = longSignedBehaviour.valueFromBitSet(TEST_MAX_LONG_BITSET);
		assertEquals(Long.MAX_VALUE, actual);
	}
	
	@Test
	public final void testMinValueFromBitSet() {
		long actual = longSignedBehaviour.valueFromBitSet(TEST_MIN_LONG_BITSET);
		assertEquals(Long.MIN_VALUE, actual);
	}

	@Test
	public final void testInsertIntoBitSet() throws BitSetOperationException {
		BitSet actual = new BitSet();
		actual = longSignedBehaviour.insertIntoBitSet(TEST_LONG, actual, 0);
		assertEquals(actual, TEST_LONG_BITSET);
	}

	@Test
	public final void testGetTypeName() throws InvalidParameterTypeException {
		assertEquals("Signed long", longSignedBehaviour.getTypeName());
	}

}
