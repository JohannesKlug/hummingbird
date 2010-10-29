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
package com.logica.hummingbird.jmshelper;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;

import com.logica.hummingbird.interfaces.ITask;

/**
 * Helper class for embedding data into a Camel exchange. Using these functions
 * guarantee that the right header fields are set and that the body of the exchange
 * is filled in properly. In other words; use it.
 */
public class ExchangeFormatter {

	/**
	 * Method for setting the default values 
	 * 
	 * @param message The message the values will be set in.
	 * @param name The 
	 * @param type
	 * @param value
	 */
	protected static void setParameterMandatory(Message message, String name, String type, Object value) {
		message.setHeader("Name", name);
		message.setHeader("Type", Boolean.class.toString());		
		message.setHeader("Value", value);
		message.setHeader("Timestamp", new Long((new Date()).getTime()));		
	}
	
	public static Message createStateParameterMessage(String stateName, String stateOff, Boolean validity) {
		Message message = new DefaultMessage();
		setParameterMandatory(message, stateName, Boolean.class.toString(), validity);
		
		message.setHeader("StateOff", stateOff);
		
		return message;
	};

	public static Message createParameterMessage(String parameterName, String clazz, Object value) {
		Message message = new DefaultMessage();
		setParameterMandatory(message, parameterName, clazz, value);		
		return message;
	};

	public static Message createCommandDefinition(String name, Object value) {
		Message message = new DefaultMessage();
		message.setHeader(HeaderFields.NAME, name);
		message.setBody(value);
		return message;
	};
	
	
	public static String getParameterName(Exchange exchange) {
		return (String) exchange.getIn().getHeader(HeaderFields.NAME);
	}

	public static String getParameterType(Exchange exchange) {
		return (String) exchange.getIn().getHeader(HeaderFields.TYPE);
	}

	public static String getParameterTimestamp(Exchange exchange) {
		return (String) exchange.getIn().getHeader(HeaderFields.TIMESTAMP);
	}

	public static Message createTask(String string, long executionTime, String name, ITask task) {
		Message message = new DefaultMessage();
		message.setHeader(HeaderFields.TYPE, "Task");
		message.setHeader(HeaderFields.EXECUTIONTIME, executionTime);
		message.setHeader(HeaderFields.TASK_OFF, name);
		message.setBody(task);			

		return message;
	}

	public static String getName(Exchange arg0) {
		return (String) arg0.getIn().getHeader(HeaderFields.NAME);
	}
}
