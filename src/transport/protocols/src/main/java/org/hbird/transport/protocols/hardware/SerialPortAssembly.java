package org.hbird.transport.protocols.hardware;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.hbird.transport.protocols.sync.FrameSynchroniser;
import org.hbird.transport.protocols.sync.ObservableFrameSynchroniser;
import org.hbird.transport.protocols.sync.asm.CcsdsAsm;
import org.hbird.transport.protocols.sync.slip.Slip;

public class SerialPortAssembly implements Observer {

	@EndpointInject(uri="activemq:slipstream")
	ProducerTemplate producer;
	
	// FIXME These should be removed and put into the default constructor for SLIP
	private static final int END = (0xC0 & 0xFF), 
							ESC = (0xDB & 0xFF), 
							ESCEND = (0xDC & 0xFF), 
							ESCESC = (0xDD & 0xFF);

	private SerialPortDriver driver;

	private byte[] receivedBytes;
	
	// Default: use /dev/ttyUSB0 and CCSDS ASM for frame sync
	public SerialPortAssembly() {
		this("/dev/ttyUSB0", new CcsdsAsm());
	}

	public SerialPortAssembly(String commPortId, final ObservableFrameSynchroniser sync) {
		try {
			driver = new SerialPortDriver(commPortId);
			sync.addObserver(this);
			
			Thread receiver = new Thread(
					new Runnable(){
						public void run() {
							try {
								sync.readFromStream(driver.getInputStream());
							}
							catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
			);
			receiver.start();
			
			
			
		}
		catch (NoSuchPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (PortInUseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (UnsupportedCommOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	
	public void closePort() {
		driver.closePort();
	}

	@Override
	public void update(Observable o, Object arg) {
		receivedBytes = (byte[]) arg;
		producer.sendBody(receivedBytes);
		System.out.println("Received " + receivedBytes.length + " bytes:");
		String receivedBytesInHex = "";
		for (byte b : receivedBytes) {
			receivedBytesInHex += Integer.toHexString(b & 0xFF) + " ";
		}
		System.out.println(receivedBytesInHex);
		System.out.println("---------------------------------------------");
		
	}

}
