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

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.ccsds.TmFrame;
import com.logica.hummingbird.framebroker.IContainer;
import com.logica.hummingbird.framebroker.IContainerFactory;
import com.logica.hummingbird.framebroker.exceptions.UnknownContainerNameException;

/**
 * TODO write here a description of the class
 */
public class FrameProducer extends CcsdsProducer {
	private final static Logger LOG = LoggerFactory.getLogger(FrameProducer.class);
	
	TmFrame tmFrame = new TmFrame();

	public TmFrame getTmFrame() {
		return tmFrame;
	}

	public FrameProducer(IContainerFactory containerFactory) {
		super(containerFactory);


		try {
			for (IContainer sub : containerFactory.getContainer("TMFrameHeader").getSubContainers()) {
				sub.addUpdateObserver(this);
			}

			for (IContainer sub : containerFactory.getContainer("TMFrameTail").getSubContainers()) {
				sub.addUpdateObserver(this);
			}

			containerFactory.getContainer("TMFrame").addCompletionObserver(this);
		}
		catch (UnknownContainerNameException e) {
			LOG.error(e.toString());
			e.printStackTrace();
		}
	}
	
	@Override
	public void completed() {
		CcsdsProducer.setFrame(tmFrame);
	}

	@Override
	public void updated(String field, BitSet value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updated(String field, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updated(String field, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updated(String field, double value) {
		// TODO Auto-generated method stub
		
	}
	
	

}