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
package com.logica.hummingbird.framebroker.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.MessageType;
import com.logica.hummingbird.framebroker.IContainerFactory;
import com.logica.hummingbird.framebroker.parameters.Parameter;

/**
 * TODO write here a description of the class
 */
public class ParameterProducer extends Producer {
	private final static Logger LOG = LoggerFactory.getLogger(ParameterProducer.class);
	
	public ParameterProducer(IContainerFactory containerFactory) {
		super(containerFactory);
		
		messageType = MessageType.TMParameter;
		
		/** Register with all parameters corresponding to header fields. */
		for (Parameter parameter : containerFactory.getAllParameters().values()) {
			parameter.addUpdateObserver(this);
			parameter.addCompletionObserver(this);
		}
	}

	@Override
	public void updated(String field, int value) {
		headers.put(field, value);
		completed();
	}

	@Override
	public void updated(String field, String value) {
		headers.put(field, value);
		completed();
	}

	@Override
	public void updated(String field, double value) {
		headers.put(field, value);
		completed();
	}
}