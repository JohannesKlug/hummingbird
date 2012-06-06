package org.hbird.application.parameterarchive.interfaces;

import java.util.Date;
import java.util.List;

import org.hbird.core.commons.tmtc.Parameter;

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

	List<Parameter<?>> findByReceivedTimeBetween(long startDate, long endDate, int page, int numOfResults);
}
