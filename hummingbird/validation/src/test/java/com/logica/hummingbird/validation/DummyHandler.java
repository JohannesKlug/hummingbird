package com.logica.hummingbird.validation;

import com.logica.hummingbird.validation.base.ISender;

public class DummyHandler implements ISender {
	
	boolean violationCalled = false;
	
	String stateName = null;
	String parameterName = null;
	boolean check = false;
	
	public void send(String stateName, boolean check) {
		violationCalled = true;
		
		this.stateName = stateName;
		this.check = check;
	}
}
