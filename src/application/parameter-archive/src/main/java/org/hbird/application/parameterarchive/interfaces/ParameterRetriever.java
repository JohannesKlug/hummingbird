package org.hbird.application.parameterarchive.interfaces;

import java.util.Date;
import java.util.List;

import org.hbird.core.commons.tmtc.Parameter;

public interface ParameterRetriever {

	// org.springframework.data.mongodb.core.MongoTemplate cannot work with Generic types due to type erasure
	@SuppressWarnings("rawtypes")
	List<Parameter> findParameters(String QualifiedName);

	// org.springframework.data.mongodb.core.MongoTemplate cannot work with Generic types due to type erasure
	@SuppressWarnings("rawtypes")
	List<Parameter> findParameters(Date startDate, Date endDate);
}
