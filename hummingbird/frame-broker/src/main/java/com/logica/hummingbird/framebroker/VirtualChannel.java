package com.logica.hummingbird.framebroker;

import org.apache.commons.lang.ArrayUtils;

public class VirtualChannel {
	private byte[] totalPayload = ArrayUtils.EMPTY_BYTE_ARRAY;
	
	private int lastFrameCount;
	
	public VirtualChannel() {
		reset();
	}
	
	public void addPayload(byte[] payload, int frameCount) {
		/*
		 * Checking for lastFrameCount == -1 will happen millions of times, this should probably optimised.
		 */
		if (lastFrameCount == -1) {
			lastFrameCount = frameCount;
		} else {
			if (isNextFrame(frameCount)) {
				// we can safely add the payload
				totalPayload = ArrayUtils.addAll(totalPayload, payload);
			} else {
				// we received frames out of order and have to throw away what we have
				reset();
			}
		}
		
	}
	
	private void reset() {
		totalPayload = ArrayUtils.EMPTY_BYTE_ARRAY;
		
		/**
		 * Initialise lastFrameCount with invalid value
		 */
		lastFrameCount = -1;
	}
	
	private boolean isNextFrame(int frameCount) {
		if (Math.abs((lastFrameCount-frameCount)%256) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
