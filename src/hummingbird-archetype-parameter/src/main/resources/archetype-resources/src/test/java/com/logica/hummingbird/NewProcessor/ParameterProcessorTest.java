#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
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
package ${package}.NewProcessor;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.JndiRegistry;
import org.apache.camel.test.CamelTestSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import org.hbird.formatter.ExchangeFormatter;
import org.hbird.telemetry.DefaultSpaceParameter;
import org.hbird.validation.base.OnlyChangeFilter;
import org.hbird.validation.base.ViolationCountFilter;
import org.hbird.validation.parameter.LowerLimit;
import org.hbird.validation.parameter.UpperLimit;

/**
 * TODO
 * 
 * For a detailed description of the testing using the Camel test framework, please
 * see;
 * 
 *    http://camel.apache.org/testing.html
 */


@ContextConfiguration (locations={"/ParameterProcessorTest-context.xml"})
public class ParameterProcessorTest extends AbstractJUnit38SpringContextTests {

	/** End point from which you can read the results from the routes. */
	@EndpointInject(uri = "mock:result")
	protected MockEndpoint mockResult;
	
	/** A producer which you can use to inject messages in the routes. */
	@Produce(uri = "direct:start")
    protected ProducerTemplate directStart;

	/** An autowired producer, i.e. Spring will locate the bean named 'producer' in the XML file and set it automatically. */
	@Autowired
	protected ProducerTemplate producer = null;

	/** An autowired context, i.e. Spring will locate the bean named 'context' in the XML file and set it automatically. */
	@Autowired
	protected CamelContext context = null;

	/** To get a reference to any bean defined in the Spring XML assembly file, simply write... */
	@Autowired
	protected NewProcessor myBean;
	
	
	/** The test function. */
	public void testProcessing() throws Exception {
		/** Insert your test code here. */
		
		/** To get a reference to one of the beans defined in the Spring XML assembly file, either
		 * use the @Autowired annotation as described above, or look it up in the registry as shown below. */
		NewProcessor processor = (NewProcessor) context.getRegistry().lookup("myBean");
		
		/** Use the context to build new exchanges. */
		Exchange exchange = new DefaultExchange(context);
		
		/** Use the ExchangeFormatter to set the in message of the exchange, in this case a state parameter. */
		exchange.setIn(ExchangeFormatter.createStateParameterMessage("aTestState", "myParameter", true));
		
		/** Use the "directStart" producer to inject exchanges. */
		directStart.send(exchange);
		
		/** Read the exchange after the processing through the "mockResult* endpoint. */
		assertTrue(mockResult.getExchanges().size() == 1);
	}
}
