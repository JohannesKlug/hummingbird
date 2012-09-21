package org.hbird.application.commanding.provided.processing;

import org.hbird.application.commanding.interfaces.processing.Commanding;
import org.hbird.core.commons.tmtc.CommandGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultCommanding implements Commanding {
	private final static Logger LOG = LoggerFactory.getLogger(DefaultCommanding.class);

	public DefaultCommanding() {
	}

	@Override
	public void sendCommand(final CommandGroup cmd) {
		// TODO Auto-generated method stub
		LOG.trace("Received command to send: " + cmd);
	}

}
