package org.hbird.application.halcyon.tm;

import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;

public interface LiveTmReceiver {
	void acceptNewLiveParameterGroup(final ParameterGroup parameterGroup);
}
