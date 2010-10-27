package com.logica.hummingbird.tasks.checks;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;

/**
 * This validation step validates that a specific parameter has a specific value
 * at the expected time.
 *
 */
public class ExpectedValue extends AbstractCheck {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String parameter = "";
	protected Object expectedValue = null;

	public ExpectedValue(long executionTime, String parameter, Object expectedValue) {
		super(executionTime);
		
		this.parameter = parameter;
		this.expectedValue = expectedValue;
	}

	public void process(Exchange arg0) {
		/** Get the value. */
		
		/** Check against the limit. */
		
		
		/** Send state parameter. */
	}

	@Override
	public void execute(CamelContext context, ProducerTemplate producer) {
		// TODO Auto-generated method stub
		
	}
}
