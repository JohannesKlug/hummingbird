package org.hbird.business.systemmonitoring;

import java.lang.management.ManagementFactory;

import org.apache.camel.Exchange;
import org.hbird.exchange.type.Parameter;

/**
 * A parameter reporting the current memory usage (bytes). Each call will lead to
 * the creation of a Parameter instance, holding the memory usage in bytes as a long.
 * 
 * To create a Parameter instance every 60 seconds and inject this into a Activemq parameter topic,
 * configure the following;
 * 
 * 	<bean id="memory" class="org.hbird.business.systemmonitoring.MemoryParameter">
 *    <constructor-arg index="0" value="Memory"/>
 *    <constructor-arg index="1" value="The memory (bytes) currently used by the system."/>
 *  </bean>
 *  <camelContext id="context" xmlns="http://camel.apache.org/schema/spring">
 *    <route>
 *      <from uri="timer://memory?fixedRate=true&amp;period=60000" />
 *      <to uri="bean:memory"/>
 *      <to uri="activemq:topic:Parameters"/>
 *    </route>
 *  </camelContext>
 * 
 */
public class MemoryParameter extends Parameter {

	/***/
	private static final long serialVersionUID = -1090599380588508004L;

	/**
	 * Constructor.
	 * 
	 * @param name The name of the Parameter to be created.
	 * @param description The description of the parameter to be created.
	 */
	public MemoryParameter(String name, String description) {
		super(name, description, null, "bytes");
	}

	/**
	 * Method to create a new instance of the memory parameter. The body of the 
	 * exchange will be updated.
	 * 
	 * @param exchange The exchange to hold the new value.
	 */
	public void check(Exchange exchange) {
		this.value = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
		this.newInstance();
		exchange.getIn().setBody(this);
	}	
}
