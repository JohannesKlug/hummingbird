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
package org.hbird.exchange.type;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import org.hbird.exchange.type.Parameter;
import org.hbird.exchange.type.StateParameter;

@ContextConfiguration (locations={"/BodyBasedRoutingTest-context.xml"})
public class BodyBasedRoutingTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Start")
    protected ProducerTemplate template;

	@EndpointInject(uri = "mock:Parameter")
	protected MockEndpoint parameterQueue;

	@EndpointInject(uri = "mock:Other")
	protected MockEndpoint otherQueue;

	@Autowired
    protected CamelContext context;
	
	
	@Test
	public void testAllFieldsWithParameter() throws InterruptedException {
		releaseQueue.reset();
		
		Exchange exchange = new DefaultExchange(context);
		exchange = new DefaultExchange(context);
		exchange.getIn().setBody(new Parameter("parameter1", "test description", "parameter2", "unit"));
		
		template.send(exchange);
		
		releaseQueue.setExpectedMessageCount(1);
		releaseQueue.assertIsSatisfied();
		
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("name")).equals("parameter1"));
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("description")).equals("test description"));
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("clazz")).equals("java.lang.String"));
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("value")).equals("parameter2"));
	}	
	
	@Test
	public void testAllFields() throws InterruptedException {
		releaseQueue.reset();
		
		Exchange exchange = new DefaultExchange(context);
		exchange = new DefaultExchange(context);
		Parameter parameter = new Parameter("parameter1", "test description", new Double(2), "TestUnit");
		exchange.getIn().setBody(parameter);
		
		releaseQueue.setExpectedMessageCount(1);
		releaseQueue.assertIsSatisfied();
		
		template.send(exchange);
		
		releaseQueue.setExpectedMessageCount(1);
		releaseQueue.assertIsSatisfied();
		
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("name")).equals("parameter1"));
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("description")).equals("test description"));
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("isStateOff")).equals("parameter2"));
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("clazz")).equals("java.lang.Boolean"));
		assertTrue(((String) releaseQueue.getReceivedExchanges().get(0).getIn().getHeader("value")).equals("true"));
	}
	
}
