package com.logica.hummingbird.telemetry;

public class Parameter implements HummingbirdParameter {
	
	String name;
	Class clazz;
	Object value;
	
	public Parameter(String name, Class clazz, Object value) {
		super();
		this.name = name;
		this.clazz = clazz;
		this.value = value;
	}

	@Override
	public Class<? extends Object> getClassType() {
		return clazz;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Parameter [clazz=");
		builder.append(clazz);
		builder.append(", name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

}
