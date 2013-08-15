package org.hbird.application.parameterarchive.mongodb;

import java.util.List;

import com.mongodb.DBObject;

/**
 * Implementations of this interface will be expected to deal with interfacing with the Mongo DB.
 * 
 * @author Mark Doyle
 * 
 */
public interface MongoServiceStrategy {

	long queryNumRecords();

	/**
	 * Query is an Object your database implementation can work with.
	 * 
	 * @param dbQuery
	 * @return
	 */
	List<DBObject> query(Object dbQuery);

	List<DBObject> query(String dbQuery);

	List<DBObject> query(Object query, DBObject sort, int limit);

	List<DBObject> query(DBObject mongoQuery, DBObject mongoFieldFilter, DBObject mongoSort, int i);

	MongoResult query(Object dbQuery, int limit, int skip, String sortCol, boolean asc);

	/**
	 * Query mongo and sort the results.
	 * 
	 * @param query
	 * @param sortColumn
	 * @return
	 */
	Object query(Object query, DBObject sort);
}
