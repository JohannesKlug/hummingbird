
package org.hbird.application.halycon;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hbird.application.commanding.interfaces.info.CommandInformationService;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.msgpack.MessagePack;
import org.osgi.util.tracker.ServiceTracker;

/**
 *
 * @author Mark Doyle
 * @author Johannes Klug
 *
 */
@Path("/commandlist")
public class CommandList {

	private List<ParameterGroup> allowedCommands = null;

	public CommandList() {
		ServiceTracker tracker = new ServiceTracker(WebAppContextListener.getBundleContext(), CommandInformationService.class.getName(), null);
		tracker.open();

		if(tracker.getTrackingCount() > 0) {
			allowedCommands = ((CommandInformationService)tracker.getService()).getAllAllowedCommands();
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
		if(allowedCommands != null) {
			msg = "Hi there! We have " + allowedCommands.size() + " commands";
			for(ParameterGroup cmdG : allowedCommands) {
				msg += cmdG.getQualifiedName();
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
		msgpack.register(ParameterGroup.class);
		return msgpack.write(allowedCommands);

	}

}
