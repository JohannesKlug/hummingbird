package org.hbird.business.command.releaser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.hbird.exchange.commanding.Argument;
import org.hbird.exchange.commanding.Command;
import org.hbird.exchange.commanding.Task;
import org.hbird.exchange.commanding.checks.RangeCheck;
import org.hbird.exchange.tasks.DummyTask;
import org.hbird.exchange.type.Parameter;
import org.hbird.exchange.type.StateParameter;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration (locations={"/CommandReleaserTest-context.xml"})
public class CommandReleaserTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Commands")
    protected ProducerTemplate toCommandsRoute;
	
	@Produce(uri = "direct:Parameters")
	protected ProducerTemplate toParametersRoute;

	@EndpointInject(uri = "mock:ReleasedCommands")
	protected MockEndpoint releasedCommands;
	
	@EndpointInject(uri = "mock:Tasks")
	protected MockEndpoint scheduledTasks;

	protected Command createCommand() {
		List<String> lockStates = Arrays.asList(new String[] {"STATE1", "STATE2", "STATE3"});
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
		
		Command command = createCommand();

		// Release command with states that will fail, i.e. locked.
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
		
		Command command = createCommand();

		// Send the lock states
		for (String state : command.getLockStates()) {
			// FIXME Externalise hard-coded ParameterName
			toParametersRoute.sendBodyAndHeader(true, "HummingbirdParameterName", state);
		}
		
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
