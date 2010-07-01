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

import com.logica.hummingbird.spacesystemmodel.Container;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.PacketObserver;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;

/**
 * The packet consists of a sequence of packet header fields, which are parameters, and a 
 * packet body which is binary data. This producer registers for the parameters in the 
 * header, and for the packet itself to get the raw data.
 */
public class CcsdsPacketProducer extends CcsdsProducer implements PacketObserver {
	private final static Logger LOG = LoggerFactory.getLogger(CcsdsPacketProducer.class);

	public CcsdsPacketProducer(ContainerFactory containerFactory) {
		super(containerFactory);

		/** The packet base container (should have the name TMPacket by convention) contains as sub containers;
		 *   1. A parameter per header field. For example CCSDS_APID
		 *   2. A container per layout of a packet. The layout to be used is defined as a constraint, i.e. for example if
		 *      the header parameter 'CCSDS_APID == 123' is valid, then a specific layout will be used. */
		try {
			for (Container sub : containerFactory.getContainer("TMPacket").getSubContainers()) {
				sub.addPacketObserver(this);
			}
			containerFactory.getContainer("TMPacket").addPacketObserver(this);
		}
		catch (UnknownContainerNameException e) {
			LOG.error(e.toString());
			e.printStackTrace();
		}
	}
	
	@Override
	public void completed(String name) {
		if(LOG.isDebugEnabled()) {
			LOG.debug("TmPacket " + name + " completely updated");
			LOG.debug("TmPacket = " + packet);
		}
		packet.setName(name);
	}

}