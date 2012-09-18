package org.hbird.application.commanding.provided.processing;

import org.hbird.application.commanding.interfaces.processing.Commanding;
import org.hbird.core.commons.tmtc.CommandGroup;

public class DefaultCommanding implements Commanding {

	public DefaultCommanding() {
	}

	@Override
	public void sendCommand(final CommandGroup cmd) {
		// TODO Auto-generated method stub
		System.out.println("Received command to send: " + cmd);
	}

}
