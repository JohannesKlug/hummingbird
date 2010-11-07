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

import com.logica.hummingbird.buffers.StateBuffer;
import com.logica.hummingbird.command.task.DummyTask;
import com.logica.hummingbird.formatter.HeaderFields;
import com.logica.hummingbird.interfaces.ITask;
import com.logica.hummingbird.tasks.checks.Range;
import com.logica.hummingbird.tasks.checks.StaticValue;
import com.logica.hummingbird.type.Argument;
import com.logica.hummingbird.type.CommandDefinition;

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
	protected StateBuffer stateConnector;
	
	@DirtiesContext
	@Test
	public void testFailingRelease() {
		
		stateConnector.addEntry(createExchange("STATE1", true));
		stateConnector.addEntry(createExchange("STATE2", true));
		stateConnector.addEntry(createExchange("STATE3", false));
		
		List<String> lockStates = Arrays.asList(new String[] {"STATE1", "STATE2", "STATE3"});
		
		List<ITask> tasks = Arrays.asList(new ITask[] {new DummyTask(), new DummyTask()});

		Range range = new Range(0, "TestStateParameter", "TestParameter", new StaticValue(0d), new StaticValue(10d)); 
		List<Argument> arguments = Arrays.asList(new Argument[]{new Argument("TestArgument1", "Test description", Long.class.toString(), 64l, "m/s", range), new Argument("TestArgument2", "Test description", Long.class.toString(), 64l, "m/s", range), new Argument("TestArgument3", "Test description", Long.class.toString(), 64l, "m/s", range)});
		
		CommandDefinition definition = new CommandDefinition("TestCommand", "Test description", arguments, lockStates, tasks);
		
		/** Release command with states that will fail, i.e. locked. */
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(definition);
		exchange.getIn().setHeader(HeaderFields.RELEASETIME, ((new Date()).getTime() + 1000));
		exchange.getIn().setHeader(HeaderFields.NAME, "TestCommand");

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

		stateConnector.addEntry(createExchange("STATE1", true));
		stateConnector.addEntry(createExchange("STATE2", true));
		stateConnector.addEntry(createExchange("STATE3", true));
		
		List<String> lockStates = Arrays.asList(new String[] {"STATE1", "STATE2", "STATE3"});
		
		List<ITask> tasks = Arrays.asList(new ITask[] {new DummyTask(), new DummyTask()});

		Range range = new Range(0, "TestStateParameter", "TestParameter", new StaticValue(0d), new StaticValue(10d)); 
		List<Argument> arguments = Arrays.asList(new Argument[]{new Argument("TestArgument1", "Test description", Long.class.toString(), 64l, "m/s", range), new Argument("TestArgument2", "Test description", Long.class.toString(), 64l, "m/s", range), new Argument("TestArgument3", "Test description", Long.class.toString(), 64l, "m/s", range)});
		
		CommandDefinition definition = new CommandDefinition("TestCommand", "Test description", arguments, lockStates, tasks);
		
		/** Release command with states that will fail, i.e. locked. */
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(definition);
		exchange.getIn().setHeader(HeaderFields.RELEASETIME, ((new Date()).getTime() + 1000));
		exchange.getIn().setHeader(HeaderFields.NAME, "TestCommand");

		template.send(exchange);
		
		/** Lock state is true, so exchange should be stopped. */
		assertTrue(releasedCommands.getReceivedCounter() == 1);
		assertTrue(scheduledTasks.getReceivedCounter() == 2);
		
		for (ITask task : tasks) {
			assertTrue(((DummyTask) task).executeCalled == false);
		}
	}

	@DirtiesContext
	@Test
	public void testImmediateRelease() {

		
		stateConnector.addEntry(createExchange("STATE1", true));
		stateConnector.addEntry(createExchange("STATE2", true));
		stateConnector.addEntry(createExchange("STATE3", true));
		
		List<String> lockStates = Arrays.asList(new String[] {"STATE1", "STATE2", "STATE3"});
		
		List<ITask> tasks = Arrays.asList(new ITask[] {new DummyTask(), new DummyTask()});

		Range range = new Range(0, "TestStateParameter", "TestParameter", new StaticValue(0d), new StaticValue(10d)); 
		List<Argument> arguments = Arrays.asList(new Argument[]{new Argument("TestArgument1", "Test description", Long.class.toString(), 64l, "m/s", range), new Argument("TestArgument2", "Test description", Long.class.toString(), 64l, "m/s", range), new Argument("TestArgument3", "Test description", Long.class.toString(), 64l, "m/s", range)});
		
		CommandDefinition definition = new CommandDefinition("TestCommand", "Test description", arguments, lockStates, tasks);
		
		/** Release command with states that will fail, i.e. locked. */
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(definition);
		exchange.getIn().setHeader(HeaderFields.RELEASETIME, 0l);
		exchange.getIn().setHeader(HeaderFields.NAME, "TestCommand");
		
		exchange.getIn().setHeader("TestArgument1", "Arg1");
		exchange.getIn().setHeader("TestArgument2", "Arg2");
		exchange.getIn().setHeader("TestArgument3", "Arg3");

		template.send(exchange);
		
		/** Lock state is true, so exchange should be stopped. */
		assertTrue(releasedCommands.getReceivedCounter() == 1);
		assertTrue(scheduledTasks.getReceivedCounter() == 2);
		
		for (ITask task : tasks) {
			assertTrue(((DummyTask) task).executeCalled == false);
		}

		for (Argument argument : ((CommandDefinition) releasedCommands.getExchanges().get(0).getIn().getBody()).getArguments()) {
			assertTrue(releasedCommands.getExchanges().get(0).getIn().getHeader(argument.getName()) != null);
		}
	}

	protected Exchange createExchange(String name, boolean value) {
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setHeader(HeaderFields.NAME, name);
		exchange.getIn().setBody(value);
		return exchange;
	}
}
