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
 * Created on   : 13.01.2010
 * ----------------------------------------------------------------------------
 */
package com.logica.hummingbird.marshaller.producers;

import java.util.BitSet;
import java.util.List;
import java.util.Map;

import org.apache.camel.ProducerTemplate;

import com.logica.hummingbird.marshaller.IContainerFactory;

/**
 * TODO write here a description of the class
 */
public class PacketProducer implements IProducer {
	
	protected ProducerTemplate producerTemplate = null;

	/** List of all containers that are parameters to be generated. */
	protected List<String> headerFields = null;

	/** List of all containers that are parameters to be generated. */
	protected List<String> parameters = null;
	
	/** List of all containers that are packets to be generated. */
	protected List<String> packets = null;

	protected String path = null;
	
	protected IContainerFactory containerFactory = null;

	private Object body;

	private Map<String, Object> headers;

		
	public void initialise() {
		/** Register with all parameters corresponding to header fields. */
		for (String field : headerFields) {
			containerFactory.getParameter(field).registerUpdateObserver(this);
		}
		
		/** Register with all containers corresponding to packets. */
		for (String field : packets) {
			containerFactory.getContainer(field).registerCompletionObserver(this);
		}
	}
	
	public void updated(String key, BitSet value) {
		body = value;
	}

	public void updated(String key, String value) {
		headers.put(key, value);
	}

	public void updated(String key, int value) {
		headers.put(key, value);
	}

	public void updated(String key, double value) {
		headers.put(key, value);
	}

	/* (non-Javadoc)
	 * @see com.logica.hummingbird.marshaller.IMessageProducer#sendFrame()
	 */
	@Override
	public void completed() {
		//producerTemplate.sendBody(packetpath, ExchangePattern.InOnly, packetBuilder.build());
		producerTemplate.sendBodyAndHeaders(body, headers);
	}
}