package com.logica.hummingbird.protocols.slip;

import static org.junit.Assert.*;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

import com.logica.hummingbird.protocols.hardware.SerialPortDriver;

public class SlipTest {
	
	// Setting up the same marker values as those that are hard-coded in the rocket flight computer
	private static final byte END = -64, ESC = -37, ESCEND = -36, ESCESC = -35;
	
	private Slip slip;

	@Before
	public void setUp() throws Exception {
		slip = new Slip(END, ESC, ESCEND, ESCESC);
//		SerialPortDriver driver = new SerialPortDriver();
	}

	@Test
	public void testConvertToSlip() {
		assertEquals((byte)0xC0, END);
		assertEquals((byte)0xDB, ESC);
		assertEquals((byte)0xDC, ESCEND);
		assertEquals((byte)0xDD, ESCESC);
		
		byte[] outputEmpty = slip.convertToSlip(ArrayUtils.EMPTY_BYTE_ARRAY);
		assertEquals(END, outputEmpty[0]);
		
		byte[] oneByteArray = new byte[1];
		oneByteArray[0] = -127;
		byte[] outputOneByte = slip.convertToSlip(oneByteArray);
		
		assertEquals(oneByteArray[0], outputOneByte[0]);
		assertEquals(END, outputOneByte[1]);
		
		oneByteArray[0] = END;
		outputOneByte = slip.convertToSlip(oneByteArray);
		assertEquals(ESCEND, outputOneByte[0]);
		assertEquals(END, outputOneByte[1]);
		assertEquals(END, outputOneByte[2]);
		
		oneByteArray[0] = ESC;
		outputOneByte = slip.convertToSlip(oneByteArray);
		assertEquals(ESCESC, outputOneByte[0]);
		assertEquals(ESC, outputOneByte[1]);
		assertEquals(END, outputOneByte[2]);
		
	}

}
