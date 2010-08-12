package com.logica.hummingbird.spacesystemmodel.parameters.behaviours;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.spacesystemmodel.parameters.behaviours.IntegerUnsignedBehaviour;
import com.logica.hummingbird.util.BitSetUtility;

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
	
	private final static String TEST_STR_VALUE_BE_1024 = "10000000000";
	private final static String TEST_STR_VALUE_LE_1024 = "00000000001";
	private final static int TEST_VALUE_LENGTH_1024 = 11;
	private static BitSet TEST_BITSET_VALUE_BE_1024;
	private static BitSet TEST_BITSET_VALUE_LE_1024;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.debug("Setting up test bitsets....");
		TEST_BITSET_VALUE_LE_555 = new BitSet();
		TEST_BITSET_VALUE_LE_555.set(0);
		TEST_BITSET_VALUE_LE_555.set(1);
		TEST_BITSET_VALUE_LE_555.set(3);
		TEST_BITSET_VALUE_LE_555.set(5);
		TEST_BITSET_VALUE_LE_555.set(9);
		assertEquals(TEST_STR_VALUE_LE_555, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_LE_555, true));
		
		TEST_BITSET_VALUE_BE_555 = new BitSet();
		TEST_BITSET_VALUE_BE_555.set(0);
		TEST_BITSET_VALUE_BE_555.set(4);
		TEST_BITSET_VALUE_BE_555.set(6);
		TEST_BITSET_VALUE_BE_555.set(8);
		TEST_BITSET_VALUE_BE_555.set(9);
		assertEquals(TEST_STR_VALUE_BE_555, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_555, true));
		
		TEST_BITSET_VALUE_BE_1024 = new BitSet(TEST_VALUE_LENGTH_1024);
		TEST_BITSET_VALUE_BE_1024.set(0);
		assertEquals(TEST_STR_VALUE_BE_1024, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_BE_1024, false).substring(0, TEST_VALUE_LENGTH_1024));
		
		TEST_BITSET_VALUE_LE_1024 = new BitSet(TEST_VALUE_LENGTH_1024);
		TEST_BITSET_VALUE_LE_1024.set(10);
		assertEquals(TEST_STR_VALUE_LE_1024, BitSetUtility.bitSetToBinaryString(TEST_BITSET_VALUE_LE_1024, false).substring(0, TEST_VALUE_LENGTH_1024));
		LOG.debug("Test bitsets set-up completed successfully");
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testLittleEndianValueFromBitSet() throws InvalidParameterTypeException {
		LOG.info("###################### Beginning test #######################");
		IntegerUnsignedBehaviour behaviour = new IntegerUnsignedBehaviour(TEST_VALUE_LENGTH_LE_555, false);
		Number actual = behaviour.valueFromBitSet(TEST_BITSET_VALUE_LE_555);
		assertEquals(555, actual);
	}

	@Test
	public void testBigEndianValueFromBitSet() throws InvalidParameterTypeException {
		IntegerUnsignedBehaviour behaviour = new IntegerUnsignedBehaviour(TEST_VALUE_LENGTH_BE_555, true);
		Number actual = behaviour.valueFromBitSet(TEST_BITSET_VALUE_BE_555);
		assertEquals(555, actual);
	}
	
	@Test
	public void testBigEndianBoundaryValueFromBitSet() throws InvalidParameterTypeException {
		IntegerUnsignedBehaviour behaviour = new IntegerUnsignedBehaviour(TEST_VALUE_LENGTH_1024, true);
		Number actual = behaviour.valueFromBitSet(TEST_BITSET_VALUE_BE_1024);
		assertEquals(1024, actual);
	}
	
	@Test
	public void testLittleEndianBoundaryValueFromBitSet() throws InvalidParameterTypeException {
		IntegerUnsignedBehaviour behaviour = new IntegerUnsignedBehaviour(TEST_VALUE_LENGTH_1024, false);
		Number actual = behaviour.valueFromBitSet(TEST_BITSET_VALUE_LE_1024);
		assertEquals(1024, actual);
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


