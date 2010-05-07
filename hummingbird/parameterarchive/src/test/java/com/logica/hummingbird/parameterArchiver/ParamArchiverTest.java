package com.logica.hummingbird.parameterArchiver;

import static org.junit.Assert.*;

import com.logica.hummingbird.testsupport.MockContainerModelFactory;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ParamArchiverTest {
	
	private ParameterArchiver parameterArchiver;
	
	@Before
	public void createParameterArchiver() {
		BeanFactory factory = new FileSystemXmlApplicationContext("src/test/resources/parameterArchiver.xml");
		parameterArchiver = (ParameterArchiver) factory.getBean("parameterArchiver");
	}
	
	@Test
	public void testParameterArchiverConstructor() {
		assertNotNull(parameterArchiver);

	}
	
	@Test
	public void testStoreParameter() {
		parameterArchiver.storeParameter(MockContainerModelFactory.PACKET_ID_NAME, System.currentTimeMillis(), 15);
		System.out.println();		
	}
	
	
}
