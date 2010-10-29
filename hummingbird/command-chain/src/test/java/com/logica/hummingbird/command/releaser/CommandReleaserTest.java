package com.logica.hummingbird.command.releaser;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import com.logica.hummingbird.command.CommandDefinition;
import com.logica.hummingbird.command.task.DummyTask;
import com.logica.hummingbird.interfaces.ITask;
import com.logica.hummingbird.jmshelper.HeaderFields;

@ContextConfiguration (locations={"/CommandReleaserTest-context.xml"})
public class CommandReleaserTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Commands")
    protected ProducerTemplate template;

	@EndpointInject(uri = "mock:ReleasedCommands")
	protected MockEndpoint releasedCommands;
	
	@EndpointInject(uri = "mock:Tasks")
	protected MockEndpoint scheduledTasks;
	
	@Autowired
    protected CamelContext context;

	@Autowired
	protected DummyParameterStateConnector stateConnector;
	
	@DirtiesContext
	@Test
	public void testFailingRelease() {

		stateConnector.states.put("STATE1", true);
		stateConnector.states.put("STATE2", true);
		stateConnector.states.put("STATE3", false);
		
		List<String> lockStates = Arrays.asList(new String[] {"STATE1", "STATE2", "STATE3"});
		
		List<ITask> tasks = Arrays.asList(new ITask[] {new DummyTask(), new DummyTask()});

		List<String> arguments = Arrays.asList(new String[] {});
		
		CommandDefinition definition = new CommandDefinition("TestCommand", arguments, lockStates, tasks);
		
		/** Release command with states that will fail, i.e. locked. */
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(definition);
		exchange.getIn().setHeader(HeaderFields.TASK_EXECUTIONTIME, ((new Date()).getTime() + 1000));
		exchange.getIn().setHeader(HeaderFields.NAME, "TestCommand");
		exchange.getIn().setHeader(HeaderFields.RELEASETIME, 1l);

		template.send(exchange);
		
		/** Lock state is false, so exchange should be stopped. */
		assertTrue(releasedCommands.getReceivedCounter() == 0);
		assertTrue(scheduledTasks.getReceivedCounter() == 0);

		for (ITask task : tasks) {
			assertTrue(((DummyTask) task).executeCalled == false);
		}
	}
	
	@DirtiesContext
	@Test
	public void testSuccessfulRelease() {

		stateConnector.states.put("STATE1", true);
		stateConnector.states.put("STATE2", true);
		stateConnector.states.put("STATE3", true);
		
		List<String> lockStates = Arrays.asList(new String[] {"STATE1", "STATE2", "STATE3"});
		
		List<ITask> tasks = Arrays.asList(new ITask[] {new DummyTask(), new DummyTask()});

		List<String> arguments = Arrays.asList(new String[] {});
		
		CommandDefinition definition = new CommandDefinition("TestCommand", arguments, lockStates, tasks);
		
		/** Release command with states that will fail, i.e. locked. */
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(definition);
		exchange.getIn().setHeader(HeaderFields.TASK_EXECUTIONTIME, ((new Date()).getTime() + 1000));
		exchange.getIn().setHeader(HeaderFields.NAME, "TestCommand");
		exchange.getIn().setHeader(HeaderFields.RELEASETIME, 1l);

		template.send(exchange);
		
		/** Lock state is false, so exchange should be stopped. */
		assertTrue(releasedCommands.getReceivedCounter() == 1);
		assertTrue(scheduledTasks.getReceivedCounter() == 2);
		
		for (ITask task : tasks) {
			assertTrue(((DummyTask) task).executeCalled == false);
		}
	}

}
