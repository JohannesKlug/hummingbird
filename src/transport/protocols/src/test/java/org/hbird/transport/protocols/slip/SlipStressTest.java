package org.hbird.transport.protocols.slip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hbird.transport.protocols.sync.slip.Slip;
import org.junit.Before;
import org.junit.Test;

public class SlipStressTest implements Observer {
	
	// Setting up the same marker values as those that are hard-coded in the rocket flight computer
	private static final int END = (0xC0 & 0xFF), 
								ESC = (0xDB & 0xFF), 
								ESCEND = (0xDC & 0xFF), 
								ESCESC = (0xDD & 0xFF);
	
	private Slip slip;
	
	String originalString = "This is a really long String I expect to be received intact.";
	byte[] originalBytes = originalString.getBytes();
	
	private List<byte[]> receivedBytes = new ArrayList<byte[]>();

	@Before
	public void setUp() throws Exception {
		slip = new Slip(END, ESC, ESCEND, ESCESC);
//		SerialPortDriver driver = new SerialPortDriver();
	}

	
	@Test
	public void testReception() throws IOException, InterruptedException {
	
		PipedOutputStream os = new PipedOutputStream();
		final InputStream is = new PipedInputStream(os);

		slip.addObserver(this);
		
		Thread receiver = new Thread(
				new Runnable(){
					public void run() {
						slip.readFromStream(is);
					}
				}
		);
		receiver.start();
		
		byte[] bytesToSend = slip.convertToSlip(originalBytes);
		
		for (int i=0; i<10000; i++) {
			os.write(bytesToSend);
		}
		os.flush();
		
		// Wait until 10000 bytes are received, but max 10ms + 20ms + 40ms + 80ms + 160ms + 320ms + 640ms + 1280ms = 2550ms.
		for(int i = 10; receivedBytes.size() != 10000 && i <= 2550; i *= 2) {
			Thread.sleep( i );
		}	
		
		assertEquals(10000, receivedBytes.size());
		for (byte[] bytes : receivedBytes) {
			assertTrue(Arrays.equals(originalBytes, bytes));
		}
	}


	@Override
	public void update(Observable o, Object arg) {
		receivedBytes.add((byte[]) arg);
	}

}
