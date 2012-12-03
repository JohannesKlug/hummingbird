package org.hbird.transport.protocols.hardware;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerialPortDriver {
	private static final Logger LOG = LoggerFactory.getLogger(SerialPortDriver.class);

	private final SerialPort serialPort;

	public SerialPortDriver(final String portIdentifier) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException {

		Enumeration<?> pList = CommPortIdentifier.getPortIdentifiers();

		while (pList.hasMoreElements()) {
			CommPortIdentifier cpi = (CommPortIdentifier) pList.nextElement();
		}

		CommPortIdentifier cpi;

		cpi = CommPortIdentifier.getPortIdentifier(portIdentifier);

		serialPort = (SerialPort) cpi.open("Hummingbird", 2000);
		serialPort.setSerialPortParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		LOG.debug(serialPort.getName() + " is open");
	}

	public InputStream getInputStream() throws IOException {
		return serialPort.getInputStream();
	}

	public OutputStream getOutputStream() throws IOException {
		return serialPort.getOutputStream();
	}

	public void closePort() {
		serialPort.close();
	}

	public SerialPort getSerialPort() {
		return serialPort;
	}

}
