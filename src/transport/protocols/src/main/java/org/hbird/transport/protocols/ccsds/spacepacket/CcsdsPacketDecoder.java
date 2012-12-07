package org.hbird.transport.protocols.ccsds.spacepacket;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.hbird.transport.protocols.ccsds.spacepacket.data.PacketPayload;
import org.hbird.transport.protocols.ccsds.transferframe.data.FramePayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CcsdsPacketDecoder {

	private static final int CCSDS_PKT_HEADER_LENGTH = 6;

	private static final int MIN_CCSDS_PKT_LENGTH = 7;

	private static final Logger LOG = LoggerFactory.getLogger(CcsdsPacketDecoder.class);

	private byte[] packetBuffer = ArrayUtils.EMPTY_BYTE_ARRAY;

	public synchronized List<PacketPayload> decode(final FramePayload framePayload) {

		LOG.debug("Decoding");

		// FIXME check for null framePayload

		List<PacketPayload> payloads = new ArrayList<PacketPayload>();
		byte[] packet = ArrayUtils.clone(framePayload.payload);
		boolean isNextPacket = framePayload.isNextFrame;

		if (!isNextPacket) {
			// this is not the next packet in sequence
			// clear the packet buffer
			packetBuffer = ArrayUtils.EMPTY_BYTE_ARRAY;
			// packetBuffer = new byte[0];
		}

		LOG.debug("Packet Buffer is now " + packetBuffer.length + " bytes long.");
		packetBuffer = ArrayUtils.addAll(packetBuffer, packet);
		LOG.debug("Packet Buffer is now " + packetBuffer.length + " bytes long.");

		// the minimum defined length for a packet is 7 bytes (6 bytes in the header, 1 byte payload)
		if (packetBuffer.length < MIN_CCSDS_PKT_LENGTH) {
			return null;
		}

		byte[] primaryHeader = ArrayUtils.subarray(packetBuffer, 0, CCSDS_PKT_HEADER_LENGTH);

		int payloadOffset = CCSDS_PKT_HEADER_LENGTH;

		int packetVersionNumber = ((0xE0 & primaryHeader[0]) & 0xFF) >>> 5;

		if (packetVersionNumber != 0) {
			LOG.error("Packet with invalid version number encountered. Version number was: " + packetVersionNumber);
			packetBuffer = new byte[0];
			return null;
		}

		String packetType;
		if ((0x10 & primaryHeader[0]) == 0x10) {
			packetType = "TC";
		}
		else {
			packetType = "TM";
		}
		LOG.debug("Packet Type: " + packetType);

		// FIXME Figure this out
		// check for secondary header flag (5th bit in primary header

		int apidHighByte = (0x07 & primaryHeader[0]) << 8;
		int apidLowByte = 0xFF & primaryHeader[1];
		int apid = apidHighByte + apidLowByte;
		LOG.debug("Apid: " + apid);

		int packetSequenceFlags = (0xC0 & primaryHeader[2]) >> CCSDS_PKT_HEADER_LENGTH;
		LOG.debug("Packet Sequence Flags: " + packetSequenceFlags);

		int packetSequenceCountOrPacketNameHighByte = (0x3F & primaryHeader[2]) << Byte.SIZE;
		int packetSequenceCountOrPacketNameLowByte = 0xFF & primaryHeader[3];
		int packetSequenceCountOrPacketName = packetSequenceCountOrPacketNameHighByte + packetSequenceCountOrPacketNameLowByte;
		LOG.debug("Packet Sequence Count or Packet Name: " + packetSequenceCountOrPacketName);

		int packetDataLengthHighByte = (0xFF & primaryHeader[4]) << Byte.SIZE;
		int packetDataLengthLowByte = 0xFF & primaryHeader[5];
		int packetDataLength = packetDataLengthHighByte + packetDataLengthLowByte + 1;
		LOG.debug("Packet Data Length: " + packetDataLength);

		int payloadEnd = payloadOffset + packetDataLength;

		byte[] packetPayload = ArrayUtils.subarray(packetBuffer, payloadOffset, payloadEnd);

		// add the current payload
		payloads.add(new PacketPayload(apid, packetPayload, framePayload.timeStamp));

		if (packetBuffer.length >= (payloadEnd)) {
			// Buffer is not empty yet, recurse!

			// put the rest into the packet buffer and reprocess
			packetBuffer = ArrayUtils.subarray(packetBuffer, payloadEnd, packetBuffer.length);

			// pass an empty byte array to ourselves.
			// Recursion, yeah!
			List<PacketPayload> morePayloads = this.decode(new FramePayload(ArrayUtils.EMPTY_BYTE_ARRAY, true, System.currentTimeMillis()));
			if (morePayloads != null) {
				payloads.addAll(morePayloads);
			}
		}
		return payloads;
	}
}
