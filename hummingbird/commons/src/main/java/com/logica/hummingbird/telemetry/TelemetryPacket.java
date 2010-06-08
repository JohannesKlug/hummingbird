package com.logica.hummingbird.telemetry;

public interface TelemetryPacket {
	public TelemetryPacketHeader getHeader();
	
	public TelemetryPacketPayload getPayload();
	
	public void setHeader(TelemetryPacketHeader header);
	
	public void setPayload(TelemetryPacketPayload payload);
}
