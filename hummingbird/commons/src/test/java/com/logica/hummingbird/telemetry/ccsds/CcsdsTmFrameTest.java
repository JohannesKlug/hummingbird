package com.logica.hummingbird.telemetry.ccsds;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CcsdsTmFrameTest {

	private static CcsdsTmFrame frame = null;
	
	private final static int FRAME_VERSION_NUM = 2;

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
	public final void testSetParameter() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException {
		CcsdsTmNumberParameter frameVersionNum = new CcsdsTmNumberParameter("frameVersionNum", FRAME_VERSION_NUM, Integer.class);
		frame.setParameter(frameVersionNum);
		
		assertEquals("Header should have frameversionnum set and be " + FRAME_VERSION_NUM, FRAME_VERSION_NUM, frame.frameHeader.getFrameVersionNum());
	}

}
