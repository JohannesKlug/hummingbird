package org.hbird.transport.spacesystemmodel.parameters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.hbird.transport.spacesystemmodel.parameters.Parameter.Encoding;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Endianness;
import org.junit.Before;
import org.junit.Test;

public class IntegerParameterTest {

	private Parameter<Integer> intParam;

	@Before
	public void setUp() throws Exception {
		intParam = new HummingbirdParameter<Integer>("IntParam", "Test Param <int>", "Test parameter typed to an Integer",
				32, Endianness.BIG, Encoding.twosComplement);
	}

	@Test
	public void testIsValue() {
		intParam.setValue(5478);

		Integer intCompareValue = new Integer(5478);
		assertTrue("isValue should be true since the parameter and the Object are the same",
				intParam.isValue(intCompareValue));

		intCompareValue = new Integer(5479);
		assertFalse("isValue should not be true since the parameter and the Object are different values",
				intParam.isValue(intCompareValue));

		String stringCompareValue = "5478";
		assertFalse("isValue should not be true since the parameter and the Object are different types",
				intParam.isValue(stringCompareValue));
	}

}
