package org.hbird.exchange.tasks.checks;

import static org.junit.Assert.*;

import org.hbird.exchange.type.Parameter;
import org.hbird.exchange.type.StateParameter;
import org.junit.Test;

public class RangeCheckTest {

	@Test
	public void testValidate() {
		StateParameter state = new StateParameter("aTestState", "Test description of a test state", "aParameter", true);
		
		Parameter lower = new Parameter("lowerRange", "The lower range", null, "");
		Parameter upper = new Parameter("upperRange", "The upper range", null, "");
				
		Parameter parameter = new Parameter("aParameter", "The parameter", new Double(5), "meter");
		
		RangeCheck check = new RangeCheck(0, state, lower, upper);

		assertTrue(check.validate(parameter) == true);
		
		lower.setValue(new Integer(3));
		assertTrue(check.validate(parameter) == true);
		
		lower.setValue(new Integer(5));
		assertTrue(check.validate(parameter) == false);
		
		lower.setValue(new Integer(6));
		assertTrue(check.validate(parameter) == false);

		lower.setValue(null);
		upper.setValue(new Integer(7));
		assertTrue(check.validate(parameter) == true);
		
		upper.setValue(new Integer(5));
		assertTrue(check.validate(parameter) == false);
		
		upper.setValue(new Integer(4));
		assertTrue(check.validate(parameter) == false);

		lower.setValue(new Integer(4));
		upper.setValue(new Double(6));
		assertTrue(check.validate(parameter) == true);
		
		lower.setValue(new Double(5));
		upper.setValue(new Integer(6));
		assertTrue(check.validate(parameter) == false);
		
		lower.setValue(new Integer(4));
		upper.setValue(new Float(5));
		assertTrue(check.validate(parameter) == false);

		lower.setValue(new Integer(5));
		upper.setValue(new Integer(5));
		assertTrue(check.validate(parameter) == false);

		lower.setValue(new Integer(6));
		upper.setValue(new Integer(4));
		assertTrue(check.validate(parameter) == false);
	}

}
