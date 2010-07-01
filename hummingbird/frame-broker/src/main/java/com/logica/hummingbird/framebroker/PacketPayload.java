package com.logica.hummingbird.framebroker;

public class PacketPayload {
	public int apid;
	public byte[] payload;
	
	public PacketPayload(int apid, byte[] payload) {
		this.apid = apid;
		this.payload = payload;
	}

}
