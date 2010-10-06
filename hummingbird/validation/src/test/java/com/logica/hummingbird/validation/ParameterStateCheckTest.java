package com.logica.hummingbird.validation;


import com.logica.hummingbird.validation.base.OnlyChangeFilter;
import com.logica.hummingbird.validation.base.ViolationCountFilter;
import com.logica.hummingbird.validation.parameter.LowerLimit;
import com.logica.hummingbird.validation.parameter.Parameter;
import com.logica.hummingbird.validation.parameter.UpperLimit;

import junit.framework.TestCase;

public class ParameterStateCheckTest extends TestCase {

	
	/**
	 *  @USERSTORY As an operator I can get notifications in case gaps are detected in the packet stream, so that I can passivly monitor the data flow.
	 */
	public void testLimits() {
		
		Parameter parameter1 = new Parameter(0);
		
		LowerLimit lower1 = new LowerLimit(-5);
		UpperLimit upper1 = new UpperLimit(5);
		parameter1.addRule(lower1);
		parameter1.addRule(upper1);
		
		/** Setup two handlers. */
		ViolationCountFilter handler1 = new ViolationCountFilter();
		ViolationCountFilter handler2 = new ViolationCountFilter();
		
		lower1.setSender(handler1);
		upper1.setSender(handler2);
		
		OnlyChangeFilter onlyChangeFilter1 = new OnlyChangeFilter(); 
		
		handler1.setSender(onlyChangeFilter1);
		handler2.setSender(onlyChangeFilter1);
		
		DummySender sender = new DummySender();
		onlyChangeFilter1.setSender(sender);

		
		/** Send parameter data. */
		parameter1.check(new TmParameterDummy(0));
		assertTrue(sender.sendCalled == true);
		sender.sendCalled = false;
		assertTrue(handler1.getViolations() == 0);
		assertTrue(handler2.getViolations() == 0);
		
		parameter1.check(new TmParameterDummy(-3));
		assertTrue(sender.sendCalled == false);
		assertTrue(handler1.getViolations() == 0);
		assertTrue(handler2.getViolations() == 0);
		
		parameter1.check(new TmParameterDummy(-6));
		assertTrue(sender.sendCalled == false);
		assertTrue(handler1.getViolations() == 1);
		assertTrue(handler2.getViolations() == 0);

		parameter1.check(new TmParameterDummy(-4));
		assertTrue(sender.sendCalled == false);
		assertTrue(handler1.getViolations() == 0);
		assertTrue(handler2.getViolations() == 0);

		parameter1.check(new TmParameterDummy(-6));
		assertTrue(sender.sendCalled == false);
		assertTrue(handler1.getViolations() == 1);
		assertTrue(handler2.getViolations() == 0);

		parameter1.check(new TmParameterDummy(-8));
		assertTrue(sender.sendCalled == true);
		sender.sendCalled = false;
		assertTrue(handler1.getViolations() == 2);
		assertTrue(handler2.getViolations() == 0);

		parameter1.check(new TmParameterDummy(-8));
		assertTrue(sender.sendCalled == true);
		assertTrue(handler1.getViolations() == 3);
		assertTrue(handler2.getViolations() == 0);
	}
}
