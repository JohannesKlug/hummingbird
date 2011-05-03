package org.hbird.business.parameterstorage;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Body;
import org.hbird.exchange.type.Parameter;


/**
 * Very simple parameter storage. Will store only the last received value of 
 * each parameter within a Map.
 */
public class InMemoryParameterBuffer {
	
	/* Map holding the buffered values. */
	protected Map<String, Parameter> latestParameterValue = new HashMap<String, Parameter>();

	
	/**
	 * Method to retrieve a parameter value based on the parameter name.
	 *  
	 * @param name The name of the parameter to be retrieved.
	 * @return The parameter object
	 */
	public Parameter getParameterByName(@Body String name) {
		return latestParameterValue.get(name);
	}
	
	
	/**
	 * Method to store a parameter into the buffer.
	 * 
	 * @param parameter The parameter to be stored.
	 */
	public void storeParameter(@Body Parameter parameter) {
		latestParameterValue.put(parameter.getName(), parameter);
	}

	
	/**
	 * Getter of the buffer.
	 * 
	 * @return The Map acting as a buffer.
	 */
	public Map<String, Parameter> getLatestParameterValue() {
		return latestParameterValue;
	}
}
