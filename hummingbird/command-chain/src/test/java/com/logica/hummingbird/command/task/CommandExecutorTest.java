package com.logica.hummingbird.command.task;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import com.logica.hummingbird.jmshelper.HeaderFields;

@ContextConfiguration (locations={"/CommandExecutorTest-context.xml"})
public class CommandExecutorTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:start")
    protected ProducerTemplate template;
	
	@Autowired
    protected CamelContext context;
	
	@Test
	public void testReceive() {
		DummyTask task = new DummyTask();
		task.deltaTime = 1000;
		
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(task);
		exchange.getIn().setHeader(HeaderFields.TASK_EXECUTIONTIME, ((new Date()).getTime() + 1000));

		template.send(exchange);
		
		assertTrue(task.executeCalled == true);
	}
}
