package org.hbird.application.parameterarchive.mongodb;

import java.util.List;

import org.hbird.application.parameterarchive.interfaces.ParameterQuerySender;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

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

	public MongoServiceStrategy getMongoService() {
		return mongoService;
	}

	public void setMongoService(MongoServiceStrategy mongoService) {
		this.mongoService = mongoService;
	}

	@Override
	public Object query(Object dbQuery, int limit, int skip) {
		return mongoService.query(dbQuery, limit, skip);
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
}
