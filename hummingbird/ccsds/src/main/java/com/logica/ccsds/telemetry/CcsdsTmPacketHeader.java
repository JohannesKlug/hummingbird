package com.logica.ccsds.telemetry;


public class CcsdsTmPacketHeader {
	
	protected int apid;
	
	public CcsdsTmPacketHeader() {
		// TODO Auto-generated constructor stub
	}
	
	public int getApid() {
		return this.apid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmPacketHeader [\n\tapid = ");
		builder.append(apid);
		builder.append("\n]");
		return builder.toString();
	}

}
