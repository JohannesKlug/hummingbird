/**
 * 
 */
package com.logica.hummingbird.framebroker;

import java.util.BitSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.BitSetUtility;
import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.testsupport.MockContainerModelFactory;
import com.logica.hummingbird.telemetry.TelemetryFrame;
import com.logica.hummingbird.telemetry.TelemetryPacket;
import com.logica.hummingbird.telemetry.TelemetryPacketHeader;
import com.logica.hummingbird.telemetry.TelemetryPacketPayload;
import com.logica.hummingbird.telemetry.TelemetryParameter;
import com.logica.hummingbird.telemetry.ccsds.CcsdsFrameHeader;
import com.logica.hummingbird.telemetry.ccsds.CcsdsFrameTail;
import com.logica.hummingbird.telemetry.ccsds.CcsdsTmPacketHeader;
import com.logica.hummingbird.telemetry.ccsds.CcsdsTmPacketPayload;
import com.logica.hummingbird.telemetry.ccsds.CcsdsTmFrame;
import com.logica.hummingbird.telemetry.ccsds.CcsdsTmPacket;
import com.logica.hummingbird.telemetry.ccsds.CcsdsTmParameter;
import com.logica.hummingbird.telemetry.types.ParameterIntegerType;

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
	 * The TelemetryFrame version of the test bitset frame.
	 */
	private static TelemetryFrame testFrame = null;

	private static MockContainerModelFactory mockSpaceSystemFactory;

	/**
	 * Set up the Mock Container Factory and create the testFrame for use by the tests.
	 */
	@BeforeClass
	public static void setupForAll() {
		mockSpaceSystemFactory = new MockContainerModelFactory();
		
		// Create the test frame
		testFrame = new CcsdsTmFrame();
		
		// Create the test frame inners
		CcsdsFrameHeader testFrameHeader = new CcsdsFrameHeader();
		CcsdsFrameTail testFrameTail = new CcsdsFrameTail();
		TelemetryPacket packet = new CcsdsTmPacket();
		TelemetryPacketHeader packetHeader = new CcsdsTmPacketHeader();
		TelemetryPacketPayload payload = new CcsdsTmPacketPayload();
		packet.setHeader(packetHeader);
		packet.setPayload(payload);
		
		// Create the payload
		TelemetryParameter apid = new CcsdsTmParameter("APID", 555, Integer.class);
		payload.addParameter(apid);
		
		// Add the inners to the test frame
		testFrame.setHeader(testFrameHeader);
		testFrame.addPacket(packet);
		testFrame.setTail(testFrameTail);
	}

	/**
	 * Create the framebroker.
	 * We do this before each test as we don't know how a test may effect the state
	 * of a framebroker.  Just to be sure ;)
	 * t
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		frameBroker = new FrameBrokerImpl(mockSpaceSystemFactory);
		LOG.info(mockSpaceSystemFactory.getContainer(MockContainerModelFactory.TM_FRAME_ALIAS).toString());
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.FrameBrokerImpl#unmarshall(java.lang.String, java.util.BitSet)}.
	 * 
	 * @throws UnknownContainerNameException
	 * @throws BitSetOperationException
	 */
	@Test
	public final void testUnmarshall() throws UnknownContainerNameException, BitSetOperationException {
		BitSet mockFrame = BitSetUtility.fromString(TEST_BITSET_FRAME);

		// Unmarshall each telemetry element in the space system model
		frameBroker.unmarshall(MockContainerModelFactory.TM_FRAME_ALIAS, mockFrame);
		TelemetryFrame unmarshalledFrame = frameBroker.getFrame();
		LOG.info("Unmarshalled Frame: " + unmarshalledFrame); 

		frameBroker.unmarshall(MockContainerModelFactory.TM_FRAME_HEADER_ALIAS, mockFrame);
		frameBroker.unmarshall(MockContainerModelFactory.TM_FRAME_TAIL_ALIAS, mockFrame);
		frameBroker.unmarshall(MockContainerModelFactory.TM_PACKET_ALIAS, mockFrame);
		frameBroker.unmarshall(MockContainerModelFactory.TM_PACKET_HEADER_ALIAS, mockFrame);
		frameBroker.unmarshall(MockContainerModelFactory.TM_PACKET_BODY_ALIAS, mockFrame);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.FrameBrokerImpl#marshall(java.lang.String, java.util.BitSet)}.
	 */
	@Test
	public final void testMarshallStringBitSet() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.FrameBrokerImpl#marshall(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testMarshallStringString() {
		// TODO
	}

}
