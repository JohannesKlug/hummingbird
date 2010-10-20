package com.logica.hummingbird.framebroker;

import org.apache.commons.lang.ArrayUtils;

public class PacketPayload {
	public int apid;
	public byte[] payload;
	
	public PacketPayload(int apid, byte[] payload) {
		this.apid = apid;
		this.payload = ArrayUtils.clone(payload);
	}

}
