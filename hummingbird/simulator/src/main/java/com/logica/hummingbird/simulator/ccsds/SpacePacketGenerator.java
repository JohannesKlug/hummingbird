package com.logica.hummingbird.simulator.ccsds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpacePacketGenerator {
	
	private final static Logger LOG = LoggerFactory.getLogger(SpacePacketGenerator.class);
	
	private int sequenceCount = 0;
	
	public SpacePacketGenerator() {
		
	}
	
	public byte[] generateSpacePacket(int apId, byte[] payload) {
		
		if ( (payload.length < 1) || (payload.length > 65536) ) {
			// TODO throw an exception here
			LOG.error("Invalid payload size (" + payload.length + "), must be between 1 and 65536)");
		}
		
		byte[] packet = new byte[payload.length+6];
		
		/*
		 * Packet Version Number 	= 000
		 * Packet Type (Telemetry) 	= 0
		 * Sec Hdr Flag				= 0
		 * ApId (11 bits)			= from argument
		 * Sequence Flag (1st Seg)	= 01 bin
		 * Sequence Count (14 bits)	= continuous
		 */
		
		/*
		 * first byte contains:
		 *  * packet version number
		 *  * packet type
		 *  * sec hdr flag
		 *  * three bits of apid
		 *  
		 *  therefore: last three bits of the bit mask must be set.
		 *  result: 0x07.
		 */
		int firstByte = 0x07;
		
		Integer apidHighByteInteger = (0x700 & apId) >> 8;
		Integer apidLowByteInteger = (0xFF & apId);
		Integer apidInteger = firstByte & apidHighByteInteger;
		packet[0] = apidInteger.byteValue();
		packet[1] = apidLowByteInteger.byteValue();
		
		int sequenceFlag = 0x01 << 6; // right shift by 6 to end up in top two bits
		
		Integer sequenceCountHighByte = (0x3F00 & sequenceCount) >>> 8;
		Integer sequenceCountLowByte = (0xFF & sequenceCount);
		
		Integer sequenceFirstByte = sequenceFlag | sequenceCountHighByte;
		packet[2] = sequenceFirstByte.byteValue();
		packet[3] = sequenceCountLowByte.byteValue();
		
		sequenceCount = (sequenceCount + 1) % 16384;
		
		return packet;
		
	}

}
