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
package org.hbird.exchange.tasks;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import org.hbird.exchange.tasks.actions.SetParameter;

@ContextConfiguration (locations={"/TasksTest-context.xml"})
public class TasksTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Timer1")
    protected ProducerTemplate template1;

	@Produce(uri = "direct:Timer2")
    protected ProducerTemplate template2;

	@EndpointInject(uri = "mock:result")
	protected MockEndpoint mockResult;

	@Autowired
    protected CamelContext context;
	
	@Autowired
	protected SetParameter setParameterTask = null;

	@Autowired
	protected SetParameter setStateParameterTask = null;
	
	@DirtiesContext
	@Test
	public void testSetParameter() {
		mockResult.reset();
		
		Exchange exchange = new DefaultExchange(context);
		template1.send(exchange);
		
		assertTrue(mockResult.getExchanges().size() == 1);
		assertTrue(mockResult.getExchanges().get(0).getIn().getHeader("name").equals("aParameter") == true);
		assertTrue(mockResult.getExchanges().get(0).getIn().getHeader("description").equals("A test parameter") == true);
		assertTrue(mockResult.getExchanges().get(0).getIn().getHeader("clazz").equals("java.lang.Double") == true);
		assertTrue(mockResult.getExchanges().get(0).getIn().getHeader("unit").equals("meter") == true);
		assertTrue(mockResult.getExchanges().get(0).getIn().getHeader("value").equals("1.0") == true);
		
		exchange = new DefaultExchange(context);
		template2.send(exchange);
		
		assertTrue(mockResult.getExchanges().size() == 2);
		assertTrue(mockResult.getExchanges().get(1).getIn().getHeader("name").equals("aStateParameter") == true);
		assertTrue(mockResult.getExchanges().get(1).getIn().getHeader("description").equals("A test state parameter") == true);
		assertTrue(mockResult.getExchanges().get(1).getIn().getHeader("clazz").equals("java.lang.Boolean") == true);
		assertTrue(mockResult.getExchanges().get(1).getIn().getHeader("unit").equals("") == true);
		assertTrue(mockResult.getExchanges().get(1).getIn().getHeader("value").equals("false") == true);
		assertTrue(mockResult.getExchanges().get(1).getIn().getHeader("isStateOff").equals("aParameter") == true);
	}	
}
