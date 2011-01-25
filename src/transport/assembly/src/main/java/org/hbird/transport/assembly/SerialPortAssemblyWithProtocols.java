package org.hbird.transport.assembly;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hbird.transport.protocols.ccsds.spacepacket.CcsdsPacketDispatcher;
import org.hbird.transport.protocols.ccsds.spacepacket.PacketPayload;
import org.hbird.transport.protocols.ccsds.transferframe.CcsdsFrameDispatcher;
import org.hbird.transport.protocols.ccsds.transferframe.CcsdsFramePayload;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.FrameFailedCrcCheckException;
import org.hbird.transport.protocols.ccsds.transferframe.exceptions.InvalidFrameLengthException;
import org.hbird.transport.protocols.hardware.SerialPortDriver;
import org.hbird.transport.protocols.slip.Slip;

public class SerialPortAssemblyWithProtocols implements Observer {

	private static final int END = (0xC0 & 0xFF), 
							ESC = (0xDB & 0xFF), 
							ESCEND = (0xDC & 0xFF), 
							ESCESC = (0xDD & 0xFF);

	private SerialPortDriver driver;
	private Slip slip;
	
	private List<byte[]> frames = new ArrayList<byte[]>();
	
	private CcsdsFrameDispatcher frameDispatcher = new CcsdsFrameDispatcher();
	private CcsdsPacketDispatcher packetDispatcher = new CcsdsPacketDispatcher();

	private byte[] receivedBytes;

	public SerialPortAssemblyWithProtocols(String commPortId) {
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
		if (o == slip) {
			if (arg instanceof byte[]) {
				receivedBytes = (byte[]) arg;
				System.out.println("Received frame from SLIP protocol. In total: " + receivedBytes.length + " bytes:");
				System.out.println(new String(receivedBytes));
				System.out.println("---------------------------------------------");
				try {
					frameDispatcher.process(receivedBytes);
				} catch (InvalidFrameLengthException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FrameFailedCrcCheckException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (o == frameDispatcher) {
			if (arg instanceof CcsdsFramePayload) {
				CcsdsFramePayload framePayload = (CcsdsFramePayload) arg;
				System.out.println("Received processed frame payload from frame dispatcher: " + framePayload.toString());
				packetDispatcher.process(framePayload);
			}
			
		} else if (o == packetDispatcher) {
			if (arg instanceof PacketPayload) {
				PacketPayload packetPayload = (PacketPayload) arg;
				System.out.println("Received processed packet payload from packet dispatcher: " + packetPayload.toString());
				
			}
			
		}
	}

}
