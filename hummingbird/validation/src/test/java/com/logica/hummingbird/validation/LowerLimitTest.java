package com.logica.hummingbird.validation;

import com.logica.hummingbird.validation.parameter.LowerLimit;

import junit.framework.TestCase;

public class LowerLimitTest extends TestCase {

	public void testCheck() {
		
		/** Test fixed value. */
		LowerLimit limit = new LowerLimit(3);
		
		TmParameterDummy parameter = new TmParameterDummy();
		
		parameter.setValue(5);		
		assertTrue(limit.rule(parameter));

		parameter.setValue(4);		
		assertTrue(limit.rule(parameter));

		parameter.setValue(3);		
		assertTrue(limit.rule(parameter));

		parameter.setValue(2);		
		assertTrue(limit.rule(parameter) == false);

		parameter.setValue(1);		
		assertTrue(limit.rule(parameter) == false);
	}
}
