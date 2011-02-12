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
 * Created on   : 10.01.2010
 * ----------------------------------------------------------------------------
 */
package org.hbird.transport.packetbroker;

import java.util.BitSet;

import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.spacesystemmodel.Container;
import org.hbird.transport.spacesystemmodel.ContainerFactory;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownContainerNameException;
import org.hbird.transport.telemetry.HummingbirdPacket;

/**
 * The interface of the Packet Broker.
 * 
 * @author Gert Villemos
 * @author Mark Doyle
 * @author Johannes Klug
 */
public interface PacketBroker {

	/**
	 * Unmarshalls the bit-set using the container identified through the container parameter name. Following the
	 * unmarshalling the 'getContainerFactory' can be used to get a reference to a sub-container.
	 * 
	 * @param container
	 *            The name of the container as registered within the container factory.
	 * @param data
	 *            The data stream from which the data shall be extracted.
	 * @throws UnknownContainerNameException
	 * 
	 */
	void unmarshall(String container, BitSet data) throws UnknownContainerNameException;

	/**
	 * Marshalls the container identified through the container parameter name into the BitSet.
	 * 
	 * @param container
	 *            The name of the container as registered within the container factory.
	 * @param data
	 *            The data stream into which the data shall be marshalled.
	 * @throws UnknownContainerNameException
	 * @throws BitSetOperationException
	 * 
	 */
	void marshall(String container, BitSet data) throws UnknownContainerNameException, BitSetOperationException;

	/**
	 * Marshalls the container identified through the container parameter name into into the String using the container.
	 * 
	 * @param container
	 *            The name of the container as registered within the container factory.
	 * @param String
	 *            The data stream from which the data shall be extracted.
	 * @throws UnknownContainerNameException
	 * 
	 */
	void marshall(String container, String data) throws UnknownContainerNameException;

	/**
	 * Returns a container reference.
	 * 
	 * @param container
	 *            Identifier of the container.
	 * @throws UnknownContainerNameException
	 * @throws Exception
	 * 
	 */
	Container getContainer(String container) throws UnknownContainerNameException;

	HummingbirdPacket getPacket();

	ContainerFactory getFactory();

	void setFactory(ContainerFactory factory);
}
