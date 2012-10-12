package org.hbird.application.halcyon;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hbird.application.halcyon.osgi.OsgiReady;
import org.hbird.application.parameterarchive.interfaces.ParameterQuerySender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/tm/parameterarchive")
public class MongoParameterArchiveQueryResource extends OsgiReady {
	private final static Logger LOG = LoggerFactory.getLogger(MongoParameterArchiveQueryResource.class);

	private static final String SERVICE_INTERFACE = "org.hbird.application.parameterarchive.interfaces.ParameterQuerySender";

	public MongoParameterArchiveQueryResource() {
		super(SERVICE_INTERFACE);
	}

	// @POST
	// @Path("/query")
	// @Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	// public String queryParameterDatabase(String jsonQuery) {
	// String result = null;
	//
	// final ParameterQuerySender parameterQuerySenderService = (ParameterQuerySender) getServiceTracker().getService();
	// if (parameterQuerySenderService != null) {
	//
	// // List<DBObject> qRes = parameterQuerySenderService.query(jsonQuery);
	// DBObject mongoQuery = (DBObject) JSON.parse(jsonQuery);
	// Object qRes = parameterQuerySenderService.query(mongoQuery);
	// if (qRes instanceof List<?>) {
	// result = JSON.serialize(qRes);
	// }
	// else {
	// LOG.error("Object returned from the parameter archiver was not a List of Mongo Db objects");
	// }
	// }
	// else {
	// LOG.warn("No " + SERVICE_INTERFACE + " service found.");
	// }
	//
	// return result;
	// }

	@POST
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	// public String queryParameterDatabase(Date startTime, Date endTime) {
	public String queryParameterDatabase(Map<String, Object> filters) {
		String result = null;

		final ParameterQuerySender parameterQuerySenderService = (ParameterQuerySender) getServiceTracker().getService();
		if (parameterQuerySenderService != null) {

			DBObject mongoQuery = new BasicDBObject();
			mongoQuery.put("receivedTime", BasicDBObjectBuilder.start("$gte", filters.get("startTime")).add("$lte", filters.get("endTime")).get());
			Object qRes = parameterQuerySenderService.query(mongoQuery);
			if (qRes instanceof List<?>) {
				result = JSON.serialize(qRes);
			}
			else {
				LOG.error("Object returned from the parameter archiver was not a List<?>");
			}
		}
		else {
			LOG.warn("No " + SERVICE_INTERFACE + " service found.");
		}

		return result;
	}

}
