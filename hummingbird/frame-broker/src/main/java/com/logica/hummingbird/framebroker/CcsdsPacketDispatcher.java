package com.logica.hummingbird.framebroker;

import java.util.Observable;

import org.apache.commons.lang.ArrayUtils;
import org.fusesource.commons.management.Statistic.UpdateMode;

public class CcsdsPacketDispatcher extends Observable{

	public void process(byte[] packet) {
		
		byte[] primaryHeader = ArrayUtils.subarray(packet, 0, 6);
		
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
		
		byte[] packetPayload = ArrayUtils.subarray(packet, payloadOffset, packetDataLength);
		
		notifyObservers(new PacketPayload(apid, packetPayload));
		
		
		
	}
}
