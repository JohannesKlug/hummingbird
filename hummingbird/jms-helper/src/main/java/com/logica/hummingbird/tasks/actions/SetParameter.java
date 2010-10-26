package com.logica.hummingbird.tasks.actions;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;

import com.logica.hummingbird.jmshelper.ExchangeFormatter;
import com.logica.hummingbird.tasks.AbstractTask;

/**
 * Task that sets a parameter to a specific value at a given time.
 * 
 * The task among others be used to;
 * 1) Enable / disable state checking in specific intervals.
 * 2) Change a limit to a new value.
 *
 */
public class SetParameter extends AbstractTask {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The name of the parameter to set. */
	protected String name = "";
	
	/** The value be set. */
	protected Object value = null;
	
	/** The class of the value. */
	protected String clazz = null;	
		
	public SetParameter(long executionTime, String name, Object value, String clazz) {
		super(executionTime);
		this.name = name;
		this.value = value;
		this.clazz = clazz;
	}

	/**
	 * Method that will send the message to the parameter query. 
	 * 
	 * @param arg0 The exchange to be send.
	 */
	public void process(Exchange arg0) {
		arg0.getIn().setBody(ExchangeFormatter.createParameterMessage(name, clazz, value));
		producerTemplate.send(arg0);
	}

	@Override
	public void execute(CamelContext context, ProducerTemplate producer) {
		Exchange exchange = new DefaultExchange(context);
		exchange.setIn(ExchangeFormatter.createParameterMessage(name, clazz, value));
		producer.send("direct:parameters", exchange);		
	}
}
