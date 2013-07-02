package org.hbird.application.halcyon.commanding;

import org.hbird.application.commanding.interfaces.processing.CommandVerificationSender;

public interface CmdVerificationReceiver {

	void verifcationUpdate(CommandVerificationSender.Stage stage, long uid);

}
