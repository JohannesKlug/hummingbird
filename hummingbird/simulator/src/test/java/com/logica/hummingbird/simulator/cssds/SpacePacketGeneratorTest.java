package com.logica.hummingbird.simulator.cssds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.logica.hummingbird.simulator.ccsds.SpacePacketGenerator;

public class SpacePacketGeneratorTest {
	
	private SpacePacketGenerator generator;
	
	@Test
	public void testWithoutPayload() {
		generator = new SpacePacketGenerator();
		
		int apid = 0x70F; // 0x70F = 1807 = 0b11100001111
		
		byte[] packet = generator.generateSpacePacket(apid, new byte[1]);
		assertEquals(7, packet.length);
		
		System.out.println(packet[0]);
		
	}

}
