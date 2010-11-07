package com.logica.hummingbird.logger;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import com.logica.hummingbird.formatter.ExchangeFormatter;

public class ActivemqAppender extends AppenderSkeleton {

	protected ProducerTemplate producer;

	protected CamelContext context;

	public ActivemqAppender() {
		context = new DefaultCamelContext();
		producer = context.createProducerTemplate();		
	}

	/* (non-Javadoc)
	 * @see org.apache.log4j.AppenderSkeleton#append(org.apache.log4j.spi.LoggingEvent)
	 */
	@Override
	public void append(LoggingEvent event) {
		Exchange exchange = new DefaultExchange(context);
		exchange.setIn(ExchangeFormatter.createLogMessage(event));
		producer.send("activemq:topic:Logging", exchange);		
	}

	@Override
	public void close() {
		/** Do null*/		
	}

	@Override
	public boolean requiresLayout() {
		return false;
	}
}
