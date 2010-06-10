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
package com.logica.hummingbird.spacesystemmodel.parameters;

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.ContainerObserver;
import com.logica.hummingbird.spacesystemmodel.ParameterObserver;
import com.logica.hummingbird.util.BitSetUtility;

/**
 * 
 * @author Gert Villemos
 * @author Mark Doyle
 * 
 */
public class IntegerParameter extends ParameterImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger LOG = LoggerFactory.getLogger(IntegerParameter.class);

	/** The value of the integer. */
	protected Integer value = 0;

	/**
	 * Constructor of the IntegerParameter class.
	 * 
	 * @param name
	 *            The name of the container. Used as the unique identifier of the container.
	 * @param shortDescription
	 *            A one-line description, tooltip style, of the container.
	 * @param longDescription
	 *            A full description of the container, help style.
	 * @param ParameterType
	 *            The type of the container. The type defines the length and behaviour of the parameter.
	 * @param value
	 *            The initial value.
	 */
	public IntegerParameter(String name, String shortDescription, String longDescription, ParameterType type, int value) {
		super(name, shortDescription, longDescription, type);
		this.value = value;
	}

	@Override
	public BitSet unmarshall(BitSet packet) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Unmarshalling " + this.name + " from packet : " + packet);
		}
		
		value = BitSetUtility.extractInteger(packet, 0, (int) type.sizeInBits, type.signed);

		for(ParameterObserver paramObserver : updatedParameterObservers) {
			paramObserver.updated(name, value);
		}
		
		BitSet returnPacket = packet.get((int) type.sizeInBits, packet.length());
		return returnPacket;
	}

	@Override
	public int marshall(BitSet packet, int offset) {
		try {
			BitSetUtility.insertInteger(packet, offset, (int) type.sizeInBits, value);
		}
		catch (RuntimeException e) {
			// TODO log this
			System.out.println("Error encoding parameter '" + this.name + "'. The value '" + this.value + "' cannot be encoded in " + type.sizeInBits
					+ " bit(s).");
		}

		return offset + (int) type.sizeInBits;
	}

	@Override
	public String toString() {
		return "[int (" + this.type.sizeInBits + ") " + this.name + "=" + this.value + "]";
	}

	@Override
	public Number getValue() {
		return value;
	}

	@Override
	public void setValue(float value) {
		this.value = (int) value;
	}

	@Override
	public boolean match(String value) {
		return (this.value == Integer.parseInt(value));
	}
}
