package com.logica.hummingbird.telemetry.ccsds;

import java.util.ArrayList;
import java.util.List;

import com.logica.hummingbird.telemetry.TelemetryPacketPayload;
import com.logica.hummingbird.telemetry.TelemetryParameter;

public class CcsdsTmPacketPayload implements TelemetryPacketPayload {

	List<TelemetryParameter> parameters = new ArrayList<TelemetryParameter>();

	@Override
	public void addParameter(TelemetryParameter parameter) {
		this.parameters.add(parameter);
	}

	@Override
	public TelemetryParameter getParameter(String parameterName) {
		for(TelemetryParameter parameter : this.parameters) {
			if(parameter.getName().equals(parameterName)) {
				return parameter;
			}
		}
		
		// We never found the parameter so return null.  Maybe use exception?
		return null;
	}

	@Override
	public List<TelemetryParameter> getParameters() {
		return this.parameters;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmPacketPayload [\n\tparameters = ");
		builder.append(parameters);
		builder.append("\n]");
		return builder.toString();
	}


}
