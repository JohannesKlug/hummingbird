package com.logica.hummingbird.telemetry.ccsds;


public class CcsdsTmNumberParameter {

	private String name;
	
	private Class<? extends Object> valueClazz;

	private Number value;
	
	
	public CcsdsTmNumberParameter(String name, Number value, Class<? extends Object> valueClazz) {
		this.value = value;
		this.valueClazz = valueClazz;
		this.name = name;
	}
	
	public Number getValue() {
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
		if (!(obj instanceof CcsdsTmNumberParameter)) {
			return false;
		}
		
		CcsdsTmNumberParameter otherParameter = (CcsdsTmNumberParameter)obj;
	    
	    boolean equal = value.equals(otherParameter.value);
		return equal;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmParameter [\n\tname = ");
		builder.append(name);
		builder.append("\n\tvalue = ");
		builder.append(value);
		builder.append("\n\tvalueClazz = ");
		builder.append(valueClazz);
		builder.append("\n]");
		return builder.toString();
	}

	/**
	 * @return the valueClazz
	 */
	public Class<? extends Object> getValueClazz() {
		return valueClazz;
	}


}
