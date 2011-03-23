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
package org.hbird.business.command.task;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration (locations={"/TaskExecutorTest-context.xml"})
public class TaskExecutorTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:start")
    protected ProducerTemplate template;
	
	@Autowired
    protected CamelContext context;
	
	@DirtiesContext
	@Test
	public void testReceive() {
		DummyTask task = new DummyTask();
		task.deltaTime = 1000;
		
		sendExchange(task, ((new Date()).getTime() + 1000));
		sendExchange(task, 0);
	}
	
	public void sendExchange(DummyTask task, long delay) {
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(task);

		template.send(exchange);

		assertTrue(task.executeCalled == true);
		task.executeCalled = false;		
	}
}
