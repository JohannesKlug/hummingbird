package org.hbird.transport.payloadcodec;

import java.util.BitSet;

import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FIXME Move to packetbroker. This is an encoding/decoding test.
 * 
 * The test uses the following BitSets:
 * 
 * <pre>
 * {@code
 * TEST_BITSET_STRING_PKT_TYPE_A
 * 1110101000100000010000000000110111100000000000000000000000001
 * 
 * Breakdown:
 * 1 = Happy flag
 * 11010100010  = Apid 555
 * 0000000000000000 = payloadLength 32
 * 11011110000000000000000000000000 = test paramA 123
 * 1  = ValidityFlag
 * 
 * 
 * TEST_BITSET_STRING_PKT_TYPE_B
 * 110110010100000000100000000001000000000010010010000111111011010100111100100011010100111100011
 * 
 * Breakdown:
 * 1 = Happy flag
 * 10000100000 = Apid 333
 * 0000001000000000 = payloadLength 64
 * 0100000000001001001000011111101101010011110010001101010011110001 = test paramB 3.14159265d
 * 1  = ValidityFlag
 * }
 * </pre>
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 */
public class ParameterGroupTest {
	/** Logger for this class */
	private static final Logger LOG = LoggerFactory.getLogger(ParameterGroupTest.class);

	/** The complete mock container model as a string using default values i.e. 0 */
	private final static String EMPTY_CONTAINER_MODEL_BITSET_STRING = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

	/**
	 * The total length of the mock factory container model with default values. This means the packet type ID is 0 so
	 * no packet types match.
	 */
	private final static int DEFAULT_MODEL_FRAME_LENGTH = 29;

	/**
	 * Based upon the MockContainerFactory this Bit String encodes the Mock ParameterGroup model with values
	 * representing a snapshot of telemetry.
	 * 
	 * See {@link ParameterGroupTest} class javadoc for details
	 */
	private final static String TEST_BITSET_STRING_PKT_TYPE_A = "1110101000100000010000000000110111100000000000000000000000001";

	/** The total length of the mock factory container model with a packet type A set (555). */
	private final static int PKT_TYPE_A_MODEL_FRAME_LENGTH = 61;

	/** The test bitset string based upon the TEST_BITSET_STRING_PKT_TYPE_A as a bitset */
	private static final BitSet TEST_BITSET_PKT_TYPE_A = new BitSet(61);

	/** The packet ID value based upon the TEST_BITSET_STRING_PKT_TYPE_A */
	private static final String PACKET_TYPE_ID_555 = "555";

	/** The packet ID value based upon the TEST_BITSET_STRING_PKT_TYPE_A as a bitset */
	private static final BitSet PACKET_TYPE_ID_555_AS_BITSET = new BitSet(11);

	private final static BitSet PKT_TYPE_A_PAYLOAD_LENGTH_AS_BITSET = new BitSet(16);

	/** The test parameter A value based upon the TEST_BITSET_STRING_PKT_TYPE_A */
	private static final int PARAM_A_TEST_VALUE = 123;

	/** The test parameter A value based upon the TEST_BITSET_STRING_PKT_TYPE_A as a binary String */
	private static final String PARAM_A_TEST_VALUE_AS_BIN_STRING = "11011110000000000000000000000000";

	/** The test parameter A value based upon the TEST_BITSET_STRING_PKT_TYPE_A as a bitset */
	private static BitSet PARAM_A_TEST_VALUE_AS_BITSET = new BitSet(32);

	/**
	 * Based upon the MockContainerFactory this Bit String encodes the Mock ParameterGroup model with values
	 * representing a snapshot of telemetry.
	 * 
	 * See {@link ParameterGroupTest} class javadoc for details
	 */
	private final static String TEST_BITSET_STRING_PKT_TYPE_B = "110110010100000000100000000001000000000010010010000111111011010100111100100011010100111100011";

	/** The test bitset string based upon the TEST_BITSET_STRING_PKT_TYPE_B as a bitset */
	private static final BitSet TEST_BITSET_PKT_TYPE_B = new BitSet(93);

	/** The packet ID value based upon the TEST_BITSET_STRING_PKT_TYPE_B */
	private static final String PACKET_TYPE_ID_333 = "333";

	/** The packet ID value based upon the TEST_BITSET_STRING_PKT_TYPE_A as a bitset */
	private static final BitSet PACKET_TYPE_ID_333_AS_BITSET = new BitSet(11);

	/** The payload length of packet type B as a bitset */
	private final static BitSet PKT_TYPE_B_PAYLOAD_LENGTH_AS_BITSET = new BitSet(16);

	/** The test parameter B value based upon the TEST_BITSET_STRING_PKT_TYPE_B */
	private final static double PARAM_B_TEST_VALUE = 3.14159265d;

	/** The test parameter B value based upon the TEST_BITSET_STRING_PKT_TYPE_B as a bitset */
	private static final BitSet PARAM_B_TEST_VALUE_AS_BITSET = new BitSet(64);

	/** The total length of the mock factory container model with a packet type B set (333). */
	private final static int PKT_TYPE_B_MODEL_FRAME_LENGTH = 93;

	/** Handy flag bitset used for test asserts */
	private final static BitSet FLAG_ON_BITSET = new BitSet(1);

	/** Handy flag bitset used for test asserts */
	private final static BitSet FLAG_OFF_BITSET = new BitSet(1);

	/**
	 * Set's up the test values used for all tests.
	 * 
	 * @throws BitSetOperationException
	 */
	@BeforeClass
	public static void setUpForAllTests() throws BitSetOperationException {
		LOG.debug("-------------------------Setup for all -------------------------------");
		// Set up test BitSets

		// Set to 1110101000100000010000000000110111100000000000000000000000001
		// Note: This is the complete raw data of the model. It cannot be interpreted as number. It is read left to
		// right
		// but parameters can be little or big endian
		TEST_BITSET_PKT_TYPE_A.set(0, 3);
		TEST_BITSET_PKT_TYPE_A.set(4);
		TEST_BITSET_PKT_TYPE_A.set(6);
		TEST_BITSET_PKT_TYPE_A.set(10);
		TEST_BITSET_PKT_TYPE_A.set(17);
		TEST_BITSET_PKT_TYPE_A.set(28, 30);
		TEST_BITSET_PKT_TYPE_A.set(31, 35);
		TEST_BITSET_PKT_TYPE_A.set(60);

		// Set to 11011110000000000000000000000000 which is 123 in decimal (note: this is little endian)
		LOG.debug("Setting up param a test value bitset");
		PARAM_A_TEST_VALUE_AS_BITSET = BitSetUtility.stringToBitSet(PARAM_A_TEST_VALUE_AS_BIN_STRING, false, false);

		// Set to 11010100010 (note: this is little endian)
		PACKET_TYPE_ID_555_AS_BITSET.set(0, 2);
		PACKET_TYPE_ID_555_AS_BITSET.set(3);
		PACKET_TYPE_ID_555_AS_BITSET.set(5);
		PACKET_TYPE_ID_555_AS_BITSET.set(9);

		// Payload length for type A is 32 so set to 0000010000000000 (note: this is little endian)
		PKT_TYPE_A_PAYLOAD_LENGTH_AS_BITSET.set(5);

		FLAG_ON_BITSET.set(0);
		FLAG_OFF_BITSET.clear();

		// Set to 110110010100000000100000000001000000000010010010000111111011010100111100100011010100111100011
		// Note: This is the complete raw data of the model. It cannot be interpreted as number. It is read left to
		// right
		// but parameters can be little or big endian
		TEST_BITSET_PKT_TYPE_B.set(0, 2);
		TEST_BITSET_PKT_TYPE_B.set(3, 5);
		TEST_BITSET_PKT_TYPE_B.set(7);
		TEST_BITSET_PKT_TYPE_B.set(9);
		TEST_BITSET_PKT_TYPE_B.set(18);
		TEST_BITSET_PKT_TYPE_B.set(29);
		TEST_BITSET_PKT_TYPE_B.set(40);
		TEST_BITSET_PKT_TYPE_B.set(43);
		TEST_BITSET_PKT_TYPE_B.set(46);
		TEST_BITSET_PKT_TYPE_B.set(51, 57);
		TEST_BITSET_PKT_TYPE_B.set(58, 60);
		TEST_BITSET_PKT_TYPE_B.set(61);
		TEST_BITSET_PKT_TYPE_B.set(63);
		TEST_BITSET_PKT_TYPE_B.set(66, 70);
		TEST_BITSET_PKT_TYPE_B.set(72);
		TEST_BITSET_PKT_TYPE_B.set(76, 78);
		TEST_BITSET_PKT_TYPE_B.set(79);
		TEST_BITSET_PKT_TYPE_B.set(81);
		TEST_BITSET_PKT_TYPE_B.set(84, 88);
		TEST_BITSET_PKT_TYPE_B.set(91, 93);

		// Set to 10110010100 which is 333 in decimal (note: this is big endian)
		PACKET_TYPE_ID_333_AS_BITSET.set(0);
		PACKET_TYPE_ID_333_AS_BITSET.set(2, 4);
		PACKET_TYPE_ID_333_AS_BITSET.set(6);
		PACKET_TYPE_ID_333_AS_BITSET.set(8);

		// Payload length for type A is 64 so set to 0000001000000000 (note: this is little endian)
		PKT_TYPE_B_PAYLOAD_LENGTH_AS_BITSET.set(6);

		// Set to 0100000000001001001000011111101101010011110010001101010011110001 which is pi (note: this is big
		// endian)
		PARAM_B_TEST_VALUE_AS_BITSET.set(1);
		PARAM_B_TEST_VALUE_AS_BITSET.set(12);
		PARAM_B_TEST_VALUE_AS_BITSET.set(15);
		PARAM_B_TEST_VALUE_AS_BITSET.set(18);
		PARAM_B_TEST_VALUE_AS_BITSET.set(23, 29);
		PARAM_B_TEST_VALUE_AS_BITSET.set(30, 32);
		PARAM_B_TEST_VALUE_AS_BITSET.set(33);
		PARAM_B_TEST_VALUE_AS_BITSET.set(35);
		PARAM_B_TEST_VALUE_AS_BITSET.set(38, 42);
		PARAM_B_TEST_VALUE_AS_BITSET.set(44);
		PARAM_B_TEST_VALUE_AS_BITSET.set(48, 50);
		PARAM_B_TEST_VALUE_AS_BITSET.set(51);
		PARAM_B_TEST_VALUE_AS_BITSET.set(53);
		PARAM_B_TEST_VALUE_AS_BITSET.set(56, 60);
		PARAM_B_TEST_VALUE_AS_BITSET.set(63);
		LOG.debug("-----------------------------------------------------------------------------");
	}


	@Test
	public void placeholdersobuldruns() {
		
	}
	
	/**
	 * Simply tests the container can marshal with the default empty parameters.
	 * 
	 * @throws UnknownParameterGroupException
	 * @throws BitSetOperationException
	 */
	// @Test
	// public void testEmptyMarshall() throws UnknownParameterGroupException, BitSetOperationException {
	// ParameterGroup tmframe = mockContainerFactory.getContainer("TMFrame");
	//
	// BitSet marshalledFrame = new BitSet();
	// tmframe.marshall(marshalledFrame, 0);
	//
	// assertEquals(BitSetUtility.stringToBitSet(EMPTY_CONTAINER_MODEL_BITSET_STRING, false, false), marshalledFrame);
	// }

	/**
	 * Test method for checking a valid BitSet can be unmarshalled into a collection of Java objects (the Containers)
	 * {@link org.hbird.transport.spacesystemmodel.HummingbirdParameterGroup#unmarshall(java.util.BitSet)}.
	 * 
	 * NOTE: Test Param B (the 64 bit float) is not checked because the {@link TEST_BITSET_STRING} has the packet type
	 * id set to 555. The model restricts this id to packet type a which only contains test param A (a 32 bit int).
	 * 
	 * @throws UnknownParameterGroupException
	 * @throws BitSetOperationException
	 */
	// @Test
	// public void testUnmarshallFrameTestParamA() throws UnknownParameterGroupException, BitSetOperationException {
	// LOG.info("########################## Beginning test #############################");
	//
	// BitSet frame = BitSetUtility.stringToBitSet(TEST_BITSET_STRING_PKT_TYPE_A, false, false);
	//
	// ParameterGroup tmframe = mockContainerFactory.getContainer("TMFrame");
	// tmframe.unmarshall(frame);
	//
	// LOG.debug("The container frame after unmarshalling: " + tmframe);
	//
	// // Check the unmarshalling was successful...
	// // Test the parameter type ID (Apid) was unmarshalled as an IntegerParameter with value 555 (PACKET_TYPE_ID_555)
	// // ParameterGroup paramTypeID = testFrameBroker.getContainer(MockContainerModelFactory.PACKET_ID_NAME);
	// ParameterGroup paramTypeID = mockContainerFactory.getContainer(MockContainerModelFactory.PACKET_ID_ALIAS);
	// Assert.isInstanceOf(IntegerParameter.class, paramTypeID);
	// Number value = ((IntegerParameter) paramTypeID).getValue();
	// LOG.info("Checking " + MockContainerModelFactory.PACKET_ID_ALIAS);
	// assertEquals("Parameter has incorrect value.", Integer.parseInt(PACKET_TYPE_ID_555), value.intValue());
	// LOG.debug(MockContainerModelFactory.PACKET_ID_ALIAS + " parameter (apid) passed with value : " +
	// value.intValue());
	//
	// // Test that there is a Test Param A (32 bit unsigned int) as expected.
	// ParameterGroup testParamA = mockContainerFactory.getContainer(MockContainerModelFactory.TEST_PARAM_A);
	// Assert.isInstanceOf(IntegerParameter.class, testParamA);
	// Number testParamAvalue = ((IntegerParameter) testParamA).getValue();
	// LOG.info("Checking " + MockContainerModelFactory.TEST_PARAM_A);
	// assertEquals("Parameter has incorrect value.", PARAM_A_TEST_VALUE, testParamAvalue.intValue());
	// LOG.debug(MockContainerModelFactory.TEST_PARAM_A + " parameter passed with value : " +
	// testParamAvalue.intValue());
	//
	// // Test the container models happy flag and the validity flag
	// // Both expected to be the default value of 0 since we never set a value.
	// final int expectedValue = 1;
	// ParameterGroup happyFlag = mockContainerFactory.getContainer(MockContainerModelFactory.HAPPY_FLAG_ALIAS);
	// Assert.isInstanceOf(IntegerParameter.class, happyFlag);
	// Number happyFlagValue = ((IntegerParameter) happyFlag).getValue();
	// LOG.info("Checking " + MockContainerModelFactory.HAPPY_FLAG_ALIAS);
	// assertEquals("Parameter has incorrect value.", expectedValue, happyFlagValue.intValue());
	// LOG.debug(MockContainerModelFactory.HAPPY_FLAG_ALIAS + " parameter passed with value : " +
	// happyFlagValue.intValue());
	//
	// ParameterGroup validityFlag = mockContainerFactory.getContainer(MockContainerModelFactory.VALIDITY_FLAG_ALIAS);
	// Assert.isInstanceOf(IntegerParameter.class, validityFlag);
	// Number vFlagValue = ((IntegerParameter) validityFlag).getValue();
	// LOG.info("Checking " + MockContainerModelFactory.VALIDITY_FLAG_ALIAS);
	// assertEquals("Parameter has incorrect value.", expectedValue, vFlagValue.intValue());
	// LOG.debug(MockContainerModelFactory.VALIDITY_FLAG_ALIAS + " parameter passed with value : " +
	// vFlagValue.intValue());
	// }

	// @Test
	// public void testUnmarshallFrameTestParamB() throws UnknownParameterGroupException, BitSetOperationException {
	// LOG.info("Beginning test");
	//
	// BitSet frame = BitSetUtility.stringToBitSet(TEST_BITSET_STRING_PKT_TYPE_B, false, false);
	//
	// ParameterGroup tmframe = mockContainerFactory.getContainer("TMFrame");
	// tmframe.unmarshall(frame);
	//
	// LOG.debug("The container frame after unmarshalling: " + tmframe);
	//
	// // Check the unmarshalling was successful...
	// // Test the parameter type ID (Apid) was unmarshalled as an IntegerParameter with value 333 (PACKET_TYPE_ID_333)
	// ParameterGroup paramTypeID = mockContainerFactory.getContainer(MockContainerModelFactory.PACKET_ID_ALIAS);
	// Assert.isInstanceOf(IntegerParameter.class, paramTypeID);
	// Number value = ((IntegerParameter) paramTypeID).getValue();
	// LOG.info("Asserting " + MockContainerModelFactory.PACKET_ID_ALIAS);
	// assertEquals("Parameter has incorrect value.", Integer.parseInt(PACKET_TYPE_ID_333), value.intValue());
	// LOG.debug(MockContainerModelFactory.PACKET_ID_ALIAS + " parameter (apid) passed with value : " +
	// value.intValue());
	//
	// // Test that there is a Test Param B (64 bit float) as expected.
	// ParameterGroup testParamB = mockContainerFactory.getContainer(MockContainerModelFactory.TEST_PARAM_B);
	// Assert.isInstanceOf(FloatParameter.class, testParamB);
	// Number testParamBvalue = ((FloatParameter) testParamB).getValue();
	// LOG.info("Extracted value = " + testParamBvalue);
	// LOG.info("Asserting " + MockContainerModelFactory.TEST_PARAM_B);
	// assertEquals("Parameter has incorrect value.", PARAM_B_TEST_VALUE, testParamBvalue.doubleValue(), 0);
	// LOG.debug(MockContainerModelFactory.TEST_PARAM_B + " parameter passed with value : " +
	// testParamBvalue.doubleValue());
	//
	// // Test the container models happy flag and the validity flag
	// // Both expected to be the default value of 0 since we never set a value.
	// final int expectedValue = 1;
	// ParameterGroup happyFlag = mockContainerFactory.getContainer(MockContainerModelFactory.HAPPY_FLAG_ALIAS);
	// Assert.isInstanceOf(IntegerParameter.class, happyFlag);
	// Number happyFlagValue = ((IntegerParameter) happyFlag).getValue();
	// LOG.info("Checking " + MockContainerModelFactory.HAPPY_FLAG_ALIAS);
	// assertEquals("Parameter has incorrect value.", expectedValue, happyFlagValue.intValue());
	// LOG.debug(MockContainerModelFactory.HAPPY_FLAG_ALIAS + " parameter passed with value : " +
	// happyFlagValue.intValue());
	//
	// ParameterGroup validityFlag = mockContainerFactory.getContainer(MockContainerModelFactory.VALIDITY_FLAG_ALIAS);
	// Assert.isInstanceOf(IntegerParameter.class, validityFlag);
	// Number vFlagValue = ((IntegerParameter) validityFlag).getValue();
	// LOG.info("Checking " + MockContainerModelFactory.VALIDITY_FLAG_ALIAS);
	// assertEquals("Parameter has incorrect value.", expectedValue, vFlagValue.intValue());
	// LOG.debug(MockContainerModelFactory.VALIDITY_FLAG_ALIAS + " parameter passed with value : " +
	// vFlagValue.intValue());
	// }

	/**
	 * Tests marshalling a <b>valid</b> population of a Mock ParameterGroup Model. The Model is populated in the test
	 * method. {@link org.hbird.transport.spacesystemmodel.HummingbirdParameterGroup#marshall(java.util.BitSet, int)} .
	 * 
	 * @throws UnknownParameterGroupException
	 * @throws BitSetOperationException
	 */
	// @Test
	// public void testMarshallTmModelType555() throws UnknownParameterGroupException, BitSetOperationException {
	// LOG.info("Beginning test");
	//
	// // FIRST WE SET UP THE MODEL FOR PACKET TYPE 555
	//
	// LOG.debug("SSModel before setting values: " + mockContainerFactory.getContainer("TMFrame").toString());
	//
	// // Populate the input mock frame parameter values
	// // Set the Frame Header
	// mockContainerFactory.getParameter(MockContainerModelFactory.HAPPY_FLAG_ALIAS).setValue(1);
	//
	// // Set the packet id to 555 (Packet ID type A)
	// DefaultParameter apid = mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS);
	// apid.setValue(Float.valueOf(MockContainerModelFactory.PACKET_TYPE_A_ID));
	//
	// // Set the payload length to 32 (the length of test param A)
	// mockContainerFactory.getParameter(MockContainerModelFactory.PAYLOAD_LENGTH_PARAM_ALIAS).setValue(32);
	//
	// // Set parameter A value
	// DefaultParameter paramA = mockContainerFactory.getParameter(MockContainerModelFactory.TEST_PARAM_A);
	// paramA.setValue(PARAM_A_TEST_VALUE);
	//
	// // Set the Frame Tail
	// mockContainerFactory.getParameter(MockContainerModelFactory.VALIDITY_FLAG_ALIAS).setValue(1);
	//
	// LOG.debug("SSModel after setting values: " + mockContainerFactory.getContainer("TMFrame").toString());
	//
	// // Get the frame length, that is, the sum of itself and it's tree of sub
	// // containers and set the target bitset to this length.
	// int length = mockContainerFactory.getContainer("TMFrame").getLength();
	// if (LOG.isDebugEnabled()) {
	// LOG.debug("TMFrame from space system model is of length = " + length);
	// }
	//
	// // NOW WE DO THE MARSHALL
	// // Marshall the Frame to a bitset
	// BitSet marshalledFrame = new BitSet();
	// ParameterGroup tmframe = mockContainerFactory.getContainer(MockContainerModelFactory.TM_FRAME_ALIAS);
	// tmframe.marshall(marshalledFrame, 0);
	//
	// LOG.debug("Bitset length = " + marshalledFrame.length());
	// String binDump = BitSetUtility.binDump(marshalledFrame);
	// LOG.debug(binDump);
	//
	// // NOW WE DO SOME ASSERTS ON THE RESULT
	//
	// // Check the marshalled frame is the as expected.
	// if (LOG.isDebugEnabled()) {
	// logAssertValues(MockContainerModelFactory.TM_FRAME_ALIAS, TEST_BITSET_PKT_TYPE_A, marshalledFrame);
	// }
	// assertEquals("BitSets not equal", TEST_BITSET_PKT_TYPE_A, marshalledFrame);
	// assertEquals("BitSets length not as expected", marshalledFrame.length(), TEST_BITSET_STRING_PKT_TYPE_A.length());
	//
	// // Now let's marshall the packet ID parameter and run some asserts
	// BitSet apidBitSet = new
	// BitSet(mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS).getSizeInBits()());
	// DefaultParameter packet = mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS);
	// packet.marshall(apidBitSet, 0);
	// if (LOG.isDebugEnabled()) {
	// LOG.debug(mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS) + " = " +
	// BitSetUtility.binDump(apidBitSet));
	// }
	//
	// if (LOG.isDebugEnabled()) {
	// logAssertValues(MockContainerModelFactory.PACKET_ID_ALIAS, PACKET_TYPE_ID_555_AS_BITSET, apidBitSet);
	// }
	// assertEquals("Apid should match expected", PACKET_TYPE_ID_555_AS_BITSET, apidBitSet);
	//
	// // Check the payload length parameter
	// BitSet payloadLength = new
	// BitSet(mockContainerFactory.getParameter(MockContainerModelFactory.PAYLOAD_LENGTH_PARAM_ALIAS).getLength());
	// packet = mockContainerFactory.getParameter(MockContainerModelFactory.PAYLOAD_LENGTH_PARAM_ALIAS);
	// packet.marshall(payloadLength, 0);
	//
	// if (LOG.isDebugEnabled()) {
	// LOG.debug(mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS) + " = " +
	// BitSetUtility.binDump(payloadLength));
	// }
	//
	// if (LOG.isDebugEnabled()) {
	// logAssertValues(MockContainerModelFactory.PAYLOAD_LENGTH_PARAM_ALIAS, PKT_TYPE_A_PAYLOAD_LENGTH_AS_BITSET,
	// payloadLength);
	// }
	//
	// assertEquals("Apid should match expected", PKT_TYPE_A_PAYLOAD_LENGTH_AS_BITSET, payloadLength);
	//
	// // Check the Test Parameter A marshalling
	// BitSet testParamABitSet = new
	// BitSet(mockContainerFactory.getParameter(MockContainerModelFactory.TEST_PARAM_A).getLength());
	// packet = mockContainerFactory.getParameter(MockContainerModelFactory.TEST_PARAM_A);
	// packet.marshall(testParamABitSet, 0);
	//
	// if (LOG.isDebugEnabled()) {
	// logAssertValues(MockContainerModelFactory.TEST_PARAM_A, PARAM_A_TEST_VALUE_AS_BITSET, testParamABitSet);
	// }
	//
	// assertEquals("Test parameter A should be equal", PARAM_A_TEST_VALUE_AS_BITSET, testParamABitSet);
	//
	// // Finally check the flags
	// BitSet marshalledFlag = new
	// BitSet(mockContainerFactory.getParameter(MockContainerModelFactory.HAPPY_FLAG_ALIAS).getLength());
	// packet = mockContainerFactory.getParameter(MockContainerModelFactory.HAPPY_FLAG_ALIAS);
	// packet.marshall(marshalledFlag, 0);
	//
	// if (LOG.isDebugEnabled()) {
	// logAssertValues(MockContainerModelFactory.HAPPY_FLAG_ALIAS, FLAG_ON_BITSET, marshalledFlag);
	// }
	//
	// assertEquals("Flag should be on", FLAG_ON_BITSET, marshalledFlag);
	//
	// marshalledFlag = new
	// BitSet(mockContainerFactory.getParameter(MockContainerModelFactory.VALIDITY_FLAG_ALIAS).getLength());
	// packet = mockContainerFactory.getParameter(MockContainerModelFactory.VALIDITY_FLAG_ALIAS);
	// packet.marshall(marshalledFlag, 0);
	//
	// if (LOG.isDebugEnabled()) {
	// logAssertValues(MockContainerModelFactory.VALIDITY_FLAG_ALIAS, FLAG_ON_BITSET, marshalledFlag);
	// }
	//
	// assertEquals("Flag should be on", FLAG_ON_BITSET, marshalledFlag);
	// }

	/**
	 * Tests marshalling a <b>valid</b> population of a Mock ParameterGroup Model. The Model is populated in the test
	 * method. {@link org.hbird.transport.spacesystemmodel.HummingbirdParameterGroup#marshall(java.util.BitSet, int)} .
	 * 
	 * @throws UnknownParameterGroupException
	 * @throws BitSetOperationException
	 */
	// @Test
	// public void testMarshallTmModelType333() throws UnknownParameterGroupException, BitSetOperationException {
	// LOG.info("Beginning test");
	//
	// LOG.debug("SSModel before setting values: " + mockContainerFactory.getContainer("TMFrame").toString());
	//
	// // Populate the input mock frame parameter values
	// // Set the Frame Header
	// mockContainerFactory.getParameter(MockContainerModelFactory.HAPPY_FLAG_ALIAS).setValue(1);
	//
	// // Set the packet id to 333 (Packet ID type B)
	// DefaultParameter apid = mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS);
	// apid.setValue(Float.valueOf(MockContainerModelFactory.PACKET_TYPE_B_ID));
	//
	// // Set the payload length to 64 (the length of test param B)
	// mockContainerFactory.getParameter(MockContainerModelFactory.PAYLOAD_LENGTH_PARAM_ALIAS).setValue(64);
	//
	// // Set parameter B value to test value pi
	// DefaultParameter paramB = mockContainerFactory.getParameter(MockContainerModelFactory.TEST_PARAM_B);
	// paramB.setValue(PARAM_B_TEST_VALUE);
	//
	// // Set the Frame Tail
	// mockContainerFactory.getParameter(MockContainerModelFactory.VALIDITY_FLAG_ALIAS).setValue(1);
	//
	// LOG.debug("SSModel after setting values: " + mockContainerFactory.getContainer("TMFrame").toString());
	//
	// // Get the frame length, that is, the sum of itself and it's tree of sub
	// // containers and set the target bitset to this length.
	// int length = mockContainerFactory.getContainer("TMFrame").getLength();
	// if (LOG.isDebugEnabled()) {
	// LOG.debug("TMFrame from space system model is of length = " + length);
	// }
	//
	// // Marshall the Frame to a bitset
	// BitSet marshalledFrame = new BitSet();
	// ParameterGroup tmframe = mockContainerFactory.getContainer("TMFrame");
	// tmframe.marshall(marshalledFrame, 0);
	//
	// LOG.debug("Bitset length = " + marshalledFrame.length());
	// String binDump = BitSetUtility.binDump(marshalledFrame);
	// LOG.debug(binDump);
	//
	// // Check the marshalled frame is the as expected.
	// if (LOG.isDebugEnabled()) {
	// logAssertValues(MockContainerModelFactory.TM_FRAME_ALIAS, TEST_BITSET_PKT_TYPE_B, marshalledFrame);
	// }
	// assertEquals("BitSets not equal", TEST_BITSET_PKT_TYPE_B, marshalledFrame);
	// assertEquals("BitSets length not as expected", marshalledFrame.length(), TEST_BITSET_STRING_PKT_TYPE_B.length());
	//
	// // Now let's marshall the packet ID parameter and run some asserts
	// BitSet packetIdMarshalled = new
	// BitSet(mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS).getLength());
	// ParameterGroup packet = mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS);
	// packet.marshall(packetIdMarshalled, 0);
	// if (LOG.isDebugEnabled()) {
	// LOG.debug(mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS) + " = " +
	// BitSetUtility.binDump(packetIdMarshalled));
	// }
	//
	// if (LOG.isDebugEnabled()) {
	// logAssertValues(MockContainerModelFactory.PACKET_ID_ALIAS, PACKET_TYPE_ID_333_AS_BITSET, packetIdMarshalled);
	// }
	// assertEquals("Apid should match expected", PACKET_TYPE_ID_333_AS_BITSET, packetIdMarshalled);
	//
	// // Check the payload length parameter
	// BitSet payloadLength = new
	// BitSet(mockContainerFactory.getParameter(MockContainerModelFactory.PAYLOAD_LENGTH_PARAM_ALIAS).getLength());
	// packet = mockContainerFactory.getParameter(MockContainerModelFactory.PAYLOAD_LENGTH_PARAM_ALIAS);
	// packet.marshall(payloadLength, 0);
	//
	// if (LOG.isDebugEnabled()) {
	// LOG.debug(mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS) + " = " +
	// BitSetUtility.binDump(payloadLength));
	// }
	//
	// if (LOG.isDebugEnabled()) {
	// logAssertValues(MockContainerModelFactory.PAYLOAD_LENGTH_PARAM_ALIAS, PKT_TYPE_B_PAYLOAD_LENGTH_AS_BITSET,
	// payloadLength);
	// }
	//
	// assertEquals("Apid should match expected", PKT_TYPE_B_PAYLOAD_LENGTH_AS_BITSET, payloadLength);
	//
	// // Check the Test Parameter B marshalling
	// BitSet testParamBmarshalled = new
	// BitSet(mockContainerFactory.getParameter(MockContainerModelFactory.TEST_PARAM_B).getLength());
	// packet = mockContainerFactory.getParameter(MockContainerModelFactory.TEST_PARAM_B);
	// packet.marshall(testParamBmarshalled, 0);
	//
	// if (LOG.isDebugEnabled()) {
	// logAssertValues(MockContainerModelFactory.TEST_PARAM_B, PARAM_B_TEST_VALUE_AS_BITSET, testParamBmarshalled);
	// }
	//
	// assertEquals("Test parameter A should be equal", PARAM_B_TEST_VALUE_AS_BITSET, testParamBmarshalled);
	//
	// // Finally check the flags
	// BitSet marshalledFlag = new
	// BitSet(mockContainerFactory.getParameter(MockContainerModelFactory.HAPPY_FLAG_ALIAS).getLength());
	// packet = mockContainerFactory.getParameter(MockContainerModelFactory.HAPPY_FLAG_ALIAS);
	// packet.marshall(marshalledFlag, 0);
	//
	// if (LOG.isDebugEnabled()) {
	// logAssertValues(MockContainerModelFactory.HAPPY_FLAG_ALIAS, FLAG_ON_BITSET, marshalledFlag);
	// }
	//
	// assertEquals("Flag should be on", FLAG_ON_BITSET, marshalledFlag);
	//
	// marshalledFlag = new
	// BitSet(mockContainerFactory.getParameter(MockContainerModelFactory.VALIDITY_FLAG_ALIAS).getLength());
	// packet = mockContainerFactory.getParameter(MockContainerModelFactory.VALIDITY_FLAG_ALIAS);
	// packet.marshall(marshalledFlag, 0);
	//
	// if (LOG.isDebugEnabled()) {
	// logAssertValues(MockContainerModelFactory.VALIDITY_FLAG_ALIAS, FLAG_ON_BITSET, marshalledFlag);
	// }
	//
	// assertEquals("Flag should be on", FLAG_ON_BITSET, marshalledFlag);
	// }

//	private void logAssertValues(final String assertDescription, final BitSet expected, final BitSet marshalledFlag) {
//		LOG.debug("Debug for " + assertDescription);
//		LOG.debug("Expected bitset = " + BitSetUtility.binDump(expected));
//		LOG.debug("Actual bitset = " + BitSetUtility.binDump(marshalledFlag));
//	}
}
