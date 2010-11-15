package org.hbird.protocols.ccsds.transferframe;

import org.apache.commons.lang.ArrayUtils;

public class FramePayload {
	public int spacecraftId;
	public int vcId;
	public byte[] payload;
	public boolean isNextFrame;
	
	public FramePayload(int vcId, byte[] payload, boolean isNextFrame) {
		this.vcId = vcId;
		this.payload = ArrayUtils.clone(payload);
		this.isNextFrame = isNextFrame;
	}

}
