/**
 *
 */
package com.logica.hummingbird.packetbroker;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.testsupport.MockParameterContainerModel;
import com.logica.hummingbird.telemetry.HummingbirdPacket;
import com.logica.hummingbird.telemetry.HummingbirdParameter;
import com.logica.hummingbird.util.BitSetUtility;
import com.logica.hummingbird.util.exceptions.BitSetOperationException;

/**
 * @author Mark Doyle
 * @TODO Test is not complete - awaiting commons telemetry models to be finalised
 */
public class PacketBrokerImplTest {
	/** Logger for this class */
	private static final Logger LOG = LoggerFactory.getLogger(PacketBrokerImplTest.class);
	
	/** APID 333 LE unsigned */
	public static final String FLIGHT_DATA_APID = "10110010100";
	public static final int FLIGHT_DATA_APID_VALUE = 333;
	/** APID 555 LE unsigned */
	public static final String LASER_DATA_APID = "11010100010";
	public static final int LASER_DATA_APID_VALUE = 555;
	/** APID 999 LE unsigned */
	public static final String ALL_SYS_DATA_APID = "11100111110";
	public static final int ALL_SYS_DATA_APID_VALUE = 999;

	/** 32 bit packet length represented as a 16bit LE unsigned */
	public static final String PACKET_LENGTH_32 = "0000010000000000";
	public static final String PACKET_LENGTH_64 = "0000001000000000";
	public static final String PACKET_LENGTH_96 = "0000011000000000";

	/** 1024 flight hours (32 bit big endian unsigned int) */
	public static final String FLIGHT_HOURS_1024 = "00000000000000000000010000000000";
	public static final int FLIGHT_HOURS_VALUE= 1024;

	/** 17949.25 Laser temperature (64 bit signed float) */
	public static final String LASER_TEMP_17959_25 = "0100000011010001100010011101000000000000000000000000000000000000";
	public static final double LASER_TEMP_VALUE = 17959.25;


	private MockParameterContainerModel mockSpaceSystemFactory;

	private PacketBroker packetBroker;

	/** The HumminbirdPacket version of the test bitset packet. */
	private static HummingbirdPacket testPacket = null;

	/**
	 * Set up the Mock Container Factory and create the testFrame for use by the tests.
	 */
	@BeforeClass
	public static void setupForAll() throws SecurityException, IllegalArgumentException, IllegalAccessException {
	}

	/**
	 * Create the packet broker. We do this before each test as we don't know how a test may effect the state of a
	 * packet broker. Just to be sure ;)
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mockSpaceSystemFactory = new MockParameterContainerModel();
		packetBroker = new HummingbirdPacketBroker(mockSpaceSystemFactory);
	}

	/**
	 * Test method for
	 * {@link com.logica.hummingbird.framebroker.PacketBrokerImpl#unmarshall(java.lang.String, java.util.BitSet)}.
	 * 
	 * @throws UnknownContainerNameException
	 * @throws BitSetOperationException
	 */
	@Test
	public final void testUnmarshallFlightDataPacket() throws UnknownContainerNameException, BitSetOperationException {
		LOG.info("---------- testUnmarshall -------------");
		
		BitSet mockPacket = BitSetUtility.stringToBitSet(FLIGHT_DATA_APID + PACKET_LENGTH_32 + FLIGHT_HOURS_1024, false);
		final int PAYLOAD_PACKET_LENGTH = 32;

		// Unmarshall each telemetry element in the space system model
		packetBroker.unmarshall(MockParameterContainerModel.TM_PACKET_ALIAS, mockPacket);
		HummingbirdPacket unmarshalledPacket = packetBroker.getPacket();
		LOG.debug("Unmarshalled Frame: " + unmarshalledPacket);
		
		List<HummingbirdParameter> parameters = unmarshalledPacket.getParameters();
		assertEquals("There should be three paramters", parameters.size(), 3);
		
		HummingbirdParameter apidParam = unmarshalledPacket.getParameter(MockParameterContainerModel.PAYLOAD_APID_ALIAS);
		assertEquals("Apid should be " + FLIGHT_DATA_APID_VALUE, FLIGHT_DATA_APID_VALUE, apidParam.getValue());
		
		HummingbirdParameter packetPayloadLength = unmarshalledPacket.getParameter(MockParameterContainerModel.PAYLOAD_LENGTH_PARAM_ALIAS);
		assertEquals("Packet payload length should be " + PAYLOAD_PACKET_LENGTH, PAYLOAD_PACKET_LENGTH, packetPayloadLength.getValue());
		
		HummingbirdParameter flightHourParam = unmarshalledPacket.getParameter(MockParameterContainerModel.FLIGHT_HOURS_PARAM);
		assertEquals("Flight hours should be " + FLIGHT_HOURS_VALUE, FLIGHT_HOURS_VALUE, flightHourParam.getValue());

		LOG.info("---------- testUnmarshall finish -------------");
	}
	
	@Test
	public final void testUnmarshallLaserDataPacket() throws UnknownContainerNameException, BitSetOperationException {
		LOG.info("---------- testUnmarshall -------------");
		
		BitSet mockPacket = BitSetUtility.stringToBitSet(LASER_DATA_APID + PACKET_LENGTH_64 + LASER_TEMP_17959_25, false);
		final int PAYLOAD_PACKET_LENGTH = 64;

		// Unmarshall each telemetry element in the space system model
		packetBroker.unmarshall(MockParameterContainerModel.TM_PACKET_ALIAS, mockPacket);
		HummingbirdPacket unmarshalledPacket = packetBroker.getPacket();
		if(LOG.isDebugEnabled()) {
			LOG.debug("Unmarshalled Frame: " + unmarshalledPacket);
		}
		
		List<HummingbirdParameter> parameters = unmarshalledPacket.getParameters();
		assertEquals("There should be three paramters", parameters.size(), 3);
		
		HummingbirdParameter apidParam = unmarshalledPacket.getParameter(MockParameterContainerModel.PAYLOAD_APID_ALIAS);
		assertEquals("Apid should be " + LASER_DATA_APID_VALUE, LASER_DATA_APID_VALUE, apidParam.getValue());
		
		HummingbirdParameter packetPayloadLength = unmarshalledPacket.getParameter(MockParameterContainerModel.PAYLOAD_LENGTH_PARAM_ALIAS);
		assertEquals("Packet payload length should be " + PAYLOAD_PACKET_LENGTH, PAYLOAD_PACKET_LENGTH, packetPayloadLength.getValue());
		
		HummingbirdParameter laserTempParam = unmarshalledPacket.getParameter(MockParameterContainerModel.LASER_TEMP_PARAM);
		assertEquals("Flight hours should be " + LASER_TEMP_VALUE, LASER_TEMP_VALUE, laserTempParam.getValue());

		LOG.info("---------- testUnmarshall finish -------------");
	}


	@Test
	@Ignore
	public final void testMarshallStringBitSet() throws UnknownContainerNameException, BitSetOperationException {

	}

	@Ignore
	@Test
	public final void testMarshallStringString() {
	}

}
