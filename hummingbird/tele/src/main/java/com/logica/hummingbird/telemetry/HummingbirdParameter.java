package com.logica.hummingbird.telemetry;

public interface HummingbirdParameter {
	public Class<? extends Object> getClassType();

	public String getName();

	public Object getValue();
}
