package com.logica.hummingbird.telemetry.ccsds;

import java.util.ArrayList;
import java.util.List;

public class CcsdsTmPacketPayload {

	List<CcsdsTmParameter> parameters = new ArrayList<CcsdsTmParameter>();

	public void addParameter(CcsdsTmParameter parameter) {
		this.parameters.add(parameter);
	}
	
//	public void addParameter(CcsdsTmStringParameter parameter) {
//		this.stringParameters.add(parameter);
//	}

	public CcsdsTmParameter getParameter(String parameterName) {
		for(CcsdsTmParameter parameter : this.parameters) {
			if(parameter.getName().equals(parameterName)) {
				return parameter;
			}
		}
		
		// We never found the parameter so return null.  Maybe use exception?
		return null;
	}

	public List<CcsdsTmParameter> getTmParameters() {
		return this.parameters;
	}
	
//	public List<CcsdsTmStringParameter> getStringParameters() {
//		return this.stringParameters;
//	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmPacketPayload [\n\tparameters = ");
		builder.append(parameters);
		builder.append("\n]");
		return builder.toString();
	}


}
