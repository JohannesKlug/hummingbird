package org.hbird.application.halcyon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.view.Viewable;

@Path("/home")
@Produces(MediaType.TEXT_HTML)
public class HalcyonResource {

	@GET
	public Viewable getHome() {
		System.out.println("Returning home page");
		return new Viewable("/index.html");
	}

}
