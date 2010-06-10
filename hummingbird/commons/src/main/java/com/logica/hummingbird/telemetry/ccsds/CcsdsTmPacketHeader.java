package com.logica.hummingbird.telemetry.ccsds;

import com.logica.hummingbird.telemetry.CcsdsTelemetryPacketHeader;

public class CcsdsTmPacketHeader implements CcsdsTelemetryPacketHeader {
	
	int apid;
	
	public CcsdsTmPacketHeader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmPacketHeader [\n\tapid = ");
		builder.append(apid);
		builder.append("\n]");
		return builder.toString();
	}

	@Override
	public void addApid(int apid) {
		this.apid = apid;
	}



}
