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

import java.io.File;
import java.util.List;
import java.util.Map;

import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.parameters.Parameter;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterContainer;

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
public interface ContainerFactory {	
	/**
	 * Retrieves a container. 
	 *
	 * @param name The unique name of the container to be returned.
	 * @return IContainer Returns the container identified through the name  or throws an UnknownContainerNameException. 
	 * @throws UnknownContainerNameException 
	 *
	 */
	Container getContainer(String name) throws UnknownContainerNameException;

	/**
	 * Retrieves a parameter container. 
	 *
	 * @param name The unique name of the parameter container to be returned.
	 * @return Parameter Returns the parameter container identified through the name, or null. 
	 *
	 */
	ParameterContainer getParameter(String name);
	
	// TODO Get all parameters function.
	Map<String, ParameterContainer> getAllParameters();
	
	Map<Parameter, List<String>> getAllParameterRestrictions();
	
	// FIXME Remove this?  Container model does not necessarily have to have a corresponding file.
	String getSpaceSystemModelFilePath();
}