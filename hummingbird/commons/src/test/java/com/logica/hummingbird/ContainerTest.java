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
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;
import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.parameters.FloatParameter;
import com.logica.hummingbird.spacesystemmodel.parameters.IntegerParameter;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterImpl;
import com.logica.hummingbird.spacesystemmodel.testsupport.MockContainerModelFactory;
import com.logica.hummingbird.util.BitSetUtility;

/**
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
	 * The total length of the mock factory container model.  This includes all possible parameters.  
	 */
	private final static int CONTAINER_MODEL_FRAME_LENGTH = 109;
	
	/**
	 * The total length of the mock factory container model with default values.
	 * This means the packet type ID is 0 so no packet types match.
	 */
	private final static int DEFAULT_MODEL_FRAME_LENGTH = 13;
	
	/**
	 * The total length of the mock factory container model with a packet type A set (555).
	 */
	private final static int PKT_TYPE_A_MODEL_FRAME_LENGTH = 45;
	
	/**
	 * The total length of the mock factory container model with a packet type B set (333).
	 */
	private final static int PKT_TYPE_B_MODEL_FRAME_LENGTH = 77;
	
	/**
	 * Based upon the MockContainerFactory this Bit String encodes the Mock Container model with values
	 * represetning a snapshot of telemetry.
	 * HappyFlag = 1
	 * Param type ID = 555
	 * Param A test = 123
	 * ValidityFlag = 1
	 * 
	 * Total length 45/
	 * NOTE: Param type ID is 555 so the packet type B is not used, i.e. the 64 bit float test param B
	 */
	private final static String TEST_BITSET_STRING = "111010100010110111100000000000000000000000001";
	
	/**
	 * The packet ID value based upon the TEST_BITSET_STRING
	 */
	private static final String PACKET_TYPE_ID_555 = "555";

	/**
	 * The test parameter A value based upon the TEST_BITSET_STRING
	 */
	private static final int PARAM_A_TEST_VALUE = 123;

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
		
		mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_NAME).setValue(Integer.valueOf(MockContainerModelFactory.PACKET_TYPE_A_ID));
		length = tmframe.getLength();
		assertEquals("Comparing length of tmframe", PKT_TYPE_A_MODEL_FRAME_LENGTH, length);
		
		mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_NAME).setValue(Integer.valueOf(MockContainerModelFactory.PACKET_TYPE_B_ID));
		length = tmframe.getLength();
		
		assertEquals("Comparing length of tmframe", PKT_TYPE_B_MODEL_FRAME_LENGTH, length);
	}
	
	/**
	 * Simply tests the container can marshal with the default empty parameters.
	 * @throws UnknownContainerNameException
	 * @throws BitSetOperationException
	 */
	@Test
	public void testEmptyMarshall() throws UnknownContainerNameException, BitSetOperationException {
		Container tmframe = mockContainerFactory.getContainer("TMFrame");
		
		BitSet marshalledFrame = new BitSet();
		tmframe.marshall(marshalledFrame, 0);	
		
		assertEquals(BitSetUtility.fromString(EMPTY_CONTAINER_MODEL_BITSET_STRING), marshalledFrame);
	}

	/**
	 * Test method for checking a valid BitSet can be unmarshalled into a collection of Java objects (the Containers)
	 * {@link com.logica.hummingbird.spacesystemmodel.ContainerImpl#unmarshall(java.util.BitSet)}.
	 * 
	 * NOTE: Test Param B (the 64 bit float) is not checked because the {@link TEST_BITSET_STRING} has the
	 * packet type id set to 555.  The model restricts this id to packet type a which only contains 
	 * test param A (a 32 bit int).
	 * 
	 * @throws UnknownContainerNameException
	 * @throws BitSetOperationException
	 */
	@Test
	public void testUnmarshallFrameTestParamA() throws UnknownContainerNameException, BitSetOperationException {
		LOG.info("Beginning test");

		BitSet frame = BitSetUtility.fromString(TEST_BITSET_STRING);

		Container tmframe = mockContainerFactory.getContainer("TMFrame");
		tmframe.unmarshall(frame);

		LOG.debug("The container frame after unmarshalling: " + tmframe);
		// Check the unmarshalling was successful...
		// Test the parameter type ID (Apid) was unmarshalled as an IntegerParameter with value 555 (PACKET_TYPE_ID_555)
		// Container paramTypeID = testFrameBroker.getContainer(MockContainerModelFactory.PACKET_ID_NAME);
		Container paramTypeID = mockContainerFactory.getContainer(MockContainerModelFactory.PACKET_ID_NAME);
		Assert.isInstanceOf(IntegerParameter.class, paramTypeID);
		Number value = ((IntegerParameter) paramTypeID).getValue();
		LOG.info("Checking " + MockContainerModelFactory.PACKET_ID_NAME);
		assertEquals("Parameter has incorrect value.", Integer.parseInt(PACKET_TYPE_ID_555), value.intValue());
		LOG.debug(MockContainerModelFactory.PACKET_ID_NAME + " parameter (apid) passed with value : " + value.intValue());

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
		Container happyFlag = mockContainerFactory.getContainer(MockContainerModelFactory.TM_FRAME_HEADER_HAPPY_FLAG);
		Assert.isInstanceOf(IntegerParameter.class, happyFlag);
		Number happyFlagValue = ((IntegerParameter) happyFlag).getValue();
		LOG.info("Checking " + MockContainerModelFactory.TM_FRAME_HEADER_HAPPY_FLAG);
		assertEquals("Parameter has incorrect value.", expectedValue, happyFlagValue.intValue());
		LOG.debug(MockContainerModelFactory.TM_FRAME_HEADER_HAPPY_FLAG + " parameter passed with value : " + happyFlagValue.intValue());
		
		Container validityFlag = mockContainerFactory.getContainer(MockContainerModelFactory.TM_FRAME_TAIL_VALIDITY_FLAG);
		Assert.isInstanceOf(IntegerParameter.class, validityFlag);
		Number vFlagValue = ((IntegerParameter) validityFlag).getValue();
		LOG.info("Checking " + MockContainerModelFactory.TM_FRAME_TAIL_VALIDITY_FLAG);
		assertEquals("Parameter has incorrect value.", expectedValue, vFlagValue.intValue());
		LOG.debug(MockContainerModelFactory.TM_FRAME_TAIL_VALIDITY_FLAG + " parameter passed with value : " + vFlagValue.intValue());
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
		
		LOG.debug(mockContainerFactory.getContainer("TMFrame").toString());

		/** Populate the input mock frame parameter values **/	
		// Set the Frame Header
		mockContainerFactory.getParameter(MockContainerModelFactory.TM_FRAME_HEADER_HAPPY_FLAG).setValue(1);
		
		// Set the Apid to Packet ID type A
		ParameterImpl apid = mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_NAME);
		apid.setValue(Float.valueOf(MockContainerModelFactory.PACKET_TYPE_A_ID));

		// Set parameter A value
		ParameterImpl paramA = mockContainerFactory.getParameter(MockContainerModelFactory.TEST_PARAM_A);
		paramA.setValue(PARAM_A_TEST_VALUE);
		
		// Set parameter B value
		mockContainerFactory.getParameter(MockContainerModelFactory.TEST_PARAM_B).setValue(0.0f);

		// Set the Frame Tail
		mockContainerFactory.getParameter(MockContainerModelFactory.TM_FRAME_TAIL_VALIDITY_FLAG).setValue(1);
		

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

		assertEquals("BitSets not equal", BitSetUtility.fromString(TEST_BITSET_STRING), marshalledFrame);
		
		assertEquals("BitSets length not as expected", marshalledFrame.length(), TEST_BITSET_STRING.length());

		// Now let's marshall a parameter and run some tests.
		BitSet apidBitSet = new BitSet(mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_NAME).getLength());
		Container packet = mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_NAME);
		packet.marshall(apidBitSet, 0);
		String apidBinDump = BitSetUtility.binDump(apidBitSet);
		if (LOG.isDebugEnabled()) {
			LOG.debug(mockContainerFactory.getParameter(MockContainerModelFactory.PACKET_ID_NAME) + " = " + apidBinDump);
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
