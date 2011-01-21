package org.hbird.transport.protocols.ccsds.spacepacket;

import java.util.Observable;

import org.apache.commons.lang.ArrayUtils;
import org.hbird.transport.protocols.ccsds.transferframe.FramePayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CcsdsPacketDispatcher extends Observable{
	
	private final static Logger LOG = LoggerFactory.getLogger(CcsdsPacketDispatcher.class);
	
	private byte[] packetBuffer = ArrayUtils.EMPTY_BYTE_ARRAY;

	public void process(FramePayload framePayload) {
		
		byte[] packet = ArrayUtils.clone(framePayload.payload);
		boolean isNextPacket = framePayload.isNextFrame;
		
		if (!isNextPacket) {
			// this is not the next packet in sequence
			// clear the packet buffer
			packetBuffer = ArrayUtils.EMPTY_BYTE_ARRAY;
//			packetBuffer = new byte[0];
		}
		
		packetBuffer = ArrayUtils.addAll(packetBuffer, packet);
		LOG.debug("Packet Buffer is now " + packetBuffer.length + " bytes long.");
		
		// the minimum defined length for a packet is 7 bytes (6 bytes in the header, 1 byte payload)
		if (packetBuffer.length < 7) {
			return;
		}
		
		byte[] primaryHeader = ArrayUtils.subarray(packetBuffer, 0, 6);
		
		int payloadOffset = 6;
		
		int packetVersionNumber = ((0xE0 & primaryHeader[0]) & 0xFF) >>> 5;
		
		if (packetVersionNumber != 0) {
			LOG.error("Packet with invalid version number encountered. Version number was: " + packetVersionNumber);
			packetBuffer = new byte[0];
			return;
		}
		
		String packetType;
		if ((0x10 & primaryHeader[0]) == 0x10) {
			packetType = "TC";
		} else {
			packetType = "TM";
		}
		LOG.debug("Packet Type: " + packetType);
		
		// check for secondary header flag (5th bit in primary header
		if ((0x08 & primaryHeader[0]) == 0x08) {
			// Not sure how to handle secondary header: where to get its length?
			// payloadOffset += ??
		}
		
		int apidHighByte = (0x07 & primaryHeader[0]) << 8;
		int apidLowByte = 0xFF & primaryHeader[1];
		int apid = apidHighByte + apidLowByte;
		LOG.debug("Apid: " + apid);
		
		int packetSequenceFlags = (0xC0 & primaryHeader[2]) >> 6;
		LOG.debug("Packet Sequence Flags: " + packetSequenceFlags);
		
		int packetSequenceCountOrPacketNameHighByte = (0x3F &primaryHeader[2]) << 8;
		int packetSequenceCountOrPacketNameLowByte = 0xFF & primaryHeader[3];
		int packetSequenceCountOrPacketName = packetSequenceCountOrPacketNameHighByte + packetSequenceCountOrPacketNameLowByte;
		LOG.debug("Packet Sequence Count or Packet Name: " + packetSequenceCountOrPacketName);
		
		
		
		int packetDataLengthHighByte = (0xFF & primaryHeader[4]) << 8;
		int packetDataLengthLowByte = 0xFF & primaryHeader[5];
		int packetDataLength = packetDataLengthHighByte + packetDataLengthLowByte + 1;
		LOG.debug("Packet Data Length: " + packetDataLength);
		
		int payloadEnd = payloadOffset + packetDataLength;
		
		if (packetBuffer.length < (6 + payloadEnd)) {
			// Not enough bytes in packetBuffer, return and wait for more data
			return;
		}
		
		byte[] packetPayload = ArrayUtils.subarray(packetBuffer, payloadOffset, payloadEnd);
		
		// return the current payload
		setChanged();
		notifyObservers(new PacketPayload(apid, packetPayload));
		
		// put the rest into the packet buffer and reprocess
		packetBuffer = ArrayUtils.subarray(packetBuffer, payloadEnd, packetBuffer.length);

		// pass an empty byte array to ourself.
		// Recursion, yeah!
		this.process(new FramePayload(ArrayUtils.EMPTY_BYTE_ARRAY, true));
		
		
		
	}
}
