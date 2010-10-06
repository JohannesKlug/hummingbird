package com.logica.hummingbird.validation;

import com.logica.hummingbird.validation.base.StateParameterSender;

public class DummySender extends StateParameterSender {

	public boolean sendCalled;
	public String stateName;
	public boolean stateValue;

	public void send(String stateName, boolean stateValue) {
		this.sendCalled = true;
		this.stateName = stateName;
		this.stateValue = stateValue;
	}
}
