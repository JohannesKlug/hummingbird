package org.hbird.application.commanding.provided.processing;

import java.io.Serializable;
import java.util.UUID;

public class VerificationUpdate implements Serializable {
	private static final long serialVersionUID = -5194052745385245449L;

	public CommandVerificationStage stage;

	public UUID uid;

	public VerificationUpdate(CommandVerificationStage stage, UUID uid) {
		this.stage = stage;
		this.uid = uid;
	}
}