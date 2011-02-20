package org.hbird.transport.xtce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.hbird.transport.generatedcode.xtce.SpaceSystem;
import org.hbird.transport.spacesystemmodel.parameters.ParameterContainer;
import org.hbird.transport.xtce.exceptions.InvalidXtceFileException;
import org.junit.BeforeClass;
import org.junit.Test;

public class XtceFactoryTest {

	private static final int NUM_OF_PARAMETERS = 4;
	private static final int NUM_OF_CONTAINERS = 9;

	private static final String XWING_APID_NAME = "XWING_APID";
	private static final String XWING_APID_TYPE = "11bitInteger";
	private static final int XWING_APID_LENGTH = 11;

	private static final String XWING_PACKET_LENGTH_NAME = "PACKET_LENGTH";
	private static final String XWING_PACKET_LENGTH_TYPE = "16bitInteger";
	private static final int XWING_PACKET_LENGTH_LENGTH = 16;

	private static final String XWING_FLIGHT_HOURS_NAME = "XWING_FLIGHT_HOURS";
	private static final String XWING_FLIGHT_HOURS_TYPE = "32bitInteger";
	private static final int XWING_FLIGHT_HOURS_LENGTH = 32;

	private static final String XWING_LASER_TEMP_NAME = "XWING_LASER_TEMP";
	private static final String XWING_LASER_TEMP_TYPE = "64bitFloat";
	private static final int XWING_LASER_TEMP_LENGTH = 64;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testSpaceSystemCreation() throws InvalidXtceFileException {
		XtceModelFactory factory = new XtceModelFactory("target/test-classes/simpleX-Wing.xml");

		// Get the space system. This will trigger the unmarshalling and creation of the Space System.
		SpaceSystem ss = factory.getSpaceSystem();
		assertNotNull(ss);

		assertEquals(NUM_OF_CONTAINERS, factory.getAllContainers().size());


		Map<String, ParameterContainer> allParameters = factory.getAllParameters();
		assertEquals(NUM_OF_PARAMETERS, allParameters.size());
		assertTrue(allParameters.containsKey(XWING_APID_NAME));
		assertTrue(allParameters.containsKey(XWING_PACKET_LENGTH_NAME));
		assertTrue(allParameters.containsKey(XWING_FLIGHT_HOURS_NAME));
		assertTrue(allParameters.containsKey(XWING_LASER_TEMP_NAME));

		ParameterContainer param = null;
		param = allParameters.get(XWING_APID_NAME);
		assertNotNull(param);
		assertEquals(XWING_APID_LENGTH, param.getLength());


		param = allParameters.get(XWING_PACKET_LENGTH_NAME);
		assertNotNull(param);
		assertEquals(XWING_PACKET_LENGTH_LENGTH, param.getLength());

		param = allParameters.get(XWING_FLIGHT_HOURS_NAME);
		assertNotNull(param);
		assertEquals(XWING_FLIGHT_HOURS_LENGTH, param.getLength());

		param = allParameters.get(XWING_LASER_TEMP_NAME);
		assertNotNull(param);
		assertEquals(XWING_LASER_TEMP_LENGTH, param.getLength());

	}

}
