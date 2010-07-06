package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;

public class IntegerUnsignedBehaviourTest {
	private final static Logger LOG = LoggerFactory.getLogger(IntegerUnsignedBehaviourTest.class);
	
	private final String TYPE_NAME = "bit Unsigned integer";
	
	// Note all test values are unsigned.  This can cause some problems with Java int which is
	// always signed.
	private final static String TEST_STR_VALUE_LE_555 = "1101010001";
	private final static int TEST_VALUE_LENGTH_LE_555 = 10;
	private static BitSet TEST_BITSET_VALUE_LE_555;
	
	private final static String TEST_STR_VALUE_BE_555 = "1000101011";
	private final static int TEST_VALUE_LENGTH_BE_555 = 10;
	private static BitSet TEST_BITSET_VALUE_BE_555;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TEST_BITSET_VALUE_LE_555 = new BitSet();
		TEST_BITSET_VALUE_LE_555.set(0);
		TEST_BITSET_VALUE_LE_555.set(4);
		TEST_BITSET_VALUE_LE_555.set(6);
		TEST_BITSET_VALUE_LE_555.set(8);
		TEST_BITSET_VALUE_LE_555.set(9);
		
		TEST_BITSET_VALUE_BE_555 = new BitSet();
		TEST_BITSET_VALUE_BE_555.set(0);
		TEST_BITSET_VALUE_BE_555.set(1);
		TEST_BITSET_VALUE_BE_555.set(3);
		TEST_BITSET_VALUE_BE_555.set(5);
		TEST_BITSET_VALUE_BE_555.set(9);
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testLittleEndianValueFromBitSet() throws InvalidParameterTypeException {
		IntegerUnsignedBehaviour behaviour = new IntegerUnsignedBehaviour(TEST_VALUE_LENGTH_LE_555, false);
		Long actual = behaviour.valueFromBitSet(TEST_BITSET_VALUE_LE_555);
		assertEquals(new Long(555), actual);
	}
	
	@Test
	public void testBigEndianValueFromBitSet() throws InvalidParameterTypeException {
		IntegerUnsignedBehaviour behaviour = new IntegerUnsignedBehaviour(TEST_VALUE_LENGTH_BE_555, true);
		Long actual = behaviour.valueFromBitSet(TEST_BITSET_VALUE_BE_555);
		assertEquals(new Long(555), actual);
	}

	@Test(expected=InvalidParameterTypeException.class)
	public void testInvalidSizeConstruction() throws InvalidParameterTypeException {
		new IntegerUnsignedBehaviour(45, true);
	}

	@Test
	public void testGetName() throws InvalidParameterTypeException {
		assertEquals(new IntegerUnsignedBehaviour(1, true).getTypeName(), 1 + TYPE_NAME);
	}
}


