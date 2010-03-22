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

import java.util.Map;

/**
 * Interface to create monitoring models.
 * 
 * The monitoring models are created based on an underlying
 * space system model, defining the structure of the space
 * system, including the telemetry and command structures. The
 * space system can be expressed in different ways, such as 
 * through the OMG/CCSDS XTCE or the ESA MIB/PUS model. The
 * model factory implementation will depend on a data structure
 * in a specific format, but hides this implementation to the
 * monitoring component. 
 *
 */
public interface IContainerFactory {

	/**
	 * Initialises the container factory. Must be called prior to
	 * calling any other methods.
	 */
	public void initialise();
	
	
	/**
	 * Retrieves a container. 
	 *
	 * @param name The unique name of the container to be returned.
	 * @return IContainer Returns the container identified through the name, or null. 
	 * @throws Exception 
	 *
	 */
	public IContainer getContainer(String name) throws Exception;

	/**
	 * Retrieves a parameter container. 
	 *
	 * @param name The unique name of the parameter container to be returned.
	 * @return Parameter Returns the parameter container identified through the name, or null. 
	 *
	 */
	public Parameter getParameter(String name);
	
	// TODO Get all parameters function.
	
	public Map<String, Parameter> getAllParameters();
}