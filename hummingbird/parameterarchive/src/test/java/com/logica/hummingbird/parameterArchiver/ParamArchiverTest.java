package com.logica.hummingbird.parameterArchiver;

import static org.junit.Assert.*;

import com.logica.hummingbird.testsupport.MockContainerModelFactory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ParamArchiverTest {
	
	@Test
	public void testParameterArchiverConstructor() {
		//ParameterArchiver pa = new ParameterArchiver(new MockContainerModelFactory());
		
		BeanFactory factory = new FileSystemXmlApplicationContext("src/test/resources/parameterArchiver.xml");
	}
	
}
