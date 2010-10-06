package com.logica.hummingbird.validation.base;

import java.util.HashMap;
import java.util.Map;

public class OnlyChangeFilter implements ISender {

	protected ISender sender = null;
	
	protected Map<String, Boolean> currentState = new HashMap<String, Boolean>();
	
	public void send(String stateName, boolean stateValue) {
		
		if (currentState.containsKey(stateName) == true) {
			if (currentState.get(stateName) != stateValue) {
				currentState.put(stateName, stateValue);
				sender.send(stateName, stateValue);
			}
			else {
				// TODO Log message that the state change was filtered out.
			}
		}
		else {
			currentState.put(stateName, stateValue);
			sender.send(stateName, stateValue);
		}
	}

	public ISender getSender() {
		return sender;
	}

	public void setSender(ISender sender) {
		this.sender = sender;
	}
}
