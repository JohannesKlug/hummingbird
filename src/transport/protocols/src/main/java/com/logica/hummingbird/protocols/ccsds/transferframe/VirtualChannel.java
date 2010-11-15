package com.logica.hummingbird.protocols.ccsds.transferframe;

import java.util.Observable;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VirtualChannel extends Observable {
	private final static Logger LOG = LoggerFactory.getLogger(VirtualChannel.class);
	
	private int lastFrameCount = -1;
	private int id;
	
	public VirtualChannel(int id) {
		this.id = id;
	}
	
	public void addPayload(byte[] payload, int frameCount, int firstHeaderPointer) {
		
		if (this.countObservers() < 1) {
			LOG.error("VirtualChannel " + id + " has no observers! This is an error.");
		}
		
		int payloadOffset = 0;
		boolean isNext;
		
		if (CcsdsFrameDispatcher.isNextFrame(lastFrameCount, frameCount)) {
			isNext = true;
		} else {
			// we received frames out of order
			// payload before firstHeaderPointer must be thrown away.
			payloadOffset = firstHeaderPointer;
			isNext = false;
		}
		
		lastFrameCount = frameCount;
		
		byte[] goodPayload = ArrayUtils.subarray(payload, payloadOffset, payload.length);
		LOG.debug("Passing payload of length " + goodPayload.length);
		
		this.setChanged();
		notifyObservers(new FramePayload(id, goodPayload, isNext));
		
		
	}
	
	public int getId() {
		return id;
	}
	
}
