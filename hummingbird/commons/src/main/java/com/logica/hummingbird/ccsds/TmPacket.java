package com.logica.hummingbird.ccsds;

import java.util.ArrayList;
import java.util.List;

public class TmPacket {
    List<TmParameter> parameters = new ArrayList<TmParameter>();;

	public List<TmParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<TmParameter> parameters) {
		this.parameters = parameters;
	}
}
