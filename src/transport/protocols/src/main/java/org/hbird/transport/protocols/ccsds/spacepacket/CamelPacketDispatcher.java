package org.hbird.transport.protocols.ccsds.spacepacket;

import java.util.Observable;
import java.util.Observer;

import org.apache.camel.Endpoint;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.hbird.transport.protocols.ccsds.transferframe.FramePayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CamelPacketDispatcher implements Observer {
	
	private final static Logger LOG = LoggerFactory.getLogger(CamelPacketDispatcher.class);
	
	private CcsdsPacketDispatcher packetDispatcher = new CcsdsPacketDispatcher();
	
	// FIXME: inject a Camel thingy here.
	Endpoint endpoint;
	
	public CamelPacketDispatcher() {
		packetDispatcher.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof PacketPayload) {
			PacketPayload payload = (PacketPayload) arg1;
			LOG.info("Processed packet with ApId: " + payload.apid);
			DefaultMessage message = new DefaultMessage();
			message.setHeader("ApId", payload.apid);
			message.setBody(payload.payload);
			// FIXME send this message somewhere. 
		} else {
			LOG.error("Returned object was not a PacketPayload");
		}
	}
	
	public void process(Message message) {
		
		if (message.getBody() instanceof FramePayload) {
			
			FramePayload payload = (FramePayload) message.getBody();
			
			packetDispatcher.process(new FramePayload(payload.payload, payload.isNextFrame));
			
		} else {
			LOG.error("I was given an object that is not a FramePayload");
		}
	}

}
