package org.hbird.application.commanding.interfaces.processing;

import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;
import org.hbird.core.spacesystempublisher.exceptions.UnavailableSpaceSystemModelException;

public interface CommandAcceptor {

	String acceptCommand(CommandGroup cmd) throws UnavailableSpaceSystemModelException, UnknownParameterException;

}
