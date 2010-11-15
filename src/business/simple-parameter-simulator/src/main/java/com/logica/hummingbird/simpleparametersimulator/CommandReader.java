package org.hbird.simpleparametersimulator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;

// FIXME refactor hard-coded header fields

/**
 * @TITLE Command Reader
 * The command reader allows the simulator to process commands, changing the
 * output accordingly.
 * 
 * Each command is an exchange that should be routed to this object. In the header
 * the exchange must have the following attributes (... as command arguments);
 * 
 * *Bean* (String). The name of the parameter to be changed, as defined in the Spring bean assembly file.
 * *Attribute* (String). The attribute to be set. See the description of each simulator parameter type to find the parameters that can be changed.
 * *Value* (Integer | Double | Long | Boolean). The new value to be set.
 * 
 * Note that the case of the attributes are of importance.
 * 
 * h2. Example
 * 
 * With the Spring configuration file;
 * 
 * bq. 	<bean id="Parameter3" class="org.hbird.simpleparametersimulator.SinusCurveParameter">
 * < constructor-arg index="0" value="0.01"/ >
 * < constructor-arg index="1" value="10"/ >
 * < constructor-arg index="2" value="0"/ >
 * < constructor-arg index="3" value="0"/ >
 * < constructor-arg index="4" value="100"/ >				
 * < constructor-arg index="5" value="Parameter3"/ >
 * < /bean >
 * < bean id="commandHandler" class="org.hbird.simpleparametersimulator.CommandReader"/ >
 * < camelContext id="context" xmlns="http://camel.apache.org/schema/spring" >
 * < template id="producer"/ >
 * < route >
 * < from uri="activemq:topic:Commands" / >
 * < to uri="bean:commandHandler"/ >
 * < /route >
 * ...
 * < /context>
 * 
 * Sending a command with the header values;
 * 
 * Bean = "Parameter3"
 * Attribute = "Amplitude"
 * Value = 30
 * 
 * Will change the 'Amplitude' of the sinus parameter "Parameter3" to 30.
 * 
 * @CATEGORY Camel Processor
 * @CATEGORY Simple Parameter Simulator
 *
 */
public class CommandReader {

	@Autowired
    protected CamelContext context;
	
	
	/**
	 * Will retrieve the bean referenced in the exchange and set the value.
	 * 
	 * @param exchange
	 */
	public void process(Exchange exchange) {
		
		/** Read the parameters. */
		
		String bean = (String) exchange.getIn().getHeader("Bean");
		String attribute = (String) exchange.getIn().getHeader("Attribute");
		Object value = exchange.getIn().getHeader("Value");
		
		BaseParameter parameter = (BaseParameter) context.getRegistry().lookup(bean);
		
		Class argument = null;
		if (value instanceof Integer) {
			argument = Integer.class;
		}
		else if (value instanceof Double) {
			argument = Double.class;
		}
		else if (value instanceof Long) {
			argument = Long.class;
		}
		else if (value instanceof Boolean) {
			argument = Boolean.class;
		}
		
		Object[] argList = new Object[] {value};
		
		Class parTypes[] = new Class[] {argument};
		try {
			Method method = parameter.getClass().getMethod("set" + attribute, parTypes);
			method.invoke(parameter, argList);
		}
		catch (SecurityException e) {
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
