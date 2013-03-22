package org.hbird.transport.protocols.ccsds.transferframe;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.hbird.transport.protocols.ccsds.spacepacket.exceptions.InvalidApIdException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidOperationalControlFieldException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidSpacecraftIdException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidVirtualChannelIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CcsdsFrameEncoder {
	private final static Logger LOG = LoggerFactory.getLogger(CcsdsFrameEncoder.class);

	private final int frameLength;

	private int masterChannelFrameCount = 0;
	private final int[] virtualChannelFrameCount = new int[8];

	private final int defaultSpacecraftId = 0;
	private final int defaultVirtualChannelId = 0;

	public CcsdsFrameEncoder(final int frameLength) {
		this.frameLength = frameLength;
		for (@SuppressWarnings("unused")
		int vcfc : virtualChannelFrameCount) {
			vcfc = 0;
		}
	}

	public List<byte[]> encodeFrames(final byte[] payload) throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException,
			InvalidOperationalControlFieldException {
		return encodeFrames(defaultSpacecraftId, defaultVirtualChannelId, payload);
	}

	public List<byte[]> encodeFrames(final int spacecraftId, final int virtualChannelId, final byte[] payload) throws InvalidVirtualChannelIdException,
			InvalidSpacecraftIdException, InvalidOperationalControlFieldException {
		return encodeFrames(spacecraftId, virtualChannelId, null, payload);
	}

	/**
	 * Given a number of Transfer Frame constituents, this function encodes one or many valid CCSDS Transfer Frames.
	 * 
	 * Unsupported constituents of the Transfer Frame: * Transfer Frame Version Number (2 bits) shall be 00 according to
	 * spec. * OCF flag * OCF * secondary header * synch flag * Packet Order flag (shall be 0 anyway as per the spec) *
	 * 
	 * @param spacecraftId
	 * @param virtualChannelId
	 * @return a valid CCSDS Transfer Frame
	 * @throws InvalidVirtualChannelIdException
	 * @throws InvalidApIdException
	 * @throws InvalidOperationalControlFieldException
	 */
	public synchronized List<byte[]> encodeFrames(final int spacecraftId, final int virtualChannelId, final byte[] operationalControlField, byte[] payload)
			throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException, InvalidOperationalControlFieldException {

		// perform input sanity checks

		if (virtualChannelId < 0 || virtualChannelId > 7) {
			throw new InvalidVirtualChannelIdException(virtualChannelId);
		}

		if (spacecraftId < 0 || spacecraftId > 1023) {
			throw new InvalidSpacecraftIdException(spacecraftId);
		}

		boolean ocfPresent = false;
		if (operationalControlField == null || operationalControlField.length == 0) {
			LOG.trace("OCF not present");
		}
		else if (operationalControlField.length == 4) {
			LOG.trace("OCF present and of correct size");
			ocfPresent = true;
		}
		else {
			// OCF present but of wrong size (MUST be 4 bytes as per the spec.
			throw new InvalidOperationalControlFieldException(operationalControlField.length);
		}

		if (payload == null) {
			payload = new byte[1];
		}

		if (payload.length == 0) {
			payload = ArrayUtils.add(payload, (byte) 0);
		}

		// end input sanity checks

		/** this is what we'll eventually return */
		List<byte[]> frames = new ArrayList<byte[]>();

		/** this denotes the current offset at which to begin copying the frame payload */
		int payloadOffset = 0;

		while (payloadOffset < payload.length) {
			byte[] currentFrame = new byte[frameLength];

			byte spacecraftIdHighByte = (byte) ((spacecraftId & 0x3f0) >> 4);
			byte spacecraftIdLowByte = (byte) ((spacecraftId & 0xF) << 4);

			// set Spacecraft ID
			currentFrame[0] = spacecraftIdHighByte;
			currentFrame[1] = spacecraftIdLowByte;

			// set Virtual Channel ID
			currentFrame[1] = (byte) (((virtualChannelId & 0x7) << 1) ^ currentFrame[1]);

			// set Operational Control Field flag
			// FIXME will this handle null?
			if (ArrayUtils.isNotEmpty(operationalControlField)) {
				currentFrame[1] = (byte) (1 ^ currentFrame[1]);
			}
			else {
				currentFrame[1] = (byte) (0 ^ currentFrame[1]);
			}

			// set frame counters
			currentFrame[2] = (byte) (masterChannelFrameCount & 0xFF);
			currentFrame[3] = (byte) (virtualChannelFrameCount[virtualChannelId] & 0xFF);

			// Transfer Frame Data Field Status
			/*
			 * 1 bit Secondary Header Flag 1 bit Synch Flag 1 bit Packet Order Flag 2 bit Segment Length ID 11 bits
			 * First Header Pointer
			 */

			// increment frame counters
			masterChannelFrameCount = (masterChannelFrameCount + 1) % 256;
			virtualChannelFrameCount[virtualChannelId] = (virtualChannelFrameCount[virtualChannelId] + 1) % 256;

			// Transfer Frame Data Field Status (bytes 4 and 5)
			// 1 bit Secondary Header Flag (0, not supported yet)
			// 1 bit Synch Flag (0 for packet and idle data)
			// 1 bit Packet Order Flag (0 for packet and idle data)
			// 2 bit Segment Length Identifier (11 for packet and idle data)
			// 11 bit First Header Pointer (0, larger payloads not yet supported.

			currentFrame[4] = (byte) (0x18 & 0xFF);
			currentFrame[5] = (byte) 0;

			// FIXME add Transfer Frame Data Status field (bytes 4 and 5)

			// FIXME unit test this.
			// This adds the frame payload

			int payloadStart = 6;
			int payloadCapacity = frameLength - payloadStart;
			if (ocfPresent) {
				payloadCapacity -= 4;
			}
			int lastByteForCurrentFrame = payloadOffset + payloadCapacity;
			if (lastByteForCurrentFrame > payload.length) {
				lastByteForCurrentFrame = payload.length;
			}

			for (; payloadOffset < lastByteForCurrentFrame; payloadStart++, payloadOffset++) {
				currentFrame[payloadStart] = payload[payloadOffset];
			}

			// If offset is still zero at this point, increment it to escape the loop.
			if (payloadOffset == 0) {
				payloadOffset++;
			}

			// frames need padding!
			frames.add(currentFrame);
		}

		return frames;
	}

}
