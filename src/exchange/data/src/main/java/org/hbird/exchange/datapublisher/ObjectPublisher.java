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
package org.hbird.exchange.datapublisher;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import org.hbird.exchange.type.Named;

/**
 * Camel 'Splitter' for loading definitions from a Spring bean file and inject
 * them into a route, for example to a ActiveMQ queue.
 * 
 * The name of the bean file must be set through the 'filename' attribute. The 
 * bean file must contain a list called 'objects' containing any number and 
 * combination of 'Named' objects. 
 * 
 * The publisher can be part of a route triggered at intervals, for example using
 * the camel timer.
 */
public class ObjectPublisher {
	
	protected static Logger logger = Logger.getLogger(ObjectPublisher.class);
	
	/** The context in which the component is running. */
	@Autowired
	protected CamelContext context = null;

	/** The name of the file to be loaded. The file may be changed on disk. */
	protected String filename;
	
	/**
	 * Constructor.
	 * 
	 * @param filename Name of the file to be read at intervals.
	 */
	public ObjectPublisher(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Method to split the message. The returned message list is actually loaded
	 * from a Spring file, i.e. the original Exchange is ignored.
	 * 
	 * @param exchange Exchange triggering the loading. The message itself is ignored.
	 * @return A list of messages, carrying as the body a command definition.
	 */
	public List<Message> process(Exchange exchange) {

		logger.info("Loading 'Named' objects from file.");
		
		/** Load the definitions from the spring bean file. */
		BeanFactory factory = new FileSystemXmlApplicationContext (filename);
		List<Named> objects = (List<Named>) factory.getBean("objects");
		
		/** Iterate through definitions and create Messages. */
		List<Message> messages = new ArrayList<Message>();
		for (Named object : objects) {
			logger.info("Loading object '" + object.getName() + "' with ID '" + object.getObjectid() + "'.");
			Message message = new DefaultMessage();
			message.setBody(object);
			messages.add(message);
		}
		
		return messages;
	}
	
	
}
