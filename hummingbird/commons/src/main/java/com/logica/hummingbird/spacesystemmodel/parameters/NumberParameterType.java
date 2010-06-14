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

import java.util.List;

import com.logica.hummingbird.spacesystemmodel.NamedElement;
import com.logica.hummingbird.spacesystemmodel.Unit;
import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;

/**
 * A parameter type. The parameter type consists of two elements;
 * Simple type. The type of the parameter such as integer, float or boolean.
 * Size in bits. The size in bits.
 * 
 * For example 'Integer8' which is a 8 bit integer, i.e. holds a maximum of
 * 128 (signed)
 * 
 * The simple type corresponds to a specific java class.
 */
public class NumberParameterType extends NamedElement {

	/** Enumeration of the available simple java types. */
	public enum eParameterType {INTEGER, FLOAT};
	
	/** The simple java type corresponding to this parameter. */
	protected final eParameterType type;
	
	/** Flag defining whether the type is signed or unsigned. */
	protected final boolean signed;	
	
	/** The initial value of the parameter. */
	protected final long initialValue;
	
	/** The size of the parameter type in bits. Allowed values are between 1 and 64. */
	protected final long sizeInBits;
	
	/** The unit of the parameter. */
	protected List<Unit> unit = null;

	/**
	 * Constructor of the ParameterType class.
	 *
	 * @param name The name of the container.
	 * @param shortDescription A one line description of the container, used for tooltip type information.
	 * @param longDescription A detailed description of the container.
	 * @param type The simple java type.
	 * @param signed Flag indicating whether the type is signed or not.
	 * @param initialValue The default value of all parameters of this type.
	 * @param sizeInBits The size of the parameters of this type in bits. 
	 * @throws InvalidParameterTypeException 
	 *
	 */
	public NumberParameterType(String name, String shortDescription, String longDescription, eParameterType type, boolean signed, long initialValue, long sizeInBits) throws InvalidParameterTypeException {
		super(name, shortDescription, longDescription);

		if (sizeInBits == 1 && signed) {
			throw new InvalidParameterTypeException("Exception creating parameter type " + name + ".  A single-bit signed parameter makes no sense - you're doing it wrong!");
		}
		
		if (sizeInBits == 0) {
			throw new InvalidParameterTypeException("Exception creating parameter type " + name + ".  A size zero parameter makes no sense - you're doing it wrong!");
		}
		
		this.type = type;
		this.signed = signed;
		this.initialValue = initialValue;
		this.sizeInBits = sizeInBits;
	}


	/**
	 * Returns the value of the signed flag.
	 * 
	 * @return boolean Flag indicating whether the parameter is signed or not. 
	 *
	 */
	public boolean isSigned() {
		return signed;
	}

	/**
	 * Returns the initial value, i.e. the default value of all parameters of
	 * this type.
	 * 
	 * @return long The initial value of the parameters of this type. 
	 *
	 */
	public long getInitialValue() {
		return initialValue;
	}

	/**
	 * Returns the size in bits.
	 * 
	 * @return long The size in bits. 
	 *
	 */
	public long getSizeInBits() {
		return sizeInBits;
	}

	
	/**
	 * Returns the unit of the type.
	 * 
	 * @return List<Unit> Returns the unit of the type. 
	 *
	 */
	public List<Unit> getUnit() {
		return unit;
	}

	/**
	 * Sets the unit of the type.
	 *
	 * @param unit The units of the type. 
	 *
	 */
	public void setUnit(List<Unit> unit) {
		this.unit = unit;
	}

	/**
	 * Adds a unit to the list of units.
	 *
	 * @param unit The unit of the type. 
	 *
	 */
	public void addUnit(Unit unit) {
		this.unit.add(unit);
	}

	/**
	 * Returns the simple java type of the type.
	 * 
	 * @return Returns the simple java type of the parameter. 
	 *
	 */
	public eParameterType getType() {
		return type;
	}
}
