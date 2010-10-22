package com.logica.hummingbird.commandreleaser.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;

import com.logica.hummingbird.interfaces.CommandDefinition;
import com.logica.hummingbird.interfaces.ICommandConnector;

public class Scheduler {

	protected ProducerTemplate taskQueue = null;
	
	protected ProducerTemplate releasedCommandsQueue = null;
	
	protected ConsumerTemplate parameters = null;
	
	protected IParameterStateConnector stateConnector = null;
	
	protected ICommandConnector commandConnector = null;
	
	public void process(Exchange arg0) {

		/** Get the command definition. */
		CommandDefinition definition = commandConnector.getCommandDefinition((String) arg0.getIn().getHeader("Name"));
		
		/** Validate the lock state(s). */
		for (String state : definition.getLockStates()) {
			if (stateConnector.getState(state) == false) {
				
				/** Stop the release of the command. */
				arg0.setProperty(Exchange.ROUTE_STOP, true);
				return;
			}
		}
		
		/** Release the command*/
		releasedCommandsQueue.send(arg0);
		
		/** Push tasks (actions and checks) to the Task query. */
		
	}
}
