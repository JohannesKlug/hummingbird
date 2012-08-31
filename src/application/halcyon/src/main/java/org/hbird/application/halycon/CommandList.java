
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
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;
import org.osgi.util.tracker.ServiceTracker;

/**
 *
 * @author Mark Doyle
 * @author Johannes Klug
 *
 */
@Path("/commandlist")
public class CommandList {

	private Map<String, String> allowedCommandNames = null;

	public CommandList() {
		ServiceTracker tracker = new ServiceTracker(WebAppContextListener.getBundleContext(), CommandInformationService.class.getName(), null);
		tracker.open();

		if(tracker.getTrackingCount() > 0) {
			List<CommandGroup> allowedCommands = ((CommandInformationService)tracker.getService()).getAllAllowedCommands();
			if(allowedCommands.size() > 0 ) {
				allowedCommandNames = new HashMap<String, String>(allowedCommands.size());
				for(CommandGroup cmd : allowedCommands) {
					allowedCommandNames.put(cmd.getQualifiedName(), cmd.getName());
				}
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
			for(String qName : allowedCommandNames.keySet()) {
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
	public String getCommandListJson() {
		String result = null;
		return result;
	}

	@GET
	@Produces("application/x-msgpack") // FIXME use a constant.
	public byte[] getCommandListAsMsgPack() throws IOException {
		MessagePack msgpack = new MessagePack();

		ByteArrayOutputStream out = new ByteArrayOutputStream();

        Packer packer = msgpack.createPacker(out);
        packer.write(allowedCommandNames);

		return out.toByteArray();

	}

}
