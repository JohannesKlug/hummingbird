package org.hbird.transport.protocols.ccsds.transferframe.data;


public class CcsdsFramePayload extends FramePayload {
	
	public int spacecraftId;
	public int virtualChannelId;

	public CcsdsFramePayload(int spacecraftId, int virtualChannelId, byte[] payload, boolean isNextFrame, long timeStamp) {
		super(payload, isNextFrame, timeStamp);
		this.spacecraftId = spacecraftId;
		this.virtualChannelId = virtualChannelId;
	}

}
