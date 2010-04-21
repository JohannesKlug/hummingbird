package com.logica.hummingbird.parameterArchiver;

import java.util.Map.Entry;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import com.logica.hummingbird.framebroker.IContainerFactory;



import java.io.File;


public class ParameterArchiver implements Processor {


	public ParameterArchiver(IContainerFactory containerFactory) {
		
		
		
		

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
