package com.logica.hummingbird.spacesystemmodel;

public interface ParameterObserver {
	public void updated(String field, int value);
	public void updated(String field, String value);
	public void updated(String field, double value);
}
