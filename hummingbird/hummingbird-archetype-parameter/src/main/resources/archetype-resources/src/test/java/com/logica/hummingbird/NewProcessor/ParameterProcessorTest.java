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

import com.logica.hummingbird.telemetry.DefaultSpaceParameter;
import com.logica.hummingbird.validation.base.OnlyChangeFilter;
import com.logica.hummingbird.validation.base.ViolationCountFilter;
import com.logica.hummingbird.validation.parameter.LowerLimit;
import com.logica.hummingbird.validation.parameter.UpperLimit;

/**
 * TODO
 * 
 * For a detailed description of the testing using the Camel test framework, please
 * see;
 * 
 *    http://camel.apache.org/testing.html
 */
public class ParameterProcessorTest extends CamelTestSupport {

	/** The registry used to resolve beans. */
	protected JndiRegistry registry = null;
	
	@EndpointInject(uri = "mock:result")
	protected MockEndpoint mockResult;
	
	@Produce(uri = "direct:start")
    protected ProducerTemplate directStart;

	/** The test function. */
	public void testProcessing() throws Exception {
		/** Insert your test code here. Use the "directStart" producer to inject exchanges. Read
		 * the exchange after the processing through the "mockResult* endpoint. */
		start.send();
	}

	@Override
	protected RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			public void configure() {

				/** Create bean and register it in the registry under some name. */
				ParameterProcessor myBean = new ParameterProcessor();
				registry.bind("myBeanName", myBean);
				
				/** A simpel route, from the endpoint "direct:start", over the bean identified through the
				 * name it was registered with above. The specification of a method is optional and is only
				 * mandatory if multiple methods have a signature 'public void [name](Exchange arg0)'. The
				 * route ends at the testing endpoint "mock:result". 
				 * */
				from("direct:start").to("bean:myBeanName?method=process").to("mock:result");
			}
		};
	}
	
	protected CamelContext createCamelContext() throws Exception {
		return new DefaultCamelContext(createRegistry());
	}

	protected JndiRegistry createRegistry() throws Exception {
		return new JndiRegistry(createJndiContext()); 
	}

	@SuppressWarnings("unchecked")
	protected Context createJndiContext() throws Exception {
		Properties properties = new Properties();
		properties.put("java.naming.factory.initial", "org.apache.camel.util.jndi.CamelInitialContextFactory");
		return new InitialContext(new Hashtable(properties));
	}
}
