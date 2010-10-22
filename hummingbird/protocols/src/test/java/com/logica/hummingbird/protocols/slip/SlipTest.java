package com.logica.hummingbird.protocols.slip;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Observable;
import java.util.Observer;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

import com.logica.hummingbird.protocols.hardware.SerialPortDriver;

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
		
		byte[] oneByteArray = new byte[1];
		oneByteArray[0] = -127;
		byte[] outputOneByte = slip.convertToSlip(oneByteArray);
		
		assertEquals(oneByteArray[0], outputOneByte[0]);
		assertEquals(END, (int) (outputOneByte[1] & 0xFF));
		
		oneByteArray[0] = (byte) (END & 0xFF);
		outputOneByte = slip.convertToSlip(oneByteArray);
		assertEquals(ESCEND, (int) (outputOneByte[0] & 0xFF)) ;
		assertEquals(END, (int) (outputOneByte[1] & 0xFF));
		assertEquals(END, (int) (outputOneByte[2] & 0xFF));
		
		oneByteArray[0] = (byte) (ESC & 0xFF);
		outputOneByte = slip.convertToSlip(oneByteArray);
		assertEquals(ESCESC, (int) (outputOneByte[0] & 0xFF));
		assertEquals(ESC, (int) (outputOneByte[1] & 0xFF));
		assertEquals(END, (int) (outputOneByte[2] & 0xFF));
		
	}
	
	@Test
	public void testReception() throws IOException, InterruptedException {
		PipedOutputStream os = new PipedOutputStream();
		
		final InputStream is = new PipedInputStream(os);
		os.write(END & 0xFF);
		slip.addObserver(this);
		new Thread(
				new Runnable(){
					public void run() {
						slip.readFromStream(is);
					}
				}
		).start();
		Thread.sleep(100);
		assertEquals(0, receivedBytes.length);
	
		

	}

	@Override
	public void update(Observable o, Object arg) {
		receivedBytes = (byte[]) arg;
	}

}
