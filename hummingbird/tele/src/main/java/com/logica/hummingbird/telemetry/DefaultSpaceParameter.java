package com.logica.hummingbird.telemetry;

public class DefaultSpaceParameter implements HummingbirdParameter {

	private String name;
	private Class<?> clazz;
	private Object value;
	private String shortDescription = null;
	private String longDescription = null;

	public DefaultSpaceParameter(String name, Class<?> clazz, Object value) {
		super();
		this.name = name;
		this.clazz = clazz;
		this.value = value;
	}

	public DefaultSpaceParameter(String name, Class<?> clazz, Object value, String shortDescription, String longDescription) {
		super();
		this.name = name;
		this.clazz = clazz;
		this.value = value;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	@Override
	public Class<?> getClassType() {
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
	public String getShortDescription() {
		return this.shortDescription;
	}

	@Override
	public String getLongDescription() {
		return this.longDescription;
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
