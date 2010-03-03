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

import java.math.BigDecimal;

/**
 * The unit of a parameter. 
 * 
 * A unit is described based on the 7 base SI dimensions;
 *   Kelvin to measure temperature.
 *   Seconds to measure time.
 *   Ampere to measure charge.
 *   Meter to measure distance.
 *   Candela to measure lumenosity.
 *   Kilogram to measure mass.
 *   Mole to measure amount.
 *   
 * The attributes holding the values are all powers of the dimension. A value of
 * meter=1 thus means 'meter' where as meter=2 means 'meter^2'. A negative value 
 * expresses a negative exponent. meter=-1 thus means '1/meter' and meter=2 means
 * '1/meter^2'.
 * The dimensions can be combined. Speed measures as meter/seconds is thus
 * meter=1 and seconds=-1. Acceleration measured in meter/seconds^2 is expressed as
 * meter=1 and seconds=-2.
 */
public class Unit extends NamedElement {
	/** TODO */
	protected BigDecimal power;
	
	/** TODO */
	protected String factor;

	/** SI dimension for temperature. */
	protected int kelvin = 0;
	
	/** SI dimension for time. */
	protected int seconds = 0;
	
	/** SI dimension for charge. */
	protected int ampere = 0;
	
	/** SI dimension for distance. */
	protected int meter = 0;
	
	/** SI dimension for lumenosity. */
	protected int candela = 0;
	
	/** SI dimension for mass. */
	protected int kilogram = 0;
	
	/** SI dimension for amount. */
	protected int mole = 0;
	
	
	/**
	 * Constructor of the Unit class.
	 *
	 * @param name The name of the container.
	 * @param shortDescription A one line description of the container, used for tooltip type information.
	 * @param longDescription A detailed description of the container. 
	 * @param power TODO
	 * @param factor TODO
	 *
	 */
	public Unit(String name, String shortDescription, String longDescription, BigDecimal power, String factor) {
		super(name, shortDescription, longDescription);
	
		this.power = power;
		this.factor = factor;
	}
	
	public BigDecimal getPower() {
		return power;
	}
	
	public void setPower(BigDecimal power) {
		this.power = power;
	}
	
	public String getFactor() {
		return factor;
	}
	
	public void setFactor(String factor) {
		this.factor = factor;
	}
}
