package org.hbird.transport.protocols.ccsds;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

import org.hbird.transport.protocols.ccsds.spacepacket.CcsdsPacketDispatcher;
import org.hbird.transport.protocols.ccsds.spacepacket.PacketPayload;
import org.hbird.transport.protocols.ccsds.transferframe.CcsdsFrameDispatcher;
import org.hbird.transport.protocols.ccsds.transferframe.FramePayload;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.FrameFailedCrcCheckException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidFrameLengthException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidVirtualChannelIdException;

public class RocketFrameDispatcherTest implements Observer {

	private static final int FRAME_LENGTH = 13;

	private List<byte[]> frames = new ArrayList<byte[]>();
	
	private CcsdsFrameDispatcher frameDispatcher = new CcsdsFrameDispatcher(FRAME_LENGTH, false, false);
	private CcsdsPacketDispatcher packetDispatcher = new CcsdsPacketDispatcher();

	List<FramePayload> receivedFramePayloads = new ArrayList<FramePayload>();
	List<PacketPayload> receivedPacketPayloads = new ArrayList<PacketPayload>();
	
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

		} finally {
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
		System.out.println("Loaded " + frames.size() + " frames from file.");
		assertEquals(FRAME_LENGTH, frames.get(0).length);
	}
	
	@Test
	public void injectFrame() throws InvalidFrameLengthException, FrameFailedCrcCheckException, InterruptedException, InvalidVirtualChannelIdException {
		frameDispatcher.addObserver(this);
		packetDispatcher.addObserver(this);
//		List<byte[]> manyFrames = frames.
		
		int multiplier = 1;
		
		long start = System.currentTimeMillis();
		for (int i=0; i<multiplier; i++) {
			for (byte[] frame : frames) {
				frameDispatcher.process(frame);
			}
		}
		
		long runningTime = System.currentTimeMillis()-start;
		System.out.println("Ran " + runningTime + "ms.");
		System.out.println("Processed " + receivedFramePayloads.size() + " frames (" + (float)receivedFramePayloads.size()/runningTime*1000 + " frames/sec)");
		System.out.println("Processed " + receivedPacketPayloads.size() + " packets (" + (float)receivedPacketPayloads.size()/runningTime*1000 + " packets/sec)");
		assertEquals(1 * multiplier, receivedFramePayloads.size());
		assertEquals(1 * multiplier, receivedPacketPayloads.size());
		
//		for (PacketPayload packetPayload : receivedPacketPayloads) {
//			System.out.println("Packet with apid " + packetPayload.apid + " has length " + packetPayload.payload.length + " bytes.");
//		}
	}
	
	@Test
	public void testIsNextFrame() {
		assertTrue(CcsdsFrameDispatcher.isNextFrame(0, 1));
		assertFalse(CcsdsFrameDispatcher.isNextFrame(1, 0));
		assertTrue(CcsdsFrameDispatcher.isNextFrame(255, 0));
		assertFalse(CcsdsFrameDispatcher.isNextFrame(123, 125));
	}

	@Override
	public void update(Observable o, Object arg) {
//		System.out.println("Called from: " + o + " with object: " + arg);
		if (o == frameDispatcher) {
			if (arg instanceof FramePayload) {
				FramePayload framePayload = (FramePayload) arg;
				receivedFramePayloads.add(framePayload);
				packetDispatcher.process(new FramePayload(framePayload.payload, framePayload.isNextFrame));
			}
			
		} else if (o == packetDispatcher) {
			if (arg instanceof PacketPayload) {
				PacketPayload packetPayload = (PacketPayload) arg;
				receivedPacketPayloads.add(packetPayload);
				for (byte currentByte : packetPayload.payload) {
					System.out.println(Integer.toHexString(currentByte));
					assertEquals(0x1e, currentByte);
				}
			}
			
		}
		
		
	}
	
	@Test
	public void testChain() {
	}

}
