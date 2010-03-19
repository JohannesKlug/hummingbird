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

import com.logica.hummingbird.MessageType;
import com.logica.hummingbird.marshaller.IContainer;
import com.logica.hummingbird.marshaller.IContainerFactory;

/**
 * TODO write here a description of the class
 */
public class FrameProducer extends Producer {

	public FrameProducer(IContainerFactory containerFactory) {
		super(containerFactory);
		
		messageType = MessageType.TMFrame.toString();

		try {
			for (IContainer sub : containerFactory.getContainer("TMFrameHeader").getSubContainers()) {
				sub.addUpdateObserver(this);
			}
			
			for (IContainer sub : containerFactory.getContainer("TMFrameTail").getSubContainers()) {
				sub.addUpdateObserver(this);
			}
			
			containerFactory.getContainer("TMFrame").addCompletionObserver(this);
		
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}

}