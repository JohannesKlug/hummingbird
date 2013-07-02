package org.hbird.application.commanding.provided.processing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hbird.application.commanding.interfaces.processing.MonitorListener;
import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;

public class CommandMonitor {

	private SpaceSystemPublisher publisher;

	private final Map<String, String> verificationsMap;

	private final MonitorListener monitorListener;

	private final CommandGroup cmd;

	public CommandMonitor(CommandGroup cmd, MonitorListener l) throws UnknownParameterException {
		this.cmd = cmd;

		monitorListener = l;

		verificationsMap = new HashMap<String, String>(publisher.getCommandVerifiers(cmd.getQualifiedName()));
		// set values to check if null

		for (Entry<String, String> entry : verificationsMap.entrySet()) {
			if (entry.getValue() == null) {
				entry.setValue(cmd.getParameter(entry.getKey()).getValue().toString());
			}
		}

		notifyCompletion();
	}

	public void receiveParameter(Parameter<?> p) {
		// look up in verifiers map

		String targetValue = verificationsMap.get(p.getQualifiedName());

		if (targetValue != null) {
			if (p.getValue() == targetValue) {
				// remove p from verifications list
				verificationsMap.remove(p.getQualifiedName());
			}

		}

		notifyCompletion();

	}

	private void notifyCompletion() {
		if (verificationsMap.isEmpty()) {
			monitorListener.commandCompleted(this);

		}

	}

	public final CommandGroup getCmd() {
		return cmd;
	}

}
