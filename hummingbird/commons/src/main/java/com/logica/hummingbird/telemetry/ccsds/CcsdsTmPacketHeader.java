package com.logica.hummingbird.telemetry.ccsds;


public class CcsdsTmPacketHeader {
	
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

	public void addApid(int apid) {
		this.apid = apid;
	}



}
