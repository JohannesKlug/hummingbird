package org.hbird.application.commanding.interfaces.processing;

import org.hbird.core.commons.tmtc.ParameterGroup;
import org.joda.time.DateTime;

public interface CommandAcceptor {

	void acceptCommand(ParameterGroup command);

	void acceptCommand(ParameterGroup command, DateTime sendTime);

}
