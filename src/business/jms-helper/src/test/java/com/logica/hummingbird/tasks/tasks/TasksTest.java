package org.hbird.tasks.tasks;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import org.hbird.buffers.ObjectBuffer;
import org.hbird.formatter.ExchangeFormatter;
import org.hbird.formatter.HeaderFields;
import org.hbird.tasks.actions.SetParameter;
import org.hbird.tasks.actions.SetStateParameter;
import org.hbird.tasks.checks.ConfigurableValue;
import org.hbird.tasks.checks.DynamicHeaderBasedValue;
import org.hbird.tasks.checks.DynamicParameterBasedValue;
import org.hbird.tasks.checks.Range;
import org.hbird.tasks.checks.StaticValue;

@ContextConfiguration (locations={"/TasksTest-context.xml"})
public class TasksTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Parameters")
    protected ProducerTemplate template;

	@EndpointInject(uri = "mock:result")
	protected MockEndpoint mockResult;

	@Autowired
    protected CamelContext context;
	
	@Autowired
	protected SetParameter setParameterTask = null;

	@Autowired
	protected SetStateParameter setStateParameterTask = null;
	
	@Autowired
	protected ObjectBuffer parameterBuffer = null;	
	
	@DirtiesContext
	@Test
	public void testSetParameter() {
		mockResult.reset();
		
		setParameterTask.execute(context, template, parameterBuffer);
		
		assertTrue(mockResult.getExchanges().size() == 1);
		assertTrue(mockResult.getExchanges().get(0).getIn().getHeader(HeaderFields.NAME).equals("TestParameter") == true);
		assertTrue(((Number) mockResult.getExchanges().get(0).getIn().getHeader(HeaderFields.VALUE)).doubleValue() == 1d);
	}
	
	@DirtiesContext
	@Test
	public void testSetStateParameter() {
		mockResult.reset();
		
		setStateParameterTask.execute(context, template, parameterBuffer);
		
		assertTrue(mockResult.getExchanges().size() == 1);
		assertTrue(mockResult.getExchanges().get(0).getIn().getHeader(HeaderFields.NAME).equals("TestStateParameter") == true);
		assertTrue(((Boolean) mockResult.getExchanges().get(0).getIn().getHeader(HeaderFields.VALUE)) == false);
		assertTrue(((String) mockResult.getExchanges().get(0).getIn().getHeader(HeaderFields.ISSTATEOF)).equals("TestParameter") == true);
	}
	
	/**
	 * A complex method, but it also checks all 125 combinations of the range.
	 */
	@DirtiesContext
	@Test
	public void testRanges() {
		ConfigurableValue staticValue1 = new StaticValue(10d);
		ConfigurableValue dynamicParameter1 = new DynamicParameterBasedValue("TestParameter1");
		ConfigurableValue dynamicParameter1Missing = new DynamicParameterBasedValue("TestParameter1Missing");
		ConfigurableValue dynamicHeaderParameter1 = new DynamicHeaderBasedValue("Value");

		ConfigurableValue[] lowers = new ConfigurableValue[]{staticValue1, dynamicParameter1, dynamicHeaderParameter1, dynamicParameter1Missing, null};
		
		ConfigurableValue staticValue2 = new StaticValue(5d);
		ConfigurableValue dynamicParameter2 = new DynamicParameterBasedValue("TestParameter2");
		ConfigurableValue dynamicParameter2Missing = new DynamicParameterBasedValue("TestParameter2Missing");
		ConfigurableValue dynamicHeaderParameter2 = new DynamicHeaderBasedValue("Value");

		ConfigurableValue[] uppers = new ConfigurableValue[]{staticValue2, dynamicParameter2, dynamicHeaderParameter2, dynamicParameter2Missing, null};

		ConfigurableValue staticValue3 = new StaticValue(7d);
		ConfigurableValue dynamicParameter3 = new DynamicParameterBasedValue("TestParameter3");
		ConfigurableValue dynamicParameter3Missing = new DynamicParameterBasedValue("TestParameter3Missing");
		ConfigurableValue dynamicHeaderParameter3 = new DynamicHeaderBasedValue("Value");

		ConfigurableValue[] parameters = new ConfigurableValue[]{staticValue3, dynamicParameter3, dynamicHeaderParameter3, dynamicParameter3Missing, null};

		Message message = ExchangeFormatter.createParameterMessage("aParameter", Double.class.toString(), 5d);

		Exchange exchange = new DefaultExchange(context);
		exchange.setIn(ExchangeFormatter.createParameterMessage("TestParameter1", Double.class.toString(), 5d));
		parameterBuffer.addEntry(exchange);
		exchange.setIn(ExchangeFormatter.createParameterMessage("TestParameter2", Double.class.toString(), 5d));
		parameterBuffer.addEntry(exchange);
		exchange.setIn(ExchangeFormatter.createParameterMessage("TestParameter3", Double.class.toString(), 5d));
		parameterBuffer.addEntry(exchange);
		
		for (ConfigurableValue lower : lowers) {
			for (ConfigurableValue upper : uppers) {
				for (ConfigurableValue parameter : parameters) {
					System.out.println("Checking: lower " + lower + " : " + parameter + " : " + upper);
					mockResult.reset();
				
					Range range = new Range(0, "TestState", "TestParameter", lower, upper);
					range.setParameter(parameter);
					range.configure(message);
					
					try {
					range.execute(context, template, parameterBuffer);
					}
					catch(NullPointerException e) {
						System.out.println("Null pointer exception. May sound surprising, but is expected...");
					}
 
					if (parameter == null || parameter == dynamicParameter3Missing) {
						assertTrue(mockResult.getExchanges().size() == 0);
					}
					else {
						assertTrue(mockResult.getExchanges().size() == 1);
					}
				}
			}
		}
	}
}
