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

import org.hbird.transport.protocols.ccsds.spacepacket.CcsdsPacketDecoder;
import org.hbird.transport.protocols.ccsds.spacepacket.PacketPayload;
import org.hbird.transport.protocols.ccsds.transferframe.CcsdsFrameDecoder;
import org.hbird.transport.protocols.ccsds.transferframe.FramePayload;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.FrameFailedCrcCheckException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidFrameLengthException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidVirtualChannelIdException;

public class CcsdsFrameDispatcherTest implements Observer {

	private static final int FRAME_LENGTH = 1115;

	private List<byte[]> frames = new ArrayList<byte[]>();
	
	private CcsdsFrameDecoder frameDispatcher = new CcsdsFrameDecoder(1115, true, true);
	private CcsdsPacketDecoder packetDispatcher = new CcsdsPacketDecoder();

	List<FramePayload> receivedFramePayloads = new ArrayList<FramePayload>();
	List<PacketPayload> receivedPacketPayloads = new ArrayList<PacketPayload>();
	
	@Before
	public void setUp() throws Exception {
		FileInputStream in = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream(FRAME_LENGTH);
		try {
			in = new FileInputStream("src/test/resources/pus_displays_pml.raw");
			int c;

			int step = 0;
			
			while ((c = in.read()) != -1) {
				
				// skip the first 20 bytes
				if (step >= 20) {
					out.write(c);
				}
				
				step++;
				
				if (step == FRAME_LENGTH+20) {
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
		assertEquals(0x20, frames.get(0)[0]);
		assertEquals(0x11, frames.get(0)[1]);
		assertEquals(1115, frames.get(0).length);
	}
	
	@Test(expected=InvalidFrameLengthException.class)
	public void testInvalidFrameLength() throws InvalidFrameLengthException, FrameFailedCrcCheckException, InvalidVirtualChannelIdException {
		CcsdsFrameDecoder dispatcher = new CcsdsFrameDecoder(2046, false, false);
		dispatcher.process(new byte[2047]);
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
				FramePayload framePayload = frameDispatcher.process(frame);
				receivedFramePayloads.add(framePayload);
				packetDispatcher.process(new FramePayload(framePayload.payload, framePayload.isNextFrame));
			}
		}
		
		long runningTime = System.currentTimeMillis()-start;
		System.out.println("Ran " + runningTime + "ms.");
		System.out.println("Processed " + receivedFramePayloads.size() + " frames (" + (float)receivedFramePayloads.size()/runningTime*1000 + " frames/sec)");
		System.out.println("Processed " + receivedPacketPayloads.size() + " packets (" + (float)receivedPacketPayloads.size()/runningTime*1000 + " packets/sec)");
		assertEquals(52 * multiplier, receivedFramePayloads.size());
		assertEquals(318 * multiplier, receivedPacketPayloads.size());
		
//		for (PacketPayload packetPayload : receivedPacketPayloads) {
//			System.out.println("Packet with apid " + packetPayload.apid + " has length " + packetPayload.payload.length + " bytes.");
//		}
	}
	
	@Test
	public void testBitMask() {
  	  assertEquals(0x80, 0x80 & 0xFF);
  	  assertEquals(0x80, 0x80 & 0x80);
  	  assertEquals(0x80, 0x80 & 0xF0);
  	  
  	  int highByte = 0xFF;
  	  int lowByte = 0xFF;
  	  
  	  assertEquals(255, highByte);
  	  
  	  highByte <<= 8;
  	  int total = highByte + lowByte;
  	  assertEquals(65535, total);
	}
	
	@Test
	public void testIsNextFrame() {
		assertTrue(CcsdsFrameDecoder.isNextFrame(0, 1));
		assertFalse(CcsdsFrameDecoder.isNextFrame(1, 0));
		assertTrue(CcsdsFrameDecoder.isNextFrame(255, 0));
		assertFalse(CcsdsFrameDecoder.isNextFrame(123, 125));
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o == packetDispatcher) {
			if (arg instanceof PacketPayload) {
				PacketPayload packetPayload = (PacketPayload) arg;
				receivedPacketPayloads.add(packetPayload);
			}
			
		}
	}
	
	@Test
	public void testChain() {
	}

}
