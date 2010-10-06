package com.logica.hummingbird.validation.parameter;

import com.logica.hummingbird.validation.TmParameterDummy;

public class LowerLimit extends BaseParameterRule {

	protected Parameter limit = null;

	public LowerLimit(Parameter parameter) {
		limit = parameter;
	}

	public LowerLimit(double value) {
		limit = new Parameter(value);
	}

	public boolean rule(TmParameterDummy packet) {		
		return limit.getValue().getValue() <= packet.getValue();
	}
}
