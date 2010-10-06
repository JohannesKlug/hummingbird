package com.logica.hummingbird.validation.parameter;


import com.logica.hummingbird.validation.TmParameterDummy;
import com.logica.hummingbird.validation.base.ISender;

public abstract class BaseParameterRule implements IParameterRule {

	protected ISender sender = null;

	public abstract boolean rule(TmParameterDummy parameter);
	
	protected String ruleName = "Unknown";
	protected String stateName = "Unknown";
	
	public void check(TmParameterDummy parameter) {
		forward(rule(parameter), parameter);
	}
	
	protected void forward(boolean check, TmParameterDummy parameter) {
		sender.send(stateName, check);
	}

	public ISender getSender() {
		return sender;
	}

	public void setSender(ISender sender) {
		this.sender = sender;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}
