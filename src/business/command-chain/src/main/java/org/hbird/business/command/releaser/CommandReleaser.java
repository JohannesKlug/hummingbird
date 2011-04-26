package org.hbird.business.command.releaser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.Handler;
import org.apache.camel.Headers;
import org.apache.log4j.Logger;
import org.hbird.business.parameterstorage.ParameterBuffer;
import org.hbird.exchange.commanding.Command;
import org.hbird.exchange.commanding.ITask;

/**
 * The command releaser reads commands from the 'Command' queue, validate that they 
 * can be released, schedule the tasks to be done in the system as a result of the command
 * and then release the command.
 * 
 * The command releaser do not use the 'releaseTime' scheduling for command release. This
 * is expected done prior to reception by this bean. A command received by this class will
 * thus be processed immediately.
 * 
 * A Command can contains any number of 'lock states', being state parameters
 * (true / false). In case any of these are false at the time of execution, the command wont
 * be released, i.e. the route will be stopped. 
 * 
 * A command will affect the satellite in some way. Thats means that the ground system(s) most likely
 * also have to be reconfigured; limits may need to be disabled, changed and at some point enabled again and
 * specific checks may need to be done to validate that the command was send, executed and succeeded. To
 * release tasks, the command releaser uses the route entry point 'begin:Tasks'. This must be available
 * in the route configuration.
 * 
 * The command releaser thereafter parses the command on in the route.
 * 
 * Example of Usage:
 * 
 * <bean id="commandReleaser" class="org.hbird.business.command.releaser.CommandReleaser"/>
 * 
 * <route>
 *   <from uri="activemq:queue:Commands"/>
 *   <to uri="bean:commandReleaser"/>
 *   <to uri="activemq:queue:ReleasedCommands"/>
 * </route>
 * 
 */
public class CommandReleaser {

	/** The object logger. */
	protected static Logger logger = Logger.getLogger(CommandReleaser.class);
	
	private ParameterBuffer parameterBuffer;
	
	public CommandReleaser(ParameterBuffer buffer) {
		this.parameterBuffer = buffer;
	}
	
	/**
	 * Processor for the scheduling of validation task for a command as well as the
	 * release of the command.
	 * 
	 * @param exchange
	 * @throws InterruptedException 
	 */
	@Handler
	public List<Object> process(@Body Command definition, @Headers Map<String, Object> headers) throws InterruptedException {

		/* Get the command definition. */
		logger.info("Processing command '" + definition.getName() + "' with ID " + definition.getObjectid() + "'.");
		
		List<Object> messages = new ArrayList<Object>();
		
		/* Validate the lock state(s). */
		for (String state : definition.getLockStates()) {
			/* TODO Get the parameter using the Camel request-response pattern. */
			Boolean parameter = (Boolean) parameterBuffer.getParameterByName(state);
			if (parameter == null || parameter == false) {				
				/* Stop the release of the command. */
				logger.error("Failed release of command with ID '" + definition.getObjectid() + "'. Lock state '" + state + "' has state 'false'.");
				headers.put("FailedRelease", true);
				return messages;
			}
		}

		/* Schedule all tasks. */
		for (ITask task : definition.getTasks()) {
			
			/* Specialized sub classes of the 'ITask' may depend on the command to configure themselves, for
			 * example the ReflectiveSetParameter' will have a value reflected from a command argument. This
			 * call ensures that the configuration can occur. */
			messages.add(task);
			logger.info("Scheduling task '" + task.getClass().toString() + "' with ID " + task.getObjectid() + "'.");
		}

		return messages;
	}
}
