package org.hbird.protocols.ccsds;


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

import org.hbird.protocols.ccsds.spacepacket.CcsdsPacketDispatcher;
import org.hbird.protocols.ccsds.spacepacket.PacketPayload;
import org.hbird.protocols.ccsds.transferframe.CcsdsFrameDispatcher;
import org.hbird.protocols.ccsds.transferframe.FramePayload;
import org.hbird.protocols.ccsds.transferframe.exceptions.FrameFailedCrcCheckException;
import org.hbird.protocols.ccsds.transferframe.exceptions.InvalidFrameLengthException;

public class CcsdsFrameDispatcherTest implements Observer {

	private List<byte[]> frames = new ArrayList<byte[]>();
	
	private CcsdsFrameDispatcher frameDispatcher = new CcsdsFrameDispatcher();
	private CcsdsPacketDispatcher packetDispatcher = new CcsdsPacketDispatcher();

	List<FramePayload> receivedFramePayloads = new ArrayList<FramePayload>();
	List<PacketPayload> receivedPacketPayloads = new ArrayList<PacketPayload>();
	
	@Before
	public void setUp() throws Exception {
		FileInputStream in = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream(1135);
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
				
				if (step == 1135) {
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
	public void testInvalidFrameLength() throws InvalidFrameLengthException, FrameFailedCrcCheckException {
		CcsdsFrameDispatcher dispatcher = new CcsdsFrameDispatcher();
		dispatcher.process(new byte[2047]);
	}
	
	@Test
	public void injectFrame() throws InvalidFrameLengthException, FrameFailedCrcCheckException, InterruptedException {
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
				packetDispatcher.process(framePayload.payload, framePayload.isNextFrame);
			}
			
		} else if (o == packetDispatcher) {
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
