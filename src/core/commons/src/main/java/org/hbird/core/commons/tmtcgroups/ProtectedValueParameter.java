package org.hbird.core.commons.tmtcgroups;


public class ProtectedValueParameter<T> extends HummingbirdParameter<T> {
	private static final long serialVersionUID = -7017970975497905485L;

	public ProtectedValueParameter(final String qualifiedName, final String name, final String shortDescription, final String longDescription,
			final T initialValue) {
		super(qualifiedName, name, shortDescription, longDescription);
		this.value = initialValue;
	}

	@Override
	public void setValue(final T value) {
		throw new UnsupportedOperationException(
				"Value is protected in ProtectedValueParameter. You should not modify this, if you work around it you are violating the intention of the model definition. Be warned!");
	}

	@Override
	public boolean isReadOnly() {
		return true;
	}
}
