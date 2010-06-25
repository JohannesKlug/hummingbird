package com.logica.hummingbird.telemetry.ccsds;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CcsdsTmFrameTest {

	private static CcsdsTmFrame frame = null;

	private final static int FRAME_VERSION_NUM = 2;
	private final static int SPACE_CRAFT_ID = 10;
	private final static boolean OP_CTRL_FIELD_FLAG = false;
	private final static boolean SYNC_FLAG = true;

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
	public final void testSetHeaderParameter() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException,
			NoSuchFieldException {
		CcsdsTmParameter frameVersionNum = new CcsdsTmParameter("frameVersionNum", FRAME_VERSION_NUM, Integer.class);
		frame.setParameterInFrame(frameVersionNum);

		assertEquals("Header should have frameversionnum set and be " + FRAME_VERSION_NUM, FRAME_VERSION_NUM, frame.frameHeader.getFrameVersionNum());
	}

	@Test
	public final void testPacketHeaderParameter() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException,
			NoSuchFieldException {
		CcsdsTmParameter apid = new CcsdsTmParameter("apid", APID, Integer.class);
		frame.setParameterInFrame(apid);

		for (CcsdsTmPacket packet : frame.packets) {
			assertEquals("Packet header should have apid set and be " + APID, APID, packet.packetHeader.getApid());
		}
	}

	@Test
	public final void testMultipleHeaderParameters() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException,
			NoSuchFieldException {
		CcsdsTmParameter frameVersionNum = new CcsdsTmParameter("frameVersionNum", FRAME_VERSION_NUM, Integer.class);
		CcsdsTmParameter spaceCraftId = new CcsdsTmParameter("spaceCraftId", SPACE_CRAFT_ID, Integer.class);
		CcsdsTmParameter operationControlFieldFlag = new CcsdsTmParameter("operationControlFieldFlag", OP_CTRL_FIELD_FLAG, Boolean.class);
		CcsdsTmParameter syncFlag = new CcsdsTmParameter("syncFlag", SYNC_FLAG, Integer.class);

		frame.setParameterInFrame(frameVersionNum);
		frame.setParameterInFrame(spaceCraftId);
		frame.setParameterInFrame(operationControlFieldFlag);
		frame.setParameterInFrame(syncFlag);

		assertEquals("Header should have frameversionnum set and be " + FRAME_VERSION_NUM, FRAME_VERSION_NUM, frame.frameHeader.getFrameVersionNum());
		assertEquals("Header should have space craft id set and be " + SPACE_CRAFT_ID, SPACE_CRAFT_ID, frame.frameHeader.getSpaceCraftId());
		assertEquals("Header should have op ctrl flag set and be " + OP_CTRL_FIELD_FLAG, OP_CTRL_FIELD_FLAG, frame.frameHeader.isOperationControlFieldFlag());
		assertEquals("Header should have sync flag set and be " + SYNC_FLAG, SYNC_FLAG, frame.frameHeader.isSyncFlag());
	}

	@Test
	public final void testPayloadParameter() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException,
			NoSuchFieldException {
		CcsdsTmParameter laserTemp = new CcsdsTmParameter(LASER_TEMP_PARAM_NAME, LASER_TEMP, Float.class);
		frame.setParameterInFrame(laserTemp);

		// NOTE: This test will fail asserts if there are multiple packets in the frame. This shouldn't be the
		// case though...unless you change the test. So don't, it's not testing that ;p
		for (CcsdsTmPacket packet : frame.packets) {
			for (CcsdsTmParameter param : packet.payload.getTmParameters()) {
				assertEquals(LASER_TEMP_PARAM_NAME, param.getName());
				assertEquals("Packet payload should have Laser Temperature with value " + LASER_TEMP, LASER_TEMP, param.getValue());
			}
		}
	}

}
