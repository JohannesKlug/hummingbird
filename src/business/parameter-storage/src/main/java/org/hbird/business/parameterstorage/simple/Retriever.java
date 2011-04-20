/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage.simple;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.camel.Body;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * Fetches the stored parameters from the database and sends them to a 
 * specified destination.
 */
public class Retriever {
	protected JdbcTemplate template = null;
	
	private String destination;

	@Autowired
	protected ProducerTemplate producer = null;

	@Autowired
	protected CamelContext context = null;

	/*
	 * Constructor. Extracts the connection to the database from
	 * the DataSource.
	 * 
	 * IN-param:
	 *   dataSource  -> The database to retrieve the parameters from.
	 *   destination -> Name of the destination to send the retrieved 
	 *   				parameters to, e.g. 'activemq:queue:replay'.
	 */
	public Retriever(DataSource dataSource, String destination) {
		template = new JdbcTemplate(dataSource);

		this.destination = destination;
	}

	/*
	 * Method to fetch the parameters from the database and send them to a 
	 * specified destination.
	 * 
	 * IN-param:  
	 *	 sqlQuery -> (Is automatically extracted from body) 
	 * 				 There are two possible input strings:
	 * 				 1. 'parameter_name;start_timestamp;end_timestamp' (will restore the 
	 *				 named parameters which have a timestamp between 'start_timestamp' and 'end_timestamp'
	 * 				 2. 'parameter_name' (will restore all parameters with the given name)
	 */
	public void fetchParameters(@Body String retrieverCommand) {
		long startTimeStamp = 0;
		long endTimeStamp = 0;
		String parameterName = "";
		String[] command;
		
		//Splits the body into 3 single Strings if necessary. If
		//it only contains the name of the parameter, nothing happens
		command = retrieverCommand.split(";");

		switch (command.length) {
		case 1:
			startTimeStamp = 0;
			endTimeStamp = System.currentTimeMillis();
			parameterName = command[0];
			break;
		case 3:
			parameterName = command[0];
			startTimeStamp = Long.parseLong(command[1]);
			endTimeStamp = Long.parseLong(command[2]);
			
			break;
		default:
			try {throw new Exception(
				"Input string to create sql query is faulty! Needs to be either\n"
				+ "'parametername;queuename' (String;String) or \n"
				+ "'starttime;endtime;parametername;queuename' (long;long;String;String)");
			} catch (Exception e) {e.printStackTrace();}
			;
		}
		
		// Ceate and run statements. Call 'processResults' to send the retrieved datasets.
		String sqlSelect;
		List<Map<String, Object>> result;

		//First statement: timestamp between 'start' and 'end - 1000ms'
		sqlSelect = "select * from " + parameterName + " where TIMESTAMP > "
		+ startTimeStamp + " and TIMESTAMP <= " + (endTimeStamp - 1000)
		+ ";";
		
		result = template.queryForList(sqlSelect);
		processResults(result);

		//Second statement: timestamp between 'end - 1000ms' and 'end'
		sqlSelect = "select * from " + parameterName + " where TIMESTAMP > "
		+ (endTimeStamp - 1000) + " and TIMESTAMP <= " + endTimeStamp
		+ ";";
		
		result = template.queryForList(sqlSelect);
		processResults(result);
	}

	/*
	 * Runs through the results, and creates and sends a message
	 * for every row in the dataset. 
	 * IN-param
	 *   result -> The List that contains all the stored parameters that
	 * 			   are restored and shall be send to a queue/topic.
	 */ 
	private void processResults(List<Map<String,Object>> result) {
		Exchange exchange;
		
		Map<String,Object> element = null;
		
		//As long as datasets exist in the ResultSet, create a new exchange
		while (!result.isEmpty()) {
			element = result.remove(0);
			exchange = new DefaultExchange(context);
			exchange.getIn().setBody(element.get("body"));
			
			//Send the created exchange
			producer.send(destination, exchange);
		}
	}
}
