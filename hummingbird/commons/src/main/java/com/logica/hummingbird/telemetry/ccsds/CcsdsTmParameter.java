package com.logica.hummingbird.telemetry.ccsds;

import com.logica.hummingbird.telemetry.TelemetryParameter;

public class CcsdsTmParameter implements TelemetryParameter {

	Integer apid;

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
	    
	    boolean equal = apid == otherParameter.apid;
		return equal;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmParameter [apid=");
		builder.append(apid);
		builder.append("]");
		return builder.toString();
	}
}
