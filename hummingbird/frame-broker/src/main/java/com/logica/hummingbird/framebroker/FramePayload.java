package com.logica.hummingbird.framebroker;

import org.apache.commons.lang.ArrayUtils;

public class FramePayload {
	public int vcId;
	public byte[] payload;
	
	public FramePayload(int vcId, byte[] payload) {
		this.vcId = vcId;
		this.payload = ArrayUtils.clone(payload);
	}

}
