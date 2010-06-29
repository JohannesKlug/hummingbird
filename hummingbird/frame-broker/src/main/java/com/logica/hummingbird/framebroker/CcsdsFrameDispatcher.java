package com.logica.hummingbird.framebroker;

import java.util.Observable;

import org.apache.commons.lang.ArrayUtils;

import com.logica.hummingbird.framebroker.exceptions.InvalidFrameLengthException;

public class CcsdsFrameDispatcher extends Observable {

	
	public final static int FRAME_LENGTH_IN_OCTETS = 1115;
	/**
	 * For now, we consider frames to be of the maximum allowed length, i.e. 16384 bits or 2048 octets.
	 */
	//public final static int FRAME_LENGTH_IN_OCTETS = 16384 / 8;
	
	/**
	 * For now, we expect operational control (4 octets) field and error control field  (2 octets) to be present. 
	 */
	private final static int PAYLOAD_END = FRAME_LENGTH_IN_OCTETS - 4 - 2;
	
	private VirtualChannel[] virtualChannel = new VirtualChannel[8];
	
	public CcsdsFrameDispatcher() {
		
		/*
		 * Create 8 VirtualChannels, accessed using their array index.
		 */
		for (int i=0; i<8; i++) {
			virtualChannel[i] = new VirtualChannel();
		}
		
	}
	
	
	public void process(byte[] frame) throws InvalidFrameLengthException {
		
		/*
		 * Check for Frame Length
		 */
		if (frame.length != FRAME_LENGTH_IN_OCTETS) {
			throw new InvalidFrameLengthException("Expected Frame length in bytes: " + FRAME_LENGTH_IN_OCTETS
					+ ", actual frame length: " + frame.length);
		}
		
		
		/*
		 * Check for CRC erros
		 */
		if (crcValid(frame) == false) {
			return;
		}
		
		
		/*
		 * Transfer Frame Primary Header = 6 octets (mandatory)
		 * Transfer Frame Data Field Status = 2 octets (mandatory)
		 * Transfer Frame Secondary Header = 1 - 64 octets (optional)
		 * 
		 * Transfer Frame Data Field = 
		 * * integral number of octets.
		 * * 
		 * 
		 * Operational Control Field = 4 octets (optional)
		 * Frame Error Control Field = 2 octets (optional)
		 */
		
		byte[] primaryHeader;
		byte[] secondaryHeader;
		byte[] dataFieldStatus;
		
		primaryHeader = ArrayUtils.subarray(frame, 0, 6);
		
		int virtualChannelId = (0x0E & primaryHeader[1])>>1;
		
		dataFieldStatus = ArrayUtils.subarray(frame, 6, 8);
		
		
		int firstHeaderPointerHighByte = (0x03 & dataFieldStatus[0]) >> 8;
		int firstHeaderPointerLowByte = 0xFF & dataFieldStatus[1];
		
		int firstHeaderPointer = firstHeaderPointerHighByte + firstHeaderPointerLowByte;
		
		int masterChannelFrameCount = primaryHeader[2];
		int virtualChannelFrameCount = primaryHeader[3];
		
		
		int payloadOffset = 8;
		
		// check for secondary header flag (1st bit in dataFieldStatus
		if ((0x80 & dataFieldStatus[0]) == 0x80) {
			// secondary header present
			
			byte secondaryHeaderStatus = frame[8];
			
			/*
			 * Secondary Header Version Number (first two bits of sec hdr status) is UNUSED.
			 */
			
			/* 
			 * actual header length is one less than that.
			 * Since ArrayUtils uses
			 */ 
			int secondaryHeaderLength = (0x3F & secondaryHeaderStatus) - 1;
			
			secondaryHeader = ArrayUtils.subarray(frame, 9, 9 + secondaryHeaderLength);
			
			payloadOffset = 9 + secondaryHeaderLength;

		}
		
		byte[] payload = ArrayUtils.subarray(frame, payloadOffset, PAYLOAD_END);
		
		virtualChannel[virtualChannelId].addPayload(payload, virtualChannelFrameCount, firstHeaderPointer);
		
		
		byte[] operationalControlField = ArrayUtils.subarray(frame, PAYLOAD_END, PAYLOAD_END + 4);
		byte[] errorControlField = ArrayUtils.subarray(frame, PAYLOAD_END + 4, PAYLOAD_END + 4 +2);
		
		
	}
	
	private boolean crcValid(byte[] frame) {
		// FIXME Implement CRC checking here.
		return true;
	}
	
	public static boolean isNextFrame(int lastFrameCount, int frameCount) {
		if (Math.abs((lastFrameCount-frameCount)%256) == 1) {
			return true;
		} else {
			return false;
		}
	}
	

}
