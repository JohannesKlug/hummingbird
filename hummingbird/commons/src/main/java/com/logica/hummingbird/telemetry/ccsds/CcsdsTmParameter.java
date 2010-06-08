package com.logica.hummingbird.telemetry.ccsds;

import com.logica.hummingbird.telemetry.TelemetryParameter;

public class CcsdsTmParameter implements TelemetryParameter {

	private String name;
	
	private Class valueClazz;

	private Object value;
	
	
	public CcsdsTmParameter(String name, Object value, Class valueClazz) {
		this.value = value;
		this.valueClazz = valueClazz;
		this.name = name;
	}
	
	public Object getValue() {
		return value;
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
	    
	    boolean equal = value.equals(otherParameter.value);
		return equal;
	}

	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmParameter [name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append(", valueClazz=");
		builder.append(valueClazz);
		builder.append("]");
		return builder.toString();
	}
}
