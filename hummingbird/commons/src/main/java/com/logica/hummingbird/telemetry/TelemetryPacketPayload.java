package com.logica.hummingbird.telemetry;

import java.util.List;

public interface TelemetryPacketPayload {

	public void addParameter(TelemetryParameter parameter);
	
	public List<TelemetryParameter> getParameters();

	public TelemetryParameter getParameter(String parameterName);
}
