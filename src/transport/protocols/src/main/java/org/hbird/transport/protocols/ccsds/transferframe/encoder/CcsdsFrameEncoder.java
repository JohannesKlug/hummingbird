package org.hbird.transport.protocols.ccsds.transferframe.encoder;

import org.apache.commons.lang.ArrayUtils;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidOperationalControlFieldException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidSpacecraftIdException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidVirtualChannelIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CcsdsFrameEncoder {
	private final static Logger LOG = LoggerFactory.getLogger(CcsdsFrameEncoder.class);

	private static int frameLength;

	private int masterChannelFrameCount = 0;
	private final int[] virtualChannelFrameCount = new int[8];

	private final int defaultSpacecraftId = 0;
	private final int defaultVirtualChannelId = 0;

	private byte[] frameBytes;

	public CcsdsFrameEncoder(final int frameLength) {
		CcsdsFrameEncoder.frameLength = frameLength;
		for (int vcfc : virtualChannelFrameCount) {
			vcfc = 0;
		}
	}

	public byte[] encodeFrame(final byte[] payload) throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException,
			InvalidOperationalControlFieldException {
		return encodeFrame(defaultSpacecraftId, defaultVirtualChannelId, payload);
	}

	public byte[] encodeFrame(final int spacecraftId, final int virtualChannelId, final byte[] payload) throws InvalidVirtualChannelIdException,
			InvalidSpacecraftIdException, InvalidOperationalControlFieldException {
		return encodeFrame(spacecraftId, virtualChannelId, null, payload);
	}

	/**
	 * Given a number of Transfer Frame constituents, this function encodes a valid CCSDS Transfer Frame.
	 * 
	 * Unsupported constituents of the Transfer Frame: * Transfer Frame Version Number (2 bits) shall be 00 according to
	 * spec. * OCF flag * OCF * secondary header * synch flag * Packet Order flag (shall be 0 anyway as per the spec) *
	 * Segment Length Identifier (shall be 11 anyway as per the spec)
	 * 
	 * Unsupported behaviour: * payloads larger than one frame.
	 * 
	 * @param spacecraftId
	 * @param virtualChannelId
	 * @return a valid CCSDS Transfer Frame
	 * @throws InvalidVirtualChannelIdException
	 * @throws InvalidSpacecraftIdException
	 * @throws InvalidOperationalControlFieldException
	 */
	public synchronized byte[] encodeFrame(final int spacecraftId, final int virtualChannelId, final byte[] operationalControlField, final byte[] payload)
			throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException, InvalidOperationalControlFieldException {

		// perform input sanity checks

		if (virtualChannelId < 0 || virtualChannelId > 7) {
			throw new InvalidVirtualChannelIdException(virtualChannelId);
		}

		if (spacecraftId < 0 || spacecraftId > 1023) {
			throw new InvalidSpacecraftIdException(spacecraftId);
		}

		boolean ocfPresent;
		if (operationalControlField == null || operationalControlField.length == 0) {
			LOG.trace("OCF not present");
		}
		else if (operationalControlField.length == 4) {
			LOG.trace("OCF present and of correct size");
		}
		else {
			// OCF present but of wrong size (MUST be 4 bytes as per the spec.
			throw new InvalidOperationalControlFieldException(operationalControlField.length);
		}

		// end input sanity checks

		frameBytes = new byte[frameLength];

		byte spacecraftIdHighByte = (byte) ((spacecraftId & 0x3f0) >> 4);
		byte spacecraftIdLowByte = (byte) ((spacecraftId & 0xF) << 4);

		// set Spacecraft ID
		frameBytes[0] = spacecraftIdHighByte;
		frameBytes[1] = spacecraftIdLowByte;

		// set Virtual Channel ID
		frameBytes[1] = (byte) (((virtualChannelId & 0x7) << 1) ^ frameBytes[1]);

		// set Operational Control Field flag
		// FIXME will this handle null?
		if (ArrayUtils.isNotEmpty(operationalControlField)) {
			frameBytes[1] = (byte) (1 ^ frameBytes[1]);
		}
		else {
			frameBytes[1] = (byte) (0 ^ frameBytes[1]);
		}

		// set frame counters
		frameBytes[2] = (byte) (masterChannelFrameCount & 0xFF);
		frameBytes[3] = (byte) (virtualChannelFrameCount[virtualChannelId] & 0xFF);

		// Transfer Frame Data Field Status
		/*
		 * 1 bit Secondary Header Flag 1 bit Synch Flag 1 bit Packet Order Flag 2 bit Segment Length ID 11 bits First
		 * Header Pointer
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
		
		frameBytes[4] = (byte) (0x18 & 0xFF);
		frameBytes[5] = (byte) 0;
		
		
		// FIXME add Transfer Frame Data Status field (bytes 4 and 5)

		// FIXME unit test this.
		// This adds the frame payload

		if (payload == null) {
			addPayload(new byte[0]);
		}
		else {
			addPayload(payload);
		}

		return frameBytes;
	}

	private void addPayload(final byte[] payload) {
		int payloadPosition = 6;
		for (byte b : payload) {
			frameBytes[payloadPosition] = b;
			payloadPosition++;
		}
	}
}
