/**
 * 
 */
package com.logica.hummingbird.framebroker;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.ccsds.telemetry.CcsdsTmFrame;
import com.logica.ccsds.telemetry.CcsdsTmFrameHeader;
import com.logica.ccsds.telemetry.CcsdsTmFrameTail;
import com.logica.ccsds.telemetry.CcsdsTmPacket;
import com.logica.ccsds.telemetry.CcsdsTmPacketHeader;
import com.logica.ccsds.telemetry.CcsdsTmPacketPayload;
import com.logica.ccsds.telemetry.CcsdsTmParameter;
import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterContainer;
import com.logica.hummingbird.spacesystemmodel.testsupport.MockContainerModelFactory;
import com.logica.hummingbird.util.BitSetUtility;

/**
 * @author Mark Doyle
 * @TODO Test is not complete - awaiting commons telemetry models to be finalised
 */
public class CcsdsPacketBrokerImplTest {
	
	/**
	 * Logger for this class
	 */
	private static final Logger LOG = LoggerFactory.getLogger(CcsdsPacketBrokerImplTest.class);

	private CcsdsPacketBroker frameBroker;

	/**
	 * Based upon the MockContainerFactory this Bit String encodes the Mock Container model with a param type ID of 555
	 * and a param A test value of 123
	 */
	private final static String TEST_BITSET_FRAME = "1110101000100000000000000000110111100000000000000000000000001";
	
	/**
	 * Based upon the MockContainerFactory this Bit String encodes the Mock Container model with a param type ID of 555
	 * only.  There is just an apid in the packet header.
	 */
	private final static String TEST_BITSET_PACKETHEADER_ONLY = "11010100010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

	/**
	 * The TelemetryFrame version of the test bitset frame.
	 */
	private static CcsdsTmFrame testFrame = null;

	private MockContainerModelFactory mockSpaceSystemFactory;
	
	/**
	 * A value used in testing to set param A to a value.
	 */
	private static final int PARAM_A_TEST_VALUE = 123;

	/**
	 * Set up the Mock Container Factory and create the testFrame for use by the tests.
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 */
	@BeforeClass
	public static void setupForAll() throws SecurityException, IllegalArgumentException, IllegalAccessException {		
		// Create the test frame
		testFrame = new CcsdsTmFrame();
		
		// Create the test frame inners
		CcsdsTmFrameHeader testFrameHeader = new CcsdsTmFrameHeader();
		CcsdsTmFrameTail testFrameTail = new CcsdsTmFrameTail();
		CcsdsTmPacket packet = new CcsdsTmPacket("Test packet");
		CcsdsTmPacketHeader packetHeader = new CcsdsTmPacketHeader();
		CcsdsTmPacketPayload payload = new CcsdsTmPacketPayload();
		packet.setHeader(packetHeader);
		packet.setPayload(payload);
		
		// Add the inners to the test frame
		testFrame.setHeader(testFrameHeader);
		testFrame.addPacket(packet);
		testFrame.setTail(testFrameTail);
		
		// Create the payload
		int APID_555 = 555;
		testFrame.setParameterInFrame(new CcsdsTmParameter("apid", APID_555, Integer.class));
		
		// Use the reflection setter from Frame?
		CcsdsTmParameter testParamA = new CcsdsTmParameter("Test Param A", 123, Integer.class);
		payload.addParameter(testParamA);		
		
		LOG.info("Hummingbird frame: " + testFrame);
	}

	/**
	 * Create the frame broker.
	 * We do this before each test as we don't know how a test may effect the state
	 * of a frame broker.  Just to be sure ;)
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mockSpaceSystemFactory = new MockContainerModelFactory();
		frameBroker = new CcsdsPacketBrokerImpl(mockSpaceSystemFactory);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.CcsdsPacketBrokerImpl#unmarshall(java.lang.String, java.util.BitSet)}.
	 * 
	 * @throws UnknownContainerNameException
	 * @throws BitSetOperationException
	 */
	@Test
	@Ignore
	public final void testUnmarshallFrame() throws UnknownContainerNameException, BitSetOperationException {
//		LOG.info("---------- testUnmarshall -------------");
//		BitSet mockFrame = BitSetUtility.stringToBitSet(TEST_BITSET_FRAME, false);

		// Unmarshall each telemetry element in the space system model
//		frameBroker.unmarshall(MockContainerModelFactory.TM_FRAME_ALIAS, mockFrame);
//		CcsdsTmFrame unmarshalledFrame = frameBroker.getFrame();
//		LOG.info("Unmarshalled Frame: " + unmarshalledFrame);
	}
	
	@Ignore
	@Test
	public final void testUnmarshallFrameHeader() throws BitSetOperationException, UnknownContainerNameException {
//		LOG.info("---------- testUnmarshallFrameHeader -------------");
//		BitSet mockFrame = BitSetUtility.stringToBitSet(TEST_BITSET_FRAME, false);
//		
//		frameBroker.unmarshall(MockContainerModelFactory.TM_FRAME_HEADER_ALIAS, mockFrame);
//		
//		CcsdsTmFrame unmarshalledFrameHeader = frameBroker.getFrame();
//		LOG.info("Unmarshalled Frame: " + unmarshalledFrameHeader);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.CcsdsPacketBrokerImpl#marshall(java.lang.String, java.util.BitSet)}.
	 * @throws UnknownContainerNameException 
	 * @throws BitSetOperationException 
	 */
	@Test
	public final void testMarshallStringBitSet() throws UnknownContainerNameException, BitSetOperationException {
		LOG.info("---------- testMarshallStringBitSet -------------");
		// Set the id parameter (apid) to 555.
		ParameterContainer apid = mockSpaceSystemFactory.getParameter(MockContainerModelFactory.PACKET_ID_ALIAS);
		apid.setValue(Float.valueOf(MockContainerModelFactory.PACKET_TYPE_A_ID));

		// Set parameter A value
		ParameterContainer paramA = mockSpaceSystemFactory.getParameter(MockContainerModelFactory.TEST_PARAM_A);
		paramA.setValue(PARAM_A_TEST_VALUE);
		
		mockSpaceSystemFactory.getParameter(MockContainerModelFactory.HAPPY_FLAG_ALIAS).setValue(1);
		
		mockSpaceSystemFactory.getParameter(MockContainerModelFactory.VALIDITY_FLAG_ALIAS).setValue(1);

		// Create an empty bitset to marshal the frame into
		BitSet marshalledFrame = new BitSet(TEST_BITSET_FRAME.length());
		
		// Marshall the frame
		frameBroker.marshall(MockContainerModelFactory.TM_FRAME_ALIAS, marshalledFrame);
		
		LOG.info("Marshalled Frame: " + BitSetUtility.binDump(marshalledFrame));

		BitSet testBitset = BitSetUtility.stringToBitSet(TEST_BITSET_FRAME, false);
		LOG.debug("Test target bindump: " + BitSetUtility.binDump(testBitset));
		assertEquals("Marshalled frame should be the same as the TEST_BITSET_FRAME", testBitset, marshalledFrame);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.CcsdsPacketBrokerImpl#marshall(java.lang.String, java.lang.String)}.
	 */
	@Ignore
	@Test
	public final void testMarshallStringString() {
		LOG.info("---------- testMarshallStringString -------------");
		// TODO
	}

}
