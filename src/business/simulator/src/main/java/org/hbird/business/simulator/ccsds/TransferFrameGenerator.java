package org.hbird.business.simulator.ccsds;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

public class TransferFrameGenerator {
	private int masterChannelFrameCount = 0;
	private int privateChannelFrameCount = 0;
	
	List<byte[]> generateTransferFrames(int virtualChannelId, byte[] payload) {
		
		/*
		 * This generator uses the longest frame defined in CCSDS 131
		 * 16384 bits = 2048 octets
		 * of which the first 6 octets are the primary header
		 * Secondary header, OCF and Error Control Field are not used
		 */
		
		List<byte[]> frames = new ArrayList<byte[]>();
		
		int payloadPerFrame = 2048-6;
		
		int numberOfFrames = (payload.length / payloadPerFrame) + 1;
		
		for (int i = 0; i < numberOfFrames; i++) {
			// Primary Header portion
			byte[] frame = new byte[6];
			
			
			// add the payload
			byte[] currentPayload = ArrayUtils.subarray(payload, i*payloadPerFrame, i*payloadPerFrame+payloadPerFrame);
			
			// pad to full frame if necessary
			if (currentPayload.length < payloadPerFrame) {
				byte[] padding = new byte[payloadPerFrame-currentPayload.length];
				currentPayload = ArrayUtils.addAll(currentPayload, padding);
			}
			
			frame = ArrayUtils.addAll(frame, currentPayload);
			frames.add(frame);
		}
		
		
		
		return frames;
		
	}

}
