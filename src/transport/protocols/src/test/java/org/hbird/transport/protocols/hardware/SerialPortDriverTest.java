package org.hbird.transport.protocols.hardware;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SerialPortDriverTest {

	//private SerialPortDriver driver;

	@Before
	public void setUp() throws Exception {
		//driver = new SerialPortDriver("/dev/ttyUSB0");
	}

	@Test
	@Ignore
	public void testSerialPortDriver() throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException {
		// fail("Not yet implemented");
		// FIXME How to test without a serial port library? How could we mock it?
		SerialPortDriver driver = new SerialPortDriver("COM5");
		driver.getSerialPort().setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

		InputStream inStream = driver.getInputStream();
		int b = 0;
		System.out.println("Beginning stream read...");
//		while ((b = inStream.read()) != -1) {
		int low = 0;
		int high = 0;
		while (true) {
			b = inStream.read();
			System.out.println(b);
		}
//		System.out.println("End of stream.");
	}

}
