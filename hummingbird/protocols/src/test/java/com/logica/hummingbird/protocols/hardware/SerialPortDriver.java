package com.logica.hummingbird.protocols.hardware;

import java.util.Enumeration;

import gnu.io.CommPortIdentifier;

public class SerialPortDriver {
	
	public SerialPortDriver() {
		Enumeration pList = CommPortIdentifier.getPortIdentifiers();

	    // Process the list.
	    while (pList.hasMoreElements()) {
	      CommPortIdentifier cpi = (CommPortIdentifier) pList.nextElement();
	      System.out.print("Port " + cpi.getName() + " ");
	      if (cpi.getPortType() == CommPortIdentifier.PORT_SERIAL) {
	        System.out.println("is a Serial Port: " + cpi);
	      } else if (cpi.getPortType() == CommPortIdentifier.PORT_PARALLEL) {
	        System.out.println("is a Parallel Port: " + cpi);
	      } else {
	        System.out.println("is an Unknown Port: " + cpi);
	      }
	    }
	  }
	

}
