package org.hbird.application.commanding.provided.processing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hbird.application.commanding.interfaces.processing.MonitorListener;
import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandMonitor {
	private static final Logger LOG = LoggerFactory.getLogger(CommandMonitor.class);

	/** Qualified Parameter name and corresponding value */
	private final Map<String, String> verificationsMap;

	private final MonitorListener monitorListener;

	private final CommandGroup cmd;

	/**
	 * 
	 * @param cmd
	 * @param monitorListener
	 * @param publisher
	 * @throws UnknownParameterException
	 */
	public CommandMonitor(CommandGroup cmd, MonitorListener monitorListener, SpaceSystemPublisher publisher) throws UnknownParameterException {
		this.cmd = cmd;
		this.monitorListener = monitorListener;

		// TODO Move this to the Executor. If there are no verifiers we don't need to construct a monitor at all!
		Map<String, String> commandVerifiers = publisher.getCommandVerifiers(cmd.getQualifiedName());
		if (commandVerifiers != null) {
			verificationsMap = new HashMap<String, String>(commandVerifiers);
			// set values to check if null

			for (Entry<String, String> entry : verificationsMap.entrySet()) {
				if (entry.getValue() == null) {
					entry.setValue(cmd.getParameter(entry.getKey()).getValue().toString());
				}
			}
		}
		else {
			verificationsMap = new HashMap<String, String>(0);
			LOG.trace("No command verifications defined");
		}
		notifyCompletion();
	}

	public void receiveParameter(Parameter<?> p) {
		// look up in verifiers map
		String targetValue = verificationsMap.get(p.getQualifiedName());

		if (targetValue != null) {
			if (p.getValue().toString().matches(targetValue)) {
				// remove p from verifications list
				verificationsMap.remove(p.getQualifiedName());
			}

		}

		notifyCompletion();
	}

	private void notifyCompletion() {
		if (verificationsMap.isEmpty()) {
			LOG.trace("Verification map is empty, firing stage complete");
			monitorListener.commandCompleted(this);
		}
	}

	public final CommandGroup getCmd() {
		return cmd;
	}

}
