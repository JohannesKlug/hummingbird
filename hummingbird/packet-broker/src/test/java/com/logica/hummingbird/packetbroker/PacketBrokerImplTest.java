/**
 *
 */
package com.logica.hummingbird.packetbroker;

import java.util.BitSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.testsupport.MockParameterContainerModel;
import com.logica.hummingbird.telemetry.HummingbirdPacket;
import com.logica.hummingbird.util.BitSetUtility;
import com.logica.hummingbird.util.exceptions.BitSetOperationException;

/**
 * @author Mark Doyle
 * @TODO Test is not complete - awaiting commons telemetry models to be finalised
 */
public class PacketBrokerImplTest {
	/** APID 333 */
	public static final String FLIGHT_DATA_APID = "10110010100";
	/** APID 555 */
	public static final String LASER_DATA_APID = "11010100010";
	/** APID 999 */
	public static final String ALL_SYS_DATA_APID = "11100111110";

	// packet length (16bit unsigned int)
	public static final String PACKET_LENGTH_32 = "0000000000100000";
	public static final String PACKET_LENGTH_64 = "0000000001000000";
	public static final String PACKET_LENGTH_96 = "0000000001100000";
	//
	// 1024 flight hours (32bit int big endian unsigned)
	public static final String FLIGHT_HOURS_1024 = "00000000000000000000010000000000";
	//
	// 17949.25 Laser temperature (64 bit signed float)
	public static final String LASER_TEMP_17959_25 = "0100000011010001100001110101000000000000000000000000000000000000";

	/**
	 * Logger for this class
	 */
	private static final Logger LOG = LoggerFactory.getLogger(PacketBrokerImplTest.class);

	private PacketBroker packetBroker;

	/**
	 * The HumminbirdPacket version of the test bitset packet.
	 */
	private static HummingbirdPacket testPacket = null;

	private MockParameterContainerModel mockSpaceSystemFactory;

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
	public final void testUnmarshallPacket() throws UnknownContainerNameException, BitSetOperationException {
		LOG.info("---------- testUnmarshall -------------");
		BitSet mockPacket = BitSetUtility.stringToBitSet(FLIGHT_DATA_APID + PACKET_LENGTH_32 + FLIGHT_HOURS_1024, false);

		// Unmarshall each telemetry element in the space system model
		packetBroker.unmarshall(MockParameterContainerModel.TM_PACKET_ALIAS, mockPacket);
		HummingbirdPacket unmarshalledPacket = packetBroker.getPacket();
		LOG.debug("Unmarshalled Frame: " + unmarshalledPacket);
	}

	@Ignore
	@Test
	public final void testUnmarshallFrameHeader() throws BitSetOperationException, UnknownContainerNameException {
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
