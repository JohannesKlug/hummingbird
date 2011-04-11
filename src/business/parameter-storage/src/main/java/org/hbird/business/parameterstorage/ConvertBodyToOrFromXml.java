/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage;

import org.apache.camel.Body;
import com.thoughtworks.xstream.XStream;

/*
 * Converts any object in the body to an xml string (or vice versa) using the xstream library.
 */
public class ConvertBodyToOrFromXml {
	XStream xstream = new XStream();

	/*
	 * Converts an object to a XML string
	 * 
	 * IN-param:  
	 * 		Object		body	(Is automatically extracted from body)
	 * 			Body of the exchange, e.g. Double with the value '2'.
	 * 			 
	 * OUT-param:
	 * 		 String	 	
	 * 			XML-String, e.g. '<Double>2</Double>'.
	 */
	public String toXml(@Body Object body) {
		return xstream.toXML(body);
	}

	/*
	 * Converts a XML string to an object
	 * 
	 * IN-param:  String 	(e.g. '<Double>2</Double>';
	 * 						 automatically extracted from Body)
	 * OUT-param: Object 	(e.g. Double with the value '2')
	 */
	public Object fromXml(@Body String body) {
		return xstream.fromXML(body);
	}
}
