package com.logica.hummingbird.framebroker;

import java.util.Observable;

import org.apache.commons.lang.ArrayUtils;

public class VirtualChannel extends Observable {
	
	private int lastFrameCount = -1;
	private int id;
	
	public VirtualChannel(int id) {
		this.id = id;
	}
	
	public void addPayload(byte[] payload, int frameCount, int firstHeaderPointer) {
		
		if (CcsdsFrameDispatcher.isNextFrame(lastFrameCount, frameCount)) {
			// we can safely pass on the whole payload
			notifyObservers(new FramePayload(id, payload, true));
		} else {
			// we received frames out of order
			// payload before firstHeaderPointer must be thrown away.
			byte[] goodPayload = ArrayUtils.subarray(payload, firstHeaderPointer, payload.length);
			notifyObservers(new FramePayload(id, goodPayload, false));
		}
		lastFrameCount = frameCount;
		
		
	}
	
	public int getId() {
		return id;
	}
	
}
