package org.hbird.application.commanding.provided.processing;

import java.util.ArrayList;
import java.util.List;

import org.hbird.application.commanding.interfaces.processing.CommandAcceptor;
import org.hbird.application.commanding.types.Command;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.joda.time.DateTime;

public class CachedCommandList implements CommandAcceptor {

	List<Command> queuedCommands;

	public CachedCommandList() {
		queuedCommands = new ArrayList<Command>();
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public void acceptCommand(final ParameterGroup command) {
		queuedCommands.add(new Command(command, DateTime.now()));
	}

	@Override
	public void acceptCommand(final ParameterGroup command, final DateTime sendTime) {
		queuedCommands.add(new Command(command, sendTime));
	}

}
