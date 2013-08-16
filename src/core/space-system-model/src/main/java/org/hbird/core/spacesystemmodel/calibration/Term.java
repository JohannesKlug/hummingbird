package org.hbird.core.spacesystemmodel.calibration;

public class Term {
	private double coefficient;

	private double exponent;

	public Term setCoefficient(double co) {
		this.coefficient = co;
		return this;
	}

	public Term setExponent(double ex) {
		this.exponent = ex;
		return this;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public double getExponent() {
		return exponent;
	}
}