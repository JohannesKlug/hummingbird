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
package com.logica.hummingbird.marshaller;

import java.util.BitSet;

/**
 * The float container encodes / decodes a float parameter from the
 * data stream. 
 */
public class FloatParameter extends Parameter {

	/** The last extracted value of the container. */
	protected float value = 0;

	/** The minimual possible value. */
	protected final double minimumValue = Double.MIN_VALUE;
	
	/** The maximal possible value. */
	protected final double maximumValue = Double.MAX_VALUE;

	
	/**
	 * Constructor of the FloatParameter class.
	 *
	 * @param name The name of the container. Used as the unique identifier of the container.
	 * @param shortDescription A one-line description, tooltip style, of the container.
	 * @param longDescription A full description of the container, help style. 
	 * @param ParameterType The type of the container. The type defines the length and behaviour of the parameter.
	 * @param value The initial value.
	 */
	public FloatParameter(String name, String shortDescription, String longDescription, ParameterType type, float value) {
		super(name, shortDescription, longDescription, type);
		this.value = value;
	}

	@Override
	public BitSet unmarshall(BitSet packet) {
		value = (float) BitSetUtility.extractDouble(packet, 0, (int) type.sizeInBits, minimumValue, maximumValue);
		/** TODO Create POJO and send to observer. */
		return packet.get((int) type.sizeInBits, packet.length());
	}

	@Override
	public int marshall(BitSet packet, int offset) {
		try{
			packet = BitSetUtility.insertDouble(packet, offset, (int) type.sizeInBits, minimumValue, maximumValue, value);
		}
		catch (RuntimeException e) {
			System.out.println("Error encoding parameter '" + this.name + "'. The value '" + this.value + "' cannot be encoded in " + type.sizeInBits + " bit(s).");	
		}

		return offset + (int) type.sizeInBits;
	}

	@Override
	public String toString() {
		return "[float (" + this.type.sizeInBits + ") " + this.name + "=" + this.value + "]"; 
	}

	@Override
	public float getValue() {
		return value;
	}

	@Override
	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public boolean match(String value) {		
		return (this.value == Float.parseFloat(value));
	}
}
