package org.hbird.parameterarchive.interfaces;

import java.util.Date;
import java.util.List;

import org.hbird.core.commons.tmtc.Parameter;

public interface ParameterRetriever {

	List<Parameter> findParamerers(String QualifiedName);

	List<Parameter> findParameters(Date startDate, Date endDate);
}
