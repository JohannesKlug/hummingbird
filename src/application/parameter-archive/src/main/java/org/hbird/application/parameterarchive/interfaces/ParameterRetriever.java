package org.hbird.application.parameterarchive.interfaces;

import java.util.Date;
import java.util.List;

import org.hbird.core.commons.tmtc.Parameter;

public interface ParameterRetriever {

	@SuppressWarnings("rawtypes") // org.springframework.data.mongodb.core.MongoTemplate cannot work with Generic types
	List<Parameter> findParamerers(String QualifiedName);

	@SuppressWarnings("rawtypes") // org.springframework.data.mongodb.core.MongoTemplate cannot work with Generic types
	List<Parameter> findParameters(Date startDate, Date endDate);
}
