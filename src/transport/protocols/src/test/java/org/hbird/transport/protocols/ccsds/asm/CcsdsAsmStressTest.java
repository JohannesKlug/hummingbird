package org.hbird.transport.protocols.ccsds.asm;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hbird.transport.protocols.sync.asm.CcsdsAsm;
import org.junit.Before;
import org.junit.Test;


public class CcsdsAsmStressTest implements Observer {
	
	private CcsdsAsm asm;
	private List<byte[]> receivedFrames;
	
	@Before
	public void setUp() {
		asm = new CcsdsAsm();
		receivedFrames = new ArrayList<byte[]>();
	}
	
	@Test
	public void stressTest() throws IOException, InterruptedException {
		int iterations = 1000;
		
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
		
		for (int i=0; i<iterations; i++) {
			//1A CF FC 1D
			os.write(0x00);
			os.write(0xFF);
			os.write(0x00);
			os.write(0x1A);
			os.write(0xCF);
			os.write(0xFC);
			os.write(0x1D);
			os.flush();
		}
		
		// Wait until all Frames are received, but max 10ms + 20ms + 40ms + 80ms + 160ms + 320ms + 640ms + 1280ms = 2550ms.
		for(int i = 10; receivedFrames.size() != iterations && i <= 2550; i *= 2) {
			Thread.sleep( i );
		}	
		
		assertEquals(iterations, receivedFrames.size());
		
		for (byte[] frame : receivedFrames) {
			assertEquals(3, frame.length);
			assertEquals(0x00, frame[0]);
			assertEquals(0xFF, frame[1] & 0xFF);
			assertEquals(0x00, frame[2]);
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		receivedFrames.add((byte[]) arg1);
	}

}
