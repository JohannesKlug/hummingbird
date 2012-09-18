package org.hbird.application.halcyon;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.hbird.application.commanding.interfaces.processing.Commanding;
import org.hbird.application.halcyon.osgi.OsgiReady;
import org.hbird.core.commons.tmtc.CommandGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/commanding")
public class CommandingResource extends OsgiReady {
	private final static Logger LOG = LoggerFactory.getLogger(CommandingResource.class);

	private static final String COMMANDING_SERVICE_NAME = "org.hbird.application.commanding.interfaces.info.Commanding";

	public CommandingResource() {
		super(COMMANDING_SERVICE_NAME);
	}

	@POST
	@Path("/sendcommand")
	@Consumes(MediaType.APPLICATION_JSON)
	public void sendCommand(final CommandGroup cmd) {
		final Commanding cmdService = (Commanding) getServiceTracker().getService();

		if(cmdService != null) {
			cmdService.sendCommand(cmd);
		}
		else {
			LOG.error("No commanding service available. Cannot send commmand " + cmd);
		}
	}

}
