package com.logica.hummingbird.telemetry.ccsds;

import java.util.HashMap;
import java.util.Map;

public class CcsdsTmParameter {

	Map<String, Object> values = new HashMap<String, Object>();

	Integer apid;

	public Map<String, Object> getValues() {
		return values;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TmParameter [apid=");
		builder.append(apid);
		builder.append(", values=");
		builder.append(values);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("parameter equals");
		// Check for comparison to self.
		if (this == obj) {
			return true;
		}

		// Check we can actually compare this object to ourselves.
		if (!(obj instanceof CcsdsTmParameter)) {
			return false;
		}
		
		CcsdsTmParameter otherParameter = (CcsdsTmParameter)obj;
	    
	    boolean equal = values.equals(otherParameter.getValues()) 
	    				&&
	    				apid == otherParameter.apid;
		return equal;
	}
}
