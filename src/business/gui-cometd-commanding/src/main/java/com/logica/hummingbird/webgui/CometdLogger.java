package org.hbird.webgui;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;

import org.hbird.formatter.HeaderFields;

public class CometdLogger {

	protected static Logger logger = Logger.getLogger(CometdLogger.class);
	
	public void process(Exchange exchange) {
		
		Map<String, String> log = new ConcurrentHashMap<String, String>();
		
		log.put("tim", (String) exchange.getIn().getHeader(HeaderFields.RELEASETIME));
		log.put("lev", (String) exchange.getIn().getHeader(HeaderFields.LEVEL));
		log.put("des", (String) exchange.getIn().getHeader(HeaderFields.VALUE));
		
		// logger.info("Forwarding message.");
		exchange.getIn().setBody(log);
	}
}
