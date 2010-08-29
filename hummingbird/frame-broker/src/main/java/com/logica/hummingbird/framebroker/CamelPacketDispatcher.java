package com.logica.hummingbird.framebroker;

import java.util.Observable;
import java.util.Observer;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;

public class CamelPacketDispatcher implements Observer {
	
	private CcsdsPacketDispatcher packetDispatcher = new CcsdsPacketDispatcher();
	private Object returnedObject;

	@Override
	public void update(Observable arg0, Object arg1) {
		returnedObject = arg1;
	}
	
	public Message process(Exchange exchange) {
		
		packetDispatcher.process((byte[]) exchange.getIn().getBody(), true);
		Message message = new DefaultMessage();
		
		if (returnedObject instanceof PacketPayload) {
			PacketPayload payload = (PacketPayload) returnedObject;
			message.setHeader("ApId", payload.apid);
			message.setBody(payload.payload);
		}
		
		return message;
		
		
		
		
	}

}
