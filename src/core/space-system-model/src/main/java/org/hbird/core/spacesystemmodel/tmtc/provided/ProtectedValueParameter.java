package org.hbird.core.spacesystemmodel.tmtc.provided;

import org.codehaus.jackson.annotate.JsonProperty;

public class ProtectedValueParameter<T> extends TelemeteredParameter<T> {
	private static final long serialVersionUID = -7017970975497905485L;

	// @formatter:off
	public ProtectedValueParameter(
			@JsonProperty("qualifiedName") final String qualifiedName,
			@JsonProperty("name") final String name,
			@JsonProperty("shortDescription") final String shortDescription,
			@JsonProperty("longDescription") final String longDescription,
			final T initialValue) {
		super(qualifiedName, name, shortDescription, longDescription);
		this.value = initialValue;
	}
	// @formatter:on

	@Override
	public void setValue(final T value) {
		throw new UnsupportedOperationException(
				"Failed to assign value "
						+ value
						+ " for parameter "
						+ getQualifiedName()
						+ " is protected in ProtectedValueParameter. You should not modify this, if you work around it you are violating the intention of the model definition. Be warned!");
	}

	@Override
	public boolean isReadOnly() {
		return true;
	}
}
