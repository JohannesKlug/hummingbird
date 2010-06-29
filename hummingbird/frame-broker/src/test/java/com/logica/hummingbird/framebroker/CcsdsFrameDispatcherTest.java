package com.logica.hummingbird.framebroker;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;

import com.logica.hummingbird.framebroker.exceptions.InvalidFrameLengthException;

public class CcsdsFrameDispatcherTest {

	private byte[] frame0;
	
	@Before
	public void setUp() throws Exception {
		FileInputStream in = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream(1115);
		try {
			in = new FileInputStream("src/test/resources/frame0.raw");
			int c;

			while ((c = in.read()) != -1) {
				out.write(c);
			}

		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
		
		frame0 = out.toByteArray();
	}
	
	@Test
	public void testReadFrame() {
		assertEquals(0x20, frame0[0]);
		assertEquals(0x11, frame0[1]);
		assertEquals(1115, frame0.length);
	}
	
	@Test(expected=InvalidFrameLengthException.class)
	public void testInvalidFrameLength() throws InvalidFrameLengthException {
		CcsdsFrameDispatcher dispatcher = new CcsdsFrameDispatcher();
		dispatcher.process(new byte[2047]);
	}
	
	@Test
	public void injectFrame() throws InvalidFrameLengthException {
		CcsdsFrameDispatcher dispatcher = new CcsdsFrameDispatcher();
		dispatcher.process(frame0);
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
