package com.logica.hummingbird.telemetry;

public interface HummingbirdParameter {

	Class<? extends Object> getClassType();

	String getName();

	Object getValue();

	String getShortDescription();

	String getLongDescription();
}
