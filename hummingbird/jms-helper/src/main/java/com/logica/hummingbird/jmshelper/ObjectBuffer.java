package com.logica.hummingbird.jmshelper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Camel processor that will buffer requests.
 * 
 * TODO Does this exist already in Camel?
 *
 */
public class ObjectBuffer  {

	/** Map of all command definitions, keyed on command name. The value
	 * is the object itself. 
	 * */
	protected Map<String, Object> buffer = new HashMap<String, Object>();

	@Autowired
	protected ConsumerTemplate consumer = null;
	
	
	/* (non-Javadoc)
	 * @see com.logica.hummingbird.jmshelper.IJmsBuffer#addEntry(org.apache.camel.Exchange)
	 */
	public void addEntry(Exchange arg0) {
		addEntry((String) arg0.getIn().getHeader("Name"), arg0.getIn().getBody());
	}

	public void addEntry(String name, Object value) {
		buffer.put(name, value);
	}
	
	public Map<String, Object> getBuffer() {
		return buffer;
	}
	
	/**
	 * Trigger the initialisation. Can be called from a timer route.
	 * 
	 * Depends on the endpoint "direct:CommandQueue" being available in the route definition.
	 * activemq:topic:Definitions?selector=Type='Command'
	 * 
	 */
	protected void initialise(Exchange arg0) {
		buffer = new ConcurrentHashMap<String, Object>();

		/** Request data, then process every exchange which is ready. If no exchange is left break the loop */
		Exchange exchange = null;
		do {
			exchange = consumer.receiveNoWait("direct:commandQueue");
			if (exchange != null) {
				addEntry(exchange);
			}
		} while (exchange != null);
	}
}
