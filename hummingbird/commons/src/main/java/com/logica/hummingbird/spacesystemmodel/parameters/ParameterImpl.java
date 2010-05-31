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

import com.logica.hummingbird.spacesystemmodel.ContainerImpl;

/**
 * The abstract base class for all parameter containers. The class
 * is intended to be subtyped for each simple Java type type. 
 * 
 * A parameter is the leaf of the container tree. Each parameter
 * has a type, which defines among others the length in bits.  
 */
public abstract class ParameterImpl extends ContainerImpl implements Parameter {

	/** The type of the parameter. */
	protected ParameterType type = null;
	

	/**
	 * Constructor of the Parameter class.
	 *
	 * @param name The name of the container.
	 * @param shortDescription A one line description of the container, used for tooltip type information.
	 * @param longDescription A detailed description of the container.
	 * @param type The parameter type.
	 *
	 */
	public ParameterImpl(String name, String shortDescription, String longDescription, ParameterType type) {
		super(name, shortDescription, longDescription);
		this.type = type;
	}
	
	
	/**
	 * Sets the value of the parameter.
	 *
	 * @param value The value to be set. 
	 *
	 */
	abstract public void setValue(float value);
	
	@Override
	public ParameterType getType() {
		return type;
	}
	
	
	/**
	 * Sets the type of the parameter.
	 *
	 * @param type The type to be set. 
	 *
	 */
	public void setType(ParameterType type) {
		this.type = type;
	}
	 
	@Override
	public int getLength() {
		return length + (int) type.sizeInBits;
	}
}
