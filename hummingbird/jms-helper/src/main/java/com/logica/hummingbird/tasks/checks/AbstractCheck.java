package com.logica.hummingbird.tasks.checks;

import org.apache.camel.Exchange;

import com.logica.hummingbird.jmshelper.ExchangeFormatter;
import com.logica.hummingbird.tasks.AbstractTask;

public abstract class AbstractCheck extends AbstractTask {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractCheck(long executionTime) {
		super(executionTime);
	}

	/** The name of the state that this check sets. */
	protected String stateName = "";	
	
	/**
	 * Method to actually send the state parameter.
	 * 
	 * @param arg0 The exchange to be send.
	 * @param stateOff The name of the parameter that this is the state of.
	 * @param validity The state of the state (true or false)
	 */
	protected void send(Exchange arg0, String stateOff, boolean validity) {
		/** Set and send the state. */
		arg0.getIn().setBody(ExchangeFormatter.createStateParameterMessage(stateName, stateOff, validity));
		producerTemplate.send(arg0);
	}
}
