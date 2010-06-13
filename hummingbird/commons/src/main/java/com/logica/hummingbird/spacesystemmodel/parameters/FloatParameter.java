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

import com.logica.hummingbird.spacesystemmodel.ParameterObserver;
import com.logica.hummingbird.spacesystemmodel.exceptions.BitSetOperationException;
import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.util.BitSetUtility;
import com.logica.hummingbird.util.BitSetUtility.FloatSizeInBits;

/**
 * The float container encodes / decodes a float parameter from the
 * data stream. 
 */
public class FloatParameter extends ParameterImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger LOG = LoggerFactory.getLogger(FloatParameter.class);
	
	/** The last extracted value of the container. */
	protected double value = 0;

	/** The minimal possible value. */
	protected final double minimumValue = Double.MIN_VALUE;
	
	/** The maximal possible value. */
	protected final double maximumValue = Double.MAX_VALUE;
	
	private FloatSizeInBits floatSize;
	
	
	/**
	 * Constructor of the FloatParameter class.
	 *
	 * @param name The name of the container. Used as the unique identifier of the container.
	 * @param shortDescription A one-line description, tooltip style, of the container.
	 * @param longDescription A full description of the container, help style. 
	 * @param ParameterType The type of the container. The type defines the length and behaviour of the parameter.
	 * @param value The initial value.
	 * @throws InvalidParameterTypeException 
	 */
	public FloatParameter(String name, String shortDescription, String longDescription, ParameterType type, double value) throws InvalidParameterTypeException {
		super(name, shortDescription, longDescription, type);
		
		if(!type.signed) {
			throw new InvalidParameterTypeException("Floats must be signed; sorry");
		}
		
		if(type.getSizeInBits() == 32) {
			floatSize = FloatSizeInBits.THIRTY_TWO;
		}
		else if(type.getSizeInBits() == 64) {
			floatSize = FloatSizeInBits.SIXTY_FOUR;
		}
		else {
			throw new InvalidParameterTypeException("Floats must be either 32 or 64 bits in size");
		}
		
	}

	@Override
	public BitSet unmarshall(BitSet packet) {	
		value = BitSetUtility.extractFloat(packet, 0, this.floatSize);

		for(ParameterObserver paramObserver : updatedParameterObservers) {
			paramObserver.updated(name, value);
		}
		
		return packet.get((int) type.sizeInBits, packet.length());
	}

	@Override
	public int marshall(BitSet packet, int offset) {
		try {
			packet = BitSetUtility.insertFloat(packet, offset, this.floatSize, value);
		}
		catch (BitSetOperationException e) {
			LOG.error(e.toString());
		}

		return offset + (int) type.sizeInBits;
	}

	@Override
	public String toString() {
		return "[float (" + this.type.sizeInBits + ") " + this.name + "=" + this.value + "]"; 
	}

	@Override
	public Number getValue() {
		return value;
	}

	@Override
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public boolean match(String value) {		
		return (this.value == Double.parseDouble(value));
	}

}
