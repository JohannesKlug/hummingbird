package com.logica.hummingbird.validation;

public class TmParameterDummy {
		
	public TmParameterDummy(double value) {
		this.setValue(value);
	}
	
	public TmParameterDummy() {};
	
	public void setValue(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	private double value;
	public String name;
}
