package com.logica.hummingbird;

import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.framebroker.CcsdsPacketDispatcher;
import com.logica.hummingbird.framebroker.PacketPayload;

public class PacketViewer implements Observer {
	
	private final static Logger LOG = LoggerFactory.getLogger(PacketViewer.class);
	
	private JLabel label;
	private JPanel panel;
	private Label swtLabel;
	
	private CcsdsPacketDispatcher packetDispatcher = new CcsdsPacketDispatcher();

	/**
	 * @param args
	 */
	public PacketViewer() {
		
		packetDispatcher.addObserver(this);
		
		
//		 Display display = new Display();
//		    Shell shell = new Shell();
//		    shell.setLayout(new GridLayout(1, false));
//
//		    // Create a label
//		    label = new Label(shell, SWT.NONE);
//		    label.setText("Test");
//
////		    // Create a vertical separator
////		    new Label(shell, SWT.SEPARATOR);
////
////		    // Create a label with a border
////		    new Label(shell, SWT.BORDER).setText("This is a label with a border.");
////
////		    // Create a horizontal separator
////		    Label separator = new Label(shell, SWT.HORIZONTAL | SWT.SEPARATOR);
////		    separator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//
//		    // Create a label with an image
////		    Image image = new Image(display, "interspatial.gif");
////		    Label imageLabel = new Label(shell, SWT.NONE);
////		    imageLabel.setImage(image);
//		    
//		    shell.open();
//		    while (!shell.isDisposed()) {
//		      if (!display.readAndDispatch()) {
//		        display.sleep();
//		      }
//		    }
//		    display.dispose();
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 650, 512 );
		frame.setLocationRelativeTo( null );
		frame.setVisible(true);
		
		label = new JLabel();
		
//		frame.add(label);
		
//		label.setText("Waiting for first packet ...");
		
//		panel = new JPanel();
//		
//		frame.add(panel);
//		panel.setVisible(true);
		
		frame.add(label);

	}
	
	public void packetIn(Exchange exchange) {
		Message message = exchange.getIn();
		byte[] body = message.getBody(byte[].class);
		packetDispatcher.process(body, true);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Object returnedObject = arg1;
		
		if (returnedObject instanceof PacketPayload) {
			PacketPayload payload = (PacketPayload) returnedObject;
//			LOG.info("Processed packet with ApId: " + payload.apid);
//			label.setText("ApId: " + payload.apid);
			
			if (payload.apid == 1) {
//				BufferedImage image = null;
				
//				try {
//					image = ImageIO.read(new ByteArrayInputStream(payload.payload));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				ImageIcon icon = new ImageIcon(payload.payload);
				label.setIcon(icon);
			} else if (payload.apid == 0) {
				
//				long byte0 = ( payload.payload[0] & 0xFF) << 24;
//				long byte1 = ( payload.payload[1] & 0xFF) << 16;
//				long byte2 = ( payload.payload[2] & 0xFF) << 8;
//				long byte3 = payload.payload[3] & 0xFF ;
//				
//				long longBits = byte0 + byte1 + byte2 + byte3;
//				double value = Double.longBitsToDouble(longBits);
				ByteArrayInputStream bis = new ByteArrayInputStream(payload.payload);
				DataInputStream dis = new DataInputStream(bis);
				
				double value = 0;
				try {
					value = dis.readDouble();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				LOG.info("Telemetry reading received: " + value);
				
			}
			
		} else {
			LOG.error("Returned object was not a PacketPayload");
		}
		
	}
	
}
