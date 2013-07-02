package org.hbird.application.halcyon.commanding;

import org.hbird.application.commanding.interfaces.processing.CommandVerificationSender.Stage;

class VerificationUpdate {
	public Stage stage;

	public long uid;

	public VerificationUpdate(Stage stage, long uid) {
		this.stage = stage;
		this.uid = uid;
	}
}