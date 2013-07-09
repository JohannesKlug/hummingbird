package org.hbird.application.commanding.provided.processing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.camel.Produce;
import org.hbird.application.commanding.interfaces.processing.CommandAcceptor;
import org.hbird.application.commanding.interfaces.processing.CommandSender;
import org.hbird.application.commanding.interfaces.processing.CommandVerificationSender;
import org.hbird.application.commanding.interfaces.processing.MonitorListener;
import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CommandSender service based {@link CommandAcceptor}.
 * Set the CommandSender before using the class. Camel annotation will look up the commandSenderEndpoint
 * first.
 * 
 * @author Mark Doyle
 */
public class CommandExecutor implements CommandAcceptor, MonitorListener {
	private final static Logger LOG = LoggerFactory.getLogger(CommandExecutor.class);

	private SpaceSystemPublisher publisher;

	/**
	 * The commandSenderEndpoint is looked up in the Registry so make sure you have one in your spring config file or
	 * blueprint!
	 * Camel proxies the interface ({@link CommandSender}) so we only have a camel annotation in the code, no direct
	 * dependency.
	 * We can plug in anything that implements {@link CommandSender}
	 */
	@Produce(ref = "commandSenderEndpoint")
	private CommandSender sender;

	@Produce(ref = "commandVerificationStatus")
	private CommandVerificationSender verificationSender;

	private final List<CommandMonitor> monitors = new ArrayList<CommandMonitor>();

	private final List<CommandMonitor> completeMonitors = new ArrayList<CommandMonitor>();

	public CommandExecutor() {
	}

	@Override
	public String acceptCommand(final CommandGroup cmd) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Received command to send: " + cmd);
		}

		UUID uid = UUID.randomUUID();
		cmd.setUid(uid);

		try {
			if (publisher != null) {
				monitors.add(new CommandMonitor(cmd, this, publisher));
			}
			else {
				LOG.warn("Command verification cannot be tracked as there is no space system publisher service available to the Command Executor.");
			}
		}
		catch (UnknownParameterException e) {
			LOG.error("Error in definition for command " + cmd.getQualifiedName() + ", Unknown parameter (" + e.getNameOfRequestedParameter()
					+ ") used in verification comparison list. Full stack trace: " + e.toString());
			return null;
		}

		cmd.setSendTime(System.currentTimeMillis());
		sender.sendCommand(cmd);

		return uid.toString();
	}

	public void receiveLiveTm(ParameterGroup pg) {
		Iterator<CommandMonitor> it = monitors.iterator();
		while (it.hasNext()) {
			CommandMonitor monitor = it.next();
			if (completeMonitors.contains(monitor)) {
				it.remove();
				continue;
			}
			for (Parameter<?> p : pg.getAllParametersAsList()) {
				monitor.receiveParameter(p);
			}
		}
	}

	@Override
	public void commandCompleted(CommandMonitor monitor) {
		// send message to command monitor endpoint
		verificationSender.sendUpdate(new VerificationUpdate(CommandVerificationStage.COMPLETE, monitor.getCmd().getUid()));

		// find monitor in list and remove
		completeMonitors.add(monitor);
	}

	public void setSender(final CommandSender sender) {
		this.sender = sender;
	}

	public final SpaceSystemPublisher getPublisher() {
		return publisher;
	}

	public final void setPublisher(SpaceSystemPublisher publisher) {
		this.publisher = publisher;
	}

	public final void setVerificationSender(CommandVerificationSender verificationSender) {
		this.verificationSender = verificationSender;
	}
}
