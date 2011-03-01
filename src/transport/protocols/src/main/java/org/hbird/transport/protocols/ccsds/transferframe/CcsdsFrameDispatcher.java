package org.hbird.transport.protocols.ccsds.transferframe;

import java.util.Observable;
import java.util.Observer;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hbird.transport.protocols.ccsds.transferframe.exceptions.FrameFailedCrcCheckException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidFrameLengthException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidVirtualChannelIdException;

public class CcsdsFrameDispatcher extends Observable implements Observer {
	private final static Logger LOG = LoggerFactory.getLogger(CcsdsFrameDispatcher.class);
	
	public static int FRAME_LENGTH_IN_OCTETS;

	/**
	 * Byte position at which the frame payload ends. This depends on whether OCF and/or ECF are present.
	 */
	private static int PAYLOAD_END;
	
	/**
	 * Signifies whether the Operational Control Field (4 octets) is present
	 */
	private static boolean OCF_PRESENT;
	
	private static int OCF_START;
	
	private static final int OCF_LENGTH = 4;
	
	private static int ECF_START;
	
	private static final int ECF_LENGTH = 2;
	
	/**
	 * Signifies whether the Error Control Field (2 octets) is present
	 */
	private static boolean ECF_PRESENT;

	private VirtualChannel[] virtualChannel = new VirtualChannel[8];
	
	public CcsdsFrameDispatcher(int frameLength, boolean ocfPresent, boolean ecfPresent) {
		
		FRAME_LENGTH_IN_OCTETS = frameLength;
		OCF_PRESENT = ocfPresent;
		ECF_PRESENT = ecfPresent;
		
		// default case (no OCF, no ECF)
		PAYLOAD_END = FRAME_LENGTH_IN_OCTETS;
		
		if (ECF_PRESENT) {
			PAYLOAD_END = PAYLOAD_END - ECF_LENGTH;
			ECF_START = PAYLOAD_END;
		}
		
		if (OCF_PRESENT) {
			PAYLOAD_END = PAYLOAD_END - OCF_LENGTH;
			OCF_START = PAYLOAD_END;
		}
		
		/*
		 * Create 8 VirtualChannels, accessed using their array index.
		 */
		for (int i=0; i<8; i++) {
			virtualChannel[i] = new VirtualChannel(i);
			virtualChannel[i].addObserver(this);
		}
		
	}
	
	
	public void process(byte[] frame) throws InvalidFrameLengthException, FrameFailedCrcCheckException, InvalidVirtualChannelIdException {
		
		/*
		 * Check for Frame Length
		 */
		if (frame.length != FRAME_LENGTH_IN_OCTETS) {
			throw new InvalidFrameLengthException("Expected Frame length in bytes: " + FRAME_LENGTH_IN_OCTETS + ", actual frame length: " + frame.length);
		}

		// Check for CRC erros
		if (crcValid(frame) == false) {
			throw new FrameFailedCrcCheckException();
		}

		// Transfer Frame Primary Header = 6 octets (mandatory) Transfer Frame Data Field Status = 2 octets (mandatory)
		// Transfer Frame Secondary Header = 1 - 64 octets (optional)		  
		// Transfer Frame Data Field = * integral number of octets. *
		// Operational Control Field = 4 octets (optional) Frame Error Control Field = 2 octets (optional)
		byte[] primaryHeader;
		byte[] secondaryHeader;
		byte[] dataFieldStatus;

		primaryHeader = ArrayUtils.subarray(frame, 0, 6);

		
		int spacecraftIdHighByte = (0x3F & primaryHeader[0]) << 4 ;
		int spacecraftIdLowByte = (0xF0 & primaryHeader[1]) >> 4;
		int spacecraftId = spacecraftIdHighByte + spacecraftIdLowByte;
		LOG.debug("Spacecraft ID: " + spacecraftId);
		
		int virtualChannelId = (0x0E & primaryHeader[1]) >> 1;
		if (virtualChannelId < 0 || virtualChannelId > 7) {
			throw new InvalidVirtualChannelIdException("Virtual Channel Id must be [0..7]. The one found in the current frame is: " + virtualChannelId);
		}
		LOG.debug("Virtual Channel Id: " + virtualChannelId);

		dataFieldStatus = ArrayUtils.subarray(frame, 4, 6);

		int firstHeaderPointerHighByte = (0x03 & dataFieldStatus[0]) << 8;
		int firstHeaderPointerLowByte = 0xFF & dataFieldStatus[1];

		int firstHeaderPointer = firstHeaderPointerHighByte + firstHeaderPointerLowByte;
		LOG.debug("First Header Pointer:" + firstHeaderPointer);
		
		int masterChannelFrameCount = primaryHeader[2] & 0xFF;
		int virtualChannelFrameCount = primaryHeader[3] & 0xFF;
		
		LOG.debug("Master Channel Frame Count: " + masterChannelFrameCount);
		LOG.debug("Virtual Channel Frame Count: " + virtualChannelFrameCount);

		int payloadOffset = 6;

		// check for secondary header flag (1st bit in dataFieldStatus
		if ((0x80 & dataFieldStatus[0]) == 0x80) {
			// secondary header present
			LOG.debug("This frame has a secondary header");

			byte secondaryHeaderStatus = frame[8];

			/*
			 * Secondary Header Version Number (first two bits of sec hdr status) is UNUSED.
			 */

			/*
			 * actual header length is one less than that. Since ArrayUtils uses
			 */
			int secondaryHeaderLength = (0x3F & secondaryHeaderStatus) - 1;
			LOG.debug("Secondary Header Length: " + secondaryHeaderLength);

			secondaryHeader = ArrayUtils.subarray(frame, payloadOffset, payloadOffset + secondaryHeaderLength);

			payloadOffset = payloadOffset + secondaryHeaderLength;

		}

		byte[] payload = ArrayUtils.subarray(frame, payloadOffset, PAYLOAD_END);

		virtualChannel[virtualChannelId].addPayload(spacecraftId, payload, virtualChannelFrameCount, firstHeaderPointer);
		
		// FIXME add a test for OCF and ECF
		byte[] operationalControlField = ArrayUtils.subarray(frame, OCF_START, OCF_START + OCF_LENGTH);
		byte[] errorControlField = ArrayUtils.subarray(frame, ECF_START, ECF_START + ECF_LENGTH);

	}

	private boolean crcValid(byte[] frame) {
		// FIXME Implement CRC checking here.
		return true;
	}
	
	public static boolean isNextFrame(int lastFrameCount, int frameCount) {
		if (((frameCount-lastFrameCount+256)%256) == 1) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public void update(Observable o, Object arg) {
		// we received a FramePayload from one of our virtual channels - pass this on to our observers.
		this.setChanged();
		notifyObservers(arg);
	}

}
