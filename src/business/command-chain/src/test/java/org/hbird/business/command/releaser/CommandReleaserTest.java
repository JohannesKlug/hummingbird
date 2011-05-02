package org.hbird.business.command.releaser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.hbird.business.parameterstorage.InMemoryParameterBuffer;
import org.hbird.exchange.commanding.Argument;
import org.hbird.exchange.commanding.Command;
import org.hbird.exchange.commanding.Task;
import org.hbird.exchange.commanding.checks.RangeCheck;
import org.hbird.exchange.tasks.DummyTask;
import org.hbird.exchange.type.Parameter;
import org.hbird.exchange.type.StateParameter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration (locations={"/CommandReleaserTest-context.xml"})
public class CommandReleaserTest extends AbstractJUnit38SpringContextTests  {

	@Autowired
	protected CamelContext context = null;
	
	@Autowired
	protected ProducerTemplate producer = null;
	
	@Autowired
	protected InMemoryParameterBuffer provider = null;

	@Produce(uri = "direct:Commands")
    protected ProducerTemplate toCommandsRoute;

	@Produce(uri = "direct:ParameterRequests")
	protected ProducerTemplate request = null;

	@Produce(uri = "direct:Parameters")
	protected ProducerTemplate parameter = null;
	
	@EndpointInject(uri = "mock:ReleasedCommands")
	protected MockEndpoint releasedCommands;
	
	@EndpointInject(uri = "mock:Tasks")
	protected MockEndpoint scheduledTasks;

	protected void prepareBuffer() {
		/** Send the request. Respond is expected to be a single StateParameter. */
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(new StateParameter("TestParameter1", "Description of test parameter 1", null, new Boolean(true)));
		parameter.send(exchange);
		assertTrue((Boolean) provider.getLatestParameterValue().get("TestParameter1").getValue() == true);

		exchange = new DefaultExchange(context);
		exchange.getIn().setBody(new StateParameter("TestParameter2", "Description of test parameter 2", null, new Boolean(true)));
		parameter.send(exchange);
		assertTrue((Boolean) provider.getLatestParameterValue().get("TestParameter2").getValue() == true);
		
		exchange = new DefaultExchange(context);
		exchange.getIn().setBody(new StateParameter("TestParameter3", "Description of test parameter 3", null, new Boolean(true)));
		parameter.send(exchange);
		assertTrue((Boolean) provider.getLatestParameterValue().get("TestParameter3").getValue() == true);

		assertTrue(provider.getLatestParameterValue().size() == 3);
	} 
	
	protected Command createCommand() {
		List<String> lockStates = Arrays.asList(new String[] {"TestParameter1", "TestParameter2", "TestParameter3"});
		List<Task> tasks = Arrays.asList(new Task[] {new DummyTask(), new DummyTask()});
		List<Argument> arguments = new ArrayList<Argument>(); 
			
		Command definition = new Command("TestCommand", "Test description", arguments, lockStates, tasks, 0, 0);
		RangeCheck range = new RangeCheck("TestStateParameter", "TestParameter", 0, new StateParameter("", "", definition, new Boolean(true)), new Parameter("", "", new Double(0d), ""), new Parameter("", "", new Double(10d), ""));
		
		arguments.add(new Argument("TestArgument1", "Test description", new Long(64l), "", range));
		arguments.add(new Argument("TestArgument2", "Test description", new Long(64l), "", range));
		arguments.add(new Argument("TestArgument3", "Test description", new Long(64l), "", range));
		
		return definition;
	}
	
	@DirtiesContext
	@Test
	public void testFailingRelease() throws InterruptedException {
		releasedCommands.reset();
		scheduledTasks.reset();
		
		/** Set one of the lock states to false, to fail the command. */
		prepareBuffer();
		
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(new StateParameter("TestParameter2", "Description of test parameter 2", null, new Boolean(false)));
		parameter.send(exchange);
		assertTrue((Boolean) provider.getLatestParameterValue().get("TestParameter2").getValue() == false);
		
		// Release command with states that will fail, i.e. locked.
		Command command = createCommand();
		toCommandsRoute.sendBody(command);
		
		// Lock state is false, so exchange should be stopped.
		releasedCommands.setExpectedMessageCount(0);
		scheduledTasks.setExpectedMessageCount(0);
		releasedCommands.assertIsSatisfied();
		scheduledTasks.assertIsSatisfied();

		for (Task task : command.getTasks()) {
			assertTrue(((DummyTask) task).executeCalled == false);
		}
	}
	
	@DirtiesContext
	@Test
	public void testSuccessfulRelease() throws InterruptedException {
		releasedCommands.reset();
		scheduledTasks.reset();
		
		prepareBuffer();
		Command command = createCommand();

		// Send the command
		toCommandsRoute.sendBody(command);
		
		releasedCommands.setExpectedMessageCount(1);
		scheduledTasks.setExpectedMessageCount(2);
		
		releasedCommands.assertIsSatisfied();
		scheduledTasks.assertIsSatisfied();
		
		for (Task task : command.getTasks()) {
			assertFalse(((DummyTask) task).executeCalled);
		}
	}
}
