package org.hbird.transport.protocols.hardware;

import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.hbird.transport.protocols.sync.ObservableFrameSynchroniser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketAssembly implements Observer {
	private final static Logger LOG = LoggerFactory.getLogger(SocketAssembly.class);

	@EndpointInject(uri = "activemq:slipstream")
	ProducerTemplate producer;

	private byte[] receivedBytes;

	public SocketAssembly(final Socket socket, final ObservableFrameSynchroniser sync) {
		sync.addObserver(this);

		Thread receiver = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					sync.readFromStream(socket.getInputStream());
				} catch (IOException e) {
					LOG.error(e.toString());
				}
			}
		});
		receiver.start();
	}

	@Override
	public void update(Observable o, Object arg) {
		receivedBytes = (byte[]) arg;
		producer.sendBody(receivedBytes);
		LOG.debug("Received " + receivedBytes.length + " bytes:");
		String receivedBytesInHex = "";
		for (byte b : receivedBytes) {
			receivedBytesInHex += Integer.toHexString(b & 0xFF) + " ";
		}
		LOG.debug(receivedBytesInHex);
		LOG.debug("---------------------------------------------");

	}

}
