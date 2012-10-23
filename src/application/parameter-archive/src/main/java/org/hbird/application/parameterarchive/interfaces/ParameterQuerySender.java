package org.hbird.application.parameterarchive.interfaces;

public interface ParameterQuerySender {

	/**
	 * Accepts a String representing a query in your database implementation. The concrete {@link ParameterQuerySender}
	 * implementation will deal with building it's actual query from this string.
	 * 
	 * @param dbQuery
	 * 
	 * @return results, probably a list. Depends upon your database.
	 */
	Object query(String dbQuery);

	/**
	 * Accepts an Object representing a query in your database implementation.
	 * 
	 * @param dbQuery
	 * @return results, probably a list. Depends upon your database.
	 */
	Object query(Object dbQuery);

	/**
	 * Accepts an Object representing a query in your database implementation and a sort in your database
	 * implementation. If your database does not separate querying and sorting use
	 * {@link ParameterQuerySender#query(Object)} method instead or simple pass null as sort.
	 * 
	 * @param query
	 * @param sort
	 * @param limit
	 * @return
	 */
	Object query(Object query, Object sort, int limit);

	/**
	 * Queries the archive for the minimum value of a particular field and returns that value.
	 * 
	 * @param mongoQuery
	 * @param mongoFieldsFilter
	 * @param mongoSort
	 * @param i
	 * @return
	 */
	Object queryMin(Object query, String field);

	/**
	 * FIXME Mongo parameters in interface. They are generic concepts though, I think.
	 * 
	 * @param dbQuery
	 * @param limit
	 * @param skip
	 * @return
	 */
	Object query(Object dbQuery, int limit, int skip);

	long queryNumRecords();

}
