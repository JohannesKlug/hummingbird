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
package org.hbird.transport.spacesystemmodel.parameters;

import org.hbird.transport.spacesystemmodel.parameters.types.NumberParameterType;

/**
 * Interface of a parameter container. */
public interface Parameter {
	/**
	 * Returns the type of the parameter.
	 * 
	 * @return ParameterType The type of the parameter.
	 *
	 */
	NumberParameterType getType();
	
	
	/**
	 * Returns the value of the parameter.
	 * 
	 * @return float The value of the parameter. 
	 *
	 */
	Number getValue();
	
	
	/**
	 * Converts the parsed value to the type of this parameter and compares the
	 * value with the current value.
	 *
	 * @param value The value to be compared against. 
	 *
	 */
	boolean match(String value);
	
	String getName();
}
