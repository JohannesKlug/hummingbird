package org.hbird.validation;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.JndiRegistry;
import org.apache.camel.test.CamelTestSupport;

import org.hbird.formatter.ExchangeFormatter;
import org.hbird.telemetry.DefaultSpaceParameter;
import org.hbird.validation.base.OnlyChangeFilter;
import org.hbird.validation.base.ViolationCountFilter;
import org.hbird.validation.parameter.LowerLimit;
import org.hbird.validation.parameter.UpperLimit;

public class ParameterLimitTest extends CamelTestSupport {

	protected JndiRegistry registry = null;

	
	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;
	
	
	@Produce(uri = "direct:startEnabled1")
    protected ProducerTemplate startEnabled1;

	@Produce(uri = "direct:startEnabled2")
    protected ProducerTemplate startEnabled2;

	@Produce(uri = "direct:startEnabledAll")
    protected ProducerTemplate startEnabledAll;

	@Produce(uri = "direct:startUpperLimit1")
    protected ProducerTemplate upperLimit1;
	
	@Produce(uri = "direct:startLowerLimit1")
    protected ProducerTemplate lowerLimit1;

	@Produce(uri = "direct:startUpperLimit2")
    protected ProducerTemplate upperLimit2;
	
	@Produce(uri = "direct:startLowerLimit2")
    protected ProducerTemplate lowerLimit2;

	@Produce(uri = "direct:startParameter1")
    protected ProducerTemplate startParameter1;
	
	@Produce(uri = "direct:startParameter2")
    protected ProducerTemplate startParameter2;
	
	public void testEjectionMessage() throws Exception {
		
		assertTrue(resultEndpoint.getReceivedCounter() == 0);

		Exchange exchange = new DefaultExchange(context);
		
		/** Both limits enabled (null). Send a few parameters that are all in limit. Validate that no 
		 * state changes occur. 
		 * 
		 * Two messages will be send;
		 * 1) UpperLimit parameter1 = true
		 * 2) LowerLimit parameter1 = true
		 */

		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter1", Double.class.toString(), 1d));
		startParameter1.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 2);
		
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter1", Double.class.toString(), 2d));
		startParameter1.send(exchange);
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter1", Double.class.toString(), 1d));
		startParameter1.send(exchange);
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter1", Double.class.toString(), 0d));
		startParameter1.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 2);

		/**	Two messages will be send;
		 * 3) UpperLimit parameter2 = true
		 * 4) LowerLimit parameter2 = true
		 */
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter2", Double.class.toString(), 3d));
		startParameter2.send(exchange);
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter2", Double.class.toString(), 4d));
		startParameter2.send(exchange);
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter2", Double.class.toString(), 5d));
		startParameter2.send(exchange);
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter2", Double.class.toString(), 6d));
		startParameter2.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 4);

		/** Send a violation. */
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter1", Double.class.toString(), -6d));
		startParameter1.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 4);
		
		/** Send a valid parameter. Clears the violation counter. */
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter1", Double.class.toString(), -4d));
		startParameter1.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 4);
		
		/** Send a violation. */
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter1", Double.class.toString(), -6d));
		startParameter1.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 4);
		
		/** Send a violation. */
		
		/**	One messages will be send;
		 * 5) LowerLimit parameter1 = false
		 */
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter1", Double.class.toString(), -7d));
		startParameter1.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 5);

		
		/** Violate lower limit. Upper limit will again become true, lower limit false */
		
		/** Send a violation. */
		
		/**	One messages will be send;
		 * 6) LowerLimit parameter1 = true
		 */
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter1", Double.class.toString(), 4d));
		startParameter1.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 6);

		/** Send a violation. */
		
		/**	One messages will be send;
		 * 7) UpperLimit parameter1 = false
		 */
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter1", Double.class.toString(), 4d));
		startParameter1.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 7);

		/** Change the limit so that the parameter gets back in limit. */
		
		/**	One messages will be send;
		 * 8) UpperLimit parameter1 = true
		 */
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("UpperLimitParameter1", Integer.class.toString(), 6d));
		upperLimit1.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 8);
		
		/** Disable all limit checking. */
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("EnableLimitChecking", Boolean.class.toString(), false));
		startEnabledAll.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 8);
		
		/** Violate limits just for fun. */
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter1", Integer.class.toString(), 20d));
		startParameter1.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 8);

		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter1", Integer.class.toString(), 30d));
		startParameter1.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 8);

		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter2", Integer.class.toString(), 20d));
		startParameter2.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 8);

		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("Parameter2", Integer.class.toString(), 30d));
		startParameter2.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 8);

		/** Enable limit checking.*/
		exchange.setProperty(Exchange.ROUTE_STOP, false);
		exchange.setIn(ExchangeFormatter.createParameterMessage("EnableLimitChecking", Boolean.class.toString(), true));
		startEnabledAll.send(exchange);
		assertTrue(resultEndpoint.getReceivedCounter() == 8);		
	}


	protected CamelContext createCamelContext() throws Exception {
		return new DefaultCamelContext(createRegistry());
	}

	protected JndiRegistry createRegistry() throws Exception {
		registry = new JndiRegistry(createJndiContext()); 
		return registry;
	}

	@SuppressWarnings("unchecked")
	protected Context createJndiContext() throws Exception {
		Properties properties = new Properties();

		// jndi.properties is optional
		InputStream in = getClass().getClassLoader().getResourceAsStream("jndi.properties");
		if (in != null) {
			log.debug("Using jndi.properties from classpath root");
			properties.load(in);
		} else {
			// set the default initial factory
			properties.put("java.naming.factory.initial", "org.apache.camel.util.jndi.CamelInitialContextFactory");
		}
		return new InitialContext(new Hashtable(properties));
	}

	@Override
	protected RouteBuilder createRouteBuilder() {


		/**
		 *  [upperLimit1]        {upperLimit1}
		 *  [enabled1]
		 *  [parameter1]
		 *  [lowerLimit1]        {lowerLimit1}
		 * 
		 *  [upperLimit2]        {upperLimit2}
		 *  [enabled1]
		 *  [parameter2]
		 *  [lowerLimit2]        {lowerLimit2}
		 * 
		 * */
		return new RouteBuilder() {

			public void configure() {

				LowerLimit lowerLimit1 = new LowerLimit("Parameter1State", -5);
				UpperLimit upperLimit1 = new UpperLimit("Parameter1State", 3);

				LowerLimit lowerLimit2 = new LowerLimit("Parameter2State", 2);
				UpperLimit upperLimit2 = new UpperLimit("Parameter2State", 10);
 
				OnlyChangeFilter changeFilterLower1 = new OnlyChangeFilter();
				OnlyChangeFilter changeFilterUpper1 = new OnlyChangeFilter();
				OnlyChangeFilter changeFilterLower2 = new OnlyChangeFilter();
				OnlyChangeFilter changeFilterUpper2 = new OnlyChangeFilter();

				
				ViolationCountFilter countFilterLower1 = new ViolationCountFilter();
				ViolationCountFilter countFilterUpper1 = new ViolationCountFilter();
				ViolationCountFilter countFilterLower2 = new ViolationCountFilter();
				ViolationCountFilter countFilterUpper2 = new ViolationCountFilter();
				
				registry.bind("upperLimit1", upperLimit1); 
				registry.bind("lowerLimit1", lowerLimit1);
				registry.bind("upperLimit2", upperLimit2);
				registry.bind("lowerLimit2", lowerLimit2);
				
				registry.bind("changeFilterLower1", changeFilterLower1);
				registry.bind("changeFilterUpper1", changeFilterUpper1);
				registry.bind("changeFilterLower2", changeFilterLower2);
				registry.bind("changeFilterUpper2", changeFilterUpper2);

				
				registry.bind("countFilterLower1", countFilterLower1);
				registry.bind("countFilterLower2", countFilterLower2);
				registry.bind("countFilterUpper1", countFilterUpper1);
				registry.bind("countFilterUpper2", countFilterUpper2);

				
				/** Routes to enable / disable the processing. */
				from("direct:startEnabledAll").multicast().to("direct:startEnabled1", "direct:startEnabled2");
				
				from("direct:startEnabled1").multicast().to("direct:enabledUpperLimit1", "direct:enabledLowerLimit1");				
				from("direct:enabledUpperLimit1").to("bean:upperLimit1?method=processEnabled").to("bean:countFilterUpper1?method=process").to("direct:filterSetUpper1");
				from("direct:enabledLowerLimit1").to("bean:lowerLimit1?method=processEnabled").to("bean:countFilterLower1?method=process").to("direct:filterSetLower1");

				from("direct:startEnabled2").multicast().to("direct:enabledUpperLimit2", "direct:enabledLowerLimit2");				
				from("direct:enabledUpperLimit2").to("bean:upperLimit2?method=processEnabled").to("bean:countFilterUpper2?method=process").to("direct:filterSetUpper2");
				from("direct:enabledLowerLimit2").to("bean:lowerLimit2?method=processEnabled").to("bean:countFilterLower2?method=process").to("direct:filterSetLower2");


				/** Routes to change the limits. */				
				from("direct:startUpperLimit1").to("bean:upperLimit1?method=processLimit").to("bean:countFilterUpper1?method=process").to("direct:filterSetUpper1");
				from("direct:startLowerLimit1").to("bean:lowerLimit1?method=processLimit").to("bean:countFilterLower1?method=process").to("direct:filterSetLower1");
				from("direct:startUpperLimit2").to("bean:upperLimit2?method=processLimit").to("bean:countFilterUpper2?method=process").to("direct:filterSetUpper2");
				from("direct:startLowerLimit2").to("bean:lowerLimit2?method=processLimit").to("bean:countFilterLower2?method=process").to("direct:filterSetLower2");

				
				/** Routes to send a parameter to be checked. */
				from("direct:startParameter1").multicast().to("direct:startParameterLowerLimit1", "direct:startParameterUpperLimit1");
				from("direct:startParameter2").multicast().to("direct:startParameterLowerLimit2", "direct:startParameterUpperLimit2");
				
				from("direct:startParameterUpperLimit1").to("bean:upperLimit1?method=processParameter").to("bean:countFilterUpper1?method=process").to("direct:filterSetUpper1");
				from("direct:startParameterLowerLimit1").to("bean:lowerLimit1?method=processParameter").to("bean:countFilterLower1?method=process").to("direct:filterSetLower1");
				from("direct:startParameterUpperLimit2").to("bean:upperLimit2?method=processParameter").to("bean:countFilterUpper2?method=process").to("direct:filterSetUpper2");
				from("direct:startParameterLowerLimit2").to("bean:lowerLimit2?method=processParameter").to("bean:countFilterLower2?method=process").to("direct:filterSetLower2");
				
				
				/** Filters. */
				from("direct:filterSetUpper1").to("bean:changeFilterUpper1").to("mock:result");
				from("direct:filterSetLower1").to("bean:changeFilterLower1").to("mock:result");
				from("direct:filterSetUpper2").to("bean:changeFilterUpper2").to("mock:result");
				from("direct:filterSetLower2").to("bean:changeFilterLower2").to("mock:result");
			}
		};
	}
}
