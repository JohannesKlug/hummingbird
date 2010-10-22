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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;

import com.logica.hummingbird.interfaces.CommandDefinition;
import com.logica.hummingbird.interfaces.ICommandConnector;

public class JmsCommandConnector implements ICommandConnector, IJmsBuffer {

	protected ConsumerTemplate consumer = null;

	/** Map of all command defi9nitions, keyed on ccommand name. The value
	 * is a map containing ann versions of the command definition, keyed on 
	 * the time the definition was released. The map is sorted in decending
	 * order, i.e. teh FIRST entry is teh MOST RECENT.
	 * */
	protected Map<String, Map<Long, CommandDefinition>> commandDefinitions = null;

	@Override
	public Map<Long, CommandDefinition> getCommandDefinitions(String name) {
		initialise();
		return commandDefinitions.get(name);
	}

	@Override
	public CommandDefinition getCommandDefinition(String name) {
		initialise();
		if (commandDefinitions.containsKey(name) == true) {
			Iterator<Entry<Long, CommandDefinition>> it = commandDefinitions.get(name).entrySet().iterator();			
			return it.next().getValue();
		}
		
		return null;
	}

	@Override
	public void addEntry(String name, Long timestamp, Object definition) {
		if (commandDefinitions.containsKey(name) == false) {
			commandDefinitions.put(name, new HashMap<Long, CommandDefinition>());
		}
		
		commandDefinitions.get(name).put(timestamp, (CommandDefinition) definition);
	}
	
	protected void initialise() {
		if (commandDefinitions == null) {
			commandDefinitions = new ConcurrentHashMap<String, Map<Long, CommandDefinition>>();

			// process every exchange which is ready. If no exchange is left break
			// the loop
			while (true) {
				Exchange ex = consumer.receiveNoWait("activemq:topic:Definitions?selector=Type='Command'");
				if (ex != null) {
					if (commandDefinitions.containsKey((String) ex.getIn().getHeader("Name")) == false) {
						commandDefinitions.put((String) ex.getIn().getHeader("Name"), new HashMap<Long, CommandDefinition>());
					}
					commandDefinitions.get((String) ex.getIn().getHeader("Name")).put((Long) ex.getIn().getHeader("Timestamp"), (CommandDefinition) ex.getIn().getBody());
				} else {
					break;
				}
			}
		}
	}
}
