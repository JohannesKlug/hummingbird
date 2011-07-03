package org.hbird.transport.spacesystemmodel.parameters;

/**
 * The Hummingbird implementation of the {@link Parameter}.
 * 
 * This is a generic class that is able to represent a parameter of any primitive or class.
 * 
 * @author Mark Doyle
 */
public class HummingbirdParameter<T> implements Parameter<T> {

	private final String name;
	private final String shortDescription;
	private final String longDescription;
	private final long sizeInBits;
	private final Endianness endianness;
	private final Encoding encoding;
	private T value;

	/**
	 * Constructor of the Parameter class.
	 * 
	 * @param name
	 *            The name of the container.
	 * @param shortDescription
	 *            A one line description of the container, used for tooltip type information.
	 * @param longDescription
	 *            A detailed description of the container.
	 * @param type
	 *            The parameter type.
	 * 
	 */
	public HummingbirdParameter(final String name,
								final String shortDescription,
								final String longDescription,
								final long sizeInBits,
								final Endianness endianness,
								final Encoding encoding) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.sizeInBits = sizeInBits;
		this.endianness = endianness;
		this.encoding = encoding;
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
	public long getSizeInBits() {
		return this.sizeInBits;
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
	public boolean isValue(final Object obj) {
		if (value.equals(obj)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Endianness getEndianness() {
		return this.endianness;
	}

	@Override
	public Encoding getEncoding() {
		return this.encoding;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DefaultParameter [name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append(", shortDescription=");
		builder.append(shortDescription);
		builder.append("]");
		return builder.toString();
	}
}
