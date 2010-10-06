package com.logica.hummingbird.validation.packet;

import java.util.ArrayList;
import java.util.List;


import com.logica.hummingbird.validation.TmPacketDummy;
import com.logica.hummingbird.validation.parameter.Parameter;

public class Packet {

	protected List<IPacketRule> rules = new ArrayList<IPacketRule>();
	
	/** Children of this parameter, i.e. parameters that depends on this one. A check of this 
	 *  parameter will automatically lead to a check of these as well. */
	protected List<Parameter> children = new ArrayList<Parameter>();

	protected TmPacketDummy packet = null;
	
	public void check(TmPacketDummy packet) {

		this.packet = packet;

		/** Iterate through the rules and check whether they are valid. If not, then they will 
		 *  trigger value changes in the parameter state parameters. */
		for (IPacketRule rule : rules) {						
			rule.check(packet);
		}
	}

	public void addRule(IPacketRule rule) {
		rules.add(rule);
	}
}
