package org.hbird.business.simulator.ccsds;

import static org.junit.Assert.assertEquals;

import org.hbird.business.simulator.ccsds.SpacePacketGenerator;
import org.junit.Test;

public class SpacePacketGeneratorTest {
	
	private SpacePacketGenerator generator;
	
	@Test
	public void testWithoutPayload() {
		generator = new SpacePacketGenerator();
		
//		int apid = 0x70F; // 0x70F = 1807 = 0b11100001111
		int apid = 0x50F; // 0x50F = 1295 = 0b10100001111
			
		byte[] packet = generator.generateSpacePacket(apid, new byte[1]);
		assertEquals(7, packet.length);
		
		int reconstructedApid = ( (0x07 & packet[0]) << 8 ) + (0xFF & packet[1]);
		
		assertEquals(apid, reconstructedApid);
		
		int packetSequenceFlags = (0xC0 & packet[2]) >>> 6;
		assertEquals(0x01, packetSequenceFlags);
		
		int packetSequenceCountOrPacketNameHighByte = (0x3F & packet[2]) << 8;
		int packetSequenceCountOrPacketNameLowByte = 0xFF & packet[3];
		int packetSequenceCountOrPacketName = packetSequenceCountOrPacketNameHighByte + packetSequenceCountOrPacketNameLowByte;
		assertEquals(0, packetSequenceCountOrPacketName);
		
		
		
	}
	
	@Test
	public void testRollover() {
		generator = new SpacePacketGenerator();
		
		int expectedSequenceCount = 0;
		
		int apid = 0x50F; // 0x50F = 1295 = 0b10100001111
		for (int i=0; i<16384; i++) {
			
			byte[] packet = generator.generateSpacePacket(apid, new byte[1]);
			
			int packetSequenceCountOrPacketNameHighByte = (0x3F & packet[2]) << 8;
			int packetSequenceCountOrPacketNameLowByte = 0xFF & packet[3];
			int packetSequenceCountOrPacketName = packetSequenceCountOrPacketNameHighByte + packetSequenceCountOrPacketNameLowByte;
			assertEquals(expectedSequenceCount, packetSequenceCountOrPacketName);
			
			expectedSequenceCount = (expectedSequenceCount+1) % 16384;
		}
		
	}
	
	@Test
	public void testWithPayload() {
		generator = new SpacePacketGenerator();
		
		byte byte0 = new Integer(0x00).byteValue();
		byte byte1 = new Integer(0xFF).byteValue();
		byte byte2 = new Integer(0xAA).byteValue();
		
		byte[] payload = {byte0, byte1, byte2};
		
		byte[] packet = generator.generateSpacePacket(0, payload);
		
		assertEquals(byte0, packet[6]);
		assertEquals(byte1, packet[7]);
		assertEquals(byte2, packet[8]);
		
		int packetDataLengthHighByte = (0xFF & packet[4]) << 8;
		int packetDataLengthLowByte = 0xFF & packet[5];
		int packetDataLength = packetDataLengthHighByte + packetDataLengthLowByte + 1;
		
		assertEquals(3, packetDataLength);
		
	}

}
