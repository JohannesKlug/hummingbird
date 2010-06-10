/**
 * 
 */
package com.logica.hummingbird.framebroker;

import java.util.BitSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterImpl;
import com.logica.hummingbird.spacesystemmodel.testsupport.MockContainerModelFactory;
import com.logica.hummingbird.telemetry.TelemetryFrame;
import com.logica.hummingbird.telemetry.TelemetryPacket;
import com.logica.hummingbird.telemetry.CcsdsTelemetryPacketHeader;
import com.logica.hummingbird.telemetry.TelemetryPacketPayload;
import com.logica.hummingbird.telemetry.TelemetryParameter;
import com.logica.hummingbird.telemetry.ccsds.CcsdsFrameHeader;
import com.logica.hummingbird.telemetry.ccsds.CcsdsFrameTail;
import com.logica.hummingbird.telemetry.ccsds.CcsdsTmPacketHeader;
import com.logica.hummingbird.telemetry.ccsds.CcsdsTmPacketPayload;
import com.logica.hummingbird.telemetry.ccsds.CcsdsTmFrame;
import com.logica.hummingbird.telemetry.ccsds.CcsdsTmPacket;
import com.logica.hummingbird.telemetry.ccsds.CcsdsTmParameter;
import com.logica.hummingbird.util.BitSetUtility;

/**
 * @author Mark Doyle
 * @TODO Test is not complete - awaiting commons telemetry models to be finalised
 */
public class FrameBrokerImplTest {
	
	/**
	 * Logger for this class
	 */
	private static final Logger LOG = LoggerFactory.getLogger(FrameBrokerImplTest.class);

	private IFrameBroker frameBroker;

	/**
	 * Based upon the MockContainerFactory this Bit String encodes the Mock Container model with a param type ID of 555
	 * and a param A test value of 123
	 */
	private final static String TEST_BITSET_FRAME = "11010100010110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
	
	/**
	 * Based upon the MockContainerFactory this Bit String encodes the Mock Container model with a param type ID of 555
	 * only.  There is just an apid in the packet header.
	 */
	private final static String TEST_BITSET_PACKETHEADER_ONLY = "11010100010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

	/**
	 * The TelemetryFrame version of the test bitset frame.
	 */
	private static TelemetryFrame testFrame = null;

	private MockContainerModelFactory mockSpaceSystemFactory;
	
	/**
	 * A value used in testing to set param A to a value.
	 */
	private static final int PARAM_A_TEST_VALUE = 123;

	/**
	 * Set up the Mock Container Factory and create the testFrame for use by the tests.
	 */
	@BeforeClass
	public static void setupForAll() {		
		// Create the test frame
		testFrame = new CcsdsTmFrame();
		
		// Create the test frame inners
		CcsdsFrameHeader testFrameHeader = new CcsdsFrameHeader();
		CcsdsFrameTail testFrameTail = new CcsdsFrameTail();
		TelemetryPacket packet = new CcsdsTmPacket();
		CcsdsTelemetryPacketHeader packetHeader = new CcsdsTmPacketHeader();
		TelemetryPacketPayload payload = new CcsdsTmPacketPayload();
		packet.setHeader(packetHeader);
		packet.setPayload(payload);
		
		// Create the payload
//		TelemetryParameter apid = new CcsdsTmParameter("APID", 555, Integer.class);
		packetHeader.addApid(555);
		
		TelemetryParameter testParamA = new CcsdsTmParameter("Test Param A", 123, Integer.class);
		payload.addParameter(testParamA);

		
		// Add the inners to the test frame
		testFrame.setHeader(testFrameHeader);
		testFrame.addPacket(packet);
		testFrame.setTail(testFrameTail);
		
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
		frameBroker = new FrameBrokerImpl(mockSpaceSystemFactory);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.FrameBrokerImpl#unmarshall(java.lang.String, java.util.BitSet)}.
	 * 
	 * @throws UnknownContainerNameException
	 * @throws BitSetOperationException
	 */
	@Test
	public final void testUnmarshallFrame() throws UnknownContainerNameException, BitSetOperationException {
		LOG.info("---------- testUnmarshall -------------");
		BitSet mockFrame = BitSetUtility.fromString(TEST_BITSET_FRAME);

		// Unmarshall each telemetry element in the space system model
		frameBroker.unmarshall(MockContainerModelFactory.TM_FRAME_ALIAS, mockFrame);
		TelemetryFrame unmarshalledFrame = frameBroker.getFrame();
		LOG.info("Unmarshalled Frame: " + unmarshalledFrame);

	}
	
	@Ignore
	@Test
	public final void testUnmarshallFrameHeader() throws BitSetOperationException, UnknownContainerNameException {
		LOG.info("---------- testUnmarshallFrameHeader -------------");
		BitSet mockFrame = BitSetUtility.fromString(TEST_BITSET_FRAME);
		
		frameBroker.unmarshall(MockContainerModelFactory.TM_FRAME_HEADER_ALIAS, mockFrame);
		
		TelemetryFrame unmarshalledFrameHeader = frameBroker.getFrame();
		LOG.info("Unmarshalled Frame: " + unmarshalledFrameHeader);
	}
		
//		frameBroker.unmarshall(MockContainerModelFactory.TM_FRAME_TAIL_ALIAS, mockFrame);
//		frameBroker.unmarshall(MockContainerModelFactory.TM_PACKET_ALIAS, mockFrame);
//		frameBroker.unmarshall(MockContainerModelFactory.TM_PACKET_HEADER_ALIAS, mockFrame);
//		frameBroker.unmarshall(MockContainerModelFactory.TM_PACKET_BODY_ALIAS, mockFrame);

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.FrameBrokerImpl#marshall(java.lang.String, java.util.BitSet)}.
	 * @throws UnknownContainerNameException 
	 * @throws BitSetOperationException 
	 */
	@Test
	public final void testMarshallStringBitSet() throws UnknownContainerNameException, BitSetOperationException {
		LOG.info("---------- testMarshallStringBitSet -------------");
		// Set the id parameter (apid) to 555.
		ParameterImpl apid = mockSpaceSystemFactory.getParameter(MockContainerModelFactory.PACKET_ID_NAME);
		apid.setValue(Float.valueOf(MockContainerModelFactory.PACKET_TYPE_A_ID));

		// Set parameter A value
		ParameterImpl paramA = mockSpaceSystemFactory.getParameter(MockContainerModelFactory.TEST_PARAM_A);
		paramA.setValue(PARAM_A_TEST_VALUE);

		// Create an empty bitset to marshal the frame into
		BitSet marshalledFrame = new BitSet(TEST_BITSET_FRAME.length());
		
		// Marshall the frame
		frameBroker.marshall(MockContainerModelFactory.TM_FRAME_ALIAS, marshalledFrame);
		
		LOG.info("Marshalled Frame: " + BitSetUtility.binDump(marshalledFrame));

		BitSet testBitset = BitSetUtility.fromString(TEST_BITSET_FRAME);
		LOG.debug("Test target bindump: " + BitSetUtility.binDump(testBitset));
		assertEquals("Marshalled frame should be the same as the TEST_BITSET_FRAME", testBitset, marshalledFrame);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.FrameBrokerImpl#marshall(java.lang.String, java.lang.String)}.
	 */
	@Ignore
	@Test
	public final void testMarshallStringString() {
		LOG.info("---------- testMarshallStringString -------------");
		// TODO
	}

}
