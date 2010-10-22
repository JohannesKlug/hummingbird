package com.logica.hummingbird.commandgenerator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.camel.Exchange;

public class ParameterBuffer {

	protected Map<String, Object> values = new ConcurrentHashMap<String, Object>();
	
	public void process(Exchange arg0) {
		values.put((String) arg0.getIn().getHeader("Name"), arg0.getIn().getHeader("Value"));
	} 
	
	public Object getValue(String parameterName) {
		return values.get(parameterName);
	}
}
