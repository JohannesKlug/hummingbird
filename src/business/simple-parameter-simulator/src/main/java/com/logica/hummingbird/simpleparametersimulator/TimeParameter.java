package org.hbird.simpleparametersimulator;

import java.util.Date;

import org.apache.camel.Exchange;

import org.hbird.formatter.ExchangeFormatter;

public class TimeParameter extends BaseParameter {

	public TimeParameter(String name) {
		super(name);
	}

	@Override
	protected void process(Exchange arg0) {
		arg0.setIn(ExchangeFormatter.createParameterMessage(name, Long.class.toString(), ((new Date()).getTime())));		
	}
}
