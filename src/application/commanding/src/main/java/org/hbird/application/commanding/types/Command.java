package org.hbird.application.commanding.types;

import org.hbird.core.commons.tmtc.ParameterGroup;
import org.joda.time.DateTime;

public class Command {
	private final ParameterGroup command;
	private final DateTime sendTime;

	public Command(final ParameterGroup command, final DateTime sendTime) {
		this.command = command;
		this.sendTime = sendTime;
	}

	public ParameterGroup getCommand() {
		return command;
	}

	public DateTime getSendTime() {
		return sendTime;
	}

}
