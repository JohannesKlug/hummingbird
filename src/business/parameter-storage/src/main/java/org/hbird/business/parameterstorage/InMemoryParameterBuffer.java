package org.hbird.business.parameterstorage;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.Header;

public class InMemoryParameterBuffer<T> implements ParameterBuffer {
	
	private Map<String, Object> latestParameterValue = new HashMap<String, Object>();

	@Override
	public Object getParameterByName(String name) {
		return latestParameterValue.get(name);
	}
	
//	public Object getParameterByNameAndClass(String name, Class<T> clazz) {
//		Object value = latestParameterValue.get(name);
//		if (value instanceof clazz) {
//			return value;
//		} else return null;
//	}
	
	// FIXME Externalise hard-coded ParameterName
	public void storeParameter(@Body Object value, @Header("HummingbirdParameterName") String name) {
		latestParameterValue.put(name, value);
	}

}
