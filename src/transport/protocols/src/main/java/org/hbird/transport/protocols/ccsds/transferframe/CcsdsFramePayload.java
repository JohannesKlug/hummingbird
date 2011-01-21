package org.hbird.transport.protocols.ccsds.transferframe;

import org.apache.commons.lang.ArrayUtils;

public class CcsdsFramePayload extends FramePayload {
	public int spacecraftId;
	public int vcId;
	public byte[] payload;
	public boolean isNextFrame;
	
	public CcsdsFramePayload(int vcId, byte[] payload, boolean isNextFrame) {
		// FIXME: add scid
		//this.spacecraftId = spacecraftId;
		this.vcId = vcId;
		this.payload = ArrayUtils.clone(payload);
		this.isNextFrame = isNextFrame;
	}

}
