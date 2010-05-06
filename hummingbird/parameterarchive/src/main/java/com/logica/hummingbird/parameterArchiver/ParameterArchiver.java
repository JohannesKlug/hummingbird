package com.logica.hummingbird.parameterArchiver;

import java.util.Map.Entry;

import javax.sql.DataSource;

import org.apache.camel.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.logica.hummingbird.framebroker.IContainerFactory;
import com.logica.hummingbird.framebroker.parameters.Parameter;
import com.logica.hummingbird.framebroker.parameters.ParameterType;

public class ParameterArchiver {
	
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



	public ParameterArchiver(IContainerFactory containerFactory) {
		
		for (Parameter parameter :containerFactory.getAllParameters().values()) {
			if (parameter.getType().getType() == ParameterType.eParameterType.FLOAT) {
				// create float table
			} else if (parameter.getType().getType() == ParameterType.eParameterType.INTEGER) {
				// create integer table
			}
			
			
		}
			
		
			

	}
	
	
	public void store(Message message) {
		
		long storageTime = System.currentTimeMillis();
		
		for (Entry<String, Object> header : message.getHeaders().entrySet()) {
			
			// Disregard the Type header field 
			if (header.getKey() == "Type" ) break;
			
			try {
//			    DatabaseEntry theKey = new DatabaseEntry(header.getKey().getBytes("UTF-8"));
//			    DatabaseEntry theData = new DatabaseEntry(header.getValue().getBytes("UTF-8"));
//			    myDatabase.put(null, theKey, theData);
			} catch (Exception e) {
			    // Exception handling goes here
			} 
		}
		
		
		
		
		
		
		
	
	}
	
	
	/**
	 * Stores the passed parameter, adding the filing time in a fourth column.
	 * 
	 * @param parameterName The parameter's name 
	 * @param time The parameter's on-board generation time
	 * @param value The parameter's value
	 */
	public void storeParameter(String parameterName, long time, Number value) {
		
	}

}
