package com.logica.hummingbird.protocols.hardware;

import static org.junit.Assert.*;
import gnu.io.NoSuchPortException;

import org.junit.Before;
import org.junit.Test;

public class SerialPortDriverTest {
	
	private SerialPortDriver driver;

	@Before
	public void setUp() throws Exception {
		try {
			driver = new SerialPortDriver("/dev/ttyUSB0");
		} catch (NoSuchPortException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testSerialPortDriver() {
//		fail("Not yet implemented");
	}

}
