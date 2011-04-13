/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage.archiver;

import java.util.TreeSet;

import org.apache.camel.Body;
import org.apache.camel.Header;

/*
 * Creates a SQL statements to write the data from the received exchange to a database.
 * If the type of parameter has not been received before, it will additionally create another
 * stement to create the database for this parameter.
 */
public class CreateSqlStatement {
	TreeSet<String> tableExists = new TreeSet<String>();

	/*
	 * Creates the SQL Statement(s).
	 * 
	 * IN-param:  
	 * 		String 		parameterName	(Is automatically extracted from header)
	 * 			Name of the parameter, e.g. 'Elevation'.
	 * 		String 		parameterValue	(Is automatically extracted from header)
	 *  		Value of the parameter, e.g. '3234234'.
	 *		String 		parameterTimestamp	(Is automatically extracted from header)
	 *			Timestamp on the satellite, e.g. '1302558974895'.
	 * 		String 		parameterValueType	(Is automatically extracted from header)
	 * 			Datatype of the parameter, e.g. 'Java.lang.long'. 
	 * 		String 		parameterBody	(Is automatically extracted from Body)
	 * 			Value of the parameter, e.g. '3234234'.
	 * OUT-param: 
	 * 		String 		
	 * 			Either one sql statement (insert into...) 
	 * 			or two (create table...; insert into...).
	 */
	public String toSql(@Header("name") String parameterName,
			@Header("value") String parameterValue,
			@Header("timestamp") String parameterTimestamp,
			@Header("clazz") String parameterValueType,
			@Body String parameterBody) {
	
		parameterName = parameterName.replace(" ", "_");
		StringBuilder sb = new StringBuilder();

		if (!tableExists.contains(parameterName)) {
			// Statement to create table
			sb.append("CREATE TABLE IF NOT EXISTS ").append(parameterName);
			sb.append(" (timestamp BIGINT, ");
//	TODO parameterValueType is not used
//			if (parameterValueType.equals("class java.lang.Long"))
//				sb.append("value BIGINT, ");
//			else if (parameterValueType.equals("class java.lang.Double"))
//				sb.append("value DOUBLE, ");
//			else if (parameterValueType.equals("class java.lang.Boolean"))
//				sb.append("value BIT, ");
//			else if (parameterValueType.equals("class java.lang.Integer"))
//				sb.append("value INT, ");
//			else
			sb.append("value VARCHAR(40), ");

			sb.append("local_timestamp BIGINT, Body varchar(1500), PRIMARY KEY (timestamp));\n");
			tableExists.add(parameterName);
		}

		// Create statement to insert data into database
		sb.append("INSERT INTO ").append(parameterName).append(" ");
		sb.append("(timestamp, value, local_timestamp, body) values (");
		sb.append("'").append(parameterTimestamp).append("', ");
		sb.append("'").append(parameterValue).append("', ");
		sb.append("'").append(System.currentTimeMillis()).append("', ");
		sb.append("'").append(parameterBody).append("');");

		return sb.toString();
	}
}
