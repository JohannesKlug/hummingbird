package com.logica.hummingbird.tasks.checks;

import com.logica.hummingbird.buffers.ObjectBuffer;

/**
 * This validation step validates that a specific parameter has a specific value
 * at the expected time.
 *
 */
public class StaticValue extends ConfigurableValue {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Number value = null;
	
	public StaticValue(Number value) {
		this.value = value;
	}
	
	@Override
	public Number getValue(ObjectBuffer in) {
		return value;
	}
}
