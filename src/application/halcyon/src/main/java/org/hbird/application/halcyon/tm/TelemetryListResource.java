package org.hbird.application.halcyon.tm;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.hbird.application.halcyon.osgi.OsgiReady;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.hbird.core.spacesystempublisher.exceptions.UnavailableSpaceSystemModelException;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.spi.resource.Singleton;

/**
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
@Singleton
@Path("/tm")
public class TelemetryListResource extends OsgiReady {
	private final static Logger LOG = LoggerFactory.getLogger(TelemetryListResource.class);

	private static final String PUBLISHER_SERVICE_NAME = "org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher";

	private List<ParameterGroup> parameterGroups;

	private List<Parameter<?>> parameters;

	public TelemetryListResource() {
		super(PUBLISHER_SERVICE_NAME);
	}

	private final void cacheTmList() throws UnavailableSpaceSystemModelException {
		if (parameterGroups == null) {
			final SpaceSystemPublisher publisher = (SpaceSystemPublisher) getServiceTracker().getService();
			if (publisher != null) {
				parameterGroups = publisher.getParameterGroupList();
				parameters = publisher.getAllParameters();
			}
			else {
				LOG.warn("No " + PUBLISHER_SERVICE_NAME + " service found.");
			}
		}
	}

	/**
	 * Method processing HTTP GET requests, producing "text/plain" MIME media type.
	 * 
	 * @return String that will be send back as a response of type "text/plain".
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTmList() {
		updateTmCache();
		String msg = "";
		msg = "Hi there! We have " + parameterGroups.size() + " ParameterGroups. ";
		for (final ParameterGroup pg : parameterGroups) {
			msg += pg.getQualifiedName() + " / " + pg.getName() + " :: ";
		}
		return msg;
	}

	private void updateTmCache() {
		try {
			cacheTmList();
		}
		catch (UnavailableSpaceSystemModelException e) {
			throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Path("/parameterGroups")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<ParameterGroup> getTmParameterGroupListJson() {
		updateTmCache();
		if (parameterGroups.size() == 0) {
			LOG.warn("No TM ParameterGroups to return!");
		}

		return parameterGroups;
	}

	@GET
	@Path("/parameters")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Parameter<?>> getTmParametersListJson() {
		updateTmCache();
		if (parameters.size() == 0) {
			LOG.warn("No TM Parameters to return!");
		}

		return parameters;
	}

	@GET
	@Path("/parameters/{searchStr}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Parameter<?>> getParametersContains(@PathParam("searchStr") final String searchStr) {
		updateTmCache();
		List<Parameter<?>> res = new ArrayList<Parameter<?>>();
		for (Parameter<?> p : parameters) {
			if (StringUtils.containsIgnoreCase(p.getQualifiedName(), searchStr)) {
				res.add(p);
			}
		}
		return res;
	}

}
