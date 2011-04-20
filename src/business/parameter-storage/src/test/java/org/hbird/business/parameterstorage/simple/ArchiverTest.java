/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage.simple;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/*
 * Tests Hummingbird's 'CreateSqlStatement' Bean
 */
@ContextConfiguration(locations = { "/simple/ArchiverTest-context.xml" })
public class ArchiverTest extends AbstractJUnit4SpringContextTests {

	@Produce(uri = "direct:Parameter")
	protected ProducerTemplate producer = null;

	@Autowired
	protected CamelContext context = null;

	@Autowired
	protected DataSource database = null;

	JdbcTemplate template = null;

	protected String parameterName = "ELEVATION";
	protected String parameterValue = "987654.3210987654";
	protected String parameterTimestamp = "1301234567891";
	protected String parameterValueType = "class java.lang.Double";
	protected String parameterBody = "<double>987654.3210987654</double>";
	protected String correctStatementFirstPart = "INSERT INTO ELEVATION (timestamp, value, local_timestamp, body) values ('1301234567890', '987654.3210987654', '1";
	protected String correctStatementSecondPart = "', '<double>987654.3210987654</double>');";

	String queryForTableCount = "SELECT count(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '"
			+ parameterName.toUpperCase()
			+ "' OR TABLE_NAME = '"
			+ parameterName.toLowerCase() + "';";

	@Before
	public void initialize() {
		template = new JdbcTemplate(database);

		template.execute("DROP TABLE IF EXISTS " + parameterName.toUpperCase() + ";");
		template.execute("DROP TABLE IF EXISTS " + parameterName.toLowerCase() + ";");
	}

	/*
	 * Tests the 'DatabaseArchiver' inside a camel route.
	 */
	@Test
	public void testRoutes() {
		// Prepare exchange. All necessary headers and the body are set.
		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setHeader("Name", parameterName);
		exchange.getIn().setHeader("Value", parameterValue);
		exchange.getIn().setHeader("Timestamp", parameterTimestamp);
		exchange.getIn().setHeader("Value Type", parameterValueType);
		exchange.getIn().setBody(parameterBody);

		// Send exchange and wait 0.1sec
		producer.send(exchange);

		// Wait until there is 1 dataset in the database, but max 4ms + 8 + 16ms
		// + 32ms + 64ms + 128ms = 252ms
		for (int i = 4; template.queryForInt(queryForTableCount) != 1 && i <= 128; i *= 2) {
			try {Thread.sleep(i);}
			catch (Exception e) {}
		}

		// Execute tests
		int numberOfTables = template.queryForInt(queryForTableCount);
		assertEquals("Number of tables in Database is not correct!!!.", 1, numberOfTables);
		
		int numberOfDatasets = template.queryForInt("select count(*) from " + parameterName + ";");
		assertEquals("Number of rows in the table is incorrect.", 1, numberOfDatasets);
	}
}
