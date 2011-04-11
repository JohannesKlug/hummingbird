/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage.retriever;

import static org.junit.Assert.assertTrue;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/*
 * Tests Hummingbird's 'PrepareSqlStatements' Bean
 */
@ContextConfiguration(locations = { "/PrepareSqlStatementsTest-context.xml" })
public class PrepareSqlStatementsTest extends AbstractJUnit4SpringContextTests {

	@Produce(uri = "direct:Parameter")
	protected ProducerTemplate producer = null;

	@EndpointInject(uri = "mock:Result")
	protected MockEndpoint result = null;

	@Autowired
	protected CamelContext createSqlQueryContext = null;

	Exchange exchange = null;
	PrepareSqlStatements prepareSqlStatements = null;
	String correctStatement1 = "";
	String correctStatement2 = "";

	/*
	 * Instantiate 'CreateSqlQuery' Set statements to compare to the results of
	 * 'CreateSqlQuery' Prepares the exchange with all information necessary to
	 * be processed by 'CreateSqlQuery'. Set the
	 */
	@Before
	public void initialize() throws Exception {
		prepareSqlStatements = new PrepareSqlStatements();

		correctStatement1 = "select * from Elevation where TIMESTAMP > 1301910000000 and TIMESTAMP <= 1301910009000;";
		correctStatement2 = "select * from Elevation where TIMESTAMP > 1301910009000 and TIMESTAMP <= 1301910010000;";

		exchange = new DefaultExchange(createSqlQueryContext);
		exchange.getIn().setBody(
				"1301910000000;1301910010000;Elevation;seda:TEST");
	}

	/*
	 * Tests the 'CreateSqlQuery' bean in a camel route.
	 */
	@Test
	public void testRoutes() {
		producer.send(exchange);

		try {
			// Wait until there is 1 message in 'result', but max 4ms + 8 + 16ms + 32ms + 64ms + 128ms = 252ms
			for(int i = 4; result.getReceivedCounter() != 1 && i <= 128; i *= 2) {
				Thread.sleep( i );
			}
		} catch (InterruptedException e) {
		}

		assertTrue(result.getReceivedCounter() == 1);

		String[] createdStatement = result.getExchanges().get(0).getIn()
				.getBody(String[].class);
		assertTrue(createdStatement.length == 2);
		assertTrue(createdStatement[0].equals(correctStatement1));
		assertTrue(createdStatement[1].equals(correctStatement2));
	}
	
	/*
	 * Tests the 'PrepareSqlStatements' Method.
	 */
	@Test
	public void testCreateQuery() {
		prepareSqlStatements.createQuery(exchange);

		String[] createdStatement = exchange.getIn().getBody(String[].class);

		assertTrue(createdStatement.length == 2);
		assertTrue(createdStatement[0].equals(correctStatement1));
		assertTrue(createdStatement[1].equals(correctStatement2));
	}
}
