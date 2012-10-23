package org.hbird.application.halcyon;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.hbird.application.halcyon.osgi.OsgiReady;
import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.ParameterGroup;
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

	private final void cacheTmList() {
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
		cacheTmList();
		String msg = "";
		msg = "Hi there! We have " + parameterGroups.size() + " ParameterGroups. ";
		for (final ParameterGroup pg : parameterGroups) {
			msg += pg.getQualifiedName() + " / " + pg.getName();
		}
		return msg;
	}

	@GET
	@Path("/parameterGroups")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<ParameterGroup> getTmParameterGroupListJson() {
		cacheTmList();
		if (parameterGroups.size() == 0) {
			LOG.warn("No TM ParameterGroups to return!");
		}

		return parameterGroups;
	}

	@GET
	@Path("/parameters")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Parameter<?>> getTmParametersListJson() {
		cacheTmList();
		if (parameters.size() == 0) {
			LOG.warn("No TM Parameters to return!");
		}

		return parameters;
	}

	@GET
	@Path("/parameters/{searchStr}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Parameter<?>> getParametersContains(@PathParam("searchStr") final String searchStr) {
		cacheTmList();
		List<Parameter<?>> res = new ArrayList<Parameter<?>>();
		for (Parameter<?> p : parameters) {
			if (StringUtils.containsIgnoreCase(p.getQualifiedName(), searchStr)) {
				res.add(p);
			}
		}
		return res;
	}

}
