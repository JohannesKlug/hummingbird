package org.hbird.application.parameterarchive.mongodb;

import java.util.List;

import org.hbird.application.parameterarchive.interfaces.ParameterQuerySender;

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
}
