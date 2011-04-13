/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage.archiver;

import static org.junit.Assert.assertTrue;

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
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/*
 * Tests Hummingbird's 'CreateSqlStatement' Bean
 */
@ContextConfiguration(locations = { "/CreateSqlStatementsTest-context.xml" })
public class CreateSqlStatementTest extends AbstractJUnit4SpringContextTests {

	@Produce(uri = "direct:Parameter")
	protected ProducerTemplate producer = null;

	@EndpointInject(uri = "mock:Result")
	protected MockEndpoint result = null;

	@Autowired
	protected CamelContext createSqlStatementContext = null;

	protected CreateSqlStatement createSqlStatement = new CreateSqlStatement();

	protected String parameterName = "Elevation";
	protected String parameterValue = "987654.3210987654";
	protected String parameterTimestamp = "1301234567890";
	protected String parameterValueType = "class java.lang.Double";
	protected String parameterBody = "<double>987654.3210987654</double>";
	protected String correctStatementFirstPart = "CREATE TABLE IF NOT EXISTS Elevation (timestamp BIGINT, value VARCHAR(40), local_timestamp BIGINT, Body varchar(1500), PRIMARY KEY (timestamp));\n"
			+ "INSERT INTO Elevation (timestamp, value, local_timestamp, body) values ('1301234567890', '987654.3210987654', '1";
	protected String correctStatementSecondPart = "', '<double>987654.3210987654</double>');";

	/*
	 * Tests the 'toSql' Method.
	 */
	@Test
	public void testToSql() {
		String createdStatement = createSqlStatement.toSql(parameterName,
				parameterValue, parameterTimestamp, parameterValueType,
				parameterBody);

		assertTrue(createdStatement.startsWith(correctStatementFirstPart));
		assertTrue(createdStatement.endsWith(correctStatementSecondPart));
	}

	/*
	 * Tests the 'ConvertBodyToSql' inside a camel route.
	 */
	@Test
	public void testRoutes() {
		// Prepare exchange. All necessary headers and the body are set.
		Exchange exchange = new DefaultExchange(createSqlStatementContext);
		exchange.getIn().setHeader("Name", parameterName);
		exchange.getIn().setHeader("Value", parameterValue);
		exchange.getIn().setHeader("Timestamp", parameterTimestamp);
		exchange.getIn().setHeader("Value Type", parameterValueType);
		exchange.getIn().setBody(parameterBody);

		// Send exchange and wait 0.1sec
		producer.send(exchange);

		try {
			// Wait until there is 1 message in 'result', but max 4ms + 8 + 16ms + 32ms + 64ms + 128ms = 252ms
			for(int i = 4; result.getReceivedCounter() != 1 && i <= 128; i *= 2) {
				Thread.sleep( i );
			}
		} catch (InterruptedException e) {
		}

		// Execute tests
		assertTrue(result.getReceivedCounter() == 1);

		String createdStatement = result.getExchanges().get(0).getIn()
				.getBody(String.class);
		assertTrue(createdStatement.startsWith(correctStatementFirstPart));
		assertTrue(createdStatement.endsWith(correctStatementSecondPart));
	}
}
