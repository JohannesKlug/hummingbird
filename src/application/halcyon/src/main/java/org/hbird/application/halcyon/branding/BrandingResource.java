package org.hbird.application.halcyon.branding;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hbird.application.halcyon.HalcyonServletContextListener;

@Path("/branding")
@Produces(MediaType.TEXT_PLAIN)
public class BrandingResource {

	@GET
	@Path("/mcsName")
	public String getMcsName() {
		return HalcyonServletContextListener.getBrandingPlugin().getMcsName();
	}

}
