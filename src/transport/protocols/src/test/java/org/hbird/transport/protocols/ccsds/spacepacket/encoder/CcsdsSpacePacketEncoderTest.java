package org.hbird.transport.protocols.ccsds.spacepacket.encoder;

import static org.junit.Assert.*;

import org.hbird.transport.protocols.ccsds.spacepacket.CcsdsPacketEncoder;
import org.hbird.transport.protocols.ccsds.spacepacket.data.CcsdsPacketType;
import org.hbird.transport.protocols.ccsds.spacepacket.data.PacketPayload;
import org.hbird.transport.protocols.ccsds.spacepacket.exceptions.InvalidApIdException;
import org.hbird.transport.protocols.ccsds.spacepacket.exceptions.InvalidPayloadLengthExeption;
import org.hbird.transport.protocols.ccsds.spacepacket.exceptions.PayloadNullException;
import org.junit.Test;

public class CcsdsSpacePacketEncoderTest {
	
	private CcsdsPacketEncoder encoder = new CcsdsPacketEncoder(CcsdsPacketType.TM);
	
	@Test
	public void testPacketLength() throws Exception {
		PacketPayload payload  = new PacketPayload(0, new byte[5]);
		byte[] actual = encoder.encode(payload);
		assertEquals(5+6,actual.length);
	}

	
	@Test(expected=InvalidPayloadLengthExeption.class)
	public void testPacketLength0() throws Exception {
		PacketPayload payload  = new PacketPayload(0, new byte[0]);
		encoder.encode(payload);
		fail();
	}
	
	@Test
	public void testPacketLength65536() throws Exception {
		PacketPayload payload  = new PacketPayload(0, new byte[65536]);
		byte[] actual = encoder.encode(payload);
		assertEquals(65536+6,actual.length);
	}
	
	@Test(expected=InvalidPayloadLengthExeption.class)
	public void testPacketLength65537() throws Exception {
		PacketPayload payload  = new PacketPayload(0, new byte[65537]);
		encoder.encode(payload);
		fail();
	}
	
	@Test(expected=PayloadNullException.class)
	public void testPacketPayloadPayloadNull() throws Exception {
		PacketPayload payload  = new PacketPayload(0, null);
		encoder.encode(payload);
		fail();
	}
	
	@Test(expected=PayloadNullException.class)
	public void testPacketPayloadNull() throws Exception {
		PacketPayload payload  = null;
		encoder.encode(payload);
		fail();
	}
	
	@Test
	public void typeFieldTestTM() throws Exception {
		CcsdsPacketEncoder encoder = new CcsdsPacketEncoder(CcsdsPacketType.TM);
		PacketPayload payload  = new PacketPayload(0, new byte[5]);
		byte[] result = encoder.encode(payload);
		assertEquals(0x00,result[0]&0x10);
	}
	
	@Test
	public void typeFieldTestTC() throws Exception {
		CcsdsPacketEncoder encoder = new CcsdsPacketEncoder(CcsdsPacketType.TC);
		PacketPayload payload  = new PacketPayload(0, new byte[5]);
		byte[] result = encoder.encode(payload);
		assertEquals(0x10,result[0]&0x10);
	}
	
	@Test(expected=InvalidApIdException.class)
	public void apidTestMinus1() throws Exception {
		PacketPayload payload  = new PacketPayload(-1, new byte[5]);
		encoder.encode(payload);
		fail();
	}
	
	@Test
	public void apidTest0() throws Exception {
		PacketPayload payload  = new PacketPayload(0, new byte[5]);
		byte[] result = encoder.encode(payload);
		
		assertEquals(0x00,result[0]&0x07);
		assertEquals(0x00,result[1]&0xFF);
	}
	
	@Test
	public void apidTest1025() throws Exception {
		PacketPayload payload  = new PacketPayload(1025, new byte[5]);
		byte[] result = encoder.encode(payload);
		
		assertEquals(0x04,result[0]&0x07);
		assertEquals(0x01,result[1]&0xFF);
	}
	
	@Test
	public void apidTest2047() throws Exception {
		PacketPayload payload  = new PacketPayload(2047, new byte[5]);
		byte[] result = encoder.encode(payload);
		
		assertEquals(0x07,result[0]&0x07);
		assertEquals(0xFF,result[1]&0xFF);
	}
	
	@Test(expected=InvalidApIdException.class)
	public void apidTest2048() throws Exception {
		PacketPayload payload  = new PacketPayload(2048, new byte[5]);
		encoder.encode(payload);
		fail();
	}
	
	@Test
	public void packetDataLength1() throws Exception {
		PacketPayload payload  = new PacketPayload(0, new byte[1]);
		
		byte[] result = encoder.encode(payload);
		
		assertEquals(0x00,result[4]&0xFF);
		assertEquals(0x00,result[5]&0xFF);
	}
	
	@Test
	public void packetDataLength65536() throws Exception {
		PacketPayload payload  = new PacketPayload(0, new byte[65536]);
		
		byte[] result = encoder.encode(payload);
		
		assertEquals(0xFF,result[4]&0xFF);
		assertEquals(0xFF,result[5]&0xFF);
	}
	
	@Test
	public void packetDataLength32770() throws Exception {
		PacketPayload payload  = new PacketPayload(0, new byte[32770]);
		
		byte[] result = encoder.encode(payload);
		
		assertEquals(0x80,result[4]&0xFF);
		assertEquals(0x01,result[5]&0xFF);
	}
}
