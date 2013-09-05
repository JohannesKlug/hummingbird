package org.hbird.application.halcyon.tm;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.StringUtils;
import org.hbird.application.halcyon.osgi.OsgiReady;
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

		String result = "undefined";
		if (publisher != null) {
			result = publisher.getUnitDescription(qualifiedName);
			if (StringUtils.isBlank(result)) {
				result = "undefined";
			}
		}
		return result;
	}

	@Path("/all")
	@GET
	@Produces(APPLICATION_JSON)
	public Map<String, String> getAllParameterUnitDescriptions() {
		SpaceSystemPublisher publisher = (SpaceSystemPublisher) getServiceTracker().getService();

		if (publisher != null) {
			return publisher.getAllUnitDescriptions();
		}
		return null;
	}
}
