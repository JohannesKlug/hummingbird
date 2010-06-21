package com.logica.hummingbird.telemetry.ccsds;


public class CcsdsTmPacket {    
    CcsdsTmPacketHeader packetHeader = new CcsdsTmPacketHeader();
    
    CcsdsTmPacketPayload payload = new CcsdsTmPacketPayload();

	public CcsdsTmPacketHeader getHeader() {
		return this.packetHeader;
	}

	public CcsdsTmPacketPayload getPayload() {
		return this.payload;
	}

	public void setHeader(CcsdsTmPacketHeader header) {
		this.packetHeader = header;
	}

	public void setPayload(CcsdsTmPacketPayload payload) {
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
