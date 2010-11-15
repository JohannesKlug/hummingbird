package com.logica.hummingbird.spacesystemmodel;

public interface ParameterObserver {
	public void updated(String field, int value, String shortDescription, String longDescription);

	public void updated(String field, String value, String shortDescription, String longDescription);

	public void updated(String field, double value, String shortDescription, String longDescription);
}
