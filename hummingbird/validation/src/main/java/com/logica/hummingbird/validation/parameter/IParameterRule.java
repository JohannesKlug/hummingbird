package com.logica.hummingbird.validation.parameter;

import com.logica.hummingbird.validation.TmParameterDummy;

public interface IParameterRule {
	public void check(TmParameterDummy parameter);
	public boolean rule(TmParameterDummy parameter);
}
