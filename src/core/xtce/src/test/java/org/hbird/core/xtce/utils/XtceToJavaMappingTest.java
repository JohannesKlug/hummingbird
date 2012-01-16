package org.hbird.core.xtce.utils;

import static org.junit.Assert.*;

import org.hbird.core.xtce.utils.XtceToJavaMapping;
import org.hbird.core.generatedcode.xtce.IntegerParameterType;
import org.junit.Test;

public class XtceToJavaMappingTest {

	private static final int MAX_BITS_FOR_JAVA_SIGNED_INTEGER = 32;
	private static final int MAX_BITS_FOR_JAVA_SIGNED_UINTEGER = 31;

	@Test
	public void testDoesIntRequireJavaLong() {
		IntegerParameterType type = new IntegerParameterType();
		
		type.setName("Signed requires Long test parameter");
		type.setSizeInBits(MAX_BITS_FOR_JAVA_SIGNED_INTEGER + 1);
		type.setSigned(true);
		
		boolean condition = XtceToJavaMapping.doesXtceIntRequireJavaLong(type);
		assertTrue("Type should required a java long", condition);
		
		type.setSizeInBits(MAX_BITS_FOR_JAVA_SIGNED_UINTEGER + 1);
		type.setSigned(false);
		condition = XtceToJavaMapping.doesXtceIntRequireJavaLong(type);
		assertTrue("Type should required a java long", condition);
	}

}
