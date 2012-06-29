package org.hbird.application.parameterarchive.mongodb;

import java.util.Date;
import java.util.List;

import org.hbird.application.parameterarchive.interfaces.ParameterRetriever;
import org.hbird.application.parameterarchive.repositories.ParameterRepository;
import org.hbird.core.commons.tmtc.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class SimpleMongoParameterRetriever implements ParameterRetriever {

	@Autowired
	private MongoTemplate mongo;

	@Autowired
	ParameterRepository parameterRepo;

	private String collection;

	public void setCollection(final String collection) {
		this.collection = collection;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Parameter> findParameters(final String qualifiedName) {
		System.out.println("Searching by Qualified name "  + qualifiedName);
		final Query query = new Query(Criteria.where("name").is(qualifiedName));
		final List<Parameter> foundParameters = mongo.find(query, Parameter.class, collection);
		return foundParameters;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Parameter> findParameters(final Date startDate, final Date endDate) {
		System.out.println("Searching by time range name "  + startDate + " - " + endDate);
		final Query query = new Query(Criteria.where("receivedTime").gte(startDate.getTime()).lte(endDate.getTime()));
		final List<Parameter> foundParameters = mongo.find(query, Parameter.class, collection);
		System.out.println("Returning " + foundParameters.size() + " parameters");
		return foundParameters;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Parameter<?>> findByReceivedTimeBetween(final long startDate, final long endDate, final int page, final int numOfResults) {
		Page<Parameter<?>> found = parameterRepo.findByReceivedTimeBetween(startDate, endDate, new PageRequest(page, numOfResults));
		System.out.println("Pageable returning: " + found.getContent().size());
		return found.getContent();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Parameter> findParameters(final String qualifiedName, final Date startDate, final Date endDate) {
		final Query query = new Query(Criteria.where("name").is(qualifiedName).and("receivedTime").gte(startDate.getTime()).lte(endDate.getTime()));
		final List<Parameter> foundParameters = mongo.find(query, Parameter.class, collection);
		return foundParameters;
	}

}

