package org.hbird.application.commanding.interfaces.processing;

import java.util.UUID;

import org.hbird.application.commanding.provided.processing.CommandVerificationStage;
import org.hbird.application.commanding.provided.processing.VerificationUpdate;

public interface CommandVerificationSender {

	void sendUpdate(VerificationUpdate verificationUpdate);

	void sendUpdate(CommandVerificationStage stage, UUID uid);

	// FIXME Remove this after debugging.
	void sendUpdate(String test);

}
