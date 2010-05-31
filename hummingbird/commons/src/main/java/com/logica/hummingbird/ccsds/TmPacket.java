package com.logica.hummingbird.ccsds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TmPacket {
    List<TmParameter> parameters = new ArrayList<TmParameter>();;

    Map<String, Object> values = new HashMap<String, Object>();
    
    Integer apid; 

    public List<TmParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<TmParameter> parameters) {
		this.parameters = parameters;
	}
	
	public Map<String, Object> getValues() {
		return values;
	}
}
