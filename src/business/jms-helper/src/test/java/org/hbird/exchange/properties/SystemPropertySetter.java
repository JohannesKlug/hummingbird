package org.hbird.exchange.properties;

import org.apache.camel.Exchange;

public class SystemPropertySetter {

	protected double mu =  3.986004415e+14;
	protected double f  =  1.0 / 298.257223563;      // flattening	
	protected double ae  =  6378137.;                      // equatorial radius in meter
	
	public void process(Exchange exchange) {

		/** Get name and value, set property. */
		String name = "";
		String value = "";		
		System.setProperty(name, value);
	}
}
