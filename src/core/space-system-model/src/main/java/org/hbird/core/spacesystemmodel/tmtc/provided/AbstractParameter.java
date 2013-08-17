package org.hbird.core.spacesystemmodel.tmtc.provided;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;

public abstract class AbstractParameter<T> implements Parameter<T> {
	private static final long serialVersionUID = 1250249760314744228L;

	private final String qualifiedName;

	private final String name;

	private final String shortDescription;

	private final String longDescription;

	private long receivedTime;

	@JsonCreator
	public AbstractParameter(@JsonProperty("qualifiedName") final String qualifiedName, @JsonProperty("name") final String name,
			@JsonProperty("shortDescription") final String shortDescription, @JsonProperty("longDescription") final String longDescription) {
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
	public String getQualifiedName() {
		return this.qualifiedName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((longDescription == null) ? 0 : longDescription.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((qualifiedName == null) ? 0 : qualifiedName.hashCode());
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractParameter)) {
			return false;
		}
		// Cast ok since we are checking the same types at this point.
		@SuppressWarnings("unchecked")
		AbstractParameter<T> other = (AbstractParameter<T>) obj;
		if (longDescription == null) {
			if (other.longDescription != null) {
				return false;
			}
		}
		else if (!longDescription.equals(other.longDescription)) {
			return false;
		}
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
		if (shortDescription == null) {
			if (other.shortDescription != null) {
				return false;
			}
		}
		else if (!shortDescription.equals(other.shortDescription)) {
			return false;
		}
		return true;
	}

	@Override
	public long getReceivedTime() {
		return receivedTime;
	}

	@Override
	public void setReceivedTime(long timestamp) {
		this.receivedTime = timestamp;
	}

}
