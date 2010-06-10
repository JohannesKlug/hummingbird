package com.logica.hummingbird.telemetry.ccsds;

import com.logica.hummingbird.telemetry.TelemetryPacket;
import com.logica.hummingbird.telemetry.CcsdsTelemetryPacketHeader;
import com.logica.hummingbird.telemetry.TelemetryPacketPayload;

public class CcsdsTmPacket implements TelemetryPacket {    
    CcsdsTelemetryPacketHeader packetHeader = new CcsdsTmPacketHeader();
    
    TelemetryPacketPayload payload = new CcsdsTmPacketPayload();

	@Override
	public CcsdsTelemetryPacketHeader getHeader() {
		return this.packetHeader;
	}

	@Override
	public TelemetryPacketPayload getPayload() {
		return this.payload;
	}

	@Override
	public void setHeader(CcsdsTelemetryPacketHeader header) {
		this.packetHeader = header;
	}

	@Override
	public void setPayload(TelemetryPacketPayload payload) {
		this.payload = payload;		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmPacket [\n\tpacketHeader = ");
		builder.append(packetHeader);
		builder.append("\n\tpayload = ");
		builder.append(payload);
		builder.append("\n]");
		return builder.toString();
	}



	
}
