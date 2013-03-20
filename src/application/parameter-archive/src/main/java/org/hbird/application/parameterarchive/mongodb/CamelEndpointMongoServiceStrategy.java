package org.hbird.application.parameterarchive.mongodb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mongodb.MongoDbConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DBObject;

public class CamelEndpointMongoServiceStrategy implements MongoServiceStrategy {
	private static final Logger LOG = LoggerFactory.getLogger(CamelEndpointMongoServiceStrategy.class);

	@EndpointInject(ref = "parameterArchiveQueriesEndpoint")
	ProducerTemplate mongoInputProducer;

	@Override
	public List<DBObject> query(Object dbQuery) {
		List<DBObject> result = null;
		if (dbQuery instanceof DBObject) {
			result = (List<DBObject>) mongoInputProducer.requestBody(dbQuery);
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
			result = (List<DBObject>) mongoInputProducer.requestBodyAndHeaders(query, headers);
		}
		return result;
	}

	@Override
	public List<DBObject> query(final DBObject query, DBObject mongoFieldFilter, DBObject sort, int limit) {
		final Map<String, Object> headers = new HashMap<String, Object>(3);
		headers.put(MongoDbConstants.SORT_BY, sort.toString());
		headers.put(MongoDbConstants.FIELDS_FILTER, mongoFieldFilter.toString());
		headers.put(MongoDbConstants.LIMIT, limit);

		return mongoInputProducer.requestBodyAndHeaders(mongoInputProducer.getDefaultEndpoint(), query, headers, List.class);
	}

	@Override
	public List<DBObject> query(String dbQuery) {
		List<DBObject> result = null;
		// camel-mongodb type converters should convert the json query string to a DBObject
		result = (List<DBObject>) mongoInputProducer.requestBody(dbQuery);
		return result;
	}

	@Override
	public MongoResult query(final Object dbQuery, int limit, int skip) {
		MongoResult result = new MongoResult();
		final Map<String, Object> headers = new HashMap<String, Object>(2);
		headers.put(MongoDbConstants.NUM_TO_SKIP, skip);
		headers.put(MongoDbConstants.LIMIT, limit);

		// We have to use a custom processor in order to get access to the return message headers, via the exchange.
		// We need to do this in order to get the meta-data about the cursor, that is, how many results there are
		// not including the pagination. This is typically different to the number of results we asked the
		// Database to return, since with pagination we don't return everything. Doing it this way prevents
		// us having to make two requests with one dedicated to counting the results.
		Exchange ex = mongoInputProducer.request(mongoInputProducer.getDefaultEndpoint(), new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				if (LOG.isTraceEnabled()) {
					LOG.trace("DBQuery: " + dbQuery);
				}
				exchange.getIn().setBody(dbQuery);
				exchange.getIn().setHeaders(headers);
			}
		});

		if (ex.getException() != null) {
			LOG.warn("producer ex: " + ex.getException().toString() + " :: " + ex.getException().getStackTrace());
		}
		Message outMsg = ex.getOut();
		result.results = outMsg.getBody(List.class);
		if (result.results != null) {
			result.totalResults = (Integer) outMsg.getHeader(MongoDbConstants.RESULT_TOTAL_SIZE);
		}
		else {
			LOG.warn("Results returned from Mongo via the camel route: " + mongoInputProducer.getDefaultEndpoint().getEndpointUri() + " are null");
			result.totalResults = 0;
		}
		if (LOG.isTraceEnabled()) {
			LOG.trace("Total results: " + result.totalResults);
		}

		return result;
	}

	@Override
	public long queryNumRecords() {
		Map<String, Object> headers = new HashMap<String, Object>(2);
		headers.put(MongoDbConstants.OPERATION_HEADER, "count");
		// camel-mongodb type converters should convert the json query string to a DBObject
		Object result = mongoInputProducer.requestBodyAndHeaders(null, headers);
		return (Long) result;
	}
}
