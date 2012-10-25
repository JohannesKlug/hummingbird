package org.hbird.application.parameterarchive;

import java.util.ArrayList;

import org.hbird.application.parameterarchive.model.QueryRequest;
import org.hbird.application.parameterarchive.mongodb.MongoDbParameterQuerySender;
import org.hbird.application.parameterarchive.mongodb.MongoServiceStrategy;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

@RunWith(MockitoJUnitRunner.class)
public class MongoDbParameterQuerySenderTest {

	private static MongoDbParameterQuerySender sender;

	@Mock
	private static MongoServiceStrategy mockMongoServiceStrategy;

	@BeforeClass
	public static void setup() {
		sender = new MongoDbParameterQuerySender();
	}

	@Before
	public void setupPerTest() {
		sender.setMongoService(mockMongoServiceStrategy);
	}

	@Test
	public void queryWithQueryRequestAndTimeRangesBoth() {
		DateTime startDate = new DateTime(2012, 1, 1, 1, 1);
		DateTime endDate = new DateTime(2012, 10, 10, 1, 1);

		QueryRequest request = new QueryRequest();
		request.startTime = startDate.getMillis();
		request.endTime = endDate.getMillis();

		DBObject expectedQuery = new BasicDBObject();
		expectedQuery.put("receivedTime", BasicDBObjectBuilder.start().add("$gte", request.startTime).add("$lte", request.endTime).get());

		sender.query(request);
		Mockito.verify(mockMongoServiceStrategy).query(expectedQuery);
	}

	@Test
	public void queryWithQueryRequestAndTimeRangesOnlyStart() {
		DateTime startDate = new DateTime(2012, 1, 1, 1, 1);

		QueryRequest request = new QueryRequest();
		request.startTime = startDate.getMillis();

		DBObject expectedQuery = new BasicDBObject();
		expectedQuery.put("receivedTime", BasicDBObjectBuilder.start().add("$gte", request.startTime).get());

		sender.query(request);
		Mockito.verify(mockMongoServiceStrategy).query(expectedQuery);
	}

	@Test
	public void queryWithQueryRequestAndTimeRangesOnlyEnd() {
		DateTime endDate = new DateTime(2012, 1, 1, 1, 1);

		QueryRequest request = new QueryRequest();
		request.endTime = endDate.getMillis();

		DBObject expectedQuery = new BasicDBObject();
		expectedQuery.put("receivedTime", BasicDBObjectBuilder.start().add("$lte", request.endTime).get());

		sender.query(request);
		Mockito.verify(mockMongoServiceStrategy).query(expectedQuery);
	}

	@Test
	public void queryWithQueryRequestAndQualifiedNameFilter() {
		String filterName = "MeGusta";

		QueryRequest request = new QueryRequest();
		request.parameterQualifiedName = new ArrayList<String>();
		request.parameterQualifiedName.add(filterName);

		DBObject expectedQuery = new BasicDBObject();
		expectedQuery.put("qualifiedName", BasicDBObjectBuilder.start().add("$in", request.parameterQualifiedName).get());

		sender.query(request);
		Mockito.verify(mockMongoServiceStrategy).query(expectedQuery);
	}

	@Test
	public void queryWithQueryRequestAndMultipleQualifiedNameFilter() {
		String filterName = "MeGusta";
		String filterName2 = "Coolface";
		String filterName3 = "Gaben";

		QueryRequest request = new QueryRequest();
		request.parameterQualifiedName = new ArrayList<String>();
		request.parameterQualifiedName.add(filterName);
		request.parameterQualifiedName.add(filterName2);
		request.parameterQualifiedName.add(filterName3);

		DBObject expectedQuery = new BasicDBObject();
		expectedQuery.put("qualifiedName", BasicDBObjectBuilder.start().add("$in", request.parameterQualifiedName).get());

		sender.query(request);
		Mockito.verify(mockMongoServiceStrategy).query(expectedQuery);
	}
}
