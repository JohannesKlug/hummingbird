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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.ContainerImpl;
import com.logica.hummingbird.spacesystemmodel.parameters.types.NumberParameterType;

/**
 * The abstract base class for all parameter <b><i>containers</i></b>. The class
 * is intended to be subtyped for each simple Java type type. 
 * 
 * A parameter is the leaf of the container tree. Each parameter
 * has a type, which defines among others the length in bits.  
 * 
 * @author Gert Villemos
 * @author Mark Doyle
 * @author Johannes Klug
 */
public abstract class ParameterContainer extends ContainerImpl implements Parameter {
	private static final Logger LOG = LoggerFactory.getLogger(ParameterContainer.class);

	/** The NumberParameterType of the parameter. */
	protected NumberParameterType type = null;
	

	/**
	 * Constructor of the Parameter class.
	 *
	 * @param name The name of the container.
	 * @param shortDescription A one line description of the container, used for tooltip type information.
	 * @param longDescription A detailed description of the container.
	 * @param type The parameter type.
	 *
	 */
	public ParameterContainer(String name, String shortDescription, String longDescription, NumberParameterType type) {
		super(name, shortDescription, longDescription);
		this.type = type;
	}
	
	
	/**
	 * Sets the value of the parameter.
	 *
	 * @param value The value to be set. 
	 *
	 */
	abstract public void setValue(double value);
	
	@Override
	public NumberParameterType getType() {
		return type;
	}
	
	
	/**
	 * Sets the type of the parameter.
	 *
	 * @param type The type to be set. 
	 *
	 */
	public void setType(NumberParameterType type) {
		this.type = type;
	}
	 
	@Override
	public int getLength() {
//		LOG.debug("returning length " + (length + (int) type.getSizeInBits()) + " for " + getName());
		
		//FIXME Why is the length field here?
		return length + (int) type.getSizeInBits();
	}
}
