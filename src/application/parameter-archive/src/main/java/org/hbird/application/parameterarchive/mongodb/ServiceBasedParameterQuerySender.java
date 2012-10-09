package org.hbird.application.parameterarchive.mongodb;

import org.apache.camel.Produce;
import org.hbird.application.parameterarchive.interfaces.ParameterQuerySender;

public class ServiceBasedParameterQuerySender implements ParameterQuerySender {

	@Produce(ref = "parameterArchiveQueriesEndpoint")
	ParameterQuerySender sender;

	@Override
	public String query(String query) {
		System.out.println("Received parameter archive query request: " + query);
		String result = null;
		// camel-mongodb type converters should convert the json query string to a DBObject
		result = sender.query(query);
		System.out.println("Result = " + result);
		return result;
	}

}
