package org.hbird.tasks.checks;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;

import org.hbird.buffers.ObjectBuffer;
import org.hbird.formatter.ExchangeFormatter;
import org.hbird.tasks.AbstractTask;

public abstract class AbstractCheck extends AbstractTask {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractCheck(long deltaTime, String stateName, String isStateoff) {
		super(deltaTime);
		this.stateName = stateName;
		this.isStateOff = isStateoff;
	}

	/** The name of the state that this check sets. */
	protected String stateName = "";	
	
	protected String isStateOff = "";
	
	/**
	 * Method to actually send the state parameter.
	 * 
	 * @param arg0 The exchange to be send.
	 * @param stateOff The name of the parameter that this is the state of.
	 * @param validity The state of the state (true or false)
	 */
	public void execute(CamelContext context, ProducerTemplate producer, ObjectBuffer buffer) {
		/** Set and send the state. */
		Exchange exchange = new DefaultExchange(context);
		
		try {
			exchange.getIn().setBody(ExchangeFormatter.createStateParameterMessage(stateName, isStateOff, validate(buffer)));
			producer.send("direct:Parameters", exchange);
		}
		catch (ParameterNotSetException e) {
			System.out.println("Failed to validate parameter. Is null.");
		}
	}
	
	protected abstract boolean validate(ObjectBuffer buffer) throws ParameterNotSetException;
}
