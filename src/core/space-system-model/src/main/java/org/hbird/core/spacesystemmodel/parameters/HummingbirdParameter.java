package org.hbird.core.spacesystemmodel.parameters;

import org.hbird.core.commons.tmtc.Parameter;

/**
 * The Hummingbird implementation of the {@link Parameter}.
 *
 * This is a generic class that is able to represent a parameter of any class.
 *
 * @author Mark Doyle
 */
public class HummingbirdParameter<T> implements Parameter<T> {
	private static final long serialVersionUID = 4723421286629148964L;

	private final String qualifiedName;
	private final String name;
	private final String shortDescription;
	private final String longDescription;
	private long receivedTime;
	private T value;

	/**
	 *
	 * @param name
	 * @param shortDescription
	 * @param longDescription
	 * @param sizeInBits
	 * @param endianness
	 * @param encoding
	 */
	public HummingbirdParameter(final String qualifiedName, final String name, final String shortDescription, final String longDescription) {
		this.name = name;
		this.qualifiedName = qualifiedName;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}

	@Override
	public String getLongDescription() {
		return this.longDescription;
	}

	@Override
	public T getValue() {
		return this.value;
	}

	@Override
	public void setValue(final T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HummingbirdParameter [name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append(", shortDescription=");
		builder.append(shortDescription);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public String getQualifiedName() {
		return this.qualifiedName;
	}

	@Override
	public long getReceivedTime() {
		return receivedTime;
	}

	@Override
	public void setReceivedTime(final long timestamp) {
		this.receivedTime = timestamp;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((qualifiedName == null) ? 0 : qualifiedName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		HummingbirdParameter<?> other = (HummingbirdParameter<?>) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		}
		else if (!name.equals(other.name)) {
			return false;
		}
		if (qualifiedName == null) {
			if (other.qualifiedName != null) {
				return false;
			}
		}
		else if (!qualifiedName.equals(other.qualifiedName)) {
			return false;
		}
		return true;
	}

}
