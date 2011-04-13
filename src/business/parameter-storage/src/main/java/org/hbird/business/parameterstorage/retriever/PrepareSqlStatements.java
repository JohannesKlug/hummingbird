/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage.retriever;

import org.apache.camel.Exchange;

/*
 * Creates SQL statements necessary to restore parameters from the database and sents the 
 * headers in the exchange needed by 'FetchStoredParameters'. 
 * 
 * TODO At the moment, it only accepts a string in the messagebody. I'm sure there are nicer 
 * options, e.g. a java object.
 */
public class PrepareSqlStatements {

	/*
	 * Creates the statements and sets header fields.
	 * IN-param:
	 * 		Exchange		exchange
	 * 		The exchange only needs to have a String in the body. There are two possibilities 
	 * 		how the String could look like: with the 
	 * 		1. 'start_timestamp;end_timestamp;parameter_name' (will restore the 
	 *		named parameters which have a timestamp between 'start_timestamp' and 'end_timestamp'
	 * 		2. 'parameter_name' (will restore all parameters with the given name)
	 */
	public void createQuery(Exchange exchange) {
		long startTimeStamp = 0;
		long endTimeStamp = 0;
		String parameterName = "";
		String[] command;
		String[] statement = new String[2];

		//Splits the body into 2 or 4 singel Strings
		command = exchange.getIn().getBody(String.class).split(";");

		switch (command.length) {
		case 1:
			startTimeStamp = 0;
			endTimeStamp = System.currentTimeMillis();
			parameterName = command[0];
			break;
		case 3:
			startTimeStamp = Long.parseLong(command[0]);
			endTimeStamp = Long.parseLong(command[1]);
			parameterName = command[2];
			break;
		default:
			try {
				throw new Exception(
						"Input string to create sql query is faulty! Needs to be either\n"
								+ "'parametername;queuename' (String;String) or \n"
								+ "'starttime;endtime;parametername;queuename' (long;long;String;String)");
			} catch (Exception e) {
				e.printStackTrace();
			}
			;
		}

		//Create statements and put it into the exchange's body. The parameterName and destinationName
		//will be put into the exchange's header. 
		statement[0] = "select * from " + parameterName + " where TIMESTAMP > "
				+ startTimeStamp + " and TIMESTAMP <= " + (endTimeStamp - 1000)
				+ ";";
		statement[1] = "select * from " + parameterName + " where TIMESTAMP > "
				+ (endTimeStamp - 1000) + " and TIMESTAMP <= " + endTimeStamp
				+ ";";

		exchange.getIn().setBody(statement);
	}
}
