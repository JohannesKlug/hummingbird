package org.hbird.application.commanding.interfaces.processing;

public interface CommandVerificationSender {

	enum Stage {
		ACCEPTED, EXECUTED, COMPLETE
	};

	void sendUpdate(Stage stage, long uid);

}
