package org.hbird.transport.protocols.ccsds.asm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Observable;
import java.util.Observer;

import org.hbird.transport.protocols.sync.asm.CcsdsAsm;
import org.junit.Before;
import org.junit.Test;


public class CcsdsAsmTest implements Observer {
	
	private CcsdsAsm asm;
	private byte[] receivedBytes;
	
	@Before
	public void setUp() {
		asm = new CcsdsAsm();
	}
	
	@Test
	public void reception() throws IOException, InterruptedException {
		PipedOutputStream os = new PipedOutputStream();
		final InputStream is = new PipedInputStream(os);

		asm.addObserver(this);
		
		Thread receiver = new Thread(
				new Runnable(){
					public void run() {
						asm.readFromStream(is);
					}
				}
		);
		receiver.start();
		//1A CF FC 1D
		os.write(0x1A);
		os.write(0xCF);
		os.write(0xFC);
		os.write(0x1D);
		os.flush();
		
		// Wait until receivedBytes is initialized. Otherwise the array's length can not be queried.
		for(int i = 10; receivedBytes == null && i <= 2550; i *= 2) {
			Thread.sleep( i );
		}	
		
		os.write(0);
		os.write(1);
		os.write(255);
		os.write(0x1A);
		os.write(0xCF);
		os.write(0xFC);
		os.write(0x1D);
		os.flush();
		
		// Wait until 3 bytes are received, but max 10ms + 20ms + 40ms + 80ms + 160ms + 320ms + 640ms + 1280ms = 2550ms.
		for(int i = 10; receivedBytes.length != 3 && i <= 2550; i *= 2) {
			Thread.sleep( i );
		}	
		
		assertEquals(3, receivedBytes.length);
		assertEquals(0, receivedBytes[0] & 0xFF);
		assertEquals(1, receivedBytes[1] & 0xFF);
		assertEquals(255, receivedBytes[2] & 0xFF);
	}
	
	@Test
	public void brokenAsm() throws IOException, InterruptedException {
		PipedOutputStream os = new PipedOutputStream();
		final InputStream is = new PipedInputStream(os);

		asm.addObserver(this);
		
		Thread receiver = new Thread(
				new Runnable(){
					public void run() {
						asm.readFromStream(is);
					}
				}
		);
		receiver.start();
		//1A CF FC 1D
		os.write(0x1A);
		os.write(0xCF);
		os.write(0xFC);
		os.write(0);
		os.write(0x1D);
		os.flush();
		
		assertNull(receivedBytes);
		
		os.write(0x1A);
		os.write(0xCF);
		os.write(0xFC);
		os.write(0x1D);
		os.flush();
		
		// Wait until receivedBytes is initialized. Otherwise the array's length can not be queried.
		for(int i = 10; receivedBytes == null && i <= 2550; i *= 2) {
			Thread.sleep( i );
		}	
		
		// Wait until 5 bytes are received, but max 10ms + 20ms + 40ms + 80ms + 160ms + 320ms + 640ms + 1280ms = 2550ms.
		for(int i = 10; receivedBytes.length != 5 && i <= 2550; i *= 2) {
			System.out.println(i);
			Thread.sleep( i );
		}	

		assertEquals(5, receivedBytes.length);
		assertEquals(0x1A, receivedBytes[0] & 0xFF);
		assertEquals(0xCF, receivedBytes[1] & 0xFF);
		assertEquals(0xFC, receivedBytes[2] & 0xFF);
		assertEquals(0, receivedBytes[3] & 0xFF);
		assertEquals(0x1D, receivedBytes[4] & 0xFF);
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		receivedBytes = (byte[]) arg1;
	}

}
