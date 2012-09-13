package org.hbird.application.halcyon;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hbird.application.halcyon.osgi.OsgiReady;
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
@Path("/telemetrylist")
public class TelemetryListResource extends OsgiReady {
	private final static Logger LOG = LoggerFactory.getLogger(TelemetryListResource.class);

	private static final String PUBLISHER_SERVICE_NAME = "org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher";

	private List<ParameterGroup> parameterGroups;

	public TelemetryListResource() {
		super(PUBLISHER_SERVICE_NAME);
	}

	private final void cacheTmList() {
		if (parameterGroups == null) {
			final SpaceSystemPublisher publisher = (SpaceSystemPublisher) getServiceTracker().getService();
			if (publisher != null) {
				parameterGroups = publisher.getParameterGroupList();
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
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	public List<ParameterGroup> getTmListJson() {
		cacheTmList();
		System.out.println("Returning TM list as json");
		if (parameterGroups.size() == 0) {
			LOG.warn("No TM ParameterGroups to return!");
		}
		return parameterGroups;
	}

}
