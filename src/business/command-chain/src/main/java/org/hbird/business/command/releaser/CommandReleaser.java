package org.hbird.business.command.releaser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Handler;
import org.apache.camel.Headers;
import org.apache.camel.impl.DefaultExchange;
import org.apache.log4j.Logger;
import org.hbird.exchange.commanding.Command;
import org.hbird.exchange.type.StateParameter;

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

	/** The object logger */
	private static final Logger LOGGER = Logger.getLogger(CommandReleaser.class);
	
	/** Name of the Camel entry point that will lead to a parameter provider. The
	 * assembly using the CommandReleaser must contain such a route. */
	protected String parameterProvider = "direct:ParameterRequests";
	
	/**
	 * Processor for the scheduling of validation task for a command as well as the
	 * release of the command.
	 * 
	 */
	@Handler
	public List<Object> process(@Body Command definition, @Headers Map<String, Object> headers, CamelContext context) {

		/* Log the release processing. */
		LOGGER.info("Processing command '" + definition.getName() + "' with ID " + definition.getObjectid() + "'.");
		
		/* List of exchanges to be send. */
		List<Object> out = new ArrayList<Object>();
		
		/* Validate the lock state(s). */
		for (String state : definition.getLockStates()) {
			
			/** Send the request. Respond is expected to be a single StateParameter. */
			Exchange exchange = new DefaultExchange(context, ExchangePattern.InOut);
			exchange.getIn().setBody(state);
			
			context.createProducerTemplate().send(parameterProvider, exchange);

			/** Check respond. */
			if (exchange.getOut().getBody() == null || ((StateParameter) exchange.getOut().getBody()).getStateValue() == false) {				

				/* Stop the release of the command. */
				LOGGER.error("Failed release of command with ID '" + definition.getObjectid() + "'. Lock state '" + state + "' has state 'false'.");
				headers.put("FailedRelease", true);
				return out;
			}
		}
		
		/* Add the command itself to the messages to be continued in the route. */
		out.add(definition);

		/* Schedule all tasks. */
		out.addAll(definition.getTasks());
		
		return out;
	}
}
