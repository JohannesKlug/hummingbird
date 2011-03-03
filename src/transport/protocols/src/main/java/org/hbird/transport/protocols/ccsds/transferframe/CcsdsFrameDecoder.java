package org.hbird.transport.protocols.ccsds.transferframe;

import java.util.Observable;

import org.apache.camel.Exchange;
import org.apache.camel.InOut;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.apache.commons.lang.ArrayUtils;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.FrameFailedCrcCheckException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidFrameLengthException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidVirtualChannelIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CcsdsFrameDecoder extends Observable {
	private final static Logger LOG = LoggerFactory.getLogger(CcsdsFrameDecoder.class);
	
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
	
	public CcsdsFrameDecoder(int frameLength, boolean ocfPresent, boolean ecfPresent) {
		
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
		}
		
	}
	
	
	public CcsdsFramePayload process(byte[] frame) throws InvalidFrameLengthException, FrameFailedCrcCheckException, InvalidVirtualChannelIdException {
		
		/*
		 * Check for Frame Length
		 */
		if (frame.length != FRAME_LENGTH_IN_OCTETS) {
			throw new InvalidFrameLengthException("Expected Frame length in bytes: " + FRAME_LENGTH_IN_OCTETS + ", actual frame length: " + frame.length);
		}

		// FIXME Handle OCF and ECF
		// FIXME add a test for OCF and ECF
		if (OCF_PRESENT) {
			byte[] operationalControlField = ArrayUtils.subarray(frame, OCF_START, OCF_START + OCF_LENGTH);
		}
		
		if (ECF_PRESENT) {
			byte[] errorControlField = ArrayUtils.subarray(frame, ECF_START, ECF_START + ECF_LENGTH);
			
			// Check for CRC erros
			if (crcValid(frame) == false) {
				throw new FrameFailedCrcCheckException();
			}
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
			throw new InvalidVirtualChannelIdException(virtualChannelId);
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

		return virtualChannel[virtualChannelId].processPayload(spacecraftId, payload, virtualChannelFrameCount, firstHeaderPointer);
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
	
	/**
	 * 
	 * @param An incoming message carrying a frame as a byte array in its body
	 * @return A CcsdsFramePayload in the body.
	 * @throws InvalidVirtualChannelIdException 
	 * @throws FrameFailedCrcCheckException 
	 * @throws InvalidFrameLengthException 
	 */
	@InOut
	public Message processMessage(Exchange exchange) throws InvalidFrameLengthException, FrameFailedCrcCheckException, InvalidVirtualChannelIdException {
		Message inMessage = exchange.getIn();
		Message outMessage = exchange.getOut();
		
		byte[] frame;
		if (inMessage.getBody() instanceof byte[]) {
			frame = (byte[]) inMessage.getBody();
			CcsdsFramePayload processedPayload = this.process(frame);
			outMessage.setHeader("VirtualChannelId", processedPayload.virtualChannelId);
			outMessage.setHeader("SpacecraftId", processedPayload.spacecraftId);
			outMessage.setHeader("IsNextFrame", processedPayload.isNextFrame);
			outMessage.setBody(processedPayload);
		}
		return outMessage;
	}

}
