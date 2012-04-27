package org.hbird.parameterarchive.mongodb;

import java.util.Date;
import java.util.List;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.parameterarchive.interfaces.ParameterRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class SimpleMongoParameterRetriever implements ParameterRetriever {

	@Autowired
	private MongoTemplate mongo;

	private String collection;

	@Override
	public List<Parameter> findParamerers(final String QualifiedName) {
		Query query = new Query(Criteria.where(""));
		List<Parameter> foundParameters = mongo.find(query, Parameter.class, collection);
		return foundParameters;
	}

	@Override
	public List<Parameter> findParameters(final Date startDate, final Date endDate) {
		Query query = new Query(Criteria.where(""));
		List<Parameter> foundParameters = mongo.find(query, Parameter.class, collection);
		return foundParameters;
	}

	public void setCollection(final String collection) {
		this.collection = collection;
	}
}

