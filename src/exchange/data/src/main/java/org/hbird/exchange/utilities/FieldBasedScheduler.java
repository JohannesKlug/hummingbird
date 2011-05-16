package org.hbird.exchange.utilities;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.Headers;
import org.apache.log4j.Logger;

/**
 * Class to delay a message until a time is reached, based on a field in the object.
 * 
 * The in message body is expected to hold a field as given by the attribute 'objectFieldName' 
 * (default is 'timestamp'). This class will calculate the time (ms) from 'now' to the 
 * given time and set a message header field as given by the attributed 'headerField' 
 * to the difference. 
 * 
 * NOTE: This class does not in itself delay the message. The actual delay should be done later
 * in the route. This class only calculates the size of the delay and sets a header field 
 * accordingly (default is "AMQ_SCHEDULED_DELAY", i.e. for activemq delaying).
 * 
 * Example;
 * 
 * The following route will take a message in, access the field 'timestamp' on the object in the body, calculate
 * the required delay until 'NOW' and set the message header field "AMQ_SCHEDULED_DELAY" accordingly. The route
 * thereafter parse the message to activemq, which will do the actual delaying. 
 * 
 * <bean id="delayer" class="org.hbird.exchange.utilities.FieldBasedScheduler">
 *   <property name="objectFieldName" value="timestamp"/>       <!-- Same as default value! Could be left out. -->
 *   <property name="headerField" value="AMQ_SCHEDULED_DELAY"/> <!-- Same as default value! Could be left out. -->
 * </bean?
 * 
 * <route>
 *   <...>
 *   <to uri="bean:delayer"/>
 *   <to uri="activemq:topic:OrbitalStates/>
 * </route>
 *
 */
public class FieldBasedScheduler extends AllFields {

	
	/** The class logger. */
	protected static Logger logger = Logger.getLogger(FieldBasedScheduler.class);

	/**
	 * The name of the field in the body object to be accessed as a time. 
	 */
	protected String fieldName = "timestamp";


	/**
	 * The message header field to be set to '[timestamp] - [now]'.
	 */
	protected String headerField = "AMQ_SCHEDULED_DELAY";

	/**
	 * 
	 * 
	 * @param body Object to be delayed. Must contain a field named 'objectFieldName' holding a long. Else an exception will be thrown.
	 * @param headers The header fields of the message.
	 * @throws IllegalArgumentException 
	 * @throws SecurityException
	 * @throws IllegalAccessException Should never be thrown. The method changes the accessibility to true, i.e. teh field can be any scope.
	 * @throws NoSuchFieldException Thrown if the object in the IN body does not contain a field named 'objectFieldName'
	 */
	public void schedule(@Body Object body, @Headers Map<String, Object> headers) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {

		/** Get current date and date field in body. */
		Date now = new Date();

		/** Get all fields of this class, including all superclass fields. */
		Map<String, Field> fields = new HashMap<String, Field>();
		recursiveGet(body.getClass(), fields);

		fields.get(fieldName).setAccessible(true);
		long time = (Long) fields.get(fieldName).get(body);

		/** If the message should be delayed...*/
		if (now.getTime() < time) {
			headers.put(headerField, time - now.getTime());
			logger.debug("Setting header field '" + headerField + "' for message '" + body + "' to " + (time - now.getTime()) + " ms.");
		}		
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getHeaderField() {
		return headerField;
	}

	public void setHeaderField(String headerField) {
		this.headerField = headerField;
	}	
	
	
}
