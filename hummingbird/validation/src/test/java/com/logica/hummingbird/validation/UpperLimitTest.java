package com.logica.hummingbird.validation;

import com.logica.hummingbird.validation.parameter.UpperLimit;

import junit.framework.TestCase;

public class UpperLimitTest extends TestCase {

	public void testCheck() {
		
		/** Test fixed value. */
		UpperLimit limit = new UpperLimit(10);
		
		TmParameterDummy parameter = new TmParameterDummy();
		
		parameter.setValue(8);		
		assertTrue(limit.rule(parameter));

		parameter.setValue(9);		
		assertTrue(limit.rule(parameter));

		parameter.setValue(10);		
		assertTrue(limit.rule(parameter));

		parameter.setValue(11);		
		assertTrue(limit.rule(parameter) == false);

		parameter.setValue(12);		
		assertTrue(limit.rule(parameter) == false);
	}
}
