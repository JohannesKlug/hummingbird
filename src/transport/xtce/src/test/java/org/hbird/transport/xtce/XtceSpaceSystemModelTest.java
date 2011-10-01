package org.hbird.transport.xtce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Map;

import org.hbird.transport.generatedcode.xtce.SpaceSystem;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.xtce.exceptions.InvalidXtceFileException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class XtceSpaceSystemModelTest {

	private SpaceSystem spaceSystem;

	private static final int NUM_OF_PARAMETERS = 3;
	private static final int NUM_OF_PARAMETER_GROUPS = 4;

	private static final String FLIGHT_HOURS_NAME = "FLIGHT_HOURS";
	private static final int LIGHT_HOURS_LENGTH = 32;

	private static final String LASER_TEMP_NAME = "LASER_TEMP";
	private static final int LASER_TEMP_LENGTH = 11;
	
	private static final String FUEL_NAME = "FUEL";
	private static final int FUEL_LENGTH = 16;
	
	private static final int NUM_OF_INTEGER_TYPED_PARAMETERS = 2;
	private static final int NUM_OF_LONG_TYPED_PARAMETERS = 2;
	
	@Before
	public final void perTestSetup() {
		spaceSystem = null;
	}


	@Test
	public void testSpaceSystemCreation() throws InvalidXtceFileException {
		URL testFileUrl = XtceSpaceSystemModelTest.class.getResource("TestSat-all-uints.xml");
		XtceSpaceSystemModel xtceSsm = new XtceSpaceSystemModel(testFileUrl.getPath());

		spaceSystem = xtceSsm.getSpaceSystem();

		// Assert it was created.
		assertNotNull(spaceSystem);
		
		testParameters(xtceSsm);
		
		testParameterGroups(xtceSsm);
	}


	private static void testParameterGroups(XtceSpaceSystemModel xtceSsm) {
		assertEquals("Should be 3 integer parameters", xtceSsm.getAllParameterGroups().size(), NUM_OF_PARAMETER_GROUPS);
	}


	private static void testParameters(SpaceSystemModel xtceSsm) {
		assertEquals(NUM_OF_PARAMETER_GROUPS, xtceSsm.getAllParameterGroups().size());

		Map<String, Parameter<?>> allParameters = xtceSsm.getAllParameters();
		assertEquals(NUM_OF_PARAMETERS, allParameters.size());
		assertTrue(allParameters.containsKey(FLIGHT_HOURS_NAME));
		assertTrue(allParameters.containsKey(LASER_TEMP_NAME));
		assertTrue(allParameters.containsKey(FUEL_NAME));

		Parameter<?> param = null;
		param = allParameters.get(FLIGHT_HOURS_NAME);
		assertNotNull(param);
		assertEquals(LIGHT_HOURS_LENGTH, param.getSizeInBits());


		param = allParameters.get(LASER_TEMP_NAME);
		assertNotNull(param);
		assertEquals(LASER_TEMP_LENGTH, param.getSizeInBits());

		param = allParameters.get(FUEL_NAME);
		assertNotNull(param);
		assertEquals(FUEL_LENGTH, param.getSizeInBits());
		
		assertEquals("Should be 2 integer type parameters", NUM_OF_INTEGER_TYPED_PARAMETERS, xtceSsm.getIntegerParameters().size());
		assertEquals("Should be 1 long type parameters", NUM_OF_LONG_TYPED_PARAMETERS, xtceSsm.getIntegerParameters().size());
	}
}



