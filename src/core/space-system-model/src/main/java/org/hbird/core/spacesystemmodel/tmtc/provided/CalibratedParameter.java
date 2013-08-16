package org.hbird.core.spacesystemmodel.tmtc.provided;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class CalibratedParameter extends AbstractParameter<Double> {
	private static final long serialVersionUID = -833822350920302695L;

	private double calibratedValue;

	@JsonCreator
	public CalibratedParameter(@JsonProperty("qualifiedName") final String qualifiedName, @JsonProperty("name") final String name,
			@JsonProperty("shortDescription") final String shortDescription, @JsonProperty("longDescription") final String longDescription) {
		super(name, qualifiedName, shortDescription, longDescription);
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
	public long getReceivedTime() {
		return 0;
	}

	@Override
	public void setReceivedTime(long timestamp) {
	}

	@Override
	public boolean isReadOnly() {
		return false;
	}

}
