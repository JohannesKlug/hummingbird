
package org.hbird.application.halycon;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hbird.application.commanding.interfaces.info.CommandInformationService;
import org.hbird.core.commons.tmtc.CommandGroup;
import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Mark Doyle
 * @author Johannes Klug
 *
 */
@Path("/commandlist")
public class CommandList {
	private final static Logger LOG = LoggerFactory.getLogger(CommandList.class);

	private Map<String, String> allowedCommandNames = null;

	public CommandList() {
		final ServiceTracker tracker = new ServiceTracker(WebAppContextListener.getBundleContext(), CommandInformationService.class.getName(), null);
		tracker.open();
		System.out.println("Tracking " + tracker.getTrackingCount() + " CommandInformationService services");

		if(tracker.getTrackingCount() > 0) {
			final List<CommandGroup> allowedCommands = ((CommandInformationService)tracker.getService()).getAllAllowedCommands();
			if(allowedCommands.size() > 0 ) {
				allowedCommandNames = new HashMap<String, String>(allowedCommands.size());
				for(final CommandGroup cmd : allowedCommands) {
					allowedCommandNames.put(cmd.getQualifiedName(), cmd.getName());
				}
			}
			else {
				allowedCommandNames = new HashMap<String, String>(0);
			}
		}
	}

	/** Method processing HTTP GET requests, producing "text/plain" MIME media
	 * type.
	 * @return String that will be send back as a response of type "text/plain".
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCommandList() {
		String msg = "";
		if(allowedCommandNames != null) {
			msg = "Hi there! We have " + allowedCommandNames.size() + " commands. ";
			for(final String qName : allowedCommandNames.keySet()) {
				msg += qName;
			}
		}
		else {
			msg = "There was a problem retreiving the command list";
		}
		return msg;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> getCommandListJson() {
		System.out.println("Returning allowed command name list as json");
		if(allowedCommandNames.size() == 0) {
			LOG.warn("No commands to return!");
		}
		return allowedCommandNames;
	}

	@GET
	@Produces("application/x-msgpack") // FIXME use a constant.
	public byte[] getCommandListAsMsgPack() throws IOException {
		final MessagePack msgpack = new MessagePack();

		final ByteArrayOutputStream out = new ByteArrayOutputStream();

		final Packer packer = msgpack.createPacker(out);
		packer.write(allowedCommandNames);

		return out.toByteArray();

	}

}
