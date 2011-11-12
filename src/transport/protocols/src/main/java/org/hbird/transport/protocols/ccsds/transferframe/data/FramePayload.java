package org.hbird.transport.protocols.ccsds.transferframe.data;

import org.apache.commons.lang.ArrayUtils;

public class FramePayload {
	public byte[] payload;
	public boolean isNextFrame;
	public long timeStamp;
	
	public FramePayload(byte[] payload, boolean isNextFrame, long timeStamp) {
		this.payload = ArrayUtils.clone(payload);
		this.isNextFrame = isNextFrame;
		this.timeStamp = timeStamp;
	}
	
}
