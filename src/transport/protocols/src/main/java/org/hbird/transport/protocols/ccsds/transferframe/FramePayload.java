package org.hbird.transport.protocols.ccsds.transferframe;

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
	
	public String toString() {
		return "Spacecraft ID: " + spacecraftId
		+ ", virtual channel: " + vcId 
		+ ", payload" + ArrayUtils.toString(payload)
		+ ", isNextFrame: " + isNextFrame;
	}

}
