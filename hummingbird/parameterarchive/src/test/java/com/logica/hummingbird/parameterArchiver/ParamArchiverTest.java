package com.logica.hummingbird.parameterArchiver;

import static org.junit.Assert.*;

import com.logica.hummingbird.framebroker.IContainerFactory;
import com.logica.hummingbird.testsupport.MockContainerModelFactory;

import org.junit.Test;

public class ParamArchiverTest {
	
	@Test
	public void testParameterArchiverConstructor() {
		IContainerFactory mockCF = new MockContainerModelFactory();
		System.out.println(mockCF.getAllParameters());
	}
	
}
