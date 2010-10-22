package com.logica.hummingbird.commandreleaser.tasks.actions;

import org.apache.camel.Exchange;

import com.logica.hummingbird.commandreleaser.tasks.AbstractTask;
import com.logica.hummingbird.jmshelper.ExchangeFormatter;

/**
 * Task that sets a parameter to a specific value at a given time.
 * 
 * The task among others be used to;
 * 1) Enable / disable state checking in specific intervals.
 * 2) Change a limit to a new value.
 *
 */
public class SetParameter extends AbstractTask {

	/** The name of the parameter to set. */
	protected String name = "";
	
	/** The value be set. */
	protected Object value = null;
	
	/** The class of the value. */
	protected String clazz = null;	
	
	/**
	 * Method that will send the message to the parameter query. 
	 * 
	 * @param arg0 The exchange to be send.
	 */
	public void process(Exchange arg0) {
		arg0.getIn().setBody(ExchangeFormatter.createParameterMessage(name, clazz, value));
		producerTemplate.send(arg0);
	}
}
