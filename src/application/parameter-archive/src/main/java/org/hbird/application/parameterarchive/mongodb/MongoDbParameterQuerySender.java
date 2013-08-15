package org.hbird.application.parameterarchive.mongodb;

import java.util.List;

import org.hbird.application.parameterarchive.interfaces.ParameterQuerySender;
import org.hbird.application.parameterarchive.model.QueryRequest;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

/**
 * 
 * @author Mark Doyle
 * 
 */
public class MongoDbParameterQuerySender implements ParameterQuerySender {

	MongoServiceStrategy mongoService;

	@Override
	public List<DBObject> query(String query) {
		return mongoService.query(query);
	}

	@Override
	public List<DBObject> query(Object dbQuery) {
		return mongoService.query(dbQuery);
	}

	@Override
	public Object query(Object query, Object sort, int limit) {
		if (sort instanceof DBObject) {
			DBObject mongoSort = (DBObject) sort;
			return mongoService.query(query, mongoSort, limit);
		}
		throw new RuntimeException("query or sort parameters were not Mongo DBObjects");
	}

	@Override
	public Object query(Object dbQuery, int limit, int skip, String sortCol, boolean ascending) {
		return mongoService.query(dbQuery, limit, skip, sortCol, ascending);
	}

	@Override
	public long queryNumRecords() {
		return mongoService.queryNumRecords();
	}

	@Override
	public Object queryMin(Object query, String field) {
		if (query instanceof DBObject) {
			DBObject mongoQuery = (DBObject) query;

			DBObject mongoSort = new BasicDBObject();
			mongoSort.put(field, 1);

			DBObject mongoFieldFilter = new BasicDBObject();
			mongoFieldFilter.put("_id", 0);
			mongoFieldFilter.put(field, 1);

			return mongoService.query(mongoQuery, mongoFieldFilter, mongoSort, 1);
		}
		throw new RuntimeException("query is not a Mongo DBObject");
	}

	// TODO Think about externalising the field names.
	@Override
	public Object query(long startTime, long endTime) {
		DBObject query = new BasicDBObject();
		query.put("receivedTime", BasicDBObjectBuilder.start("$gte", startTime).add("$lte", endTime).get());

		return mongoService.query(query);
	}

	@Override
	public Object query(QueryRequest request) {
		if (request.sortColumn == null) {
			DBObject query = buildQuery(request);
			return mongoService.query(query);
		}

		return query(request, request.sortColumn);
	}

	@Override
	public Object query(QueryRequest request, String sortColumn) {
		DBObject query = buildQuery(request);

		DBObject mongoSort = new BasicDBObject();
		mongoSort.put(sortColumn, 1);

		return mongoService.query(query, mongoSort);
	}

	private static DBObject buildQuery(QueryRequest request) {
		// DBObject query = new BasicDBObject();
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();

		// Set range query on builder
		BasicDBObject rangeFilter = createRangeQuery(request);
		if (rangeFilter != null) {
			builder.add("receivedTime", rangeFilter);
		}

		// Set parameter qualified name filter on builder. TODO support multiple parameters.
		if (request.parameterQualifiedName != null) {
			DBObject in = new BasicDBObject("$in", request.parameterQualifiedName);
			new BasicDBObject("qualifiedName", in);

			builder.add("qualifiedName", in);
		}

		return builder.get();
	}

	private static BasicDBObject createRangeQuery(QueryRequest request) {
		BasicDBObject rangeObject = null;
		if (request.startTime != -1) {
			rangeObject = new BasicDBObject("$gte", request.startTime);
			if (request.endTime != -1) {
				rangeObject.append("$lte", request.endTime);
			}
		}
		else {
			if (request.endTime != -1) {
				rangeObject = new BasicDBObject("$lte", request.endTime);
			}
		}
		return rangeObject;
	}

	/**
	 * 
	 * @return
	 */
	public MongoServiceStrategy getMongoService() {
		return mongoService;
	}

	/**
	 * 
	 * @param mongoService
	 */
	public void setMongoService(MongoServiceStrategy mongoService) {
		this.mongoService = mongoService;
	}
}
