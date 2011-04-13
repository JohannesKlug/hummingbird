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
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.camel.Exchange;

/** Maps all POJO fields to JMS header fields, leaving the POJO unchanged.
 * 
 *  This class can be added to a camel route, to map the fields of a POJO to
 *  JMS message header fields. The JMS message, containing the POJO in its 
 *  body, will thereafter also list all POJO fields in its header. This is 
 *  useful for filtering in for example routes using ActiveMQ, where only
 *  the header fields can be used for filtering / routing.*/
public class AllFields {

	/**
	 * The method will access the IN message of the exchange, and read the
	 * body. The body will typically contain a POJO to be transfered in the
	 * route. All fields of the POJO will be read using reflection, and the 
	 * exchange IN message edited, setting a header field for each POJO field.
	 * The header field will become;
	 * - [field name]:[field value as String]
	 * The exchange and the IN body is not edited.
	 * 
	 * @param exchange The exchange carrying the message to be mapped.
	 */
	public synchronized void process(Exchange exchange) {

		/** Use reflection to map all object fields to JMS header fields. */
		Object pojo = exchange.getIn().getBody();
		if (pojo != null) { 

			/** Find all fields of this class as well as all super classes. */
			Map<String, Field> fields = new HashMap<String, Field>();
			recursiveGet(pojo.getClass(), fields);

			/** Iterate through all fields, and map them to header fields. */
			Iterator<Entry<String, Field>> it = fields.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Field> entry = it.next();

				try {
					/** Ensure that the field is accessible, i.e. if its protected or private we
					 * could else not be able to read the value. */
					entry.getValue().setAccessible(true);
					
					/** If the value is null, then we dont map. */
					if (entry.getValue().get(pojo) != null) {
						/** Set the header field name to the name of the field and the 
						 * value to the value of the field. */		
						exchange.getIn().setHeader(entry.getKey(), entry.getValue().get(pojo).toString());
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}		
	}


	/**
	 * Method to list all fields of the 'clazz', including all inherited fields of all
	 * super classes, private as well as protected.
	 * 
	 * @param clazz The name of the class of which all fields should be listed.
	 * @param fields The map of all private, protected and public fields of the clazz and all its super classes. 
	 * The map is keyed on the field name, and the value is the field.
	 */
	protected void recursiveGet(Class<?> clazz, Map<String, Field> fields) {

		for (Field field : clazz.getDeclaredFields()) {
			fields.put(field.getName(), field);
		}
		if (clazz.getSuperclass() != null) {
			recursiveGet(clazz.getSuperclass(), fields);
		}
	}
}
