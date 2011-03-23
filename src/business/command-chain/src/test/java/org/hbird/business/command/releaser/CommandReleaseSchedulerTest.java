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
package org.hbird.business.command.releaser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.hbird.business.command.task.DummyTask;
import org.hbird.exchange.tasks.ITask;
import org.hbird.exchange.tasks.checks.RangeCheck;
import org.hbird.exchange.type.Argument;
import org.hbird.exchange.type.Command;
import org.hbird.exchange.type.Parameter;
import org.hbird.exchange.type.StateParameter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;


@ContextConfiguration (locations={"/CommandReleaseSchedulerTest-context.xml"})
public class CommandReleaseSchedulerTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Commands")
	protected ProducerTemplate template;

	@EndpointInject(uri = "mock:ReleasedCommands")
	protected MockEndpoint releasedCommands;

	@Autowired
	protected CamelContext context;

	protected Command createCommand() {
		List<String> lockStates = Arrays.asList(new String[] {"STATE1", "STATE2", "STATE3"});
		List<ITask> tasks = Arrays.asList(new ITask[] {new DummyTask(), new DummyTask()});
		List<Argument> arguments = new ArrayList<Argument>(); 
			
		Command definition = new Command("TestCommand", "Test description", arguments, lockStates, tasks, (new Date()).getTime() + 5000, 0);
		RangeCheck range = new RangeCheck("TestStateParameter", "TestParameter", 0, new StateParameter("", "", definition, new Boolean(true)), new Parameter("", "", new Double(0d), ""), new Parameter("", "", new Double(10d), ""));
		
		arguments.add(new Argument("TestArgument1", "Test description", new Long(64l), "", range));
		arguments.add(new Argument("TestArgument2", "Test description", new Long(64l), "", range));
		arguments.add(new Argument("TestArgument3", "Test description", new Long(64l), "", range));
		
		return definition;
	}

	@DirtiesContext
	@Test
	public void testScheduleRelease() {
		Command command = createCommand();
		
		/** Release command with states that will fail, i.e. locked. */
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(command);
		template.send(exchange);
		
		/** Lock state is false, so exchange should be stopped. */
		assertTrue(releasedCommands.getReceivedCounter() == 1);
		assertTrue( (Long) releasedCommands.getExchanges().get(0).getIn().getHeader("AMQ_SCHEDULED_DELAY") > 0);
	}
}
