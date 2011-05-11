/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage.simple;

import org.apache.camel.Body;
import org.apache.camel.Header;

/*
 * A processor which adds the timestamp from the exchange-IN header
 * to the message-IN body. Timestamp and old body are seperated via ';', 
 * e.g. '120900900909;test'
 */
public class AddTimestampToBody {

	/*
	 * Alters the exchange's IN-Message by adding a timestamp.
	 * 
	 * IN-Param: 
	 *   body      -> Body may contain any string value, e.g. 'test'.
	 *   timestamp -> timestamp to be added to the body
	 */
	public String addTimestamp(@Body String body, @Header("Timestamp") String timestamp) throws Exception {
		return timestamp + ";" + body + "\n";
	}
}
