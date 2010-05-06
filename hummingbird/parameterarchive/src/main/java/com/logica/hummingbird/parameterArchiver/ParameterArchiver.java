package com.logica.hummingbird.parameterArchiver;

import java.util.Map.Entry;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import com.logica.hummingbird.framebroker.IContainerFactory;
import com.logica.hummingbird.framebroker.parameters.Parameter;
import com.logica.hummingbird.framebroker.parameters.ParameterType;



import java.io.File;


public class ParameterArchiver implements Processor {


	public ParameterArchiver(IContainerFactory containerFactory) {
		
		for (Parameter parameter :containerFactory.getAllParameters().values()) {
			if (parameter.getType().getType() == ParameterType.eParameterType.FLOAT) {
				System.out.println(parameter.getName() + " says it's a Float. Will check." );
				if (parameter.getValue() instanceof Float) {
					System.out.println(parameter.getName() + " is really a Float." );
				} else {
					System.out.println(parameter.getName() + " is NOT a Float." );
				}
			} else if (parameter.getType().getType() == ParameterType.eParameterType.INTEGER) {
				System.out.println(parameter.getName() + " says it's an Integer. Will check." );
				if (parameter.getValue() instanceof Integer) {
					System.out.println(parameter.getName() + " is really an Integer." );
				} else {
					System.out.println(parameter.getName() + " is NOT an Integer." );
				}
			}
			
			
		}
			
		
			

	}
	
	
	@Override
	public void process(Exchange exchange) {
		
		long storageTime = System.currentTimeMillis();
		
		for (Entry<String, Object> header : exchange.getIn().getHeaders().entrySet()) {
			
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
	

}
