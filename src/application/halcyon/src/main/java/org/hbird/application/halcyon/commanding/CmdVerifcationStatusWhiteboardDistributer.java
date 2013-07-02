package org.hbird.application.halcyon.commanding;

import java.util.ArrayList;
import java.util.List;

import org.hbird.application.commanding.interfaces.processing.CommandVerificationSender;

public class CmdVerifcationStatusWhiteboardDistributer {

	private List<CmdVerificationReceiver> receivers;

	public CmdVerifcationStatusWhiteboardDistributer() {
		receivers = new ArrayList<CmdVerificationReceiver>(0);
	}

	public void receiveVerificationUpdate(CommandVerificationSender.Stage stage, long uid) {
		for (CmdVerificationReceiver receiver : receivers) {
			receiver.verifcationUpdate(stage, uid);
		}
	}

	public void setReceivers(final List<CmdVerificationReceiver> receivers) {
		this.receivers = receivers;
	}

}
