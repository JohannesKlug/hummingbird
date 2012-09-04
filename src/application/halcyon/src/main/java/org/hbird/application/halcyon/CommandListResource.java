package org.hbird.application.halcyon;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hbird.application.commanding.interfaces.info.CommandInformationService;
import org.hbird.application.halcyon.osgi.OsgiReady;
import org.hbird.core.commons.tmtc.CommandGroup;
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
@Path("/commandlist")
public class CommandListResource extends OsgiReady {
	private static final String COMMAND_INFORMATION_SERVICE_NAME = "org.hbird.application.commanding.interfaces.info.CommandInformationService";

	private final static Logger LOG = LoggerFactory.getLogger(CommandListResource.class);

	//	private Map<String, String> allowedCommandNames = null;
	private List<CmdNames> allowedCommandNames = null;

	private CommandInformationService cmdInfoService;

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

	private final void cacheAllowedCommands() {
		if (allowedCommandNames == null) {
			cmdInfoService = (CommandInformationService) getServiceTracker().getService();
			if (cmdInfoService != null) {
				//				allowedCommandNames = new HashMap<String, String>();
				allowedCommandNames = new ArrayList<CmdNames>();
				for (final CommandGroup cmd : cmdInfoService.getAllAllowedCommands()) {
					allowedCommandNames.add(new CmdNames(cmd.getQualifiedName(), cmd.getName()));
				}
			}
			else {
				LOG.warn("No " + COMMAND_INFORMATION_SERVICE_NAME + " service found.");
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
	public String getCommandList() {
		cacheAllowedCommands();
		String msg = "";
		msg = "Hi there! We have " + allowedCommandNames.size() + " commands. ";
		for (final CmdNames cmdName : allowedCommandNames) {
			msg += cmdName.qualifiedName + " / " + cmdName.name;
		}
		return msg;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	public List<CmdNames> getCommandListJson() {
		cacheAllowedCommands();
		System.out.println("Returning allowed command name list as json");
		if (allowedCommandNames.size() == 0) {
			LOG.warn("No commands to return!");
		}
		return allowedCommandNames;
	}


	@GET
	@Path("/command/{qualifiedName}")
	@Produces({MediaType.APPLICATION_JSON})
	public CommandGroup getCommand(@PathParam("qualifiedName") final String qualifiedName) {
		LOG.debug("Getting command " + qualifiedName + " from commmand information service");
		return cmdInfoService.getCommand(qualifiedName);
	}

	//	@GET
	//	@Produces("application/x-msgpack")
	//	// FIXME use a constant.
	//	public byte[] getCommandListAsMsgPack() throws IOException {
	//		cacheAllowedCommands();
	//		final MessagePack msgpack = new MessagePack();
	//
	//		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	//
	//		final Packer packer = msgpack.createPacker(out);
	//		packer.write(allowedCommandNames);
	//
	//		return out.toByteArray();
	//
	//	}

}
