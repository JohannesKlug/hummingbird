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
package org.hbird.business.navigation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.hbird.exchange.orbital.LocationContactEvent;
import org.hbird.exchange.orbital.OrbitPredictionRequest;
import org.hbird.exchange.orbital.OrbitalState;
import org.hbird.exchange.type.Satellite;
import org.hbird.exchange.type.D3Vector;
import org.hbird.exchange.type.Location;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration (locations={"/OrbitPredictionTest-context.xml"})
public class OrbitPredictionTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Start")
    protected ProducerTemplate template;

	@EndpointInject(uri = "mock:End")
	protected MockEndpoint consumerQueue;

	@Autowired
    protected CamelContext context;
	
	Satellite satellite = new Satellite("Humsat", "Test satellite.");
	Location groundStation1 = new Location("GS1", "Ground station in Germany", new D3Vector("Position", "The position", 48.69096, 9.84375, 0.));
	Location groundStation2 = new Location("GS2", "Ground station in US", new D3Vector("Position", "The position", 43.068888, -111.445312, 0.));
	List<Location> locations = new ArrayList<Location>();
	
	D3Vector position  = new D3Vector("", "", -6142438.668, 3492467.560, -25767.25680);
	D3Vector velocity  = new D3Vector("", "", 505.8479685, 942.7809215, 7435.922231);

	@Test
	public void testProcess() {
		locations.add(groundStation1);
		locations.add(groundStation2);
		
		/** Create request. Predicts for 1 hour at 60 seconds intervals.  */
		OrbitPredictionRequest request = new OrbitPredictionRequest("Test", satellite, position, velocity, 1301584739097l /** 31.03.2011 17:19 */, locations);
		
		
		/** Predict for 24 hours. */
		request.deltaPropagation = 3600 * 24;

		/** Create exchange and send it. */
		Exchange exchange = new DefaultExchange(context);
		exchange = new DefaultExchange(context);
		exchange.getIn().setBody(request);
				
		template.send(exchange);
		
		/** Keep iterating as long as the module is injecting data. */
		int count = -1;
		int newCount = 0;
		while (newCount > count) {
			count = newCount;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			newCount = consumerQueue.getReceivedCounter();
		}
		
		/** Assert the provided data. 40 visibility events. 1440 orbit events. */
		assertTrue(consumerQueue.getReceivedCounter() == 1480);
		
		List<OrbitalState> orbitalStates = new ArrayList<OrbitalState>();
		List<LocationContactEvent> locationContactEvents = new ArrayList<LocationContactEvent>();
		
		/** Go through all messages and sort them. */
		for (Exchange out : consumerQueue.getExchanges()) {
			if (out.getIn().getBody() instanceof OrbitalState) {
				orbitalStates.add((OrbitalState) out.getIn().getBody());
			}
			else if (out.getIn().getBody() instanceof LocationContactEvent) {
				locationContactEvents.add((LocationContactEvent) out.getIn().getBody());
			}
			else {
				assertTrue("Unknown body type." , false);
			}
		}

		assertTrue(orbitalStates.size() == 1440);
		assertTrue(locationContactEvents.size() == 40);
		
		Collections.sort(orbitalStates);
		Collections.sort(locationContactEvents);
	}	
}
