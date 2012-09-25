package org.hbird.application.commanding.interfaces.processing;

import org.apache.camel.InOnly;
import org.hbird.core.commons.tmtc.CommandGroup;

public interface Commanding {

	@InOnly
	void acceptCommand(CommandGroup cmd);

}
