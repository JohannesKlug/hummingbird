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
		
		Thread.sleep(2000);
		assertEquals(0, receivedBytes.length);
	
		
		os.write(0);
		os.write(1);
		os.write(255);
		os.write(0x1A);
		os.write(0xCF);
		os.write(0xFC);
		os.write(0x1D);
		
		Thread.sleep(2000);
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
		
		Thread.sleep(2000);
		assertNull(receivedBytes);
		
		os.write(0x1A);
		os.write(0xCF);
		os.write(0xFC);
		os.write(0x1D);
		
		Thread.sleep(2000);
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
