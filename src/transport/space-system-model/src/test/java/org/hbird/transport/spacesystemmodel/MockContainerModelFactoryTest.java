package org.hbird.transport.spacesystemmodel;

import static org.junit.Assert.assertTrue;

import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.parameters.DefaultParameter;
import org.hbird.transport.spacesystemmodel.testsupport.MockContainerModelFactory;
import org.junit.Before;
import org.junit.Test;

// TODO Implement this test.
public class MockContainerModelFactoryTest {

	private SpaceSystemModelFactory containerFactory;

	@Before
	public void setUp() throws InvalidParameterTypeException {
		containerFactory = new MockContainerModelFactory();
	}


	@Test
	public void testParameterNames() {
		for (DefaultParameter parameter : containerFactory.getAllParameters().values()) {
			assertTrue("Parameter name '" + parameter.getName() + "' contains invalid characters.", parameter.getName().matches("\\p{Alnum}*"));
		}
	}

}
