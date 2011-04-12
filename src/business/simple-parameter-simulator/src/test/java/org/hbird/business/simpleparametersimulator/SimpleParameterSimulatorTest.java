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
package org.hbird.business.simpleparametersimulator;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.hbird.business.simpleparametersimulator.BooleanParameter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration (locations={"/SimpleParameterSimulatorTest-context.xml"})
public class SimpleParameterSimulatorTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Commands")
    protected ProducerTemplate template;

	@Autowired
    protected CamelContext context;
	
	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	@DirtiesContext
	@Test
	public void testParameterGeneration() throws Exception {
		logger.info("Testing all simulators.");
		Thread.sleep(10000);
		
		for (int counter = 0; counter < 100; counter++) {
			// System.out.println("Testing for counter " + counter + " equals " + resultEndpoint.message(counter).body().toString());
		}		
		
		logger.info("Works fine.");
	}
	
	@DirtiesContext
	@Test
	public void testCommanding() throws Exception {
	
		Exchange exchange = new DefaultExchange(context);
		
		exchange.getIn().setHeader("Bean", "Parameter1");
		exchange.getIn().setHeader("Attribute", "Value");
		exchange.getIn().setHeader("Value", false);
		
		template.send(exchange);
		
		assertFalse( (Boolean) ((BooleanParameter) context.getRegistry().lookup("Parameter1")).getValue());
	}
}
