/**
 * Licensed to the Hummingbird Foundation (HF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The HF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hbird.exchange.jms;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;

/** Maps all a subset of POJO fields to JMS header fields, leaving the POJO unchanged.
 * 
 *  This class can be added to a camel route, to map a selected set of fields of a POJO to
 *  JMS message header fields. The JMS message, containing the POJO in its 
 *  body, will thereafter also list the selected POJO fields in its header. This is 
 *  useful for filtering in for example routes using ActiveMQ, where only
 *  the header fields can be used for filtering / routing.*/
public class SelectedFields extends AllFields {

	/** List of the field names to be mapped. The fields may be private, protected or public. */
	protected String[] fields = {};

	/**
	 * The method will access the IN message of the exchange, and read the
	 * body. The body will typically contain a POJO to be transfered in the
	 * route. The selected fields of the POJO will be read using reflection, and the 
	 * exchange IN message edited, setting a header field for each POJO field.
	 * The header field will become;
	 * - [field name]:[field value as String]
	 * The exchange and the IN body is not edited.
	 * 
	 * @param exchange The exchange carrying the message to be mapped.
	 */
	public void process(Exchange exchange) {
		
		/** Use reflection to map all object fields to JMS header fields. */
		Object pojo = exchange.getIn().getBody();

		/** Find all fields of this class as well as all super classes. */
		Map<String, Field> allFields = new HashMap<String, Field>();
		recursiveGet(pojo.getClass(), allFields);

		/** Iterate through all fields to be mapped, locate the field and map them. */
		if (pojo != null) {
			for (String fieldName : fields) {
				try {
					/** The field may be protected or private. Make it accessible prior to reading the values. */
					allFields.get(fieldName).setAccessible(true);
					
					/** Set the header field name to the name of the field and the 
					 * value to the value of the field. */
					exchange.getIn().setHeader(allFields.get(fieldName).getName(), allFields.get(fieldName).get(pojo).toString());
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}
}
