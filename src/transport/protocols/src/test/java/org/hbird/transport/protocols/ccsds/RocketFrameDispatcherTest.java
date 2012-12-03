package org.hbird.transport.protocols.ccsds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.hbird.transport.protocols.ccsds.spacepacket.CcsdsPacketDecoder;
import org.hbird.transport.protocols.ccsds.spacepacket.data.PacketPayload;
import org.hbird.transport.protocols.ccsds.transferframe.CcsdsFrameDecoder;
import org.hbird.transport.protocols.ccsds.transferframe.data.FramePayload;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.FrameFailedCrcCheckException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidFrameLengthException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidVirtualChannelIdException;
import org.junit.Before;
import org.junit.Test;

public class RocketFrameDispatcherTest {

	private static final int FRAME_LENGTH = 13;

	private final List<byte[]> frames = new ArrayList<byte[]>();

	private final CcsdsFrameDecoder frameDispatcher = new CcsdsFrameDecoder(FRAME_LENGTH, false, false);
	private final CcsdsPacketDecoder packetDispatcher = new CcsdsPacketDecoder();

	@Before
	public void setUp() throws Exception {
		FileInputStream in = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream(1135);
		try {
			in = new FileInputStream("src/test/resources/ID-Thunderbird-EGSE-39547-1298901661910-0-0-1-1-2");
			int c;

			int step = 0;

			while ((c = in.read()) != -1) {

				out.write(c);

				step++;

				if (step == FRAME_LENGTH) {
					step = 0;
					frames.add(out.toByteArray());
					out.reset();
				}

			}

		}
		finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}

	}

	@Test
	public void testReadFrame() {
		assertEquals(FRAME_LENGTH, frames.get(0).length);
	}

	@Test
	public void injectFrame() throws InvalidFrameLengthException, FrameFailedCrcCheckException, InterruptedException, InvalidVirtualChannelIdException {
		List<FramePayload> receivedFramePayloads = new ArrayList<FramePayload>();
		List<PacketPayload> receivedPacketPayloads = new ArrayList<PacketPayload>();
		int multiplier = 10;

		for (int i = 0; i < multiplier; i++) {
			for (byte[] frame : frames) {
				FramePayload framePayload = frameDispatcher.decode(frame);
				receivedFramePayloads.add(framePayload);
				List<PacketPayload> payloads = packetDispatcher.decode(new FramePayload(framePayload.payload, framePayload.isNextFrame, 0));

				receivedPacketPayloads.addAll(payloads);
				for (byte currentByte : payloads.get(0).payload) {
					assertEquals(0x1e, currentByte);
				}
			}
		}

		assertEquals(1 * multiplier, receivedFramePayloads.size());
		assertEquals(1 * multiplier, receivedPacketPayloads.size());
	}

	@Test
	public void testIsNextFrame() {
		assertTrue(CcsdsFrameDecoder.isNextFrame(0, 1));
		assertFalse(CcsdsFrameDecoder.isNextFrame(1, 0));
		assertTrue(CcsdsFrameDecoder.isNextFrame(255, 0));
		assertFalse(CcsdsFrameDecoder.isNextFrame(123, 125));
	}

	@Test
	public void testChain() {
	}

}
