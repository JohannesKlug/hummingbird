package org.hbird.tasks.checks;

import org.apache.camel.Message;

import org.hbird.buffers.ObjectBuffer;

public class DynamicHeaderBasedValue extends ConfigurableValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String headerField = "";
	
	protected Number value = null;
	
	public DynamicHeaderBasedValue(String headerField) {
		this.headerField = headerField;
	}
	
	@Override
	public Number getValue(ObjectBuffer in) {
		return value;
	}

	public void configure(Message in) {
		value = (Number) in.getHeader(headerField);
	};	
}
