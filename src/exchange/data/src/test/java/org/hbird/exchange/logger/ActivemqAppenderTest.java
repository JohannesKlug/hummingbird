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
package org.hbird.exchange.logger;

import org.apache.camel.EndpointInject;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration (locations={"/ActivemqAppenderTest-context.xml"})
public class ActivemqAppenderTest extends AbstractJUnit38SpringContextTests  {

	@Autowired
	protected ActivemqAppender appender = null;
	
	@EndpointInject(uri = "mock:End")
	protected MockEndpoint releaseQueue;

	@Test
	public void testAppendLoggingEvent() {
		appender.append(new LoggingEvent("test category", Category.getInstance("test"), 1, Level.INFO, "test message", null));
		assertTrue(releaseQueue.getReceivedCounter() == 0);		
	}
}
