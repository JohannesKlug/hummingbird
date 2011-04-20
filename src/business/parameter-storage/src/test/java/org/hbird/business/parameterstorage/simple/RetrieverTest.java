/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage.simple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/*
 * Tests Hummingbird's 'FetchStoredParameters' Bean
 */
@ContextConfiguration(locations = { "/simple/RetrieverTest-context.xml" })
public class RetrieverTest extends AbstractJUnit4SpringContextTests {
	@Produce(uri = "direct:Parameter")
	protected ProducerTemplate producer = null;

	@EndpointInject(uri = "mock:Result")
	protected MockEndpoint result = null;

	@Autowired
	protected CamelContext context = null;

	@Autowired
	protected DataSource database = null;

	/*
	 * Create the database and fill it with 4 datasets. Each Dataset has a
	 * different timestamp.
	 */
	@Before
	public void initialize() {
		try {
			Statement statement = database.getConnection().createStatement();
			statement.execute("DROP TABLE IF EXISTS test_parameter;");
			statement
					.execute("CREATE TABLE test_parameter (timestamp BIGINT, value DOUBLE, "
							+ "local_timestamp BIGINT, Body varchar(500), PRIMARY KEY (timestamp));");
			statement
					.execute("INSERT INTO test_parameter (timestamp, value, local_timestamp, body) "
							+ "values ('1300000001000', '11111', '1301910090000', '<long>"
							+ "11111</long>');");
			statement
					.execute("INSERT INTO test_parameter (timestamp, value, local_timestamp, body) "
							+ "values ('1300000003000', '22222', '1301910090001', '<long>"
							+ "22222</long>');");

			statement
					.execute("INSERT INTO test_parameter (timestamp, value, local_timestamp, body) "
							+ "values ('1300000000500', '00000', '1301910090002', '<long>"
							+ "00000</long>');");
			statement
					.execute("INSERT INTO test_parameter (timestamp, value, local_timestamp, body) "
							+ "values ('1300000004000', '44444', '1301910090003', '<long>"
							+ "44444</long>');");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Drop the database
	 */
	@After
	public void dropDatabase() throws Exception {
		Statement statement = database.getConnection().createStatement();
		statement.execute("DROP TABLE test_parameter");
	}

	/*
	 * Method to test FetchStoredParameter-Bean in an Camel route. Creates a
	 * query to retrieve 2 of the 4 datasets stored in the test-database. Tests
	 * if the correct datasets, with the correct headers and correct body are
	 * retrieved.
	 */
	@Test
	public void testRoutes() {
		// Prepare statements
		String sqlQuery = "test_parameter;1300000000500;1300000003500";

		// Prepare exchange (set Body and Headers) and send it.
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody(sqlQuery);

		producer.send("direct:Parameter", exchange);

		try {
			// Wait until there are 2 messages in 'result', but max 4ms + 8 + 16ms + 32ms + 64ms + 128ms = 252ms
			for(int i = 4; result.getReceivedCounter() != 2 && i <= 128; i *= 2) {
				Thread.sleep( i );
			}
		} catch (InterruptedException e) {
		}

		// Execute tests
		assertTrue(result.getReceivedCounter() == 2);

		Message firstMessage = result.getExchanges().get(0).getIn();
		Message secondMessage = result.getExchanges().get(1).getIn();

		assertEquals("<long>11111</long>", firstMessage.getBody(String.class));
		assertEquals("<long>22222</long>", secondMessage.getBody(String.class));
	}
}
