package org.hbird.application.parameterarchive.mongodb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mongodb.MongoDbConstants;

import com.mongodb.DBObject;

public class CamelEndpointMongoServiceStrategy implements MongoServiceStrategy {

	@EndpointInject(ref = "parameterArchiveQueriesEndpoint")
	ProducerTemplate mongoInputEndpoint;

	@Override
	public List<DBObject> query(Object dbQuery) {
		List<DBObject> result = null;
		if (dbQuery instanceof DBObject) {
			result = (List<DBObject>) mongoInputEndpoint.requestBody(dbQuery);
		}
		return result;
	}

	@Override
	public List<DBObject> query(Object query, DBObject sort, int limit) {
		List<DBObject> result = null;
		if (query instanceof DBObject) {
			final Map<String, Object> headers = new HashMap<String, Object>(2);
			headers.put(MongoDbConstants.SORT_BY, sort);
			headers.put(MongoDbConstants.LIMIT, limit);
			result = (List<DBObject>) mongoInputEndpoint.requestBodyAndHeaders(query, headers);
		}
		return result;
	}

	@Override
	public List<DBObject> query(final DBObject query, DBObject mongoFieldFilter, DBObject sort, int limit) {
		final Map<String, Object> headers = new HashMap<String, Object>(3);
		headers.put(MongoDbConstants.SORT_BY, sort.toString());
		headers.put(MongoDbConstants.FIELDS_FILTER, mongoFieldFilter.toString());
		headers.put(MongoDbConstants.LIMIT, limit);

		return mongoInputEndpoint.requestBodyAndHeaders(mongoInputEndpoint.getDefaultEndpoint(), query, headers, List.class);
	}

	@Override
	public List<DBObject> query(String dbQuery) {
		List<DBObject> result = null;
		// camel-mongodb type converters should convert the json query string to a DBObject
		result = (List<DBObject>) mongoInputEndpoint.requestBody(dbQuery);
		return result;
	}

	@Override
	public MongoResult query(final Object dbQuery, int limit, int skip) {
		MongoResult result = new MongoResult();
		final Map<String, Object> headers = new HashMap<String, Object>(2);
		headers.put(MongoDbConstants.NUM_TO_SKIP, skip);
		headers.put(MongoDbConstants.LIMIT, limit);

		// We have to use a processor in order to get access to the return message headers, via the exchange.
		// We need to do this in order to get the metadata about the cursor, that is, how many results there are
		// not including the pagination. This is typically different to the number of results we asked the
		// Database to return, since with pagination we don't return everything. Doing it this way prevents
		// us having to make two requests with one dedicated to counting the results.
		Exchange ex = mongoInputEndpoint.request(mongoInputEndpoint.getDefaultEndpoint(), new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				exchange.getIn().setBody(dbQuery);
				exchange.getIn().setHeaders(headers);
			}
		});

		result.results = ex.getOut().getBody(List.class);
		result.totalResults = (Integer) ex.getOut().getHeader(MongoDbConstants.RESULT_TOTAL_SIZE);
		return result;
	}

	@Override
	public long queryNumRecords() {
		Map<String, Object> headers = new HashMap<String, Object>(2);
		headers.put(MongoDbConstants.OPERATION_HEADER, "count");
		// camel-mongodb type converters should convert the json query string to a DBObject
		Object result = mongoInputEndpoint.requestBodyAndHeaders(null, headers);
		return (Long) result;
	}
}
