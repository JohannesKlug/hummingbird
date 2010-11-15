package org.hbird.protocols.hardware;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class SerialPortDriver {
	
	private SerialPort serialPort;

	public SerialPortDriver(String portIdentifier) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException {

		Enumeration<?> pList = CommPortIdentifier.getPortIdentifiers();

		while (pList.hasMoreElements()) {
			CommPortIdentifier cpi = (CommPortIdentifier) pList.nextElement();
			System.out.print("Port " + cpi.getName() + " ");
			if (cpi.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				System.out.println("is a Serial Port: " + cpi);
			}
			else if (cpi.getPortType() == CommPortIdentifier.PORT_PARALLEL) {
				System.out.println("is a Parallel Port: " + cpi);
			}
			else {
				System.out.println("is an Unknown Port: " + cpi);
			}
		}

		CommPortIdentifier cpi;

		cpi = CommPortIdentifier.getPortIdentifier(portIdentifier);

		serialPort = (SerialPort) cpi.open("Hummingbird", 2000);
		serialPort.setSerialPortParams(57600, 
			       SerialPort.DATABITS_8, 
			       SerialPort.STOPBITS_1, 
			       SerialPort.PARITY_NONE);


	}

	public InputStream getInputStream() throws IOException {
		return serialPort.getInputStream();
	}
	
	public void closePort() {
		serialPort.close();
	}

}
