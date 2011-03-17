package org.hbird.exchange.logger;

import org.apache.camel.EndpointInject;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration (locations={"/ActivemqAppenderTest-context.xml"})
public class ActivemqAppenderTest extends AbstractJUnit38SpringContextTests  {

	@Autowired
	protected ActivemqAppender appender = null;
	
	@EndpointInject(uri = "mock:End")
	protected MockEndpoint releaseQueue;

	@Test
	public void testAppendLoggingEvent() {
		appender.append(new LoggingEvent("test category", Category.getInstance("test"), 1, Level.INFO, "test message", null));
		assertTrue(releaseQueue.getReceivedCounter() == 0);		
	}
}
