package org.hbird.application.halcyon;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hbird.application.halcyon.osgi.OsgiReady;
import org.hbird.application.parameterarchive.interfaces.ParameterQuerySender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/tm/parameterarchive")
public class ParameterArchiveQueryResource extends OsgiReady {
	private final static Logger LOG = LoggerFactory.getLogger(ParameterArchiveQueryResource.class);

	private static final String SERVICE_INTERFACE = "org.hbird.application.parameterarchive.interfaces.ParameterQuerySender";

	public ParameterArchiveQueryResource() {
		super(SERVICE_INTERFACE);
	}

	@POST
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String queryParameterDatabase(String jsonQuery) {
		String result = null;

		final ParameterQuerySender parameterQuerySenderService = (ParameterQuerySender) getServiceTracker().getService();
		if (parameterQuerySenderService != null) {
			result = parameterQuerySenderService.query(jsonQuery);
		}
		else {
			LOG.warn("No " + SERVICE_INTERFACE + " service found.");
		}

		return result;
	}

}
