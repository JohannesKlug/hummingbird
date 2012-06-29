package org.hbird.application.parameterarchive.interfaces;

import java.util.Date;
import java.util.List;

import org.hbird.core.commons.tmtc.Parameter;
import org.springframework.data.domain.Page;

public interface ParameterRetriever {

	// org.springframework.data.mongodb.core.MongoTemplate cannot work with Generic types due to type erasure
	@SuppressWarnings("rawtypes")
	List<Parameter> findParameters(String qualifiedName);

	// org.springframework.data.mongodb.core.MongoTemplate cannot work with Generic types due to type erasure
	@SuppressWarnings("rawtypes")
	List<Parameter> findParameters(Date startDate, Date endDate);

	// org.springframework.data.mongodb.core.MongoTemplate cannot work with Generic types due to type erasure
	@SuppressWarnings("rawtypes")
	List<Parameter> findParameters(String qualifiedName, Date startDate, Date endDate);

	/**
	 * Returns a list of parameters filtered by received time. The number of results is divided into
	 * {@link Page}s given the number of results requested. The method returns the list of parameters contained
	 * in the requested page.
	 *
	 * @param startDate 	start received time of parameter filter
	 * @param endDate		end received time of parameter filter
	 * @param page			The page of parameters to return based upon the number of results
	 * @param numOfResults	the number of parameters to divide the results into, that is, the number per page.
	 */
	List<Parameter<?>> findByReceivedTimeBetween(long startDate, long endDate, int page, int numOfResults);
}
