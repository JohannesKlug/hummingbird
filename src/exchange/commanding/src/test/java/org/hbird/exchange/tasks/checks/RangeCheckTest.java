/**
 * Licensed to the Hummingbird Foundation (HF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The HF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hbird.exchange.tasks.checks;

import static org.junit.Assert.*;

import org.hbird.exchange.commanding.checks.RangeCheck;
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
		
		RangeCheck check = new RangeCheck("TestRange", "A test range.", 0, state, lower, upper);

		/** Both lower and upper are null, i.e. no lower or upper limit. Range should return
		 * true. */
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
