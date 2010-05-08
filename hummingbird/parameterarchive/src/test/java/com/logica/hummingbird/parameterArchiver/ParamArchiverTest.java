package com.logica.hummingbird.parameterArchiver;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import com.logica.hummingbird.testsupport.MockContainerModelFactory;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
	public void testStoreParameter() throws Exception, NoSuchFieldException {
		
		// Set up reflection: Get a jdbcTemplate to verify storing of parameters
		Class<? extends ParameterArchiver> pa = parameterArchiver.getClass();
		
		Field jdbcField = pa.getDeclaredField("jdbcTemplate"); 
		
		jdbcField.setAccessible(true);
		JdbcTemplate reflectedTemplate = (JdbcTemplate) jdbcField.get(parameterArchiver);
		
		
		// Store the first parameter
		parameterArchiver.storeParameter(MockContainerModelFactory.PACKET_ID_NAME, System.currentTimeMillis(), 15);
		
		int countOfStoredParameters = reflectedTemplate.queryForInt(
				"select count(*) from " + MockContainerModelFactory.PACKET_ID_NAME);
		
		assertEquals(1, countOfStoredParameters);

		// Store the second parameter
		parameterArchiver.storeParameter(MockContainerModelFactory.PACKET_ID_NAME, System.currentTimeMillis(), 15);
		
		countOfStoredParameters = reflectedTemplate.queryForInt(
				"select count(*) from " + MockContainerModelFactory.PACKET_ID_NAME);
		
		assertEquals(2, countOfStoredParameters);
		
	}
	
}
