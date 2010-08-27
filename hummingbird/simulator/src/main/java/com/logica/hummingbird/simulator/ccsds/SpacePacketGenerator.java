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
		 * Sequence Count 			= continuous
		 */
		
		/*
		 * first byte contains:
		 *  * packet version number
		 *  * packet type
		 *  * sec hdr flag
		 *  * three bits of apid
		 */
		byte firstByte = 0x00;
		
		Integer apidHighByteInteger = (0x700 & apId) >> 8;
		Integer apidLowByteInteger = (0xFF & apId);
		byte apidHighByte = apidHighByteInteger.byteValue();
		// FIXME cast to byte goes wrong :(
		packet[0] = (byte) (firstByte & apidHighByte);
		packet[0] = apidHighByteInteger.byteValue();
		packet[1] = apidLowByteInteger.byteValue();
		
		return packet;
		
	}

}
