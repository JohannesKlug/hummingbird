package org.hbird.transport.protocols.slip;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Observable;
import java.util.Observer;

import org.apache.commons.lang.ArrayUtils;
import org.hbird.transport.protocols.sync.slip.Slip;
import org.junit.Before;
import org.junit.Test;

public class SlipTest implements Observer {
	
	// Setting up the same marker values as those that are hard-coded in the rocket flight computer
	private static final int END = (0xC0 & 0xFF), 
								ESC = (0xDB & 0xFF), 
								ESCEND = (0xDC & 0xFF), 
								ESCESC = (0xDD & 0xFF);
	
	private Slip slip;
	
	private byte[] receivedBytes;

	@Before
	public void setUp() throws Exception {
		slip = new Slip(END, ESC, ESCEND, ESCESC);
//		SerialPortDriver driver = new SerialPortDriver();
	}

	@Test
	public void testConvertToSlip() {
		
		byte[] outputEmpty = slip.convertToSlip(ArrayUtils.EMPTY_BYTE_ARRAY);
		assertEquals((byte) (END & 0xFF), outputEmpty[0]);
		assertEquals((byte) (END & 0xFF), outputEmpty[1]);
		
		byte[] oneByteArray = new byte[1];
		oneByteArray[0] = -127;
		byte[] outputOneByte = slip.convertToSlip(oneByteArray);
		
		assertEquals(oneByteArray[0], outputOneByte[0]);
		assertEquals(END, (int) (outputOneByte[1] & 0xFF));
		assertEquals(END, (int) (outputOneByte[2] & 0xFF));
		
		oneByteArray[0] = (byte) (END & 0xFF);
		outputOneByte = slip.convertToSlip(oneByteArray);
		assertEquals(ESCEND, (int) (outputOneByte[0] & 0xFF)) ;
		assertEquals(END, (int) (outputOneByte[1] & 0xFF));
		assertEquals(END, (int) (outputOneByte[2] & 0xFF));
		assertEquals(END, (int) (outputOneByte[3] & 0xFF));
		
		oneByteArray[0] = (byte) (ESC & 0xFF);
		outputOneByte = slip.convertToSlip(oneByteArray);
		assertEquals(ESCESC, (int) (outputOneByte[0] & 0xFF));
		assertEquals(ESC, (int) (outputOneByte[1] & 0xFF));
		assertEquals(END, (int) (outputOneByte[2] & 0xFF));
		assertEquals(END, (int) (outputOneByte[3] & 0xFF));
		
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
		
		os.write(END & 0xFF);
		os.write(END);
		
		Thread.sleep(2000);
		assertEquals(0, receivedBytes.length);
	
		
		os.write(0);
		os.write(1);
		os.write(255);
		os.write(END);
		os.write(END & 0xFF);
		
		Thread.sleep(2000);
		assertEquals(3, receivedBytes.length);
		assertEquals(0, receivedBytes[0] & 0xFF);
		assertEquals(1, receivedBytes[1] & 0xFF);
		assertEquals(255, receivedBytes[2] & 0xFF);
		
	}

	@Test
	public void testReceptionOutside0and255() throws IOException, InterruptedException {

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
	
		// Testing values outside [0-255]
		
		os.write(256);
		os.write(257);
		os.write(-1);
		os.write(-2);
		os.write(END);
		os.write(END);
		
		Thread.sleep(2000);
		// 256 rolls over and is 0
		assertEquals(0, receivedBytes[0] & 0xFF);

		// 257 rolls over and is 1
		assertEquals(1, receivedBytes[1] & 0xFF);
		
		// -1 rolls over and is 255
		assertEquals(255, receivedBytes[2] & 0xFF);
		
		// -2 rolls over and is 254
		assertEquals(254, receivedBytes[3] & 0xFF);
		
	}

	@Test
	public void testReceptionWithEscapes() throws IOException, InterruptedException {

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
	
		
		// Testing escapes
		
		// We should receive a single byte (END) with this sequence
		os.write(ESCEND);
		os.write(END);
		os.write(END);
		os.write(END);
		
		Thread.sleep(2000);
		assertEquals(1, receivedBytes.length);
		assertEquals(END, receivedBytes[0] & 0xFF);

	}

	@Override
	public void update(Observable o, Object arg) {
		receivedBytes = (byte[]) arg;
	}

}
