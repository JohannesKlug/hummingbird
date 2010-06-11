/**
 * 
 */
package com.logica.hummingbird;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.logica.hummingbird.spacesystemmodel.Container;
import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;
import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.parameters.FloatParameter;
import com.logica.hummingbird.spacesystemmodel.parameters.IntegerParameter;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterImpl;
import com.logica.hummingbird.spacesystemmodel.testsupport.MockContainerModelFactory;
import com.logica.hummingbird.util.BitSetUtility;

/**
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
 * 110110010100000000100000000000011101011110001101101001000010000000000000000000000000000000001
 * 
 * Breakdown:
 * 1 = Happy flag
 * 10000100000 = Apid 333
 * 0000001000000000 = payloadLength 64
 * 0001110101111000110110100100001000000000000000000000000000000000 = test paramB 54.78
 * 1  = ValidityFlag
 * }
 * </pre>
 * 
 * @author Mark Doyle
 * 
 */
public class ContainerTest {
	/**
	 * Logger for this class
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ContainerTest.class);

	/**
	 * Mock Factory used in all the tests.
	 */
	private static MockContainerModelFactory mockContainerFactory;

	/**
	 * The complete mock container model as a string using default values i.e. 0
	 */
	private final static String EMPTY_CONTAINER_MODEL_BITSET_STRING = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

	/**
	 * The total length of the mock factory container model with default values. This means the packet type ID is 0 so
	 * no packet types match.
	 */
	private final static int DEFAULT_MODEL_FRAME_LENGTH = 29;

	/**
	 * Based upon the MockContainerFactory this Bit String encodes the Mock Container model with values representing a
	 * snapshot of telemetry.
	 * 
	 * See class javadoc for details
	 */
	private final static String TEST_BITSET_STRING_PKT_TYPE_A = "1110101000100000010000000000110111100000000000000000000000001";
	
	/**
	 * The packet ID value based upon the TEST_BITSET_STRING_PKT_TYPE_A
	 */
	private static final String PACKET_TYPE_ID_555 = "555";

	/**
	 * The test parameter A value based upon the TEST_BITSET_STRING_PKT_TYPE_A
	 */
	private static final int PARAM_A_TEST_VALUE = 123;
	
	/**
	 * The total length of the mock factory container model with a packet type A set (555).
	 */
	private final static int PKT_TYPE_A_MODEL_FRAME_LENGTH = 61;
	
	/**
	 * Based upon the MockContainerFactory this Bit String encodes the Mock Container model with values representing a
	 * snapshot of telemetry.
	 * 
	 * See class javadoc for details
	 */
	private final static String TEST_BITSET_STRING_PKT_TYPE_B = "110110010100000000100000000000011101011110001101101001000010000000000000000000000000000000001";
	
	/**
	 * The packet ID value based upon the TEST_BITSET_STRING_PKT_TYPE_B
	 */
	private static final String PACKET_TYPE_ID_333 = "333";
	
	/**
	 * The test parameter B value based upon the TEST_BITSET_STRING_PKT_TYPE_B
	 */
	private static final float PARAM_B_TEST_VALUE = 54.78f;
	
	/**
	 * The total length of the mock factory container model with a packet type B set (333).
	 */
	private final static int PKT_TYPE_B_MODEL_FRAME_LENGTH = 93;

	/**
	 * Set's up the FrameBroker with a mock container model factory.
	 */
	@BeforeClass
	public static void setUpForAllTests() {
	}

	@Before
	public void setUpPerTest() throws InvalidParameterTypeException {
		mockContainerFactory = new MockContainerModelFactory();
	}

	@Test
	public void testGetLength() throws UnknownContainerNameException {
		Container tmframe = mockContainerFactory.getContainer("TMFrame");

		int length = tmframe.getLength();
		// Using default values, i.e. everything 0 including packet type ID we should get the length
		// of the model with NO parameters.
		assertEquals("Comparing length of tmframe", DEFAULT_MODEL_FRAME_LENGTH, length);

		mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS).setValue(Integer.valueOf(MockContainerModelFactory.PACKET_TYPE_A_ID));
		length = tmframe.getLength();
		assertEquals("Comparing length of tmframe", PKT_TYPE_A_MODEL_FRAME_LENGTH, length);

		mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS).setValue(Integer.valueOf(MockContainerModelFactory.PACKET_TYPE_B_ID));
		length = tmframe.getLength();

		assertEquals("Comparing length of tmframe", PKT_TYPE_B_MODEL_FRAME_LENGTH, length);
	}

	/**
	 * Simply tests the container can marshal with the default empty parameters.
	 * 
	 * @throws UnknownContainerNameException
	 * @throws BitSetOperationException
	 */
	@Test
	public void testEmptyMarshall() throws UnknownContainerNameException, BitSetOperationException {
		Container tmframe = mockContainerFactory.getContainer("TMFrame");

		BitSet marshalledFrame = new BitSet();
		tmframe.marshall(marshalledFrame, 0);

		assertEquals(BitSetUtility.stringToBitSet(EMPTY_CONTAINER_MODEL_BITSET_STRING), marshalledFrame);
	}

	/**
	 * Test method for checking a valid BitSet can be unmarshalled into a collection of Java objects (the Containers)
	 * {@link com.logica.hummingbird.spacesystemmodel.ContainerImpl#unmarshall(java.util.BitSet)}.
	 * 
	 * NOTE: Test Param B (the 64 bit float) is not checked because the {@link TEST_BITSET_STRING} has the packet type
	 * id set to 555. The model restricts this id to packet type a which only contains test param A (a 32 bit int).
	 * 
	 * @throws UnknownContainerNameException
	 * @throws BitSetOperationException
	 */
	@Test
	public void testUnmarshallFrameTestParamA() throws UnknownContainerNameException, BitSetOperationException {
		LOG.info("Beginning test");

		BitSet frame = BitSetUtility.stringToBitSet(TEST_BITSET_STRING_PKT_TYPE_A);

		Container tmframe = mockContainerFactory.getContainer("TMFrame");
		tmframe.unmarshall(frame);

		LOG.debug("The container frame after unmarshalling: " + tmframe);
		
		// Check the unmarshalling was successful...
		// Test the parameter type ID (Apid) was unmarshalled as an IntegerParameter with value 555 (PACKET_TYPE_ID_555)
		// Container paramTypeID = testFrameBroker.getContainer(MockContainerModelFactory.PACKET_ID_NAME);
		Container paramTypeID = mockContainerFactory.getContainer(MockContainerModelFactory.PACKET_ID_ALIAS);
		Assert.isInstanceOf(IntegerParameter.class, paramTypeID);
		Number value = ((IntegerParameter) paramTypeID).getValue();
		LOG.info("Checking " + MockContainerModelFactory.PACKET_ID_ALIAS);
		assertEquals("Parameter has incorrect value.", Integer.parseInt(PACKET_TYPE_ID_555), value.intValue());
		LOG.debug(MockContainerModelFactory.PACKET_ID_ALIAS + " parameter (apid) passed with value : " + value.intValue());

		// Test that there is a Test Param A (32 bit unsigned int) as expected.
		// Container testParamA = testFrameBroker.getContainer(MockContainerModelFactory.TEST_PARAM_A);
		Container testParamA = mockContainerFactory.getContainer(MockContainerModelFactory.TEST_PARAM_A);
		Assert.isInstanceOf(IntegerParameter.class, testParamA);
		Number testParamAvalue = ((IntegerParameter) testParamA).getValue();
		LOG.info("Checking " + MockContainerModelFactory.TEST_PARAM_A);
		assertEquals("Parameter has incorrect value.", PARAM_A_TEST_VALUE, testParamAvalue.intValue());
		LOG.debug(MockContainerModelFactory.TEST_PARAM_A + " parameter passed with value : " + testParamAvalue.intValue());

		// Test the container models happy flag and the validity flag
		// Both expected to be the default value of 0 since we never set a value.
		final int expectedValue = 1;
		Container happyFlag = mockContainerFactory.getContainer(MockContainerModelFactory.HAPPY_FLAG_ALIAS);
		Assert.isInstanceOf(IntegerParameter.class, happyFlag);
		Number happyFlagValue = ((IntegerParameter) happyFlag).getValue();
		LOG.info("Checking " + MockContainerModelFactory.HAPPY_FLAG_ALIAS);
		assertEquals("Parameter has incorrect value.", expectedValue, happyFlagValue.intValue());
		LOG.debug(MockContainerModelFactory.HAPPY_FLAG_ALIAS + " parameter passed with value : " + happyFlagValue.intValue());

		Container validityFlag = mockContainerFactory.getContainer(MockContainerModelFactory.VALIDITY_FLAG_ALIAS);
		Assert.isInstanceOf(IntegerParameter.class, validityFlag);
		Number vFlagValue = ((IntegerParameter) validityFlag).getValue();
		LOG.info("Checking " + MockContainerModelFactory.VALIDITY_FLAG_ALIAS);
		assertEquals("Parameter has incorrect value.", expectedValue, vFlagValue.intValue());
		LOG.debug(MockContainerModelFactory.VALIDITY_FLAG_ALIAS + " parameter passed with value : " + vFlagValue.intValue());
	}

	@Test
	public void testUnmarshallFrameTestParamB() throws UnknownContainerNameException, BitSetOperationException {
		LOG.info("Beginning test");

		BitSet frame = BitSetUtility.stringToBitSet(TEST_BITSET_STRING_PKT_TYPE_B);

		Container tmframe = mockContainerFactory.getContainer("TMFrame");
		tmframe.unmarshall(frame);
		
		LOG.debug("The container frame after unmarshalling: " + tmframe);
		
		// Check the unmarshalling was successful...
		// Test the parameter type ID (Apid) was unmarshalled as an IntegerParameter with value 333 (PACKET_TYPE_ID_333)
		Container paramTypeID = mockContainerFactory.getContainer(MockContainerModelFactory.PACKET_ID_ALIAS);
		Assert.isInstanceOf(IntegerParameter.class, paramTypeID);
		Number value = ((IntegerParameter) paramTypeID).getValue();
		LOG.info("Checking " + MockContainerModelFactory.PACKET_ID_ALIAS);
		assertEquals("Parameter has incorrect value.", Integer.parseInt(PACKET_TYPE_ID_333), value.intValue());
		LOG.debug(MockContainerModelFactory.PACKET_ID_ALIAS + " parameter (apid) passed with value : " + value.intValue());
		
		// Test that there is a Test Param B (64 bit unsigned float) as expected.
		Container testParamB = mockContainerFactory.getContainer(MockContainerModelFactory.TEST_PARAM_B);
		Assert.isInstanceOf(FloatParameter.class, testParamB);
		Number testParamBvalue = ((FloatParameter) testParamB).getValue();
		LOG.info("Checking " + MockContainerModelFactory.TEST_PARAM_B);
		assertEquals("Parameter has incorrect value.", PARAM_B_TEST_VALUE, testParamBvalue.intValue(), 0);
		LOG.debug(MockContainerModelFactory.TEST_PARAM_A + " parameter passed with value : " + testParamBvalue.intValue());
	}

	/**
	 * Tests marshalling a <b>valid</b> population of a Mock Container Model. The Model is populated in the test method.
	 * {@link com.logica.hummingbird.spacesystemmodel.ContainerImpl#marshall(java.util.BitSet, int)} .
	 * 
	 * @throws UnknownContainerNameException
	 * @throws BitSetOperationException
	 */
	@Test
	public void testMarshallOfValidModel() throws UnknownContainerNameException, BitSetOperationException {
		LOG.info("Beginning test");

		LOG.debug("SSModel before setting values: " + mockContainerFactory.getContainer("TMFrame").toString());

		/** Populate the input mock frame parameter values **/
		// Set the Frame Header
		mockContainerFactory.getParameter(MockContainerModelFactory.HAPPY_FLAG_ALIAS).setValue(1);

		// Set the packet id to 555 (Packet ID type A)
		ParameterImpl apid = mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS);
		apid.setValue(Float.valueOf(MockContainerModelFactory.PACKET_TYPE_A_ID));

		// Set the payload length to 32 (the length of test param A)
		mockContainerFactory.getParameter(MockContainerModelFactory.PAYLOAD_LENGTH_PARAM_ALIAS).setValue(32);

		// Set parameter A value
		ParameterImpl paramA = mockContainerFactory.getParameter(MockContainerModelFactory.TEST_PARAM_A);
		paramA.setValue(PARAM_A_TEST_VALUE);

		// Set the Frame Tail
		mockContainerFactory.getParameter(MockContainerModelFactory.VALIDITY_FLAG_ALIAS).setValue(1);

		LOG.debug("SSModel after setting values: " + mockContainerFactory.getContainer("TMFrame").toString());

		// Get the frame length, that is, the sum of itself and it's tree of sub
		// containers and set the target bitset to this length.
		int length = mockContainerFactory.getContainer("TMFrame").getLength();
		if (LOG.isDebugEnabled()) {
			LOG.debug("TMFrame from space system model is of length = " + length);
		}

		// Marshall the Frame to a bitset
		BitSet marshalledFrame = new BitSet();
		Container tmframe = mockContainerFactory.getContainer("TMFrame");
		tmframe.marshall(marshalledFrame, 0);

		LOG.debug("Bitset length = " + marshalledFrame.length());
		String binDump = BitSetUtility.binDump(marshalledFrame);
		LOG.debug(binDump);

		assertEquals("BitSets not equal", BitSetUtility.stringToBitSet(TEST_BITSET_STRING_PKT_TYPE_A), marshalledFrame);

		assertEquals("BitSets length not as expected", marshalledFrame.length(), TEST_BITSET_STRING_PKT_TYPE_A.length());

		// Now let's marshall a parameter and run some tests.
		BitSet apidBitSet = new BitSet(mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS).getLength());
		Container packet = mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS);
		packet.marshall(apidBitSet, 0);
		String apidBinDump = BitSetUtility.binDump(apidBitSet);
		if (LOG.isDebugEnabled()) {
			LOG.debug(mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS) + " = " + apidBinDump);
		}

		String apidBinValue = Integer.toBinaryString(Integer.valueOf(MockContainerModelFactory.PACKET_TYPE_A_ID));
		// LSB first so we need to reverse the dumped string.
		apidBinValue = new StringBuffer(apidBinValue).reverse().toString();
		// BitSets are rounded up to 64 bits so we will have to pad the marshalled APID with extra 0's
		// We will calculate the required zeros using the apid's length so we don't spoil the test
		int requiredPadding = 64 - apidBinValue.length();
		char[] zeroPadding = new char[requiredPadding];
		for (int c = 0; c < requiredPadding; c++) {
			zeroPadding[c] = '0';
		}
		StringBuffer apidBinValueWithPadding = new StringBuffer(apidBinValue);
		apidBinValueWithPadding.append(zeroPadding);
		assertEquals("Apid does not match", StringUtils.deleteWhitespace(apidBinDump), apidBinValueWithPadding.toString());
	}
}
