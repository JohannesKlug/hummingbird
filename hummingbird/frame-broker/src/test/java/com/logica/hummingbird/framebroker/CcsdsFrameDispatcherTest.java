package com.logica.hummingbird.framebroker;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.logica.hummingbird.framebroker.exceptions.FrameFailedCrcCheckException;
import com.logica.hummingbird.framebroker.exceptions.InvalidFrameLengthException;

public class CcsdsFrameDispatcherTest {

	private List<byte[]> frames = new ArrayList<byte[]>();
	
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
	public void injectFrame() throws InvalidFrameLengthException, FrameFailedCrcCheckException {
		CcsdsFrameDispatcher dispatcher = new CcsdsFrameDispatcher();
		for (byte[] frame : frames) {
			dispatcher.process(frame);
		}
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
		//CcsdsFrameDispatcher
		assertTrue(CcsdsFrameDispatcher.isNextFrame(0, 1));
		assertTrue(CcsdsFrameDispatcher.isNextFrame(0, 1));
	}

}
