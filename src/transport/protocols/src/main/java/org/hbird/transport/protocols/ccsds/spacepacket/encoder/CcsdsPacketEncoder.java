package org.hbird.transport.protocols.ccsds.spacepacket.encoder;

import org.apache.commons.lang.ArrayUtils;
import org.hbird.transport.protocols.ccsds.spacepacket.PacketPayload;
import org.hbird.transport.protocols.ccsds.spacepacket.exceptions.InvalidApIdException;
import org.hbird.transport.protocols.ccsds.spacepacket.exceptions.InvalidPayloadLengthExeption;
import org.hbird.transport.protocols.ccsds.spacepacket.exceptions.PayloadNullException;

/**
 * Currently not supported:
 * <ul>
 * <li>segmented packet data
 * <li>secondary header
 * </ul>
 * 
 * @author Johannes Klug
 * 
 */
public class CcsdsPacketEncoder {

	// 3 bits
	private int packetVersionNumber = 0;

	// 1 bit
	private int packetType = 0;
	
	// 1 bit
	//private int secondaryHeaderFlag = 0; // unsupported!
	
	// 11 bits
	// APID - passed to the encode() function
	
	// 2 bits
	private int sequenceFlags = 3; // both bits set. Only unsegmented packet data supported!
	
	// 14 bits
	private int sequenceCount = 0; // or packet name
	
	// 16 bits
	// packet data length - calculated in the encode() function
	
	
	public CcsdsPacketEncoder(CcsdsPacketType type) {
		if (type == CcsdsPacketType.TM) {
			packetType = 0;
		} else if (type == CcsdsPacketType.TC) {
			packetType = 1;
		}
		// FIXME: How to handle other cases? Can this ever happen? packetType is set to 0 by default anyway.
	}

	/**
	 * 
	 * @param A payload object to encode
	 * @return a CCSDS Space Packet with all header fields set.
	 * @throws InvalidPayloadLengthExeption
	 * @throws PayloadNullException
	 * @throws InvalidApIdException 
	 */
	public synchronized byte[] encode(PacketPayload payload)	throws InvalidPayloadLengthExeption, PayloadNullException, InvalidApIdException {
		
		if ((payload == null) || (payload.payload == null)) {
			throw new PayloadNullException();
		}
		
		if ((payload.apid < 0) || (payload.apid >= 2048)) {
			throw new InvalidApIdException(payload.apid);
		}
		
		if ((payload.payload.length == 0) || (payload.payload.length > 65536)) {
			throw new InvalidPayloadLengthExeption(payload.payload.length);
		}
		// CCSDS Space Packet Header is 6 bytes in length. We start with that.
		byte[] packet = new byte[6];
		int[] header = new int[6];

		// Populate primary header fields as integers.
		header[0] = (packetVersionNumber & 0x7) << 5;
		header[0] = ((packetType & 0x01) << 4) | header[0];
		
		header[0] = ((payload.apid & 0x700) >>> 8) | header[0];
		header[1] = (payload.apid & 0xFF);
		
		header[2] = (sequenceFlags & 0x3) << 6;
		
		header[2] = ((sequenceCount & 0x3F00) >>> 8) | header[2];
		header[3] = sequenceCount & 0xff;
		
		header[4] = ((payload.payload.length-1) & 0xFF00) >>> 8;
		header[5] = ((payload.payload.length-1) & 0x00FF);
		
		
		// set the primary header fields in the packet byte[]
		for (int i=0; i<6; i++) {
			packet[i] = (byte) (header[i]&0xFF);
		}

		// Add the passed payload to the packet.
		packet = ArrayUtils.addAll(packet, payload.payload);
		
		sequenceCount++;
		if (sequenceCount == (int) Math.pow(2, 14)) {
			sequenceCount = 0;
		}

		return packet;
	}

}
