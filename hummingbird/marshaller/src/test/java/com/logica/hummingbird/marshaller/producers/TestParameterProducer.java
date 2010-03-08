package com.logica.hummingbird.marshaller.producers;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestParameterProducer {
	
	private ParameterProducer parameterProducer;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHeader() {
		parameterProducer = new ParameterProducer();
		parameterProducer.updated("String", "Test");
		parameterProducer.updated("double", Double.MAX_VALUE);
		parameterProducer.updated("int", Integer.MAX_VALUE);
		parameterProducer.completed();
		
	}
}
