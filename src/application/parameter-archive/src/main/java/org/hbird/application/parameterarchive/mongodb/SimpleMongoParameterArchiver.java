package org.hbird.application.parameterarchive.mongodb;

import org.hbird.application.parameterarchive.interfaces.ParameterArchiver;
import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class SimpleMongoParameterArchiver implements ParameterArchiver {

	@Autowired
	private MongoTemplate mongo;

	private String collection;

	@Override
	public void archiveParameter(final Parameter<?> parameter) {
		mongo.save(parameter, collection);
	}

	@Override
	public void archiveParameter(final ParameterGroup parameterGroup) {
		for(Parameter<?> parameter : parameterGroup.getAllParameters().values()) {
			mongo.save(parameter, collection);
		}
	}

	public void setCollection(final String collection) {
		this.collection = collection;
	}

}