package com.logica.hummingbird.telemetry;

import java.util.List;

public interface TelemetryFrame {
	
	public void setHeader(TelemetryFrameHeader header);
	
	public void setTail(TelemetryFrameTail tail);
	
	public void addPacket(TelemetryPacket packet);
	
	public void addPackets(List<TelemetryPacket> packets);

	public List<TelemetryPacket> getPackets();

}