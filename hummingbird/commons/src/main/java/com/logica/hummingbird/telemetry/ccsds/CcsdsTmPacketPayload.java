package com.logica.hummingbird.telemetry.ccsds;

import java.util.ArrayList;
import java.util.List;

public class CcsdsTmPacketPayload {

	List<CcsdsTmNumberParameter> numberParameters = new ArrayList<CcsdsTmNumberParameter>();
	List<CcsdsTmStringParameter> stringParameters = new ArrayList<CcsdsTmStringParameter>();

	public void addParameter(CcsdsTmNumberParameter parameter) {
		this.numberParameters.add(parameter);
	}
	
	public void addParameter(CcsdsTmStringParameter parameter) {
		this.stringParameters.add(parameter);
	}

	public CcsdsTmNumberParameter getParameter(String parameterName) {
		for(CcsdsTmNumberParameter parameter : this.numberParameters) {
			if(parameter.getName().equals(parameterName)) {
				return parameter;
			}
		}
		
		// We never found the parameter so return null.  Maybe use exception?
		return null;
	}

	public List<CcsdsTmNumberParameter> getNumberParameters() {
		return this.numberParameters;
	}
	
	public List<CcsdsTmStringParameter> getStringParameters() {
		return this.stringParameters;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmPacketPayload [\n\tparameters = ");
		builder.append(numberParameters);
		builder.append("\n]");
		return builder.toString();
	}


}
