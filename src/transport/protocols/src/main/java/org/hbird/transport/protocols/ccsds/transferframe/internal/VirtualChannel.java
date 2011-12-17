package org.hbird.transport.protocols.ccsds.transferframe.internal;

import org.apache.commons.lang.ArrayUtils;
import org.hbird.transport.protocols.ccsds.transferframe.CcsdsFrameDecoder;
import org.hbird.transport.protocols.ccsds.transferframe.data.CcsdsFramePayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VirtualChannel {
	private final static Logger LOG = LoggerFactory.getLogger(VirtualChannel.class);
	
	private int lastFrameCount = -1;
	private int id;
	
	public VirtualChannel(int id) {
		this.id = id;
	}
	
	public CcsdsFramePayload processPayload(int spacecraftId, byte[] payload, int frameCount, int firstHeaderPointer) {
		
		int payloadOffset = 0;
		boolean isNext;
		
		if (CcsdsFrameDecoder.isNextFrame(lastFrameCount, frameCount)) {
			isNext = true;
		} 
		else {
			// we received frames out of order
			// payload before firstHeaderPointer must be thrown away.
			payloadOffset = firstHeaderPointer;
			isNext = false;
		}
		
		lastFrameCount = frameCount;
		
		byte[] goodPayload = ArrayUtils.subarray(payload, payloadOffset, payload.length);
		LOG.debug("Passing payload of length " + goodPayload.length);
		
		return new CcsdsFramePayload(spacecraftId, id, goodPayload, isNext, System.currentTimeMillis());
	}
	
	public int getId() {
		return id;
	}
	
}
