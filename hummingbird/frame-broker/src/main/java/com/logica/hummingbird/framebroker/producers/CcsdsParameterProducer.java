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

import com.logica.ccsds.telemetry.CcsdsTmParameter;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.ParameterObserver;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterContainer;

/**
 * TODO write here a description of the class
 */
public class CcsdsParameterProducer extends CcsdsProducer implements ParameterObserver {
	private final static Logger LOG = LoggerFactory.getLogger(CcsdsParameterProducer.class);

	CcsdsPacketProducer parent;

	public CcsdsParameterProducer(ContainerFactory containerFactory, CcsdsPacketProducer parent) {
		super(containerFactory);

		this.parent = parent;

		// Register with all parameters corresponding to header fields.
		for (ParameterContainer parameter : containerFactory.getAllParameters().values()) {
			parameter.addParameterUpdateObserve(this);
		}
	}

	@Override
	public void updated(String field, int value) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Updated Parameter: " + field + " : " + value);
		}

		try {
			this.getTmFrame().setParameterInFrame(new CcsdsTmParameter(field, value, Integer.class));
		}
		catch (SecurityException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void updated(String field, String value) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Updated Parameter: " + field + " : " + value);
		}
		try {
			this.getTmFrame().setParameterInFrame(new CcsdsTmParameter(field, value, String.class));
		}
		catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updated(String field, double value) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Updated Parameter: " + field + " : " + value);
		}

		try {
			this.getTmFrame().setParameterInFrame(new CcsdsTmParameter(field, value, Double.class));
		}
		catch (SecurityException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
	}

}