package com.logica.hummingbird.validation.packet;


import com.logica.hummingbird.validation.TmPacketDummy;
import com.logica.hummingbird.validation.base.ISender;

public abstract class BasePacketRule implements IPacketRule{
	protected ISender sender = null;

	public abstract boolean rule(TmPacketDummy parameter);
	
	protected String ruleName = "";
	protected String stateName = "";
	
	public void check(TmPacketDummy parameter) {
		forward(rule(parameter), parameter);
	}
	
	protected void forward(boolean check, TmPacketDummy parameter) {
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
