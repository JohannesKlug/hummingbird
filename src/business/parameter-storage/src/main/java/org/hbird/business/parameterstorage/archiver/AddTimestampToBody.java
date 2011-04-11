/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage.archiver;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/*
 * A processor which adds the timestamp from the exchange-IN header
 * to the message-IN body. Timestamp and old body are seperated via ';', 
 * e.g. '120900900909;test'
 */
public class AddTimestampToBody implements Processor {

	/*
	 * Alters the exchange's IN-Message by adding a timestamp.
	 * 
	 * IN-Param: 
	 * 		Exchange	exchange 
	 * 			Body may contain any string value, e.g. 'test'.
	 */
	public void process(Exchange exchange) throws Exception {
		String originalBody = exchange.getIn().getBody(String.class);
		String timeStamp = exchange.getIn()
				.getHeader("Timestamp", String.class);

		exchange.getIn().setBody(timeStamp + ";" + originalBody);
	}
}
