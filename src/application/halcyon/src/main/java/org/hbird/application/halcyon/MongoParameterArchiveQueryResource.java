package org.hbird.application.halcyon;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hbird.application.halcyon.datatables.ServerSideProcReturnData;
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

	@POST
	@Path("/rawquery")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String queryParameterDatabaseForDataTables(List<Map<String, String>> dataTablesAoData) throws JsonGenerationException, JsonMappingException,
			IOException {
		String result = null;

		final ParameterQuerySender parameterQuerySenderService = (ParameterQuerySender) getServiceTracker().getService();
		if (parameterQuerySenderService != null) {
			Map<String, String> aoData = refineAoDataList(dataTablesAoData);
			if (aoData != null) {
				DBObject query = buildMongoQuery(aoData);
				String skip = aoData.get("iDisplayStart");
				String count = aoData.get("iDisplayLength");
				Object results = parameterQuerySenderService.query(query, Integer.parseInt(count), Integer.parseInt(skip));
				// FIXME Put results into aaData and return aoData back to server!
				if (results instanceof List<?>) {
					ServerSideProcReturnData aaDataStructure = new ServerSideProcReturnData();
					aaDataStructure.sEcho = aoData.get("sEcho");
					aaDataStructure.aaData = (List<?>) results;
					aaDataStructure.iTotalRecords = 20000;
					aaDataStructure.iTotalDisplayRecords = 20000;
					ObjectMapper mapper = new ObjectMapper();
					Writer out = new StringWriter();
					mapper.writeValue(out, aaDataStructure);
					result = out.toString();
				}
				else {
					LOG.error("Object returned from the parameter archiver was not a List<?>");
				}
			}
			else {
				LOG.error("Invalid aoData received");
			}
		}
		else {
			LOG.warn("No " + SERVICE_INTERFACE + " service found.");
		}
		return result;
	}

	private static DBObject buildMongoQuery(Map<String, String> aoData) {
		DBObject mongoQuery = new BasicDBObject();

		return mongoQuery;
	}

	private static Map<String, String> refineAoDataList(List<Map<String, String>> dataTablesAoData) {
		final int AO_DATA_ARRAY_LENGTH = 25;
		Map<String, String> aoData = null;
		if (dataTablesAoData.size() == 25) {
			aoData = new HashMap<String, String>(AO_DATA_ARRAY_LENGTH);
			for (Map<String, String> aoDataObj : dataTablesAoData) {
				aoData.put(aoDataObj.get("name"), aoDataObj.get("value"));
			}
		}
		return aoData;
	}
}
