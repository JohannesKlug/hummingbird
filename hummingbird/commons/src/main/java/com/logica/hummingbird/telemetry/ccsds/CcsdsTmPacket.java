package com.logica.hummingbird.telemetry.ccsds;

import com.logica.hummingbird.telemetry.TelemetryPacket;
import com.logica.hummingbird.telemetry.TelemetryPacketHeader;
import com.logica.hummingbird.telemetry.TelemetryPacketPayload;

public class CcsdsTmPacket implements TelemetryPacket {    
    TelemetryPacketHeader packetHeader = new CcsdsTmPacketHeader();
    
    TelemetryPacketPayload payload = new CcsdsTmPacketPayload();

	@Override
	public TelemetryPacketHeader getHeader() {
		return this.packetHeader;
	}

	@Override
	public TelemetryPacketPayload getPayload() {
		return this.payload;
	}

	@Override
	public void setHeader(TelemetryPacketHeader header) {
		this.packetHeader = header;
	}

	@Override
	public void setPayload(TelemetryPacketPayload payload) {
		this.payload = payload;		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmPacket [packetHeader=");
		builder.append(packetHeader);
		builder.append(", payload=");
		builder.append(payload);
		builder.append("]");
		return builder.toString();
	}	

	
}
