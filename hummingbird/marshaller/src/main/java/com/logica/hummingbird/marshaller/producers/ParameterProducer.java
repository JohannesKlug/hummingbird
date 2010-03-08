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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsMessage;
import org.apache.camel.impl.DefaultCamelContext;

import com.logica.hummingbird.marshaller.IContainerFactory;
import com.logica.hummingbird.marshaller.Parameter;

/**
 * TODO write here a description of the class
 */
public class ParameterProducer implements IProducer {
	
	DefaultCamelContext context = new DefaultCamelContext();
	
	protected ProducerTemplate producerTemplate = context.createProducerTemplate();

	/** List of all containers that are parameters to be generated. */
	protected List<String> parameters = null;

	protected String parameterpath = "parameter";
	
	protected IContainerFactory containerFactory = null;
	
	private Map<String,Object> headers = new HashMap<String, Object>();

	private byte[] body;
	
	public void initialise() {
		
		/** Register with all parameters corresponding to header fields. */
		for (String field : parameters) {
			Parameter parameter = containerFactory.getParameter(field);
			
			parameter.registerUpdateObserver(this);
			parameter.registerCompletionObserver(this);
		}
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
		//producerTemplate.sendBody(parameterpath, ExchangePattern.InOnly, parameterBuilder.build());
		//producerTemplate.sendBodyAndHeaders(parameterpath, body, headers);
		producerTemplate.sendBodyAndHeaders(body, headers);
	}
}