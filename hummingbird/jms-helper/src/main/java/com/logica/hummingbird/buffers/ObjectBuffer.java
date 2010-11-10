package com.logica.hummingbird.buffers;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Camel processor that will buffer requests.
 * 
 * TODO Does this exist already in Camel?
 * TODO When is stuff deleted?
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
		buffer.put((String) arg0.getIn().getHeader("Name"), arg0.getIn().getBody());
	}

	public Object getEntry(String name) {
		return buffer.get(name);
	}
	
	public int getSize() {
		return buffer.size();
	}
}
