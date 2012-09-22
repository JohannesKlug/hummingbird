package org.hbird.application.commanding.interfaces.processing;

import org.hbird.core.commons.tmtc.CommandGroup;

public interface CommandSender {

	void sendCommand(CommandGroup cmd);
}
