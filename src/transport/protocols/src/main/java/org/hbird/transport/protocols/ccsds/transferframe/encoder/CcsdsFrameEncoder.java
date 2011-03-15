package org.hbird.transport.protocols.ccsds.transferframe.encoder;

import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidSpacecraftIdException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidVirtualChannelIdException;

public class CcsdsFrameEncoder {

	private static int FRAME_LENGTH;
	
	private int masterChannelFrameCount = 0;
	private int virtualChannelFrameCount = 0;

	public CcsdsFrameEncoder(int frameLength) {
		this.FRAME_LENGTH = frameLength;
	}

	/**
	 * Given a number of Transfer Frame constituents, this function encodes a
	 * valid CCSDS Transfer Frame.
	 * 
	 * Unsupported constituents of the Tranfer Frame: 
	 * * Transfer Frame Version Number (2 bits) shall be 00 according to spec. 
	 * * OCF flag 
	 * * OCF 
	 * * secondary header 
	 * * synch flag 
	 * * Packet Order flag (shall be 0 anyway as per the spec) 
	 * * Segment Length Identifier (shall be 11 anyway as per the spec)
	 * 
	 * Unsupported behaviour:
	 * * payloads larger than one frame.
	 * 
	 * @param spacecraftId
	 * @param virtualChannelId
	 * @return a valid CCSDS Transfer Frame
	 * @throws InvalidVirtualChannelIdException 
	 * @throws InvalidSpacecraftIdException 
	 */
	public byte[] encodeFrame(int spacecraftId, int virtualChannelId, boolean ocfPresent, byte[] payload) throws InvalidVirtualChannelIdException, InvalidSpacecraftIdException {
		
		// perform input sanity checks
		if (virtualChannelId < 0 || virtualChannelId > 7) {
			throw new InvalidVirtualChannelIdException(virtualChannelId);
		}
		if (spacecraftId < 0 || spacecraftId > 1023) {
			throw new InvalidSpacecraftIdException(spacecraftId);
		}
		
		byte[] frame = new byte[FRAME_LENGTH];
		
		
		byte spacecraftIdHighByte = (byte) ((spacecraftId & 0x3f0) >> 4);
		byte spacecraftIdLowByte = (byte) ((spacecraftId & 0xF) << 4);
		
		// set Spacecraft ID
		frame[0] = spacecraftIdHighByte;
		frame[1] = spacecraftIdLowByte;
		
		// set Virtual Channel ID
		frame[1] = (byte) (((virtualChannelId & 0x7) << 1) ^ frame[1]);
		
		// set Operational Control Field flag
		if (ocfPresent) {
			frame[1] = (byte) (1 ^ frame[1]);
		} else {
			frame[1] = (byte) (0 ^ frame[1]);
		}
		
		return frame;
	}

}
