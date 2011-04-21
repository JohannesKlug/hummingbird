/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.business.parameterstorage.simple;

import java.util.HashMap;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.apache.camel.Body;
import org.apache.camel.Header;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * Creates all tables necessary to store the received parameter in a database.
 */
public class Archiver {
	protected TreeSet<String> tableExists = new TreeSet<String>();
	protected HashMap<String,String> sqlPreparedStatements = new HashMap<String,String>();
	protected String[] sqlTableCount = {"SELECT count(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '", "' OR TABLE_NAME = '", "';"};
	
	protected JdbcTemplate template = null;

	public Archiver(DataSource database) {
		template = new JdbcTemplate(database);
	}

	/*
	 * Creates the SQL Statement(s).
	 * 
	 * IN-param: 
	 *   name          -> (Is automatically extracted from header)
	 * 		              Name of the parameter, e.g. 'Elevation'. 
	 *   timestamp     -> (Is automatically extracted from header) 
	 *                    Timestamp set by thn the satellite, e.g. '1302558974895'.
	 *   parameterBody -> (Is automatically extracted from Body) 
	 *    	              Value of the parameter, e.g. an XML string. 
	 */
	public void store(@Header("name") String name,
			//@Header("value") String value,
			//@XPath("*/value/@class") String type,
			@Header("timestamp") Long timestamp,
			@Body String body) {

		name = name.toLowerCase();
		name = name.replace(" ", "_");

		if (!tableExists.contains(name)) {
			//If tableExists doesn't contain the name of the table, the table might not exists...
			//but check the database to make sure.
			//Anyways, the statement to insert data into this table will be created.
			sqlPreparedStatements.put(name,
					"INSERT INTO " + name + " (timestamp, local_timestamp, body) values (?, ?, ?);");
					//"INSERT INTO " + name + " (timestamp, value, local_timestamp, body) values (?, ?, ?, ?);");

			int numberOfTables = template.queryForInt(sqlTableCount[0] + name.toUpperCase() + sqlTableCount[1] + name.toLowerCase() + sqlTableCount[2]);
								
			if (numberOfTables == 0) {
				//Table really doesn't exists in the database. Create it.
			
				String createTableStatement = "CREATE TABLE " + name
						+ " (timestamp BIGINT, "
						//+ "value VARCHAR(40), "
						+ "local_timestamp BIGINT, body varchar(1500), "
						+ "PRIMARY KEY (timestamp));\n";
				template.execute(createTableStatement);
			}

			tableExists.add(name);
		}

		// Insert data into database
		template.update(sqlPreparedStatements.get(name), new Object[] { timestamp,
				//value, 
				System.currentTimeMillis(), body });
	}
}
