package org.hbird.business.systemmonitoring;

import java.lang.management.ManagementFactory;

import org.apache.camel.Exchange;
import org.hbird.exchange.type.Parameter;

/**
 * A parameter reporting the current thread usage (count). Each call will lead to
 * the creation of a Parameter instance, holding the the number of threads used.
 * 
 * To create a Parameter instance every 60 seconds and inject this into a Activemq parameter topic,
 * configure the following;
 * 
 * 	<bean id="threads" class="org.hbird.business.systemmonitoring.ThreadParameter">
 *    <constructor-arg index="0" value="Threads"/>
 *    <constructor-arg index="1" value="The threads (count) currently used by the system."/>
 *  </bean>
 *  <camelContext id="context" xmlns="http://camel.apache.org/schema/spring">
 *    <route>
 *      <from uri="timer://threads?fixedRate=true&amp;period=60000" />
 *      <to uri="bean:threads"/>
 *      <to uri="activemq:topic:Parameters"/>
 *    </route>
 *  </camelContext>
 * 
 */
public class ThreadParameter extends Parameter {

	/***/
	private static final long serialVersionUID = -1090599380588508004L;

	/**
	 * Constructor.
	 * 
	 * @param name The name of the Parameter to be created.
	 * @param description The description of the parameter to be created.
	 */
	public ThreadParameter(String name, String description) {
		super(name, description, null, " count");
	}

	/**
	 * Method to create a new instance of the threads parameter. The body of the 
	 * exchange will be updated.
	 * 
	 * @param exchange The exchange to hold the new value.
	 */
	public void check(Exchange exchange) {
		this.value = ManagementFactory.getThreadMXBean().getThreadCount();
		this.newInstance();
		exchange.getIn().setBody(this);
	}	
}
