package org.hbird.application.halcyon.commanding;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.collections.ListUtils;
import org.hbird.application.commanding.interfaces.info.CommandInformationService;
import org.hbird.application.halcyon.osgi.OsgiReady;
import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;
import org.hbird.core.spacesystempublisher.exceptions.UnavailableSpaceSystemModelException;
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
@Path("/commanding/info")
public class CommandListResource extends OsgiReady {
	private final static Logger LOG = LoggerFactory.getLogger(CommandListResource.class);

	private static final String COMMAND_INFORMATION_SERVICE_NAME = "org.hbird.application.commanding.interfaces.info.CommandInformationService";

	private List<CmdNames> allowedCommandNames = null;

	// TODO check if we need this. Could be junk.
	private class CmdNames {
		public String qualifiedName;

		public String name;

		public CmdNames(final String qualifiedName, final String name) {
			super();
			this.qualifiedName = qualifiedName;
			this.name = name;
		}
	};

	public CommandListResource() {
		super(COMMAND_INFORMATION_SERVICE_NAME);
	}

	private final void cacheAllowedCommands() throws UnavailableSpaceSystemModelException {
		final CommandInformationService cmdInfoService = (CommandInformationService) getServiceTracker().getService();
		allowedCommandNames = new ArrayList<CmdNames>();
		if (cmdInfoService != null) {
			// allowedCommandNames = new HashMap<String, String>();
			for (final CommandGroup cmd : cmdInfoService.getAllAllowedCommands()) {
				allowedCommandNames.add(new CmdNames(cmd.getQualifiedName(), cmd.getName()));
			}
			LOG.debug("Cached " + cmdInfoService.getAllAllowedCommands().size() + " commands");
		}
		else {
			LOG.warn("No " + COMMAND_INFORMATION_SERVICE_NAME + " service found.");
		}
	}

	/**
	 * Method processing HTTP GET requests, producing "text/plain" MIME media type.
	 * 
	 * @return String that will be send back as a response of type "text/plain".
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCommandList() {
		String msg = "";
		try {
			cacheAllowedCommands();
		}
		catch (UnavailableSpaceSystemModelException e) {
			msg = e.getMessage();
		}
		msg = "Hi there! We have " + allowedCommandNames.size() + " commands. ";

		for (final CmdNames cmdName : allowedCommandNames) {
			msg += cmdName.qualifiedName + " / " + cmdName.name;
		}
		return msg;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<CmdNames> getCommandListJson() {
		try {
			cacheAllowedCommands();
		}
		catch (UnavailableSpaceSystemModelException e) {
			LOG.error("Could not cache the allowed commands due to {0}", e.getMessage());
			allowedCommandNames = ListUtils.EMPTY_LIST;
		}
		if (allowedCommandNames.size() == 0) {
			LOG.info("No commands to return!");
		}
		return allowedCommandNames;
	}

	@GET
	@Path("/command/{qualifiedName}")
	@Produces({ MediaType.APPLICATION_JSON })
	public CommandGroup getCommand(@PathParam("qualifiedName") final String qualifiedName) {
		final CommandInformationService cmdInfoService = (CommandInformationService) getServiceTracker().getService();
		try {
			return cmdInfoService.getCommand(qualifiedName);
		}
		catch (UnavailableSpaceSystemModelException e) {
			throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

}
