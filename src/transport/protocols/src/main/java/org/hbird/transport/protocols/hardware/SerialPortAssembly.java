package org.hbird.transport.protocols.hardware;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.hbird.transport.protocols.sync.ObservableFrameSynchroniser;
import org.hbird.transport.protocols.sync.asm.CcsdsAsm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerialPortAssembly implements Observer {
	private static final int SIGN_BYTE_MASK = 0xFF;

	private static final Logger LOG = LoggerFactory.getLogger(SerialPortAssembly.class);

	// FIXME hardcoded lol
	@EndpointInject(uri = "activemq:slipstream")
	ProducerTemplate producer;

	// FIXME These should be removed and put into the default constructor for SLIP
	private static final int END = (0xC0 & 0xFF);
	private static final int ESC = (0xDB & 0xFF);
	private static final int ESCEND = (0xDC & 0xFF);
	private static final int ESCESC = (0xDD & 0xFF);

	private SerialPortDriver driver;

	// Default: use /dev/ttyUSB0 and CCSDS ASM for frame sync
	public SerialPortAssembly() {
		this("COM5", new CcsdsAsm());
	}

	public SerialPortAssembly(final String commPortId, final ObservableFrameSynchroniser sync) {
		try {
			driver = new SerialPortDriver(commPortId);
			sync.addObserver(this);

			Thread receiverThread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						sync.readFromStream(driver.getInputStream());
					}
					catch (IOException e) {
						LOG.error(e.toString());
					}
					finally {
						closePort();
					}
				}
			});
			receiverThread.start();

		}
		catch (NoSuchPortException e) {
			LOG.error(e.toString());
		}
		catch (PortInUseException e) {
			LOG.error(e.toString());
		}
		catch (UnsupportedCommOperationException e) {
			LOG.error(e.toString());
		}

	}

	public void closePort() {
		driver.closePort();
	}

	@Override
	public void update(final Observable o, final Object arg) {
		byte[] receivedBytes = (byte[]) arg;
		producer.sendBody(receivedBytes);
		LOG.debug("Received " + receivedBytes.length + " bytes:");
		String receivedBytesInHex = "";
		for (byte b : receivedBytes) {
			receivedBytesInHex += Integer.toHexString(b & SIGN_BYTE_MASK) + " ";
		}
		LOG.debug(receivedBytesInHex);
		LOG.debug("---------------------------------------------");

	}

}
