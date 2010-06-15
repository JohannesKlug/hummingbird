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
package com.logica.hummingbird.spacesystemmodel;

import java.util.BitSet;
import java.util.List;

import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;


/**
 * The standard interface of a marshaller container. The interface supports the
 * unmarshalling and marshalling of containers.
 */
public interface Container {

	/**
	 *  The method MUST remove the part of the packet that it represents, i.e.
	 *  truncate the length of the parameter 
	 * 
	 * @param packet A bitwise representation of the packet. The packet 
	 * has been truncated to the right position by the caller, i.e. the
	 * offset to this packet is always '0'.
	 */
	public BitSet unmarshall(BitSet packet);
	
	/**
	 * Encodes this container into the bitset, from the provider offset.
	 *
	 * @param packet The data set to be inserted into.
	 * @param offset The current position to be inserted into. 
	 * @return int The offset of the last inserted data. 
	 * @throws BitSetOperationException 
	 */
	public int marshall(BitSet packet, int offset) throws BitSetOperationException;
	
	
	/**
	 * Encodes the container (and sub containers) into a string. The string 
	 * is purely informative format, intended to help debugging and visualization. 
	 * The format is;
	 * 
	 *   Container = '[' + NAME + 0..n * Container | Parameter + ']'
	 *   Parameter = '{' + TYPE (LENGTH) NAME value = VALUE'}'
	 *   NAME      = N*ASCII 
	 *   TYPE      = float | int
	 *   LENGTH    = 0..64
	 *   VALUE     = integer or float to string.
	 * 
	 * @return String Encoded representation of the container.
	 *
	 */
	public String toString();

	
	/**
	 * Returns the total length of the container, based on the length of
	 * the subcontainers (if any).
	 * 
	 * @return int The parsed length + the length of the container. 
	 *
	 */
	public int getLength();

	
	/**
	 * Returns the raw value of the container.
	 *
	 * @return The container value as a bitset.  
	 *
	 */
	public BitSet getRawValue();

	public void addCompletionObserver(ContainerObserver observer);

	public void addUpdateObserver(ContainerObserver observer);
	
	public void addParameterUpdateObserve(ParameterObserver observer);
	
	public List<Container> getSubContainers();
}
