package org.hbird.application.halcyon.tm;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hbird.application.halcyon.osgi.OsgiReady;
import org.hbird.core.spacesystempublisher.exceptions.UnavailableSpaceSystemModelException;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/parameter/unit")
public class UnitDescriptionResource extends OsgiReady {
	private static final String PUBLISHER_SERVICE_NAME = "org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher";

	public UnitDescriptionResource() {
		super(PUBLISHER_SERVICE_NAME);
	}

	/**
	 * Gets the unit description for passed qialified parameter name.
	 * 
	 * @return String that will be send back as a response of type "text/plain".
	 */
	@Path("/{searchStr}")
	@GET
	@Produces(TEXT_PLAIN)
	public String getParameterUnitDescription(@PathParam("searchStr") String qualifiedName) {
		SpaceSystemPublisher publisher = (SpaceSystemPublisher) getServiceTracker().getService();

		if (publisher != null) {
			try {
				return publisher.getUnitDescription(qualifiedName);
			}
			catch (UnavailableSpaceSystemModelException e) {
				throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
			}
		}
		throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR).entity("SpaceSystemPublisher is unavailable.").build());
	}

	@Path("/all")
	@GET
	@Produces(APPLICATION_JSON)
	public Map<String, String> getAllParameterUnitDescriptions() {
		SpaceSystemPublisher publisher = (SpaceSystemPublisher) getServiceTracker().getService();

		if (publisher != null) {
			try {
				return publisher.getAllUnitDescriptions();
			}
			catch (UnavailableSpaceSystemModelException e) {
				throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
			}
		}
		throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR).entity("SpaceSystemPublisher is unavailable.").build());
	}
}
