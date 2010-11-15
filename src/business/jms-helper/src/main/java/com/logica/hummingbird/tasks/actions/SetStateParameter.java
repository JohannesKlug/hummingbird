package org.hbird.tasks.actions;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.apache.log4j.Logger;

import org.hbird.buffers.ObjectBuffer;
import org.hbird.formatter.ExchangeFormatter;
import org.hbird.tasks.AbstractTask;

public class SetStateParameter extends AbstractTask {

	protected static Logger logger = Logger.getLogger(SetStateParameter.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String name;

	protected String stateOff;
	
	protected Boolean value;
	
	public SetStateParameter(long deltaTime, String name, String stateOff, Boolean value) {
		super(deltaTime);
		
		this.name = name;
		this.stateOff = stateOff;
		this.value = value;
	}

	/**
	 * Method that will send the message to the parameter query. 
	 * 
	 * @param arg0 The exchange to be send.
	 */
	public void execute(CamelContext context, ProducerTemplate producer, ObjectBuffer buffer) {
		logger.info("Setting state parameter '" + name + "' to value '" + value.toString() + "'.");
		
		Exchange exchange = new DefaultExchange(context);
		exchange.setIn(ExchangeFormatter.createStateParameterMessage(name, stateOff, value));
		producer.send("direct:Parameters", exchange);	
	}	
}
