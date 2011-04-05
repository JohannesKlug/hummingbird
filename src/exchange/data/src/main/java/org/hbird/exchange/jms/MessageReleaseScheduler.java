package org.hbird.exchange.jms;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;

/** 
 * Components for delaying the release of an object. 
 * 
 * A object can have a field containing a timestamp, defining when the object is to be released
 * in a route. This can be used to schedule command releases or script execution, inserting them
 * in any order, but only releasing them in the defined order.
 * 
 * The scheduling of this component is is based on the Activemq scheduling capabilities as described 
 * in http://activemq.apache.org/delay-and-schedule-message-delivery.html. Activemq will only
 * parse the command on to the subscribers (will only 'broker' the exchange) when the delay has
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
public class MessageReleaseScheduler extends SelectedFields {

	protected static Logger logger = Logger.getLogger(MessageReleaseScheduler.class);
	
	public synchronized void process(Exchange exchange) {

		/** Use reflection to map all object fields to JMS header fields. */
		Object pojo = exchange.getIn().getBody();

		/** Iterate through all fields to be mapped, locate the field and map them. */
		if (pojo != null) {

			/** Find all fields of this class as well as all super classes. */
			Map<String, Field> allFields = new HashMap<String, Field>();
			recursiveGet(pojo.getClass(), allFields);
			
			for (String fieldName : fields) {
				if (allFields.containsKey(fieldName)) {
					try {
						/** The field may be protected or private. Make it accessible prior to reading the values. */
						allFields.get(fieldName).setAccessible(true);

						/** The field has to be an instance of long. 
						 * TODO Is this to harsh? Should it be instance of Number instead? */
						if (allFields.get(fieldName).get(pojo) instanceof Long) {
							Date now = new Date();
							
							/** If the release time is in the future, then delay it. */
							if (now.getTime() < (Long) allFields.get(fieldName).get(pojo)) {
								
								/** Set the header field name to the name of the field and the 
								 * value to the value of the field. */
								exchange.getIn().setHeader("AMQ_SCHEDULED_DELAY", ((Long) allFields.get(fieldName).get(pojo) - now.getTime()));								
								logger.info("Release of message delayed with '" + ((Long) allFields.get(fieldName).get(pojo) - now.getTime()) + "' ms.");
							}		
							else {
								logger.warn("Schedule field '" + fieldName + "' has time '" + (Long) allFields.get(fieldName).get(pojo) + "' which is BELOW now == '" + now.getTime() + "'.");
							}
							break;
						}
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NullPointerException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		boolean test = true;
	}
}
