package com.logica.hummingbird.telemetry.ccsds;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CcsdsTmFrameTest {

	private static CcsdsTmFrame frame = null;
	
	private final static int FRAME_VERSION_NUM = 2;
	
	private final static int APID = 555;
	
	private final static String LASER_TEMP_PARAM_NAME = "Laser Temperature";
	private final static Float LASER_TEMP = 2560.78f;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ArrayList<CcsdsTmPacket> packets = new ArrayList<CcsdsTmPacket>(1);
		packets.add(new CcsdsTmPacket());
		frame = new CcsdsTmFrame(new CcsdsTmFrameHeader(), packets, new CcsdsTmFrameTail());
	}

	@Test
	public final void testSetHeaderParameter() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
		CcsdsTmNumberParameter frameVersionNum = new CcsdsTmNumberParameter("frameVersionNum", FRAME_VERSION_NUM, Integer.class);
		frame.setParameterInFrame(frameVersionNum);
		
		assertEquals("Header should have frameversionnum set and be " + FRAME_VERSION_NUM, FRAME_VERSION_NUM, frame.frameHeader.getFrameVersionNum());
	}
	
	@Test
	public final void testPacketHeaderParameter() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
		CcsdsTmNumberParameter apid = new CcsdsTmNumberParameter("apid", APID, Integer.class);
		frame.setParameterInFrame(apid);
		
		for(CcsdsTmPacket packet : frame.packets) {
			assertEquals("Packet header should have apid set and be " + APID, APID, packet.packetHeader.getApid());
		}
	}
	
	@Test
	public final void testPayloadParameter() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
		CcsdsTmNumberParameter laserTemp = new CcsdsTmNumberParameter(LASER_TEMP_PARAM_NAME, LASER_TEMP, Float.class);
		frame.setParameterInFrame(laserTemp);
		
		// NOTE: This test will fail asserts if there are multiple packets in the frame.  This shouldn't be the
		// case though...unless you change the test.  So don't, it's not testing that ;p
		for(CcsdsTmPacket packet : frame.packets) {
			for(CcsdsTmNumberParameter param : packet.payload.getNumberParameters()) {
				assertEquals(LASER_TEMP_PARAM_NAME, param.getName());
				assertEquals("Packet payload should have Laser Temperature with value " + LASER_TEMP, LASER_TEMP, param.getValue());
			}
		}
	}

}
