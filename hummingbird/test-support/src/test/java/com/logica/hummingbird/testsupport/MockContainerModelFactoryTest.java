package com.logica.hummingbird.testsupport;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterImpl;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterType;


public class MockContainerModelFactoryTest {
	
	private ContainerFactory containerFactory;
	
	@Before
	public void setUp() {
		containerFactory = new MockContainerModelFactory();
	}
	
	@Test
	public void testMockContainerFactoryTypes() {
		
		
		
		for (ParameterImpl parameter : containerFactory.getAllParameters().values()) {
			if (parameter.getType().getType() == ParameterType.eParameterType.FLOAT) {
				assertTrue("Parameter data type mismatch", parameter.getValue() instanceof Float);
			} else if (parameter.getType().getType() == ParameterType.eParameterType.INTEGER) {
				assertTrue("Parameter data type mismatch", parameter.getValue() instanceof Integer);
			} else {
				fail("Parameter data type unknown: " + parameter.getType().getType() + " for " + parameter.getName());
			}
			
			
		}
	}
	
	@Test
	public void testParameterNames() {
		for (ParameterImpl parameter : containerFactory.getAllParameters().values()) {
			assertTrue("Parameter name '" + parameter.getName() + "' contains invalid characters.", parameter.getName().matches("\\p{Alnum}*"));
		}
		
	}

}
