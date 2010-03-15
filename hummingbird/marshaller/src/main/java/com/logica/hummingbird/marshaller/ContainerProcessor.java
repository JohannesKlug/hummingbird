/* ----------------------------------------------------------------------------
 * (c) Copyright Logica 2010
 *
 * All rights reserved. This document is protected by international copyright 
 * law and may not be reprinted, reproduced, copied or utilised in whole or in 
 * part by any means including electronic, mechanical, or other means without 
 * the prior written consent of Logica. 
 * Whilst reasonable care has been taken by Logica to ensure the information 
 * contained herein is reasonably accurate, Logica shall not, under any 
 * circumstances be liable for any loss or damage (direct or consequential) 
 * suffered by any party as a result of the contents of this publication or the 
 * reliance of any party thereon or any inaccuracy or omission therein. The 
 * information in this document is therefore provided on an "as is" basis 
 * without warranty and is subject to change without further notice and cannot 
 * be construed as a commitment by Logica. 
 * The products mentioned in this document are identified by the names, 
 * trademarks, service marks and logos of their respective companies or 
 * organisations and may not be used in any advertising or publicity or in any 
 * other way whatsoever without the prior written consent of those companies 
 * or organisations and Logica.
 * ----------------------------------------------------------------------------
 * System       : Hummingbird
 * Author       : VillemosG
 * Created on   : 08.01.2010
 * ----------------------------------------------------------------------------
 */
package com.logica.hummingbird.marshaller;

import java.util.BitSet;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import com.logica.hummingbird.marshaller.producers.FrameProducer;
import com.logica.hummingbird.marshaller.producers.IProducer;
import com.logica.hummingbird.marshaller.producers.PacketProducer;
import com.logica.hummingbird.marshaller.producers.ParameterProducer;
import com.logica.hummingbird.marshaller.producers.Producer;

/** 
 * 
 * 
 * The notification model for observers could have been implemented in two ways;
 * Firstly we could notify the observer when it changes. This is architecturally
 * pleasing as there is a direct coupling between the 
 * 2. Notify the observers when the complete container has been unmarshalled.
 * 
 */
public class ContainerProcessor implements IMarshaller {

	/** The factory used to locate the models. */
	protected IContainerFactory factory = null;
	
	IProducer frameProducer;
	IProducer packetProducer;
	IProducer parameterProducer;
	
	/** Constructor.
	 * 
	 * @param factory The factory to be used to obtain references to the container.
	 * */
	public ContainerProcessor(IContainerFactory factory) {
		this.factory = factory;
		
		frameProducer = new FrameProducer(factory);
		packetProducer = new PacketProducer(factory);
		parameterProducer = new ParameterProducer(factory);
	}
	
	@Override
	public void unmarshall(String packetname, BitSet packet) {
		try {
			factory.getContainer(packetname).unmarshall(packet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void marshall(String packetname, BitSet packet) {
		try {
			factory.getContainer(packetname).marshall(packet, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void marshall(String packetname, String packet) {
		try {
			packet = factory.getContainer(packetname).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public IContainer getContainer(String container) throws Exception {
		return factory.getContainer(container);
	}
	
	public IContainerFactory getFactory() {
		return factory;
	}

	public void setFactory(IContainerFactory factory) {
		this.factory = factory;
	}

	public List<Message> process(Exchange arg0) throws Exception {
		unmarshall("TMFrame", (BitSet) arg0.getIn().getBody());
		
		List<Message> messages = Producer.getMessages();


		for (Message message : messages) {
			System.out.println(message.getHeaders());
			System.out.println(message.getBody());
		}
		Producer.clearMessages();
		
		return messages;
		
		
	}
	
	
}
