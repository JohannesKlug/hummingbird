package com.logica.hummingbird.telemetry.ccsds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.logica.hummingbird.telemetry.TelemetryPacket;

public class CcsdsTmPacket implements TelemetryPacket {
	
	/**
	 * List of Telemetry Parameters contained by this packet.
	 * Initialised with an initial capacity of 1
	 */
    List<CcsdsTmParameter> parameters = new ArrayList<CcsdsTmParameter>(1);

    Map<String, Object> values = new HashMap<String, Object>();
    
    Integer apid; 

    public List<CcsdsTmParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<CcsdsTmParameter> parameters) {
		this.parameters = parameters;
	}
	
	public Map<String, Object> getValues() {
		return values;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TmPacket [apid=");
		builder.append(apid);
		builder.append(", parameters=");
		builder.append(parameters);
		builder.append(", values=");
		builder.append(values);
		builder.append("]");
		return builder.toString();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("packet equals");
		// Check for comparison to self.
		if (this == obj) {
			return true;
		}

		// Check we can actually compare this object to ourselves.
		if (!(obj instanceof CcsdsTmPacket)) {
			return false;
		}
		
		CcsdsTmPacket otherPacket = (CcsdsTmPacket)obj;
	    
	    boolean equal = parameters.equals(otherPacket.getParameters()) 
	    				&&
	    				apid == otherPacket.apid;
		return equal;
	}
	
}
