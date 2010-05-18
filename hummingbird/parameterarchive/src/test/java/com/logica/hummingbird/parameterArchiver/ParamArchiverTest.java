package com.logica.hummingbird.parameterArchiver;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import com.logica.hummingbird.testsupport.MockContainerModelFactory;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
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
	public void handleEmptyMessage() throws Exception {
		// Send an empty message - this must be handled gracefully.
		parameterArchiver.onMessage(new DefaultMessage());
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
		
		// Store a different parameter
		parameterArchiver.storeParameter(MockContainerModelFactory.TEST_PARAM_B, System.currentTimeMillis(), 15.9);
		
		countOfStoredParameters = reflectedTemplate.queryForInt(
				"select count(*) from " + MockContainerModelFactory.TEST_PARAM_B);
		
		assertEquals(1, countOfStoredParameters);
		
	}
	
	@Test
	public void testRetrieval() {
		Message message = new DefaultMessage();
		message.setHeader("Type", "RetrievalRequest");
		message.setHeader("Name", MockContainerModelFactory.PACKET_ID_NAME);
		message.setHeader("FromDate", Long.MIN_VALUE);
		message.setHeader("LongDate", Long.MAX_VALUE);
		message.getHeader("JmsReplyTo", "");
		
	}
}
