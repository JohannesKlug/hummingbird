package com.logica.hummingbird.validation.parameter;

import com.logica.hummingbird.validation.TmParameterDummy;


public class UpperLimit extends BaseParameterRule {

	protected Parameter limit = null;

	public UpperLimit(Parameter parameter) {
		limit = parameter;
	}
	
	public UpperLimit(double value) {
		limit = new Parameter(value);
	}

	public boolean rule(TmParameterDummy packet) {		
		return packet.getValue() <= limit.getValue().getValue();
	}
}
