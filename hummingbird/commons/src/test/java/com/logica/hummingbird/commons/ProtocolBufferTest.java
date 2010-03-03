package com.logica.hummingbird.commons;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.logica.hummingbird.commons.CCSDSMessageTypes.CCSDSFrame;
import com.logica.hummingbird.commons.CCSDSMessageTypes.CCSDSPacket;
import com.logica.hummingbird.commons.CCSDSMessageTypes.CCSDSParameter;


public class ProtocolBufferTest {

	@Before
	public void setUp() throws Exception {
		//CCSDSParameter parameter = getParameter();
		//CCSDSPacket packet = getPacket();
		
		/*
		CCSDSFrame.Builder frame = CCSDSFrame.newBuilder();
		frame.setCCSDSFVERSION(1);
		frame.setCCSDSSCID(16);
		*/
	}
	
	private CCSDSParameter getParameter() {
		CCSDSParameter.Builder parameter = CCSDSParameter.newBuilder()
		.setName("Temperature (K)")
		.setValue("80");
		
		return parameter.build();
	}
	
	private CCSDSPacket getPacket() {
		
		CCSDSPacket.Builder packet = CCSDSPacket.newBuilder()
		.setCCSDSAPID(1)
		.setCCSDSGPFLAGS(2)
		.setCCSDSPLENGTH(128)
		.setCCSDSSECHD(0)
		.setCCSDSSSC(1)
		.setCCSDSTYPE(64)
		.setCCSDSVERSION(2)
		.addTMParameters(getParameter());
		
		return packet.build();
	}
	
	private CCSDSFrame getFrame() {
		
		CCSDSFrame.Builder frame = CCSDSFrame.newBuilder()
		.setCCSDSFVERSION(1)
		.setCCSDSMSCNT(1)
		.setCCSDSOPCTRL(15)
		.setCCSDSSCID(2)
		.setCCSDSTFEC(1)
		.setCCSDSTFFH(19)
		.setCCSDSTFHL(9)
		.setCCSDSTFHV(9000)
		.setCCSDSTFOC(1234567890)
		.setCCSDSTFORDER(1)
		.setCCSDSTFSECH(1)
		.setCCSDSTFSEGM(0)
		.setCCSDSTFSYNC(0)
		.setCCSDSTFVC(23)
		.setCCSDSVCCNT(12)
		.addTMPackets(getPacket());
		
		return frame.build();
	}

	@Test (expected=com.google.protobuf.UninitializedMessageException.class)
	public void uninitialisedParameter() {
		assertNotNull(getParameter().newBuilderForType().clear().build());
	}
	
	@Test (expected=com.google.protobuf.UninitializedMessageException.class)
	public void uninitialisedPacket() {
		assertNotNull(getPacket().newBuilderForType().clear().build());
	}
	
	@Test (expected=com.google.protobuf.UninitializedMessageException.class)
	public void uninitialisedFrame() {
		assertNotNull(getFrame().newBuilderForType().clear().build());
	}
	
	@Test
	public void newParameter() {
		assertNotNull(getParameter());
	}
	
	@Test
	public void newPacket() {
		assertNotNull(getPacket());
	}
	
	@Test
	public void newFrame() {
		assertNotNull(getFrame());
	}
	
	@Test
	public void unwrapOneParamterInOnePacketInOneFrame() {
		assertEquals("80", getFrame().getTMPacketsList().get(0).getTMParameters(0).getValue());
	}

}
