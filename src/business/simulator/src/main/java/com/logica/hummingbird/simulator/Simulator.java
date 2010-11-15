package com.logica.hummingbird.simulator;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.simulator.ccsds.SpacePacketGenerator;
import com.logica.hummingbird.simulator.graphics.URLReader;
import com.logica.hummingbird.simulator.waveforms.Waveform;

public class Simulator implements Runnable {

	private final static Logger LOG = LoggerFactory.getLogger(Simulator.class);

	private SpacePacketGenerator packetGenerator = new SpacePacketGenerator();

	/** The context of the route, used to create exchanges. */
	private CamelContext context;
	
	/** The producer sending the exchanges. */
	private ProducerTemplate template;
	
	private List<Waveform> waveforms = new ArrayList<Waveform>();

	private boolean run;

	private long messageInterval = 1000;

	private String urlToPacketise;

	/**
	 * Basic constructor.
	 * 
	 * @param context The Camel context of the route.
	 * @param template The exchange producer used to create new exchanges.
	 * @param urlToPacketise The URL from which data will be read from the packetizer.
	 */
	public Simulator(CamelContext context, ProducerTemplate template, String urlToPacketise) {
		this.context = context;
		this.template = template;
		this.urlToPacketise = urlToPacketise;
	}

	public void setMessageInterval(long messageInterval) {
		this.messageInterval = messageInterval;
	}

	public void addWaveform(Waveform waveform) {
		waveforms.add(waveform);
	}

	public Message nextMessage(Object value) {
		Message message = new DefaultMessage();
		message.setHeader("Source", "Hummingbird Simulator");
		message.setBody(value, byte[].class);
		return message;

	}

	public Exchange nextExchange(Object value) {
		Exchange exchange = new DefaultExchange(context);
		exchange.setIn(nextMessage(value));
		return exchange;
	}

	public void sendMessage(Object value) {
		template.send("direct:sendMessage", nextExchange(value));
	}

	public void stopSimulator() {
		run = false;
	}

	public void run() {
		run = true;

		// File file = new File("/dev/video0");
		// // byte[] image = FileUtils.readFileToByteArray(file);
		// byte[] bytes = new byte[640 * 480 * 3];
		// BufferedImage image = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
		//
		// FileInputStream is = null;
		// try {
		// is = new FileInputStream(file);
		// } catch (FileNotFoundException e2) {
		// // TODO Auto-generated catch block
		// e2.printStackTrace();
		// }

		while (run) {

			for (Waveform waveform : waveforms) {
				for (int i = 0; i < waveform.getReadings() && run == true; i++) {

					// TODO Passing the value down to nextMessage() is ugly. Refactor?
					// sendMessage(waveform.nextValue());

					Double doubleValue = waveform.nextValue();

					// Long value = Double.doubleToLongBits(doubleValue);
					// Long byte0 = (value & 0xFF000000 ) >>> 24;
					// Long byte1 = (value & 0x00FF0000 ) >>> 16;
					// Long byte2 = (value & 0x0000FF00 ) >>> 8;
					// Long byte3 = (value & 0x000000FF );
					// System.out.println(doubleValue);
					// byte[] payload = new byte[] {
					// byte0.byteValue(),
					// byte1.byteValue(),
					// byte2.byteValue(),
					// byte3.byteValue()
					// };
					// System.out.println();
					// System.out.println(byte0.byteValue());
					// System.out.println(byte1.byteValue());
					// System.out.println(byte2.byteValue());
					// System.out.println(byte3.byteValue());

					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					DataOutputStream dos = new DataOutputStream(bos);
					try {
						dos.writeDouble(doubleValue);
						dos.flush();
					}
					catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					// etc.
					byte[] payload = bos.toByteArray();

					sendMessage(packetGenerator.generateSpacePacket(0, payload));

					if (!(urlToPacketise == null)) {
						try {
							sendMessage(packetGenerator.generateSpacePacket(1, URLReader.readUrl(urlToPacketise)));
						}
						catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

					try {
						Thread.sleep(messageInterval);
					}
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

	public void setWaveforms(List<Waveform> waveforms) {
		this.waveforms = waveforms;
	}
}
