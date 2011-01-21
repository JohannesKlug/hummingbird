package org.hbird.transport.protocols.ccsds.spacepacket;

import java.util.Observable;
import java.util.Observer;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.hbird.transport.protocols.ccsds.transferframe.FramePayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CamelPacketDispatcher implements Observer {
	
	private final static Logger LOG = LoggerFactory.getLogger(CamelPacketDispatcher.class);
	
	private CcsdsPacketDispatcher packetDispatcher = new CcsdsPacketDispatcher();
	private Object returnedObject;
	
	public CamelPacketDispatcher() {
		packetDispatcher.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		returnedObject = arg1;
	}
	
	public Message process(Exchange exchange) {
		
		packetDispatcher.process(new FramePayload((byte[]) exchange.getIn().getBody(), true));
		Message message = new DefaultMessage();
		
		if (returnedObject instanceof PacketPayload) {
			PacketPayload payload = (PacketPayload) returnedObject;
			LOG.info("Processed packet with ApId: " + payload.apid);
			message.setHeader("ApId", payload.apid);
			message.setBody(payload.payload);
		} else {
			LOG.error("Returned object was not a PacketPayload");
		}
		
		return message;
		
		
		
		
	}

}
