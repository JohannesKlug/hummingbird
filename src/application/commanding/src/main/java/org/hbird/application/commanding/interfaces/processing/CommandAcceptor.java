package org.hbird.application.commanding.interfaces.processing;

import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;

public interface CommandAcceptor {

	String acceptCommand(CommandGroup cmd);

}
