package org.hbird.application.commanding.interfaces.processing;

import org.apache.camel.InOnly;
import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;

public interface CommandSender {

	@InOnly
	void sendCommand(CommandGroup cmd);
}
