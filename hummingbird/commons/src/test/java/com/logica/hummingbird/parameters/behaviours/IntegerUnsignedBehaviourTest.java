package com.logica.hummingbird.parameters.behaviours;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.spacesystemmodel.parameters.behaviours.IntegerUnsignedBehaviour;

public class IntegerUnsignedBehaviourTest {
	private final static Logger LOG = LoggerFactory.getLogger(IntegerUnsignedBehaviourTest.class);
	
	private final String TYPE_NAME = "bit Unsigned integer";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected=InvalidParameterTypeException.class)
	public void testInvalidSizeConstruction() throws InvalidParameterTypeException {
		new IntegerUnsignedBehaviour(45, true);
	}

	@Test
	public void testGetName() throws InvalidParameterTypeException {
		assertEquals(new IntegerUnsignedBehaviour(1, true).getTypeName(), 1 + TYPE_NAME);
	}
}
