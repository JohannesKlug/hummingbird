package org.hbird.application.parameterarchive.mongodb;

import java.util.List;

import com.mongodb.DBObject;

public interface MongoServiceStrategy {

	/**
	 * Query is an Object your database implementation can work with.
	 * 
	 * @param dbQuery
	 * @return
	 */
	List<DBObject> query(Object dbQuery);

	List<DBObject> query(String dbQuery);
}
