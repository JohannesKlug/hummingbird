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
import java.util.List;

import javax.jms.BytesMessage;
import javax.jms.Message;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsMessage;

import com.logica.hummingbird.commons.CCSDSMessageTypes;
import com.logica.hummingbird.marshaller.IContainerFactory;
import com.logica.hummingbird.marshaller.Parameter;
import com.logica.hummingbird.commons.CCSDSMessageTypes.CCSDSFrame;
import com.logica.hummingbird.commons.CCSDSMessageTypes.CCSDSPacket;
import com.logica.hummingbird.commons.CCSDSMessageTypes.CCSDSParameter;
import com.logica.hummingbird.commons.CCSDSMessageTypes.CCSDSParameter.Builder;

/**
 * TODO write here a description of the class
 */
public class ParameterProducer implements IProducer {
	
	protected ProducerTemplate producerTemplate = null;

	/** List of all containers that are parameters to be generated. */
	protected List<String> parameters = null;

	protected Camel parameterMessage;
	
	protected String parameterpath = "parameter";
	
	protected IContainerFactory containerFactory = null;
	
	public void initialise() {
		/** Register with all parameters corresponding to header fields. */
		for (String field : parameters) {
			Parameter parameter = containerFactory.getParameter(field);
			
			parameter.registerUpdateObserver(this);
			parameter.registerCompletionObserver(this);
		}
	}

	public void updated(String field, String value) {
		parameterBuilder.setName(field);
		parameterBuilder.setValue(value);
	}

	public void updated(String field, int value) {
		parameterBuilder.setName(field);
		parameterBuilder.setValue(Integer.toString(value));
	}

	public void updated(String field, double value) {
		parameterBuilder.setName(field);
		parameterBuilder.setValue(Double.toString(value));
	}

	/* (non-Javadoc)
	 * @see com.logica.hummingbird.marshaller.IMessageProducer#sendFrame()
	 */
	@Override
	public void completed() {
		producerTemplate.sendBody(parameterpath, ExchangePattern.InOnly, parameterBuilder.build());
		parameterBuilder.clear();
	}
}