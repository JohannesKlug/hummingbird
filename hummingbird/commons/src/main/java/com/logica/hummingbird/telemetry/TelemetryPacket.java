package com.logica.hummingbird.telemetry;

public interface TelemetryPacket {
	public CcsdsTelemetryPacketHeader getHeader();
	
	public TelemetryPacketPayload getPayload();
	
	public void setHeader(CcsdsTelemetryPacketHeader header);
	
	public void setPayload(TelemetryPacketPayload payload);
}
