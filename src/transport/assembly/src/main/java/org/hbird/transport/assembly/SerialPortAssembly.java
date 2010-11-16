package org.hbird.transport.assembly;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import org.hbird.transport.protocols.hardware.SerialPortDriver;
import org.hbird.transport.protocols.slip.Slip;

public class SerialPortAssembly implements Observer {

	private static final int END = (0xC0 & 0xFF), 
							ESC = (0xDB & 0xFF), 
							ESCEND = (0xDC & 0xFF), 
							ESCESC = (0xDD & 0xFF);

	private SerialPortDriver driver;
	private Slip slip;

	private byte[] receivedBytes;

	public SerialPortAssembly(String commPortId) {
		try {
			driver = new SerialPortDriver(commPortId);
			slip = new Slip(END, ESC, ESCEND, ESCESC);
			slip.addObserver(this);
			
			Thread receiver = new Thread(
					new Runnable(){
						public void run() {
							try {
								slip.readFromStream(driver.getInputStream());
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
		System.out.println("Received " + receivedBytes.length + " bytes:");
		System.out.println(new String(receivedBytes));
		System.out.println("---------------------------------------------");
		
	}

}
