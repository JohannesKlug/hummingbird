package com.logica.hummingbird.framebroker;

public class FramePayload {
	public int vcId;
	public byte[] payload;
	
	public FramePayload(int vcId, byte[] payload) {
		this.vcId = vcId;
		this.payload = payload;
	}

}
