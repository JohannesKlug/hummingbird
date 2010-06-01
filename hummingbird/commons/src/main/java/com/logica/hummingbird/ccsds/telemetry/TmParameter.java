package com.logica.hummingbird.ccsds.telemetry;

import java.util.HashMap;
import java.util.Map;

public class TmParameter {

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

	
}
