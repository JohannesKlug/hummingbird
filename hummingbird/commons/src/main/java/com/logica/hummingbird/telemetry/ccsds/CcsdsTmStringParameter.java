package com.logica.hummingbird.telemetry.ccsds;


public class CcsdsTmStringParameter {

	private String name;
	
	private Class<? extends Object> valueClazz;

	private String value;
	
	
	public CcsdsTmStringParameter(String name, String value, Class<? extends Object> valueClazz) {
		this.value = value;
		this.valueClazz = valueClazz;
		this.name = name;
	}
	
	public String getValue() {
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
		if (!(obj instanceof CcsdsTmStringParameter)) {
			return false;
		}
		
		CcsdsTmStringParameter otherParameter = (CcsdsTmStringParameter)obj;
	    
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
