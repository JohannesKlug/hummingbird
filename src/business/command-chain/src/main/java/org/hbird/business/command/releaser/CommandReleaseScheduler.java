package org.hbird.business.command.releaser;

import java.util.Date;

import org.apache.camel.Exchange;
import org.hbird.exchange.type.Command;

/** 
 * Components for delaying the release of a command. 
 * A command object has a 'releaseTime' variable, defining when the command is to be released
 * for transfer to the satellite. This can be used to schedule command releases, inserting them
 * in any order, but only releasing them in the defined order.
 * The scheduling of this component is is based on the Activemq scheduling capabilities as described 
 * in http://activemq.apache.org/delay-and-schedule-message-delivery.html. Activemq will only
 * parse the command on to the subscribers (will onky 'broker' the exchange) when the delay has
 * expired. 
 * 
 * Example of Usage;
 * 
 *   <!-- Create scheduling bean. -->
 * 	 <bean id="releaseScheduler" class="org.hbird.business.command.release.CommandReleaseScheduler">
 *   
 *   ...
 *   <!-- Integrate scheduling bean in route. The end point of the route must be activemq. -->
 *   <route>
 *     [Component that created a 'Command' object and sets it on the exchanges in message body]
 *     <to uri="bean:releaseScheduler"/>
 *     <to uri="activemq:queue:Commands"/>
 *   </route>
 *   
 * */
public class CommandReleaseScheduler {

	public void process(Exchange exchange) {
		/** Get command. */
		Command command = (Command) exchange.getIn().getBody();
		
		/** If the release time is in the future, then set the activemq delay header field. */
		long now = (new Date()).getTime();
		if (now < command.getReleaseTime()) {
			exchange.getIn().setHeader("AMQ_SCHEDULED_DELAY", command.getReleaseTime() - now);
		}
	}
}
