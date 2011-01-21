package org.hbird.transport.protocols.ccsds.transferframe;

import org.apache.commons.lang.ArrayUtils;

public class FramePayload {
	public byte[] payload;
	public boolean isNextFrame;
	
	public FramePayload(byte[] payload, boolean isNextFrame) {
		this.payload = ArrayUtils.clone(payload);
		this.isNextFrame = isNextFrame;
	}
	
	public FramePayload() {}


}
