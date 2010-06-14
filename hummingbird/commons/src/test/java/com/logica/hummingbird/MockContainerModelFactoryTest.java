package com.logica.hummingbird;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterContainer;
import com.logica.hummingbird.spacesystemmodel.parameters.NumberParameterType;
import com.logica.hummingbird.spacesystemmodel.testsupport.MockContainerModelFactory;

public class MockContainerModelFactoryTest {

	private ContainerFactory containerFactory;

	@Before
	public void setUp() throws InvalidParameterTypeException {
		containerFactory = new MockContainerModelFactory();
	}

	@Test
	public void testMockContainerFactoryTypes() {

		for (ParameterContainer parameter : containerFactory.getAllParameters().values()) {
			if (parameter.getType().getType() == NumberParameterType.eParameterType.FLOAT) {
				assertTrue("Parameter data type mismatch", parameter.getValue() instanceof Double);
			}
			else if (parameter.getType().getType() == NumberParameterType.eParameterType.INTEGER) {
				assertTrue("Parameter data type mismatch", parameter.getValue() instanceof Long);
			}
			else {
				fail("Parameter data type unknown: " + parameter.getType().getType() + " for " + parameter.getName());
			}

		}
	}

	@Test
	public void testParameterNames() {
		for (ParameterContainer parameter : containerFactory.getAllParameters().values()) {
			assertTrue("Parameter name '" + parameter.getName() + "' contains invalid characters.", parameter.getName().matches("\\p{Alnum}*"));
		}

	}

}
