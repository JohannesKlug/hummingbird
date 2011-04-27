package org.hbird.transport.protocols.ccsds.transferframe;

public class CcsdsFramePayload extends FramePayload {
	
	public int spacecraftId;
	public int virtualChannelId;

	public CcsdsFramePayload(int spacecraftId, int virtualChannelId, byte[] payload, boolean isNextFrame) {
		super(payload, isNextFrame);
		this.spacecraftId = spacecraftId;
		this.virtualChannelId = virtualChannelId;
	}

}
