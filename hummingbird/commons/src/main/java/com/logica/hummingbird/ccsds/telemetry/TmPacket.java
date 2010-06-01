package com.logica.hummingbird.ccsds.telemetry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TmPacket {
    List<TmParameter> parameters = new ArrayList<TmParameter>();;

    Map<String, Object> values = new HashMap<String, Object>();
    
    Integer apid; 

    public List<TmParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<TmParameter> parameters) {
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
	
	
}
