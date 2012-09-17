package org.hbird.application.halcyon.tm;

import java.util.ArrayList;
import java.util.List;

import org.hbird.core.commons.tmtc.ParameterGroup;

public class LiveTmWhiteboardDistributer {

	private List<LiveTmReceiver> receivers;

	public LiveTmWhiteboardDistributer() {
		receivers = new ArrayList<LiveTmReceiver>(0);
	}

	public final void liveTmGroupIn(final ParameterGroup parameterGroup) {
		for (final LiveTmReceiver receiver : receivers) {
			receiver.acceptNewLiveParameterGroup(parameterGroup);
		}
	}

	public void setReceivers(final List<LiveTmReceiver> receivers) {
		this.receivers = receivers;
	}

}
