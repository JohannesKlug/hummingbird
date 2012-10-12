package org.hbird.application.parameterarchive.mongodb;

import java.util.List;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;

import com.mongodb.DBObject;

public class CamelEndpointMongoServiceStrategy implements MongoServiceStrategy {

	@EndpointInject(ref = "parameterArchiveQueriesEndpoint")
	ProducerTemplate producer;

	@Override
	public List<DBObject> query(Object dbQuery) {
		System.out.println("Received parameter archive query request: " + dbQuery);
		List<DBObject> result = null;
		if (dbQuery instanceof DBObject) {
			result = (List<DBObject>) producer.requestBody(dbQuery);
		}
		return result;
	}

	@Override
	public List<DBObject> query(String dbQuery) {
		System.out.println("Received parameter archive query request: " + dbQuery);
		List<DBObject> result = null;
		// camel-mongodb type converters should convert the json query string to a DBObject
		result = (List<DBObject>) producer.requestBody(dbQuery);
		System.out.println("Result = " + result);
		return result;
	}

}
