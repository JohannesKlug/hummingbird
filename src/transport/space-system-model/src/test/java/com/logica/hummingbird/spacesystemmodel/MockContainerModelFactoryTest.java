package org.hbird.spacesystemmodel;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import org.hbird.spacesystemmodel.ContainerFactory;
import org.hbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.spacesystemmodel.parameters.ParameterContainer;
import org.hbird.spacesystemmodel.testsupport.MockContainerModelFactory;

// TODO Implement this test.
public class MockContainerModelFactoryTest {

	private ContainerFactory containerFactory;

	@Before
	public void setUp() throws InvalidParameterTypeException {
		containerFactory = new MockContainerModelFactory();
	}

	@Ignore
	@Test
	public void testMockContainerFactoryTypes() {

//		for (ParameterContainer parameter : containerFactory.getAllParameters().values()) {
//			if (parameter.getType().getType() == NumberParameterType.eParameterType.FLOAT) {
//				assertTrue("Parameter data type mismatch", parameter.getValue() instanceof Double);
//			}
//			else if (parameter.getType().getType() == NumberParameterType.eParameterType.INTEGER) {
//				assertTrue("Parameter data type mismatch", parameter.getValue() instanceof Long);
//			}
//			else {
//				fail("Parameter data type unknown: " + parameter.getType().getType() + " for " + parameter.getName());
//			}
//		}
	}

	@Test
	public void testParameterNames() {
		for (ParameterContainer parameter : containerFactory.getAllParameters().values()) {
			assertTrue("Parameter name '" + parameter.getName() + "' contains invalid characters.", parameter.getName().matches("\\p{Alnum}*"));
		}
	}

}
