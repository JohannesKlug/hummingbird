package org.hbird.core.spacesystemmodel.tmtc.provided;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;

public class CalibratedParameter extends AbstractParameter<Double> {
	private static final long serialVersionUID = -833822350920302695L;

	private double calibratedValue;

	@JsonCreator
	public CalibratedParameter(@JsonProperty("qualifiedName") final String qualifiedName, @JsonProperty("name") final String name,
			@JsonProperty("shortDescription") final String shortDescription, @JsonProperty("longDescription") final String longDescription) {
		super(qualifiedName, name, shortDescription, longDescription);
	}

	/**
	 * Factory method from constructing a calibrated version of an existing parameter with a calibrated value preset.
	 * 
	 * @param p
	 * @param cval
	 * @return
	 */
	public static CalibratedParameter createFromParameterAndValue(Parameter<?> p, double cval) {
		CalibratedParameter cp = new CalibratedParameter(p.getQualifiedName(), p.getName(), p.getShortDescription(), p.getLongDescription());
		cp.setValue(cval);
		cp.setReceivedTime(p.getReceivedTime());
		return cp;
	}

	@Override
	public Double getValue() {
		return calibratedValue;
	}

	@Override
	public void setValue(Double value) {
		calibratedValue = value;
	}

	@Override
	public boolean isReadOnly() {
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CalibratedParameter [calibratedValue=");
		builder.append(calibratedValue);
		builder.append(", getName()=");
		builder.append(getName());
		builder.append(", getShortDescription()=");
		builder.append(getShortDescription());
		builder.append(", getLongDescription()=");
		builder.append(getLongDescription());
		builder.append(", getQualifiedName()=");
		builder.append(getQualifiedName());
		builder.append(", getReceivedTime()=");
		builder.append(getReceivedTime());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(calibratedValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof CalibratedParameter)) {
			return false;
		}
		CalibratedParameter other = (CalibratedParameter) obj;
		if (Double.doubleToLongBits(calibratedValue) != Double.doubleToLongBits(other.calibratedValue)) {
			return false;
		}
		return true;
	}

}
