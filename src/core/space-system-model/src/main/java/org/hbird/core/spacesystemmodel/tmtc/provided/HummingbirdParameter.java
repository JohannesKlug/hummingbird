package org.hbird.core.spacesystemmodel.tmtc.provided;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;

/**
 * The Hummingbird implementation of the {@link Parameter}.
 * 
 * This is a generic class that is able to represent a parameter of any class.
 * 
 * @author Mark Doyle
 */
@XmlRootElement()
@JsonIgnoreProperties(ignoreUnknown = true)
// FIXME This will cause problems if we need to deserialise subclasses such as protectedvalueparameter
public class HummingbirdParameter<T> implements Parameter<T> {
	private static final long serialVersionUID = 4723421286629148964L;

	private final String qualifiedName;
	private final String name;
	private final String shortDescription;
	private final String longDescription;
	private long receivedTime;
	protected T value;

	/**
	 * 
	 * @param name
	 * @param shortDescription
	 * @param longDescription
	 * @param sizeInBits
	 * @param endianness
	 * @param encoding
	 */
	@JsonCreator
	public HummingbirdParameter(@JsonProperty("qualifiedName") final String qualifiedName, @JsonProperty("name") final String name,
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
	public T getValue() {
		return this.value;
	}

	@Override
	public void setValue(final T value) {
		this.value = value;
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

	@Override
	public String toString() {
		return "HummingbirdParameter [qualifiedName=" + qualifiedName + ", name=" + name + ", shortDescription=" + shortDescription + ", longDescription="
				+ longDescription + ", receivedTime=" + receivedTime + ", value=" + value + "]";
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
		result = prime * result + ((longDescription == null) ? 0 : longDescription.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((qualifiedName == null) ? 0 : qualifiedName.hashCode());
		result = prime * result + (int) (receivedTime ^ (receivedTime >>> 32));
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		final HummingbirdParameter<?> other = (HummingbirdParameter<?>) obj;
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
		if (receivedTime != other.receivedTime) {
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
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		}
		else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isReadOnly() {
		return false;
	}

}
