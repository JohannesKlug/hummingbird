package org.hbird.tasks.checks;

import org.apache.camel.Message;

import org.hbird.buffers.ObjectBuffer;


/**
 * This validation step validates that a specific parameter has a specific value
 * at the expected time.
 *
 */
public class Range extends AbstractCheck {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ConfigurableValue parameter = null;	
	protected ConfigurableValue lowerValue = null;
	protected ConfigurableValue upperValue = null;

	public Range(long deltaTime, String stateParameterName, String isStateOff, ConfigurableValue lowerValue, ConfigurableValue upperValue) {
		super(deltaTime, stateParameterName, isStateOff);

		this.lowerValue = lowerValue;
		this.upperValue = upperValue;
	}

	@Override
	public void configure(Message in) {
		for (ConfigurableValue value : new ConfigurableValue[]{parameter, lowerValue, upperValue}) {
			if (value != null) {
				value.configure(in);
			}
		}
	}

	public boolean validate(ObjectBuffer buffer) throws ParameterNotSetException {
		if (parameter == null || parameter.getValue(buffer) == null) {
			throw new ParameterNotSetException();
		}
		
		/** Check states. */
		boolean inLower = lowerValue == null || lowerValue.getValue(buffer) == null || (lowerValue.getValue(buffer).doubleValue() < parameter.getValue(buffer).doubleValue());  
		boolean inUpper = upperValue == null || upperValue.getValue(buffer) == null || (upperValue.getValue(buffer).doubleValue() > parameter.getValue(buffer).doubleValue());
		
		return inLower && inUpper;
	}

	public void setParameter(ConfigurableValue staticValue) {
		parameter = staticValue;		
	}	
}
