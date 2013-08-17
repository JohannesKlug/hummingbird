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
 * <p>
 * FIXME extend new Abstract Parameter {@link AbstractParameter}
 * </p>
 * 
 * @author Mark Doyle
 */
@XmlRootElement()
@JsonIgnoreProperties(ignoreUnknown = true)
// FIXME This will cause problems if we need to deserialise subclasses such as protectedvalueparameter
public class TelemeteredParameter<T> extends AbstractParameter<T> {
	private static final long serialVersionUID = 4723421286629148964L;

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
	public TelemeteredParameter(@JsonProperty("qualifiedName") final String qualifiedName, @JsonProperty("name") final String name,
			@JsonProperty("shortDescription") final String shortDescription, @JsonProperty("longDescription") final String longDescription) {
		super(qualifiedName, name, shortDescription, longDescription);
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
		builder.append("TelemeteredParameter [value=");
		builder.append(value);
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
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		if (!(obj instanceof TelemeteredParameter)) {
			return false;
		}
		// Cast ok since we are checking the same types at this point.
		@SuppressWarnings("unchecked")
		TelemeteredParameter<T> other = (TelemeteredParameter<T>) obj;
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
