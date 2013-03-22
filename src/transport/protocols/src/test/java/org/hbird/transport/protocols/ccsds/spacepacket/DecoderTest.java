package org.hbird.transport.protocols.ccsds.spacepacket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.hbird.transport.protocols.ccsds.spacepacket.data.CcsdsPacketType;
import org.hbird.transport.protocols.ccsds.spacepacket.data.PacketPayload;
import org.hbird.transport.protocols.ccsds.transferframe.data.CcsdsFramePayload;
import org.junit.Test;

public class DecoderTest {

	CcsdsPacketEncoder encoder = new CcsdsPacketEncoder(CcsdsPacketType.TM);
	CcsdsPacketDecoder decoder = new CcsdsPacketDecoder();

	@Test
	public void decodeOnePacket() throws Exception {

		int dummyApid = 123;
		int dummyPayloadLength = 35;

		PacketPayload packetPayload = new PacketPayload(dummyApid, new byte[dummyPayloadLength], 0);
		byte[] encodedPacket = encoder.encode(packetPayload);

		CcsdsFramePayload framePayload = new CcsdsFramePayload(0, 0, encodedPacket, true, 0);

		List<PacketPayload> decodedPayloads = decoder.decode(framePayload);

		assertEquals(1, decodedPayloads.size());
		assertEquals(dummyApid, decodedPayloads.get(0).payloadIdentifier);
		assertEquals(dummyPayloadLength, decodedPayloads.get(0).payload.length);
	}

	@Test
	public void decodezeroPackets() throws Exception {

		CcsdsFramePayload framePayload = new CcsdsFramePayload(0, 0, new byte[0], true, 0);

		assertNull(decoder.decode(framePayload));
	}

	@Test
	public void decodeTwoPackets() throws Exception {

		decoder = new CcsdsPacketDecoder();

		PacketPayload packetPayload = new PacketPayload(0, new byte[35], 0);
		byte[] encodedPacket = encoder.encode(packetPayload);

		byte[] twoPackets = ArrayUtils.addAll(encodedPacket, encodedPacket);

		CcsdsFramePayload framePayload = new CcsdsFramePayload(0, 0, twoPackets, true, 0);

		assertEquals(2, decoder.decode(framePayload).size());
	}

	@Test
	public void decodeThreePackets() throws Exception {

		decoder = new CcsdsPacketDecoder();

		PacketPayload packetPayload = new PacketPayload(0, new byte[35], 0);
		byte[] encodedPacket = encoder.encode(packetPayload);

		byte[] twoPackets = ArrayUtils.addAll(encodedPacket, encodedPacket);

		byte[] threePackets = ArrayUtils.addAll(twoPackets, encodedPacket);

		CcsdsFramePayload framePayload = new CcsdsFramePayload(0, 0, threePackets, true, 0);

		assertEquals(3, decoder.decode(framePayload).size());
	}

}
