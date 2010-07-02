package com.logica.hummingbird.framebroker;

import java.util.Observable;

import org.apache.commons.lang.ArrayUtils;

public class CcsdsPacketDispatcher extends Observable{
	
	private byte[] packetBuffer = ArrayUtils.EMPTY_BYTE_ARRAY;

	public void process(byte[] packet, boolean isNextPacket) {
		
		if (!isNextPacket) {
			// this is not the next packet in sequence
			// clear the packet buffer
			packetBuffer = ArrayUtils.EMPTY_BYTE_ARRAY;
		}
		
		packetBuffer = ArrayUtils.addAll(packetBuffer, packet);
		
		// the minimum defined length for a packet is 7 bytes (6 bytes in the header, 1 byte payload)
		if (packetBuffer.length < 7) {
			return;
		}
		
		byte[] primaryHeader = ArrayUtils.subarray(packetBuffer, 0, 6);
		
		int payloadOffset = 6;
		
		int packetVersionNumber = ((0xE0 & primaryHeader[0]) & 0xFF) >>> 5;
		
		String packetType;
		if ((0x10 & primaryHeader[0]) == 0x10) {
			packetType = "TC";
		} else {
			packetType = "TM";
		}
		
		// check for secondary header flag (5th bit in primary header
		if ((0x08 & primaryHeader[0]) == 0x08) {
			// Not sure how to handle secondary header: where to get its length?
			// payloadOffset += ??
		}
		
		int apidHighByte = (0x07 & primaryHeader[0]) << 8;
		int apidLowByte = 0xFF & primaryHeader[1];
		int apid = apidHighByte + apidLowByte;
		
		int packetDataLengthHighByte = (0xFF & primaryHeader[4]) << 8;
		int packetDataLengthLowByte = 0xFF & primaryHeader[5];
		int packetDataLength = packetDataLengthHighByte + packetDataLengthLowByte + 1;
		
		int payloadEnd = payloadOffset + packetDataLength;
		
		if (packetBuffer.length < (6 + payloadEnd)) {
			// Not enough bytes in packetBuffer, return and wait for more data
			return;
		}
		
		byte[] packetPayload = ArrayUtils.subarray(packetBuffer, payloadOffset, payloadEnd);
		
		// return the current payload
		notifyObservers(new PacketPayload(apid, packetPayload));
		
		// put the rest into the packet buffer and reprocess
		packetBuffer = ArrayUtils.subarray(packetBuffer, payloadEnd, packetBuffer.length);

		// pass an empty byte array to ourself.
		// Recursion, yeah!
		this.process(ArrayUtils.EMPTY_BYTE_ARRAY, true);
		
		
		
	}
}
