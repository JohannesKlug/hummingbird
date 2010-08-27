package com.logica.hummingbird.simulator.cssds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.logica.hummingbird.simulator.ccsds.SpacePacketGenerator;

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
		System.out.println(reconstructedApid);
		
		assertEquals(apid, reconstructedApid);
		
		
		
	}

}
