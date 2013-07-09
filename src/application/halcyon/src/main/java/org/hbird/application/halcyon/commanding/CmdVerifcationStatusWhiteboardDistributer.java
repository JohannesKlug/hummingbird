package org.hbird.application.halcyon.commanding;

import java.util.ArrayList;
import java.util.List;

import org.hbird.application.commanding.provided.processing.VerificationUpdate;

public class CmdVerifcationStatusWhiteboardDistributer {

	private List<CmdVerificationReceiver> receivers;

	public CmdVerifcationStatusWhiteboardDistributer() {
		receivers = new ArrayList<CmdVerificationReceiver>(0);
	}

	public void receiveVerificationUpdate(VerificationUpdate update) {
		for (CmdVerificationReceiver receiver : receivers) {
			receiver.verifcationUpdate(update);
		}
	}

	public void setReceivers(final List<CmdVerificationReceiver> receivers) {
		this.receivers = receivers;
	}

}
