package com.logica.hummingbird.tasks.checks;

import com.logica.hummingbird.buffers.ObjectBuffer;

public class DynamicParameterBasedValue extends ConfigurableValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String parameter = null;
	
	public DynamicParameterBasedValue(String parameter) {
		this.parameter = parameter;
	}
	
	@Override
	public Number getValue(ObjectBuffer in) {
		if (in != null) {
			return (Number) ((ObjectBuffer) in).getEntry(parameter);
		}
		
		return null;
	}
}
