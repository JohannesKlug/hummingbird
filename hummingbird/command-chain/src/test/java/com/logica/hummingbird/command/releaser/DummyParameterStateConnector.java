package com.logica.hummingbird.command.releaser;

import java.util.HashMap;
import java.util.Map;

import com.logica.hummingbird.interfaces.IParameterStateConnector;

public class DummyParameterStateConnector implements IParameterStateConnector {

	public Map<String, Boolean> states = new HashMap<String, Boolean>();
	
	@Override
	public boolean getState(String stateName) {
		return states.get(stateName);
	}

}
